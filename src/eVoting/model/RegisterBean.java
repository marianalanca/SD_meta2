package eVoting.model;


import eVoting.rmiserver.RMIServer_I;
import eVoting.rmiserver.Type;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;

public class RegisterBean {
    private final RMIConnectBean server = new RMIConnectBean();
    public String username= null, department= null;
    public String contact= null, address= null, cc_number= null;
    public Calendar cc_expiring = null;
    private String password = null;
    private Type type = null;

    public String getUsername() {
        return username;
    }

    public String getDepartment() {
        return department;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public String getCc_number() {
        return cc_number;
    }

    public Calendar getCc_expiring() {
        return cc_expiring;
    }

    public String getPassword() {
        return password;
    }

    public Type getType() {
        return type;
    }

    public RegisterBean(){}

    public boolean createVoter() throws RemoteException{
        return this.server.getRmiServer_i().createVoter(username, department,contact,address,cc_number,cc_expiring,password,type);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCc_number(String cc_number) {
        this.cc_number = cc_number;
    }

    public void setCc_expiring(Calendar cc_expiring) {
        this.cc_expiring = cc_expiring;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
