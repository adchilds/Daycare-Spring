package com.adamchilds.daycare.web.registration.util;

import com.adamchilds.daycare.entity.account.model.Account;
import com.adamchilds.daycare.entity.address.model.Address;
import com.adamchilds.daycare.entity.business.model.Business;
import com.adamchilds.daycare.entity.subscription.enumeration.SubscriptionTypeEnum;
import com.adamchilds.daycare.entity.roles.enumeration.UserRoleEnum;
import com.adamchilds.daycare.entity.user.model.User;
import com.adamchilds.daycare.util.encryption.EncryptionUtil;
import com.adamchilds.daycare.web.registration.form.RegistrationForm;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;

/**
 * This class provides utility methods for the user registration process.
 *
 * @author Adam Childs
 * @since 1.0
 */
public class RegistrationUtil {

    /**
     * Creates a new {@link com.adamchilds.daycare.entity.account.model.Account} object
     * from the given {@link com.adamchilds.daycare.web.registration.form.RegistrationForm}.
     *
     * @param form the {@link com.adamchilds.daycare.web.registration.form.RegistrationForm} to pull Account information from
     * @param user the {@link com.adamchilds.daycare.entity.user.model.User} associated with this Account
     * @param address the {@link com.adamchilds.daycare.entity.address.model.Address} associated with this Account
     * @return a new {@link com.adamchilds.daycare.entity.account.model.Account} object
     */
    public static Account createAccountFromRegistrationForm(RegistrationForm form, User user, Address address) {
        Account account = new Account();

        account.setAccountOwnerId(user.getId());
        account.setCreatedDate(new Date());
        account.setInviteCode(generateUserInviteCode(10));
        account.setUserSlots(SubscriptionTypeEnum.valueOf(form.getSubscriptionType()).getUserSlots());

        return account;
    }

    /**
     * Creates a new {@link com.adamchilds.daycare.entity.address.model.Address} object
     * from the given {@link com.adamchilds.daycare.web.registration.form.RegistrationForm}.
     *
     * @param form the {@link com.adamchilds.daycare.web.registration.form.RegistrationForm} to pull Address information from
     * @return a new {@link com.adamchilds.daycare.entity.address.model.Address} object
     */
    public static Address createAddressFromRegistrationForm(RegistrationForm form) {
        Address address = new Address();

        address.setStreetAddress1(form.getCompanyStreetAddress1());
        address.setStreetAddress2(form.getCompanyStreetAddress2());
        address.setPoBox(null);
        address.setCity(form.getCity());
        address.setState(form.getState());
        address.setCountry(null);
        address.setZipcode(form.getZipcode());

        return address;
    }

    /**
     * Creates a new {@link com.adamchilds.daycare.entity.business.model.Business} object
     * from the given {@link com.adamchilds.daycare.web.registration.form.RegistrationForm}.
     *
     * @param form the {@link com.adamchilds.daycare.web.registration.form.RegistrationForm} to pull Business information from
     * @param user the {@link com.adamchilds.daycare.entity.user.model.User} associated with this Business
     * @param address the {@link com.adamchilds.daycare.entity.address.model.Address} associated with this Business
     * @return a new {@link com.adamchilds.daycare.entity.business.model.Business} object
     */
    public static Business createBusinessFromRegistrationForm(RegistrationForm form, User user, Address address) {
        Business business = new Business();

        business.setAddressId(address.getAddressId());
        business.setOwnerId(user.getId());
        business.setCompanyName(form.getCompanyName());
        business.setOpeningDate(null);

        return business;
    }

    /**
     * Creates a new {@link com.adamchilds.daycare.entity.user.model.User} object
     * from the given {@link com.adamchilds.daycare.web.registration.form.RegistrationForm}.
     *
     * @param form the {@link com.adamchilds.daycare.web.registration.form.RegistrationForm} to pull User information from
     * @return a new {@link com.adamchilds.daycare.entity.user.model.User} object
     */
    public static User createUserFromRegistrationForm(RegistrationForm form) {
        User user = new User();

        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmailAddress(form.getEmailAddress());
        user.setUsername(form.getEmailAddress());
        user.setPassword(EncryptionUtil.encodeString(form.getPassword()));
        user.setCreatedDate(new Date());
        user.setEnabled(true);

        return user;
    }

    /**
     * Generate an invite code for users to register with.
     * <p>
     * These inviteCodes relate to individual Accounts and will associate the User that signs
     * up with a given inviteCode to the Account that the inviteCode is associated with.
     *
     * @param lengthOfString the length of the inviteCode to be generated
     * @return the generated invitation code
     */
    private static String generateUserInviteCode(int lengthOfString) {
        SecureRandom random = new SecureRandom();

        return new BigInteger(lengthOfString, random).toString();
    }

}