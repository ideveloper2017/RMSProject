package uz.namangan.developer.rms.dto;

import java.io.Serializable;
import java.util.Objects;

public class PinCodeDto {
    private String pincode;

    public void setPinCodeDto(String pincode) {
        this.pincode = pincode;
    }

    public String getPincode() {
        return pincode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PinCodeDto entity = (PinCodeDto) o;
        return Objects.equals(this.pincode, entity.pincode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pincode);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"(pincode="+pincode+")";
    }
}
