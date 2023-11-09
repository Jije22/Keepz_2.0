package api.endpoint;

import api.payload.Authorization;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthorizationEndPoint {


    public static Response Post_method(Authorization payload, String end_point) {

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(payload).log().all().
                when()
                        .post(end_point);

                return response;

    }


    public static Response getMethod(String end_point){

        Response response =
                given()
                        .contentType(ContentType.JSON).
                when()
                        .post(end_point);

                return response;
    }



    public static Response updateMethod(String end_point, Authorization payload){

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(payload).
                when()
                        .put(end_point);
                return response;
    }


    public static Response deleteMethod(String userName, String end_point){

        Response response =
                given()
                        .pathParam("id", userName).
                when()
                        .delete(end_point);
                return response;
    }


}
