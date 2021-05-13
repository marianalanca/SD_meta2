package eVoting.model;

import eVoting.rmiserver.Type;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

public class EleicaoBean extends RMIConnectBean {

    private String title;
    private String description;
    private Calendar beggDate;
    private Calendar endDate;
    private String department;
    private List<Type> allowedVoters;

    private String username;
    private String candidateName;

    private  String local;

    public EleicaoBean(){
        super();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Calendar getBeggDate() {
        return beggDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public String getDepartment() {
        return department;
    }

    public List<Type> getAllowedVoters() {
        return allowedVoters;
    }

    public String getUsername() {
        return username;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getLocal() {
        return local;
    }

    public boolean createElection() throws RemoteException {
        return getRmiServer_i().createElection(title,description,beggDate,endDate,department,allowedVoters);
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public boolean voterVotes() throws RemoteException{
        return getRmiServer_i().voterVotes(username,title,candidateName,local);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBeggDate(Calendar beggDate) {
        this.beggDate = beggDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setAllowedVoters(List<Type> allowedVoters) {
        this.allowedVoters = allowedVoters;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }


}
