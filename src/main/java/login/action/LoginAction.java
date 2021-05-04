/**
 * Raul Barbosa 2014-11-07
 */
package login.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.Map;
import login.model.LoginModel;

public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	private String username = null, password = null;

	@Override
	public String execute() throws RemoteException {
		if(this.username != null && this.password != null && !username.equals("") && !password.equals("")) {
			this.getModel().setUsername(this.username);
			this.getModel().setPassword(this.password);

			if (this.getModel().getUserMatchesPassword()) {
				session.put("username", username);
				session.put("password", password);
				session.put("loggedin", true); // this marks the user as logged in
				return SUCCESS;
			}
		}
		return LOGIN;
	}
	
	public void setUsername(String username) {
		this.username = username; // will you sanitize this input? maybe use a prepared statement?
	}

	public void setPassword(String password) {
		this.password = password; // what about this input? 
	}
	
	public LoginModel getModel() {
		if(!session.containsKey("heyBean"))
			this.setHeyBean(new LoginModel());
		return (LoginModel) session.get("heyBean");
	}

	public void setHeyBean(LoginModel model) {
		this.session.put("heyBean", model);
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
