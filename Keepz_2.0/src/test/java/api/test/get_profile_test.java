package api.test;

import api.endpoint.Routes;
import api.endpoint.profile_end_points;
import api.endpoint.auth_end_points;
import api.payload.auth_payload;
import api.payload.profile_payload;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class get_profile_test {

    auth_payload AuthPayload;
    private String userSmsId;


    @BeforeClass
    public void setupData() {

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



    @Test
    public void get_logged_user_profile(){

        auth_end_points
                .Post_method(AuthPayload, Routes.send_sms);
        Response response = auth_end_points
                .Post_method(AuthPayload, Routes.verify_sms);

        userSmsId = response.asString();
        AuthPayload.setUserSMSId(userSmsId);

            //send request to get token
        Response verResp = auth_end_points
                    .Post_method(AuthPayload, Routes.login_url);
        JsonPath jsonPath = verResp.jsonPath();
        String token = jsonPath.getString("access_token");

        Response proResp = profile_end_points.getMethod(token, Routes.get_profile);
        proResp.then().log().all();


    }

}
