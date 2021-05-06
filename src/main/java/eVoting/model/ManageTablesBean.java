package eVoting.model;

import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;
import java.util.Properties;

import eVoting.rmiserver.*;

public class ManageTablesBean {
    private RMIServer_I server;
    private String dep;
    private MulticastServer table;
    private Election election;
    private List<Election> elections;

    public ManageTablesBean() {
        try {
            Properties prop = new Properties();
            String fileName = "config.properties";
            prop.load(new FileInputStream(fileName));
            server = (RMIServer_I) LocateRegistry.getRegistry(prop.getProperty("ip"),Integer.parseInt(prop.getProperty("port"))).lookup("RMIServer");
        } catch (Exception e) {
            System.out.println("Something went Wrong");
        }
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
        return server.searchTableDept(this.dep);
    }

    public List<Election> stateElections() throws RemoteException {
        return server.stateElections(State.WAITING, null);
    }

    public boolean addTableElection() throws RemoteException {
        return server.addTableElection(table, election);
    }

    public boolean removeTableElection() throws RemoteException {
        return server.removeTableElection(table, election);
    }
}
