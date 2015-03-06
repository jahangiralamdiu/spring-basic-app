package jh.springbasicapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BS-113-Jahangir on 3/3/2015.
 */
public class BaseResponse {

    private int responseCode;

    private List<String> errors;

    public BaseResponse()
    {
        this.errors = new ArrayList<String>();
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
