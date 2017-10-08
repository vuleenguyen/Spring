package com.lee;

/**
 * Created by Do My Duyen on 8/31/2017.
 * Suppose we wanted a singleton called InstallationDetails that stored some information, including the licenseNumber
 * How would we implement this?
 */
public class InstallationDetails {

    // ------------1. Lazy Way --------------------

//    private static InstallationDetails INSTANCE = null;

    // ------------2. Eager Way---------------------

    private static final InstallationDetails INSTANCE = new InstallationDetails();


    private String licenseNumber;

    public String getLicenseNumber() {
        return licenseNumber;
    }

    private InstallationDetails() {
        this.licenseNumber = "ABCD1234TYD";
    }

//    public static InstallationDetails getInstance() {
//        if (INSTANCE == null) {
//            INSTANCE = new InstallationDetails();
//        }
//        return INSTANCE;
//    }

    // Thread safe way
//    public static InstallationDetails getInstance() {
//        if (INSTANCE == null) {
//            synchronized (InstallationDetails.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = new InstallationDetails();
//                }
//            }
//        }
//        return INSTANCE;
//    }

    // Eager Way
    public static InstallationDetails getInstance() {
        return INSTANCE;
    }
}
