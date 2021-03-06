package com.adamchilds.daycare.internationalization.impl;

import com.adamchilds.daycare.internationalization.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * {@inheritDoc}
 */
@Service
public class MessageServiceImpl implements MessageService {
    private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    private MessageSource messageSource;

    /**
     * {@inheritDoc}
     */
    public String get(String code) {
        return get(code, null);
    }

    /**
     * {@inheritDoc}
     */
    public String get(String code, Object[] args) {
        if (StringUtils.hasText(code)) {
            try {
                return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
            } catch (NoSuchMessageException nsme) {
                logger.error("No message found for code=[" + code + "]", nsme);
            } catch (Exception e) {
                logger.error("Could not find message for code=[" + code + "]", e);
            }
        } else {
            logger.warn("No message code supplied to MessageServiceImpl#get(code, args)...");
        }

        return "";
    }

}