package com.adamchilds.daycare.util.jython;

import com.google.common.io.Resources;
import org.junit.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Tests for the {@link JythonScriptUtil} utility class.
 *
 * @author Adam Childs
 * @since 1.0
 */
public class JythonScriptUtilTest {

    private static final String TEST_JYTHON_SCRIPT = "test/TestJythonConfiguration.py";

    @Test
    public void testExecuteScriptByScriptName() {
        JythonScriptUtil.executeScript(TEST_JYTHON_SCRIPT);
    }

    @Test
    public void testExecuteScriptByFile() {
        String filePath = JythonScriptUtil.JYTHON_SCRIPT_BASE_PATH + TEST_JYTHON_SCRIPT;
        File file = new File(Resources.getResource(filePath).getPath());

        JythonScriptUtil.executeScript(file);
    }

    @Test
    public void testExecuteScrip2tByInputStream() {
        String filePath = JythonScriptUtil.JYTHON_SCRIPT_BASE_PATH + TEST_JYTHON_SCRIPT;
        File file = new File(Resources.getResource(filePath).getPath());

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            fail("Could not create input stream for test Jython file=[" + JythonScriptUtil.JYTHON_SCRIPT_BASE_PATH + TEST_JYTHON_SCRIPT + "]");
        }

        JythonScriptUtil.executeScript(inputStream);
    }

}