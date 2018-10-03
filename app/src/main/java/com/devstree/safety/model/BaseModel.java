
package com.devstree.safety.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseModel {
    @SerializedName("errorCode")
    @Expose
    private Integer errorCode;
    @SerializedName("reason")
    @Expose
    private String reason;
    @SerializedName("success")
    @Expose
    private Boolean success;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }


}
