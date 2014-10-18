package com.adamchilds.daycare.util.jython;

import com.google.common.io.Resources;
import org.python.util.PythonInterpreter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

/**
 * <p>This utility class provides useful functions for executing Jython scripts dynamically.</p>
 *
 * <p>Scripts should live in the resources directory of the project and under the {@link #JYTHON_SCRIPT_BASE_PATH} in
 * order to be located easily. Scripts can be loaded from other directories; however, the calling code must create the
 * {@link File} or {@link InputStream} itself before interfacing with this utility class.</p>
 *
 * @author Adam Childs
 * @since 1.0
 */
public class JythonScriptUtil {
    private static final Logger logger = LoggerFactory.getLogger(JythonScriptUtil.class);

    public static final PythonInterpreter INTERPRETER = new PythonInterpreter();
    public static final String JYTHON_SCRIPT_BASE_PATH = "scripts/jython/";

    /**
     * Executes the Jython script with the given name. The script must be located in the {@link #JYTHON_SCRIPT_BASE_PATH}.
     *
     * @param scriptRelativePath the relative path of the Jython script. The given path should exist within the {@link #JYTHON_SCRIPT_BASE_PATH}
     */
    public static void executeScript(String scriptRelativePath) {
        // Ensure that the scriptRelativePath is not null or empty
        if (!StringUtils.hasText(scriptRelativePath)) {
            logger.warn("Could not execute a Jython script that doesn't exist. Given file path String is null or empty.");

            return;
        }

        URL scriptURL = Resources.getResource(JYTHON_SCRIPT_BASE_PATH + scriptRelativePath);
        if (scriptURL != null) {

            InputStream inputStream;
            try {
                inputStream = scriptURL.openStream();

                executeScript(inputStream);
            } catch (Exception e) {
                logger.error("Could not open Jython script from location=[" + (JYTHON_SCRIPT_BASE_PATH + scriptRelativePath) + "]");
            }
        } else {
            logger.warn("Could not open Jython script from location=[" + (JYTHON_SCRIPT_BASE_PATH + scriptRelativePath) + "]");
        }
    }

    /**
     * Executes the given Jython script.
     *
     * @param scriptFile the Jython script to execute
     */
    public static void executeScript(File scriptFile) {
        // Ensure that the script is not null
        if (scriptFile == null) {
            logger.warn("Could not execute a Jython script that doesn't exist! File is null.");

            return;
        }

        try {
            InputStream inputStream = new FileInputStream(scriptFile);

            executeScript(inputStream);
        } catch (FileNotFoundException e) {
            logger.error("Could not open inputstream of the given file=[" + scriptFile + "]", e);
        }
    }

    /**
     * Executes the given Jython script.
     *
     * @param inputStream the {@link InputStream} that represents the Jython script to be executed
     */
    public static void executeScript(InputStream inputStream) {
        if (inputStream != null) {
            try {
                INTERPRETER.execfile(inputStream);
            } catch (Exception e) {
                logger.error("Could not execute Jython script.", e);
            }
        } else {
            logger.warn("Cannot execute a Jython script that doesn't exist! InputStream is null.");
        }
    }

}