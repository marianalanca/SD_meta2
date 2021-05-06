package Eleicao.model;

import RMIConnect.model.RMIConnectBean;
import rmiserver.Election;
import rmiserver.Type;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

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

    public boolean createElection() throws RemoteException {
        return getRmiServer_i().createElection(title,description,beggDate,endDate,department,allowedVoters);
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
