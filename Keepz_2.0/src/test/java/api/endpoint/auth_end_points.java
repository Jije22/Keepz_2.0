package api.endpoint;

import api.payload.auth_payload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class auth_end_points {


    public static Response Post_method(auth_payload payload, String end_point) {

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(payload).
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



    public static Response updateMethod(String end_point, auth_payload payload){

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
