package com.example.spring_api.API.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
@Entity
public class UnverifiedUser {
    
    enum PurposeType {
        ChangePass,
        VerifyUser,
        Others
    }

    public UnverifiedUser(){ 
        email = "thkinh2008@gmail.com"; //if this email exists in the database, there have been a bug in server side
        vCode= "0";
        purposeType = PurposeType.ChangePass;
    };

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    private String email;
    private String vCode;
    private PurposeType purposeType;

    public PurposeType getPurposeType() {
        return purposeType;
    }
    public void setPurposeType(PurposeType purposeType) {
        this.purposeType = purposeType;
    }

    private Boolean isConfirmed = false;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getvCode() {
        return vCode;
    }
    public void setvCode(String vCode) {
        this.vCode = vCode;
    }
    public boolean isConfirmed() {
        return isConfirmed;
    }
    public void setConfirmed(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

}
