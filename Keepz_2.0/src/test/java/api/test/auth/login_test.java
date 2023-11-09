package api.test.auth;

import api.endpoint.auth_end_points;
import api.endpoint.Routes;
import api.payload.auth_payload;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class login_test {


    auth_payload AuthPayload;
    private String userSmsId;


    @BeforeClass
    public void setupData(){

        AuthPayload = new auth_payload();

        AuthPayload.setCountryCode("996");
        AuthPayload.setPhone("599989981");
        AuthPayload.setSmsType("LOGIN");
        AuthPayload.setOtphash("string");
        AuthPayload.setCode(123456);
        AuthPayload.setDeviceToken("string");
        AuthPayload.setMobileName("string");
        AuthPayload.setMobileOS("ANDROID");


    }


    @Test(priority = 1)
    public void getUserId(){
        //send sms
        Response smsResponse = auth_end_points
                .Post_method(AuthPayload, Routes.send_sms);
        Assert
                .assertEquals(smsResponse.getStatusCode(), 200);
        //verify sms
        Response verifyResponse = auth_end_points
                .Post_method(AuthPayload, Routes.verify_sms);
        verifyResponse
                .then()
                .log()
                .all();
        Assert
                .assertEquals(verifyResponse.getStatusCode(), 202);

    }


    @Test(dependsOnMethods = "getUserId")
    public void getTokenByLogin(){
        // send and verify sms
        auth_end_points
                .Post_method(AuthPayload, Routes.send_sms);
        Response verResponse = auth_end_points
                .Post_method(AuthPayload, Routes.verify_sms);
        // set variable get from response in string
        userSmsId = verResponse.asString();
        AuthPayload.setUserSMSId(userSmsId);
        //send request to get token
        Response response = auth_end_points
                .Post_method(AuthPayload, Routes.login_url);
        response
                .then()
                .log()
                .all();

    }


    //TODO login with invalid usersmsid
    //TODO login with invalid mobile
    //TODO login with unregistered mobile number

}
