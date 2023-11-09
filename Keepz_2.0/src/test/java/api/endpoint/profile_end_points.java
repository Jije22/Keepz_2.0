package api.endpoint;

import api.payload.profile_payload;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class profile_end_points {


    public static Response getMethod(String access_Token, String end_point){

        Response response =
                given()
                        .header("Authorization", "Bearer " + access_Token )
                        .contentType(ContentType.JSON).
                        when()
                        .get(end_point);
        return response;
    }




}
