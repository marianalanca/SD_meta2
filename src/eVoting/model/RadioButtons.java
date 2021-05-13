package eVoting.model;

public class RadioButtons {

    private String key;
    private String value;

    public RadioButtons(String key,String value){
        this.key=key;
        this.value=value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
