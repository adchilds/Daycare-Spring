package com.adamchilds.daycare.encryption.model;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This is a utility class to apply encryption on sensitive information that will be stored
 * in a database
 *
 * @author Adam Childs
 */
public class Encryption {

    private static final String DEFAULT_ENCODING = "UTF-8";

    /**
     * Converts the specified String to it's base 64 representation.
     *
     * @param text the text to convert to base 64
     * @return the base 64 representation
     */
    public static String base64Encode(String text) {
        try {
            return new BASE64Encoder().encode(text.getBytes(DEFAULT_ENCODING));
        } catch (UnsupportedEncodingException uee) {
            return null;
        }
    }

    public static String base64Decode(String text) {
        try {
            return new String(new BASE64Decoder().decodeBuffer(text), DEFAULT_ENCODING);
        } catch (IOException ioe) {
            return null;
        }
    }

    /**
     * Generates a 128-bit (16 byte) MD5 hash for the specified String.
     *
     * @param md5 the String to encrypt
     * @return the encrypted String
     */
    public static String MD5(String md5) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes(DEFAULT_ENCODING));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static String SHA256(String text) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(text.getBytes(DEFAULT_ENCODING));
            byte[] array = messageDigest.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * Encodes the specified String by first converting it to base 64 and then
     * converting that to an MD5 hashed String.
     *
     * Note: This String cannot easily be decrypted. If authenticating a user, it will
     * be much faster to convert the entered String using this method and then comparing
     * that String with what is stored in the database.
     *
     * @param text the string to encrypt
     * @return the encrypted String
     */
    public static String encodeString(String text) {
        return MD5(base64Encode(text));
    }
}