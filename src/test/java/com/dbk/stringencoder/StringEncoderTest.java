package com.dbk.stringencoder;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StringEncoder.class})
public class StringEncoderTest {

    private static final Logger LOGGER = Logger.getLogger(StringEncoderTest.class);


    StringEncoder stringEncoder;

    /**
     * Test string encoder for positive offset
     */
    @Test
    public void testStringEncoderWithPositiveOffset(){
        stringEncoder = new StringEncoder();
        String originalString = "abcde";
        String encodedString = stringEncoder.encodeString(1, originalString);
        Assert.assertEquals(encodedString, "bcdef");
    }

    /**
     * Test string encoder for negative offset
     */
    @Test()
    public void testStringEncoderWithNegatibveOffest(){
        stringEncoder = new StringEncoder();
        String originalString = "abcdz";
        String encodedString = stringEncoder.encodeString(-1, originalString);
        Assert.assertEquals(encodedString, "zabcy");
   }

    /**
     * Test string encoder for negative offset and special characters as input
     */
    @Test(expected = StringOutOfRangeException.class)
    public void testStringEncoderOutsideRange(){
        stringEncoder = new StringEncoder();
        String originalString = "#@$56773";
        String encodedString = stringEncoder.encodeString(-1, originalString);
     }

    /**
     * Test string encoder for negative offset and uppercase characters as input
     */
    @Test(expected = StringOutOfRangeException.class)
    public void testStringEncoderOutsideRangeAndUpperCase(){
        stringEncoder = new StringEncoder();
        String originalString = "ABCD";
        String encodedString = stringEncoder.encodeString(-1, originalString);
    }
}
