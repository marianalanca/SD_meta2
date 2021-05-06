package login.model;

import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;
import java.util.Properties;
import rmiserver.RMIServer_I;
import rmiserver.Voter;

// public synchronized Voter searchUser(String username, String password) throws RemoteException
public class LoginModel {
	private RMIServer_I server;
	private String username; // username and password supplied by the user
	private String password;

	public LoginModel() {
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

	public boolean getUserMatchesPassword() throws RemoteException {
		return server.searchUser(username, password) != null;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
