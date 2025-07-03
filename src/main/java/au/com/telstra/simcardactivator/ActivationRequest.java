package au.com.telstra.simcardactivator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivationRequest{
    @JsonProperty("iccid")
    private String iccid;
    @JsonProperty("customerEmail")
    private String customerEmail;

    public ActivationRequest() {}

    // getters
    public String getId() {return iccid;}
    public String getEmail() {return customerEmail;}

    // setters
    public void setId(String iccid) {this.iccid = iccid;}
    public void setEmail(String customerEmail) {this.customerEmail = customerEmail;}
}