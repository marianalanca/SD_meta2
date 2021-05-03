package registar.model;


import rmiserver.RMIServer_I;
import rmiserver.Type;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;

public class RegisterBean {
    RMIServer_I rmiServer_i;
    private Map<String, Object> session;



    public String username= null, department= null;
    public String contact= null, address= null, cc_number= null;
    public Calendar cc_expiring = null;
    private String password = null;
    private Type type = null;
    private int port;
    private String addressRMI;

    public RegisterBean(){
        try{
            Properties prop = new Properties();
            String fileName = "config.properties";

            prop.load(new FileInputStream(fileName));
            this.port = Integer.parseInt(prop.getProperty("port"));
            addressRMI = prop.getProperty("ip");
            rmiServer_i = (RMIServer_I) LocateRegistry.getRegistry(addressRMI, this.port).lookup("RMIServer");
        } catch (NotBoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public boolean createVoter() throws RemoteException{
        return this.rmiServer_i.createVoter(username, department,contact,address,cc_number,cc_expiring,password,type);
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
