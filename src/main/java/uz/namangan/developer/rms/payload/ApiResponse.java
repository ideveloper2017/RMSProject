package uz.namangan.developer.rms.payload;

import java.util.List;
import java.util.Optional;

public class ApiResponse<T> {
    private Boolean success;
    private String message;
    private List<T> data;

    public ApiResponse() {
    }

    public ApiResponse(Boolean success, String message, List<T> data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }


    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }


}
