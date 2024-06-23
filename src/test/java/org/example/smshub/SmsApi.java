package org.example.smshub;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class SmsApi {

    private final String URL = "https://smshub.org/stubs/handler_api.php";
    private final String API_KEY = "219966U39c6af7c28b024b2d6a6197538857b8a";

    public String getAccountBalance() {
        String body = given()
                .contentType(ContentType.HTML)
                .queryParam("api_key", API_KEY)
                .queryParam("action", "getBalance")
                .get(URL)
                .then().log().body()
                .extract().body().htmlPath().getString("body");
        String[] split = body.split(":");
        return split[1];
    }
}
