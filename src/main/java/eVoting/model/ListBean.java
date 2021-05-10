package eVoting.model;

import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;
import java.util.Properties;

import eVoting.rmiserver.*;
import eVoting.model.RMIConnectBean;

public class ListBean {
    private final RMIConnectBean server = new RMIConnectBean();
    private List<Election> elections;
    private Election election;
    private String nameList, cc_number;
    private List<Type> allowed;
    private Type typeList;
    private List<Candidates> cand;
    private Voter voter;
    private int option, size, optionCandidate;

    public ListBean() {
    }

    public List<Election> getElections() {
        return elections;
    }

    public Election getElection() {
        return election;
    }

    public String getNameList() {
        return nameList;
    }

    public String getCc_number() {
        return cc_number;
    }

    public List<Type> getAllowed() {
        return allowed;
    }

    public Type getTypeList() {
        return typeList;
    }

    public List<Candidates> getCand() {
        return cand;
    }

    public Voter getVoter() {
        return voter;
    }

    public int getOption() {
        return option;
    }

    public int getSize() {
        return size;
    }

    public int getOptionCandidate() {
        return optionCandidate;
    }

    public void setElections(List<Election> elections) {
        this.elections = elections;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public void setNameList(String nameList) {
        this.nameList = nameList;
    }

    public void setAllowed(List<Type> allowed) {
        this.allowed = allowed;
    }

    public void setTypeList(Type typeList) {
        this.typeList = typeList;
    }

    public void setCand(List<Candidates> cand) {
        this.cand = cand;
    }

    public void setCc_number(String cc_number) {
        this.cc_number = cc_number;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    public void setOptionCandidate(int optionCandidate) {
        this.optionCandidate = optionCandidate;
    }

    public List<Election> stateElections() throws RemoteException {
        this.elections = server.getRmiServer_i().stateElections(State.WAITING, null);
        return this.elections;
    }

    public boolean createCandidate() throws RemoteException {
        return this.server.getRmiServer_i().createCandidate(nameList, election.getTitle(), typeList);
    }

    public boolean addMemberToList() throws RemoteException {
        return this.server.getRmiServer_i().addMembroToLista(election, cand.get(optionCandidate).getName(), voter);
    }

    public boolean removeMemberFromList() throws RemoteException {
        return this.server.getRmiServer_i().removeMembroToLista(election, cand.get(optionCandidate).getName(), voter);
    }

    public boolean removeCandidate() throws RemoteException {
        return this.server.getRmiServer_i().removeCandidate(election.getTitle(), cand.get(option).getName());
    }

    public Voter searchVoterCc () throws RemoteException {
        return this.server.getRmiServer_i().searchVoterCc(this.cc_number);
    }

}
