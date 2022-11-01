package com.juaracoding.rizkimaulana;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestJMeterMovieDB {
    {
        System.out.println("Welcome to Rizki Maulana Azis JMeter Testing");
    }
    @Test
    public void testGetPopularMovie() {
        JSONObject request = new JSONObject();
        request.get("Popular");
        request.get("Movie");
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .get("https://developers.themoviedb.org/3/movies/get-popular-movies")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void testGetNowPlaying() {
        JSONObject request = new JSONObject();
        request.get("Now");
        request.get("Playing");
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .get("https://developers.themoviedb.org/3/movies/get-now-playing")
                .then()
                .statusCode(200)
                .log().all();
    }

}
