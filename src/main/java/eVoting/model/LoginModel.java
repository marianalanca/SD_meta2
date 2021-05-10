package eVoting.model;

import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;
import java.util.Properties;
import eVoting.rmiserver.RMIServer_I;
import eVoting.rmiserver.Voter;

// public synchronized Voter searchUser(String username, String password) throws RemoteException
public class LoginModel {
	private final RMIConnectBean server = new RMIConnectBean();
	private String username; // username and password supplied by the user
	private String password;

	public LoginModel() {}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public List<Voter> getAllUsers() throws RemoteException {
		return server.getRmiServer_i().getVoterList(); // are you going to throw all exceptions?
	}

	public boolean getUserMatchesPassword() throws RemoteException {
		return server.getRmiServer_i().searchUser(username, password) != null;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
