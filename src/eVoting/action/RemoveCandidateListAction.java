package eVoting.action;

import com.opensymphony.xwork2.ActionSupport;
import eVoting.model.ListBean;
import eVoting.rmiserver.Candidates;
import eVoting.rmiserver.Election;
import eVoting.rmiserver.Voter;
import org.apache.struts2.interceptor.SessionAware;

import java.rmi.ConnectException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public class RemoveCandidateListAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private int option, size, optionCandidate;
    private String cc_number;
    private List<Election> elections;
    private Election election;
    private List<Candidates> cand;
    private Voter voter;

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

            if (optionCandidate>=0 && optionCandidate < size || cc_number.equals("")) {
                return ERROR;
            }

            this.getModel().setOption(this.option);
            this.getModel().setCc_number(this.cc_number);
            this.getModel().setOptionCandidate(optionCandidate);
            this.getModel().setVoter(voter);

            voter = this.getModel().searchVoterCc();

            if (voter==null){
                return ERROR;
            }

            try {
                if (this.getModel().removeMemberFromList()) {
                    return SUCCESS;
                }

            } catch (ConnectException e) {
                // tentar reconectar
                if (this.getModel().removeMemberFromList()) {
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
