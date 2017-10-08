package com.lee;

/**
 * Created by Do My Duyen on 9/15/2017.
 *
 * Lazy Loading way but not thread safe
 *
 * But now is thread safe
 *
 */
public class InstallationDetails {

    private static InstallationDetails INSTANCE = null;

    private long licenseNumber;

    private InstallationDetails() {
        this.licenseNumber = 123456L;
    }

    public static final InstallationDetails getInstance() {
        if (INSTANCE == null) {
            synchronized (InstallationDetails.class) {
                if (INSTANCE == null) {
                    return new InstallationDetails();
                }
            }
        }
        return INSTANCE;
    }
}
