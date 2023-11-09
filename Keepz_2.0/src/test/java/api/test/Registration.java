package api.test;

import api.endpoint.AuthorizationEndPoint;
import api.endpoint.Routes;
import api.payload.Authorization;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.testng.annotations.BeforeClass;
import api.endpoint.Routes.*;
import org.testng.annotations.Test;

public class Registration {

    Authorization AuthPayload;
    Faker faker;

    private String userSmsId;

    @BeforeClass
    public void setupData(){

        AuthPayload = new Authorization();
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


    @Test(priority = 1)
    public void registerUser(){

        AuthorizationEndPoint.Post_method(AuthPayload, Routes.send_sms);
        Response verResponse = AuthorizationEndPoint.Post_method(AuthPayload, Routes.verify_sms);

        userSmsId = verResponse.asString();
        AuthPayload.setUserSMSId(userSmsId);

        Response token = AuthorizationEndPoint.Post_method(AuthPayload, Routes.registration_url);
        token.then().log().all();

    }

    public void registerWithInvaliMobile(){


    }


}
