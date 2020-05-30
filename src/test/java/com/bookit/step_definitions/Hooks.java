package com.bookit.step_definitions;

import com.bookit.utilities.DBUtility;
import com.bookit.utilities.Environment;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    /**
     * This hook will be executed only for scenarios that are annotated with @db tag
     */
    @Before("@db")
    public void dbSetup(){
        DBUtility.createDBConnection(Environment.DB_HOST, Environment.DB_USERNAME, Environment.DB_PASSWORD);
    }

    /**
     * This hook will be executed only for scenarios that are annotated with @db tag
     */
    @After("@db")
    public void dbTearDown(){
        DBUtility.destroy();
    }
}
