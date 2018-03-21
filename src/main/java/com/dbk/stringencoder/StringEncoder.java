package com.dbk.stringencoder;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class StringEncoder {

    private static final Logger LOGGER = Logger.getLogger(StringEncoder.class);

    private final StringBuilder encodedString;

    private final List<Integer> asciiList = new LinkedList<>();

    private final VerifyStringEncoder lowerCaseVerification;

    private final VerifyStringEncoder specialCharVerification;

    public StringEncoder(){
        this.encodedString = new StringBuilder();
        lowerCaseVerification = new VerifyStringEncoderLowercaseRange();
        specialCharVerification = new VerifyStringEncoderSpecialCharacters();
        lowerCaseVerification.setNextVerificationRule(specialCharVerification);
    }

    /**
     * Encode originalString based on the offset
     *
     * @param offset
     * @param originalString
     * @return
     */
    public String encodeString(int offset, String originalString){

        LOGGER.debug("Input String received: " + originalString);

        //Validate input string
        this.lowerCaseVerification.verifyStringToEncode(originalString);

        //Initialize the linked list with ascii values for a to z
        for(int i=97; i<123; i++){
            asciiList.add(i);
        }

        //Initialize character array to iterate through every character in originalString
        char [] originalStringCharArray = originalString.toCharArray();

        for (char ch : originalStringCharArray){

            int asciiCode = (int) ch;

            int nextInt=0;
            int index = asciiList.indexOf(asciiCode);
            ListIterator<Integer> listIterator = asciiList.listIterator(index);

            //Rotate input string for positive offset
            if(offset > 0){
                if(asciiCode == 122){
                    nextInt = asciiList.get(0);
                }else {
                    nextInt = listIterator.next() + 1;
                }
            }else{
                if(asciiCode == 97){
                    nextInt = asciiList.get(25);
                }else {
                    nextInt = listIterator.previous();
                }
            }

            //Append new character to string builder
            encodedString.append((char) nextInt);
        }

        LOGGER.debug("Encoded String: "+encodedString.toString());
        return encodedString.toString();
    }
}