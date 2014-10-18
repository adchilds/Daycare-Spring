package com.adamchilds.daycare.util.encryption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.util.StringUtils;
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
public class EncryptionUtil {
    private static final Logger logger = LoggerFactory.getLogger(EncryptionUtil.class);

    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final String SALT = "7H1S I5 4 D4YC4RE APP1IC47I0N";

    /**
     * Converts the specified String to it's base 64 representation.
     *
     * @param text the text to convert to base 64
     * @return the base 64 representation; null if the given string is null or empty
     */
    public static String base64Encode(String text) {
        if (!StringUtils.hasText(text)) {
            return null;
        }

        try {
            return new BASE64Encoder().encode(text.getBytes(DEFAULT_ENCODING));
        } catch (UnsupportedEncodingException uee) {
            logger.error("Could not encode the given text to base 64. text=[" + text + "]", uee);
            return null;
        }
    }

    /**
     * Converts the base 64 representation of a String into it's normal form.
     *
     * @param text the text to convert to it's normal form
     * @return the normal form of the given text; null if the given string is null or empty
     */
    public static String base64Decode(String text) {
        if (!StringUtils.hasText(text)) {
            return null;
        }

        try {
            return new String(new BASE64Decoder().decodeBuffer(text), DEFAULT_ENCODING);
        } catch (IOException ioe) {
            logger.error("Could not decode the given text from base 64. text=[" + text + "]", ioe);
            return null;
        }
    }

    /**
     * Generates a 128-bit (16 byte) MD5 hash for the specified String.
     *
     * @param md5 the String to encrypt
     * @return the encrypted String; null if the given string is null or empty
     */
    public static String MD5(String md5) {
        if (!StringUtils.hasText(md5)) {
            return null;
        }

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes(DEFAULT_ENCODING));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException nsae) {
            logger.error("Could not encode the given text. text=[" + md5 + "]", nsae);
            return null;
        } catch (UnsupportedEncodingException uee) {
            logger.error("Could not encode the given text. text=[" + md5 + "]", uee);
            return null;
        }
    }

    /**
     * Generates a 256-bit (32 byte) SHA encrypted String from the given {code text}.
     *
     * @param text the text to encrypt
     * @return the encrypted text; null if the given string is null or empty
     */
    public static String SHA256(String text) {
        if (!StringUtils.hasText(text)) {
            return null;
        }

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(text.getBytes(DEFAULT_ENCODING));
            byte[] array = messageDigest.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException nsae) {
            logger.error("Could not encode the given text. text=[" + text + "]", nsae);
            return null;
        } catch (UnsupportedEncodingException uee) {
            logger.error("Could not encode the given text. text=[" + text + "]", uee);
            return null;
        }
    }

    /**
     * <p>Encodes the specified {@link String} by first converting it to base 64 and then
     * converting that to an MD5 hashed {@link String}.</p>
     *
     * <p><b>Note:</b> This {@link String} cannot easily be decrypted (brute force). If authenticating a user, it will
     * be years faster to convert the entered {@link String} using this method and then comparing
     * that {@link String} with what is stored in the database.</p>
     *
     * @param text the {@link String} object to encrypt
     * @return the encrypted {@link String} object; null if the given string is null or empty
     */
    public static String encodeString(String text) {
        if (!StringUtils.hasText(text)) {
            return null;
        }

        return MD5(base64Encode(text));
    }

    /**
     * Encodes the given {@code password} using Springframework's default {@link ShaPasswordEncoder} at a
     * setting of 256-bits of encryption and also encodes the 256-bit hash as a base64 {@link String}.
     *
     * @param password the password to encrypt
     * @return the encrypted password; null if the given string is null or empty
     */
    public static String encodePassword(String password) {
        if (!StringUtils.hasText(password)) {
            return null;
        }

        ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
        encoder.setEncodeHashAsBase64(true);

        return encoder.encodePassword(password, SALT);
    }

}