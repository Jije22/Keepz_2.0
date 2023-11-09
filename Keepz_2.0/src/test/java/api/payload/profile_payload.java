package api.payload;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class profile_payload {

   String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
