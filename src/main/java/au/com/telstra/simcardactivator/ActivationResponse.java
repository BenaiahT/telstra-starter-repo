package au.com.telstra.simcardactivator;

public class ActivationResponse {
    private boolean success;

    public boolean succeeded(){
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
