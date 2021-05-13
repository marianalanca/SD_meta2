package eVoting.action;

import eVoting.model.EleicaoBean;
import com.opensymphony.xwork2.ActionSupport;
import eVoting.rmiserver.Election;
import org.apache.struts2.interceptor.SessionAware;
import eVoting.rmiserver.Type;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class EleicaoAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;

    public void setTitle(String title) {
        this.title = title;
    }



    private String title = null;
    private String description= null;
    private Calendar beggDate= null;
    private Calendar endDate= null;
    private String department= null;
    private List<Type> allowedVoters= null;

    private String username = null;
    private String candidateName = null;



    private String local = null;

    public String execute() throws RemoteException {
        if(title != null && department != null && description != null && beggDate != null && endDate != null && allowedVoters != null && !allowedVoters.isEmpty()){
            getEleicaoBean().setTitle(title);
            getEleicaoBean().setDepartment(department);
            getEleicaoBean().setDescription(description);
            getEleicaoBean().setBeggDate(beggDate);
            getEleicaoBean().setEndDate(endDate);
            getEleicaoBean().setAllowedVoters(allowedVoters);
            getEleicaoBean().setLocal(local);
            if(getEleicaoBean().createElection()) {
                session.put("title", title);
                session.put("created", true);
                return SUCCESS;
            }
        }

        return ERROR;
    }


    public String voterVotes()  throws RemoteException {
        if(title != null && username != null && candidateName != null){
            getEleicaoBean().setTitle(title);
            getEleicaoBean().setUsername(username);
            getEleicaoBean().setCandidateName(candidateName);
            getEleicaoBean().setCandidateName(candidateName);
            if(getEleicaoBean().voterVotes()){
                session.put("title",title);
                session.put("candidate",candidateName);
                session.put("username",username);
                session.put("voted",true);
                return SUCCESS;
            }

        }
        return ERROR;
    }


    public String voterVotesAdmin() throws RemoteException{
        if(title != null && username != null && candidateName != null) {
            getEleicaoBean().setTitle(title);
            getEleicaoBean().setUsername(username);
            getEleicaoBean().setCandidateName(candidateName);
            getEleicaoBean().setCandidateName(candidateName);
            if (getEleicaoBean().earlyVote()) {
                session.put("title", title);
                session.put("title", title);
                session.put("candidate", candidateName);
                session.put("username", username);
                session.put("voted", true);
                return SUCCESS;
            }

        }
        return ERROR;
    }


    public String changeInfo() throws RemoteException{
        if(title != null && department != null && description != null && beggDate != null && endDate != null && allowedVoters != null && !allowedVoters.isEmpty()){
            getEleicaoBean().setElection(new Election(title,description,beggDate, endDate,department,allowedVoters));
            if(getEleicaoBean().changeElection()){
                session.put("title",title);
                session.put("change",true);
                return SUCCESS;
            }
        }
        return  ERROR;
    }

    public EleicaoBean getEleicaoBean(){
        if(!session.containsKey("eleicaoBean"))
            this.setEleicaoBean(new EleicaoBean());
        return (EleicaoBean) session.get("eleicaoBean");
    }

    private void setEleicaoBean(EleicaoBean eleicaoBean) {
        this.session.put("eleicaoBean",eleicaoBean);
    }


    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }
}
