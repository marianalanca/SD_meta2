package registar.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Map;
import rmiserver.Type;
import registar.model.RegisterBean;

public class RegisterAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;


    public String username= null, department= null;
    public String contact= null, address= null, cc_number= null;
    public Calendar cc_expiring = null;
    private String password = null;
    private Type type = null;


    public String execute() throws RemoteException {
        if(username != null && department != null && contact != null && address != null && cc_number != null && cc_expiring != null && password != null && type != null){
            this.getRegisterBean().setUsername(username);
            this.getRegisterBean().setPassword(password);
            this.getRegisterBean().setDepartment(department);
            this.getRegisterBean().setContact(contact);
            this.getRegisterBean().setAddress(address);
            this.getRegisterBean().setCc_number(cc_number);
            this.getRegisterBean().setCc_expiring(cc_expiring);
            this.getRegisterBean().setType(type);
            if(getRegisterBean().createVoter()){
                session.put("username", username);
                session.put("password", password);
                session.put("created", true);
                return SUCCESS;
            }

        }
        return ERROR;
    }


    public RegisterBean getRegisterBean(){
        if(!session.containsKey("registerBean"))
            this.setRegisterBean(new RegisterBean());
        return (RegisterBean) session.get("registerBean");
    }

    public void setRegisterBean(RegisterBean registerBean){
        this.session.put("registerBean",registerBean);
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    //Otimizar para não aceitar valores vazios
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
