package com.djc.scene.domain;

public class IOSCert {

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

    @Override
    public String toString() {
        return "IOSCert{" +
                "cert='" + cert + '\'' +
                ", certEnv='" + certEnv + '\'' +
                ", certDate='" + certDate + '\'' +
                ", certPassword='" + certPassword + '\'' +
                '}';
    }
}
