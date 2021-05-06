package eVoting.model;

import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;
import java.util.Properties;

import eVoting.rmiserver.MulticastServer;
import eVoting.rmiserver.RMIServer_I;
import eVoting.rmiserver.Voter;

// public synchronized Voter searchUser(String username, String password) throws RemoteException
public class TableMemberBean {
    private RMIServer_I server;
    private String dep, cc_number;
    private MulticastServer table;
    private Voter voter;

    public TableMemberBean() {
        try {
            Properties prop = new Properties();
            String fileName = "config.properties";
            prop.load(new FileInputStream(fileName));
            server = (RMIServer_I) LocateRegistry.getRegistry(prop.getProperty("ip"),Integer.parseInt(prop.getProperty("port"))).lookup("RMIServer");
        } catch (Exception e) {
            System.out.println("Something went Wrong");
        }
    }

    public List<Voter> getAllUsers() throws RemoteException {
        return server.getVoterList(); // are you going to throw all exceptions?
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
        return server.searchTableDept(dep);
    }

    public List<Voter> getTableMembers() throws RemoteException {
        return server.getRMITableMembers(dep);
    }

    public Voter searchVoter() throws RemoteException {
        return server.searchVoterCc(this.cc_number);
    }

    public Boolean addVoter() throws RemoteException {
        return server.addVoterTable(this.table, this.voter);
    }

    public Boolean removeVoter() throws RemoteException {
        return server.removeVoterTable(this.table, this.voter);
    }
}
