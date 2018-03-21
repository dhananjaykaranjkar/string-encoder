package com.dbk.stringencoder;

import org.apache.log4j.Logger;

public class VerifyStringEncoderLowercaseRange implements VerifyStringEncoder {

    private static final Logger LOGGER = Logger.getLogger(VerifyStringEncoderLowercaseRange.class);

    private VerifyStringEncoder nextVerifyRule;

    @Override
    public void setNextVerificationRule(VerifyStringEncoder nextVerificationRule) {
        this.nextVerifyRule = nextVerificationRule;
    }

    @Override
    public void verifyStringToEncode(String stringToEncode) throws StringOutOfRangeException {

        char [] stringToEncodeCharArray = stringToEncode.toCharArray();

        for (int i=0; i<stringToEncodeCharArray.length; i++){

            int asciiCode = (int) stringToEncodeCharArray[i];
            if((asciiCode>96 && asciiCode<123)) {
                LOGGER.debug("Input String '" + stringToEncode + "' is within the Alphabet lowercase range");
            }else {
                LOGGER.error("Input String '" + stringToEncode + "' out of range");
                throw new StringOutOfRangeException("Input String out of range");
            }
        }
    }
}
