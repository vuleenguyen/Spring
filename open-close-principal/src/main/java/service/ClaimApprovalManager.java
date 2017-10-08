package service;

/**
 * Created by Do My Duyen on 8/18/2017.
 */
public class ClaimApprovalManager {

    public void processHealthClaim(HealthInsuranceSurveyor surveyor) {
        if (surveyor.isValidClaim()) {
            System.out.println("ClaimApprovalManager: Valid claim. Currently processing claim for approval....");
        }
    }
}
