package com.dbk.stringencoder;

public interface VerifyStringEncoder {
    void setNextVerificationRule(VerifyStringEncoder nextVerificationRule);
    void verifyStringToEncode(String stringToEncode) throws StringOutOfRangeException;
}
