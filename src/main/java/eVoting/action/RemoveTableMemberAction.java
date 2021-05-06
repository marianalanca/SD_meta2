package eVoting.action;

import com.opensymphony.xwork2.ActionSupport;
import freemarker.core.ReturnInstruction;
import org.apache.struts2.interceptor.SessionAware;

import java.rmi.ConnectException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import eVoting.model.TableMemberBean;
import eVoting.rmiserver.*;

public class RemoveTableMemberAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String dep, cc_number;
    private MulticastServer table;
    private Voter voter;
    private int index;
    private List<Voter> members;

    @Override
    public String execute() throws RemoteException {
        try {
            this.getModel().setDep(this.dep);
            this.getModel().setCc_number(this.cc_number);
            this.table = this.getModel().searchTable(); // HERE

            if (table == null) {
                return ERROR;
            }
            this.getModel().setTable(table);

            members = this.getModel().getTableMembers();

            voter = members.get(index);


            try {

                if (voter == null) {
                    return ERROR;
                }

                this.getModel().setVoter(voter);

                if (this.getModel().removeVoter()) {
                    return SUCCESS;
                } else {
                    return ERROR;
                }

            } catch (Exception e) {
                return ERROR;
            }
        }catch (ConnectException e){
            // reconectar
        } catch (Exception e) {
            return ERROR;
        }
        return ERROR;
    }

    public TableMemberBean getModel() {
        if(!session.containsKey("heyBean"))
            this.setHeyBean(new TableMemberBean());
        return (TableMemberBean) session.get("heyBean");
    }

    public void setHeyBean(TableMemberBean model) {
        this.session.put("heyBean", model);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
