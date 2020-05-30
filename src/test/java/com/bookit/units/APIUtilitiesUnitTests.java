package com.bookit.units;

import com.bookit.utilities.APIUtilities;
import org.junit.Assert;
import org.junit.Test;

/**
 * Class with unit tests for APIUtilities class
 * Here we ensure that utilities work fine before using hem in action
 */
public class APIUtilitiesUnitTests {


    @Test
    public void getTokenTest(){
        String token = APIUtilities.getToken();
        String tokenForStudent = APIUtilities.getToken("student");
        String tokenForTeacher = APIUtilities.getToken("teacher");

        Assert.assertNotNull(token);
        Assert.assertNotNull(tokenForStudent);
        Assert.assertNotNull(tokenForTeacher);
    }
}
