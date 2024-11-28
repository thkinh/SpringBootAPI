package com.example.spring_api.API.Model;

import jakarta.persistence.Embeddable;

@Embeddable
public class PotholeDetails {
    
    private Long accel_var_z;
    private Long accel_std_z;
    private Long accel_sd_z;
    private Long Depth;
    private Long Width;
    private Boolean isConfirmed;
    public Long getAccel_var_z() {
        return accel_var_z;
    }
    public void setAccel_var_z(Long accel_var_z) {
        this.accel_var_z = accel_var_z;
    }
    public Long getAccel_std_z() {
        return accel_std_z;
    }
    public void setAccel_std_z(Long accel_std_z) {
        this.accel_std_z = accel_std_z;
    }
    public Long getAccel_sd_z() {
        return accel_sd_z;
    }
    public void setAccel_sd_z(Long accel_sd_z) {
        this.accel_sd_z = accel_sd_z;
    }
    public Long getDepth() {
        return Depth;
    }
    public void setDepth(Long depth) {
        Depth = depth;
    }
    public Long getWidth() {
        return Width;
    }
    public void setWidth(Long width) {
        Width = width;
    }
    public Boolean getIsConfirmed() {
        return isConfirmed;
    }
    public void setIsConfirmed(Boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }
}
