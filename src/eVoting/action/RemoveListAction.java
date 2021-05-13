package eVoting.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.rmi.ConnectException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import eVoting.model.ListBean;
import eVoting.rmiserver.*;

public class RemoveListAction extends ActionSupport implements SessionAware{
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    int option, size;
    String nameList;
    List<Election> elections;
    Election election;
    List<Type> allowed;
    Type typeList;
    List<Candidates> cand;

    @Override
    public String execute() throws RemoteException {
        try {
            elections = this.getModel().stateElections();

            if (elections.size()==0) {
                return "empty";
            }

            election = elections.get(option);

            this.getModel().setElection(election);

            // ERA A PARTE EM QUE SE MOSTRAVA O TÍTULO
            // ORIGINAL

            /*
            * if(election.getAllowedVoters().size() == 3){
                    System.out.println (election.getTitle() + " - general election ");
                }
                else{
                    System.out.println (election.getTitle() + " -  " + election.getAllowedVoters().get(0));
                }
            * */

            cand = election.getCandidatesList();
            this.getModel().setCand(this.cand);

            size = cand.size();

            if (size==0) {
                return "empty";
            }

            if (option>=0 && option < size) {
                return ERROR;
            }

            this.getModel().setOption(this.option);

            try {
                if (this.getModel().removeCandidate()) {
                    return SUCCESS;
                }

            } catch (ConnectException e) {
                // tentar reconectar
                if (this.getModel().removeCandidate()) {
                    return SUCCESS;
                }
            }

        } catch (Exception e) {
            return ERROR;
        }
        return ERROR;
    }

    public ListBean getModel() {
        if(!session.containsKey("heyBean"))
            this.setHeyBean(new ListBean());
        return (ListBean) session.get("heyBean");
    }

    public void setHeyBean(ListBean model) {
        this.session.put("heyBean", model);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
