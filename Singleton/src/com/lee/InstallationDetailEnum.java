package com.lee;

/**
 * Created by Do My Duyen on 8/31/2017.
 */
public enum InstallationDetailEnum {
    INSTANCE;

    private String licenNumber;

    private InstallationDetailEnum() {
        this.licenNumber = "ABCD";
    }

    public String getLicenNumber() {
        return this.licenNumber;
    }
}
