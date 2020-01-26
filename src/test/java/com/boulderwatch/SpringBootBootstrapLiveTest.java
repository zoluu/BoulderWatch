package com.boulderwatch;

import static org.junit.Assert.*;

import com.boulderwatch.persistence.model.Session;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SpringBootBootstrapLiveTest {

    public static final String API_ROOT = "http://localhost:8080/api/sessions";

    private Session createRandomSession() {
        Session session = new Session();
        session.setTitle(randomAlphabetic(10));
        session.setLevel(randomAlphabetic(3));
        session.setCount((int) Math.random() * 50 + 1);
        return session;
    }

    private String createSessionAsUri(Session session) {
        final Response response = (Response) RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(session)
                .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath()
                .get("id");
    }

    @Test
    public void whenGetAllSessions_thenOK() {
        final Response response = RestAssured.get(API_ROOT);
        System.out.println("=========================================");
        System.out.println(HttpStatus.OK.value() + response.getStatusCode());
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

//    @Test
//    public void whenGetSessionsByTitle_thenOK() {
//        Session session = createRandomSession();
//        createSessionAsUri(session);
//        Response response = RestAssured.get( API_ROOT + "/title/" + session.getTitle());
//
//        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
//        assertTrue(response.as(List.class).size() > 0);
//    }
}
