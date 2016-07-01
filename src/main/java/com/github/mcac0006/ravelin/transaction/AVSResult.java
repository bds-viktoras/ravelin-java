package com.github.mcac0006.ravelin.transaction;

/**
 * Address verification is a compound check: both the street name and ZIP code are independently
 * verified, and both get an independent result code from your PSP.
 * 
 * @author <a href="matthew.cachia@gmail.com">matthew.cachia</a>
 *
 */
public class AVSResult {
    
    /**
     * The result code from a postal code verification.
     */
    private VerificationResult postalCode;
    
    /**
     * The result code from a street name verification.
     */
    private VerificationResult street;

    
    public AVSResult(VerificationResult postalCode, VerificationResult street) {
        super();
        this.postalCode = postalCode;
        this.street = street;
    }


    public VerificationResult getPostalCode() {
    
        return postalCode;
    }

    
    public void setPostalCode(VerificationResult postalCode) {
    
        this.postalCode = postalCode;
    }

    
    public VerificationResult getStreet() {
    
        return street;
    }

    
    public void setStreet(VerificationResult street) {
    
        this.street = street;
    }
    
    
}
