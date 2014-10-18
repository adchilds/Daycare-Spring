package com.adamchilds.daycare.util.encryption;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the {@link EncryptionUtil} class
 */
public class EncryptionUtilTest {

    @Test
    public void testBase64Encode() {
        // Null
        assertNull(EncryptionUtil.base64Encode(null));

        // Empty
        String stringToEncode = "";
        assertNull(EncryptionUtil.base64Encode(stringToEncode));

        // Whitespace
        stringToEncode = "    ";
        assertNull(EncryptionUtil.base64Encode(stringToEncode));

        /*
         * Valid examples
         */
        stringToEncode = "Daycare Management System";
        String expected = "RGF5Y2FyZSBNYW5hZ2VtZW50IFN5c3RlbQ==";
        assertEquals(EncryptionUtil.base64Encode(stringToEncode), expected);

        stringToEncode = "h";
        expected = "aA==";
        assertEquals(EncryptionUtil.base64Encode(stringToEncode), expected);

        stringToEncode = "21413515";
        expected = "MjE0MTM1MTU=";
        assertEquals(EncryptionUtil.base64Encode(stringToEncode), expected);
    }

    @Test
    public void testBase64Decode() {
        // Null
        assertNull(EncryptionUtil.base64Decode(null));

        // Empty
        String stringToDecode = "";
        assertNull(EncryptionUtil.base64Decode(stringToDecode));

        // Whitespace
        stringToDecode = "    ";
        assertNull(EncryptionUtil.base64Decode(stringToDecode));

        /*
         * Valid examples
         */
        stringToDecode = "RGF5Y2FyZSBNYW5hZ2VtZW50IFN5c3RlbQ==";
        String expected = "Daycare Management System";
        assertEquals(EncryptionUtil.base64Decode(stringToDecode), expected);

        stringToDecode = "aA==";
        expected = "h";
        assertEquals(EncryptionUtil.base64Decode(stringToDecode), expected);

        stringToDecode = "MjE0MTM1MTU=";
        expected = "21413515";
        assertEquals(EncryptionUtil.base64Decode(stringToDecode), expected);
    }

    @Test
    public void testMD5() {
        // Null
        assertNull(EncryptionUtil.MD5(null));

        // Empty
        String stringToEncode = "";
        assertNull(EncryptionUtil.MD5(stringToEncode));

        // Whitespace
        stringToEncode = "    ";
        assertNull(EncryptionUtil.MD5(stringToEncode));

        /*
         * Valid examples
         */
        stringToEncode = "Daycare Management System";
        String expected = "e549a33f0836adea5364294e2d80d42f";
        assertEquals(EncryptionUtil.MD5(stringToEncode), expected);

        stringToEncode = "h";
        expected = "2510c39011c5be704182423e3a695e91";
        assertEquals(EncryptionUtil.MD5(stringToEncode), expected);

        stringToEncode = "31094810";
        expected = "17ee296ee0632e26c43cda98cebfda2d";
        assertEquals(EncryptionUtil.MD5(stringToEncode), expected);
    }

    @Test
    public void testSHA256() {
        // Null
        assertNull(EncryptionUtil.SHA256(null));

        // Empty
        String stringToEncode = "";
        assertNull(EncryptionUtil.SHA256(stringToEncode));

        // Whitespace
        stringToEncode = "    ";
        assertNull(EncryptionUtil.SHA256(stringToEncode));

        /*
         * Valid examples
         */
        stringToEncode = "Daycare Management System";
        String expected = "e1f8d004c5400b16077c89911f342449475e9c960cc1f4ed3afeb462321b0261";
        assertEquals(EncryptionUtil.SHA256(stringToEncode), expected);

        stringToEncode = "h";
        expected = "aaa9402664f1a41f40ebbc52c9993eb66aeb366602958fdfaa283b71e64db123";
        assertEquals(EncryptionUtil.SHA256(stringToEncode), expected);

        stringToEncode = "31094810";
        expected = "7e7e89d378d67b9bcee1e215e8830e7551b1fb192933335835c221353ef1a8de";
        assertEquals(EncryptionUtil.SHA256(stringToEncode), expected);
    }

    @Test
    public void testEncodeString() {
        // Null
        assertNull(EncryptionUtil.encodeString(null));

        // Empty
        String stringToEncode = "";
        assertNull(EncryptionUtil.encodeString(stringToEncode));

        // Whitespace
        stringToEncode = "    ";
        assertNull(EncryptionUtil.encodeString(stringToEncode));

        /*
         * Valid examples
         */
        stringToEncode = "Daycare Management System";
        String expected = "23bc303b16a07ce36b6529fd59974bbf";
        assertEquals(EncryptionUtil.encodeString(stringToEncode), expected);

        stringToEncode = "h";
        expected = "5618576f143fc779084bc0c5df965779";
        assertEquals(EncryptionUtil.encodeString(stringToEncode), expected);

        stringToEncode = "34712098410";
        expected = "c352f0c83b4edfcf965813b4c135ee80";
        assertEquals(EncryptionUtil.encodeString(stringToEncode), expected);
    }

    @Test
    public void testEncodePassword() {
        // Null
        assertNull(EncryptionUtil.encodePassword(null));

        // Empty
        String stringToEncode = "";
        assertNull(EncryptionUtil.encodePassword(stringToEncode));

        // Whitespace
        stringToEncode = "    ";
        assertNull(EncryptionUtil.encodePassword(stringToEncode));

        /*
         * Valid examples
         */
        stringToEncode = "Daycare Management System";
        String expected = "YvG/Qus2zRwV19ABAL/HxDBLedO44uj78iNa+vU/O7o=";
        assertEquals(EncryptionUtil.encodePassword(stringToEncode), expected);

        stringToEncode = "h";
        expected = "P0+1k5oWQU5UZ/wc/7vu6txBTax4DGt/4Lg0ge+r1Dc=";
        assertEquals(EncryptionUtil.encodePassword(stringToEncode), expected);

        stringToEncode = "34712098410";
        expected = "W9MsFDjC/L65PAGSnE3+TEo2Zd28voPSU+vj/iIQZnw=";
        assertEquals(EncryptionUtil.encodePassword(stringToEncode), expected);
    }

}