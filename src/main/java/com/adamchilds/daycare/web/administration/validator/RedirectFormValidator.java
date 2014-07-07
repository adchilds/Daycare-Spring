package com.adamchilds.daycare.web.administration.validator;

import com.adamchilds.daycare.web.administration.form.RedirectForm;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validation for the {@link RedirectForm}.
 */
public class RedirectFormValidator implements Validator {

    private static final DateTimeFormatter FORMAT = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");

    /**
     * {@inheritDoc}
     */
    public boolean supports(Class<?> clazz) {
        return clazz.equals(RedirectFormValidator.class);
    }

    /**
     * {@inheritDoc}
     */
    public void validate(Object o, Errors errors) {
        RedirectForm form = (RedirectForm) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sourceURL", "pulse.administration.redirect.form.sourceURL.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "destinationURL", "pulse.administration.redirect.form.destinationURL.empty");

        if (StringUtils.hasText(form.getStartDate())) {
            // Verify that the format of the date is correct
            try {
                FORMAT.parseDateTime(form.getStartDate());
            } catch(Exception e) {
                errors.rejectValue("startDate", "pulse.administration.redirect.form.startDate.invalid");
            }
        }

        if (StringUtils.hasText(form.getEndDate())) {
            // Verify that the format of the date is correct
            try {
                FORMAT.parseDateTime(form.getEndDate());
            } catch(Exception e) {
                errors.rejectValue("endDate", "pulse.administration.redirect.form.endDate.invalid");
            }
        }
    }

}
