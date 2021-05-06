package eVoting.action;

import com.opensymphony.xwork2.ActionSupport;
import eVoting.model.ManageTablesBean;
import eVoting.rmiserver.Election;
import eVoting.rmiserver.MulticastServer;
import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public class RemoveTablesElectionAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String dep;
    private MulticastServer table;
    private Election election;
    private int index;
    private List<Election> elections;

    @Override
    public String execute() throws RemoteException {
        try {
            this.getModel().setDep(this.dep);
            this.elections = this.getModel().stateElections();

            this.getModel().setElections(this.elections);

            election = elections.get(index);
            this.getModel().setElection(election);

            this.table = this.getModel().searchTable();
            if (table==null) {
                return ERROR;
            }

            this.getModel().setTable(this.table);

            if (this.getModel().removeTableElection()) {
                return SUCCESS;
            } else {
                return ERROR;
            }
        } catch (Exception e) {
            return ERROR;
        }
    }

    public ManageTablesBean getModel() {
        if(!session.containsKey("heyBean"))
            this.setHeyBean(new ManageTablesBean());
        return (ManageTablesBean) session.get("heyBean");
    }

    public void setHeyBean(ManageTablesBean model) {
        this.session.put("heyBean", model);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
