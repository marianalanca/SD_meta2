package eVoting.model;

import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;
import java.util.Properties;

import eVoting.rmiserver.MulticastServer;
import eVoting.rmiserver.RMIServer_I;
import eVoting.rmiserver.Voter;

public class TableMemberBean {
    private final RMIConnectBean server = new RMIConnectBean();
    private String dep, cc_number;
    private MulticastServer table;
    private Voter voter;

    public TableMemberBean() {}

    public String getDep() {
        return dep;
    }

    public String getCc_number() {
        return cc_number;
    }

    public MulticastServer getTable() {
        return table;
    }

    public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    public void setTable(MulticastServer table) {
        this.table = table;
    }

    public void setCc_number(String cc_number) {
        this.cc_number = cc_number;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public MulticastServer searchTable() throws RemoteException {
        return server.getRmiServer_i().searchTableDept(dep);
    }

    public List<Voter> getTableMembers() throws RemoteException {
        return server.getRmiServer_i().getRMITableMembers(dep);
    }

    public Voter searchVoter() throws RemoteException {
        return server.getRmiServer_i().searchVoterCc(this.cc_number);
    }

    public Boolean addVoter() throws RemoteException {
        return server.getRmiServer_i().addVoterTable(this.table, this.voter);
    }

    public Boolean removeVoter() throws RemoteException {
        return server.getRmiServer_i().removeVoterTable(this.table, this.voter);
    }
}
