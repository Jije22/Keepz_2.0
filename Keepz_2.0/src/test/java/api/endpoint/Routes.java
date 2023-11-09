package api.endpoint;

public class Routes {

    public static String base_url = "https://appdev.keepz.me:8888/common-service";

    //Common Auth endpoints

    public static String send_sms = base_url + "/api/v1/auth/send-sms";

    public static String verify_sms = base_url + "/api/v1/auth/verify-sms";

    public static String login_url = base_url + "/api/v1/auth/login";

    public static String registration_url = base_url + "/api/v1/auth/registration";




}