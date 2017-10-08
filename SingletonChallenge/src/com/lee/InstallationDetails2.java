package com.lee;

/**
 * Created by Do My Duyen on 9/15/2017.
 *
 * Eager loading
 *
 */
public class InstallationDetails2 {

    private static final InstallationDetails2 INSTANCE = new InstallationDetails2();

    private long licenceNumber;

    private InstallationDetails2() {
        this.licenceNumber = 12345L;
    }

    public static final InstallationDetails2 getInstance() {
        return INSTANCE;
    }
}
