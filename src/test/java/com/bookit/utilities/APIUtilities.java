package com.bookit.utilities;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class APIUtilities {

    /**
     * static block used to initialize static variables.
     * has highest priority in the execution order:
     *  1. static block
     *  2. instance block
     *  3. constructor
     *  4. method
     */
    static {
        baseURI = Environment.BASE_URI;
    }

    /**
     * This method is used to retrieve token from the server.
     * Token bust be attached to the header of every API call
     *
     * @return token
     */
    public static String getToken() {
        Response response = given().
                queryParam("email", Environment.LEADER_USERNAME).
                queryParam("password", Environment.LEADER_PASSWORD).
                when().
                get("/sign");
        response.then().log().ifError();//if request failed, print response information
        String token = response.jsonPath().getString("accessToken");
        System.out.println("TOKEN :: " + token);
        return token;
    }

    /**
     * This method is used to retrieve authorization token from the server for specific role.
     * Token bust be attached to the header of every API call
     *
     * @return token
     */
    public static String getToken(String role) {
        String email = null;
        String password = null;

        if (role.toLowerCase().contains("teacher")) {
            email = Environment.TEACHER_USERNAME;
            password = Environment.TEACHER_PASSWORD;
        } else if (role.toLowerCase().contains("lead")) {
            email = Environment.LEADER_USERNAME;
            password = Environment.LEADER_PASSWORD;
        } else {
            email = Environment.MEMBER_USERNAME;
            password = Environment.MEMBER_PASSWORD;
        }

        Response response = given().
                queryParam("email", email).
                queryParam("password", password).
                when().
                get("/sign");
        response.then().log().ifError();//if request failed, print response information
        String token = response.jsonPath().getString("accessToken");
        System.out.println("TOKEN :: " + token);
        return token;
    }
}
