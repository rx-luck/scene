package com.djc.scene.dto;

public class IOSCertDto {

    private String cert;
    private String certEnv;
    private String certDate;
    private String certPassword;

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public String getCertEnv() {
        return certEnv;
    }

    public void setCertEnv(String certEnv) {
        this.certEnv = certEnv;
    }

    public String getCertDate() {
        return certDate;
    }

    public void setCertDate(String certDate) {
        this.certDate = certDate;
    }

    public String getCertPassword() {
        return certPassword;
    }

    public void setCertPassword(String certPassword) {
        this.certPassword = certPassword;
    }
}
