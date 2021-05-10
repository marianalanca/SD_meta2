package eVoting.model;

import eVoting.rmiserver.RMIServer_I;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.util.Map;
import java.util.Properties;

public class RMIConnectBean {

    private Map<String, Object> session;

    RMIServer_I rmiServer_i;
    private int port;
    private String addressRMI;

    public RMIConnectBean(){
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

    public RMIServer_I getRmiServer_i() {
        return rmiServer_i;
    }

    public int getPort() {
        return port;
    }

    public String getAddressRMI() {
        return addressRMI;
    }
}
