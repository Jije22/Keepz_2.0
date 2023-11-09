package api.test.auth;

import api.endpoint.auth_end_points;
import api.endpoint.Routes;
import api.payload.auth_payload;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;

public class registration_test {

    auth_payload AuthPayload;
    Faker faker;
    private String userSmsId;

    @BeforeClass
    public void setupData(){

        AuthPayload = new auth_payload();
        faker = new Faker();

        AuthPayload.setCountryCode("996");
        AuthPayload.setPhone("599989982");
        AuthPayload.setSmsType("REGISTRATION");
        AuthPayload.setOtphash("string");
        AuthPayload.setCode(123456);
        AuthPayload.setDeviceToken("string");
        AuthPayload.setMobileName("string");
        AuthPayload.setMobileOS("ANDROID");
        AuthPayload.setBirthDate("1990-06-22");
        AuthPayload.setIban("GE12TB1383884488381818");
        AuthPayload.setLastname(faker.name().lastName());
        AuthPayload.setName(faker.name().firstName());
        AuthPayload.setPersonalNumber("62014008420");
        AuthPayload.setUserType("STANDARD");

    }


    @Test(priority = 4)  //check priority in any case
    public void registerUser(){

        auth_end_points.Post_method(AuthPayload, Routes.send_sms);
        Response verResponse = auth_end_points.Post_method(AuthPayload, Routes.verify_sms);

        userSmsId = verResponse.asString();
        AuthPayload.setUserSMSId(userSmsId);

        Response token = auth_end_points.Post_method(AuthPayload, Routes.registration_url);
        token.then().log().all();

    }
    @Test(priority = 1)
    public void registerInvalidFirstName(){

        AuthPayload.setName("");
        AuthPayload.setPhone("510989981");


        auth_end_points.Post_method(AuthPayload, Routes.send_sms);
        Response verResponse = auth_end_points.Post_method(AuthPayload, Routes.verify_sms);

        userSmsId = verResponse.asString();
        AuthPayload.setUserSMSId(userSmsId);

        Response response = auth_end_points.Post_method(AuthPayload, Routes.registration_url);
        response
                .then()
                .assertThat()
                .body("message", containsString("[name-Is required]"));
        Assert
                .assertEquals(response.getStatusCode(), 400);

    }
    @Test(priority = 2)
    public void registerWithInvalidLastName(){

        AuthPayload.setLastname("123");
        AuthPayload.setPhone("511989981");

        auth_end_points.Post_method(AuthPayload, Routes.send_sms);
        Response response = auth_end_points.Post_method(AuthPayload, Routes.verify_sms);
        response
                .then()
                .log()
                .all();

        userSmsId = response.asString();
        AuthPayload.setUserSMSId(userSmsId);

    }

    //TODO register with invalid usersmsid
    //TODO register with invalid / empty devicetoken
    //TODO register with invalid Mobile OS


}
