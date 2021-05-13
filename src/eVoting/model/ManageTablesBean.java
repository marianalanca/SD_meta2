package eVoting.model;

import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;
import java.util.Properties;

import eVoting.rmiserver.*;

public class ManageTablesBean {
    private final RMIConnectBean server = new RMIConnectBean();
    private String dep;
    private MulticastServer table;
    private Election election;
    private List<Election> elections;

    public ManageTablesBean() {}

    public String getDep() {
        return dep;
    }

    public MulticastServer getTable() {
        return table;
    }

    public List<Election> getElections() {
        return elections;
    }

    public Election getElection() {
        return election;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public void setTable(MulticastServer table) {
        this.table = table;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public void setElections(List<Election> elections) {
        this.elections = elections;
    }

    public MulticastServer searchTable() throws RemoteException {
        return server.getRmiServer_i().searchTableDept(this.dep);
    }

    public List<Election> stateElections() throws RemoteException {
        return server.getRmiServer_i().stateElections(State.WAITING, null);
    }

    public boolean addTableElection() throws RemoteException {
        return server.getRmiServer_i().addTableElection(table, election);
    }

    public boolean removeTableElection() throws RemoteException {
        return server.getRmiServer_i().removeTableElection(table, election);
    }
}
