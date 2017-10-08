package com.lee;

/**
 * Created by Do My Duyen on 9/15/2017.
 */
public enum InstallationDetails3 {

    INSTANCE;

    private long licenseNumber;

    private InstallationDetails3() {
        this.licenseNumber = 12345L;
    }

    public long getLicenseNumber() {
        return licenseNumber;
    }
}
