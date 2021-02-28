package utils.api;

import io.restassured.path.json.JsonPath;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static io.restassured.RestAssured.given;

public class EmailApi {
    public static final String API_GET_EMAIL_URL = "https://privatix-temp-mail-v1.p.rapidapi.com/request/mail/id/";
    public static final String HEADER_API_KEY = "48515310b0msh97b10219365ea3fp1b17d2jsna49f09625b44";
    public static final String HEADER_API_HOST = "privatix-temp-mail-v1.p.rapidapi.com";
    public static final String MAIL_PATH = "[0].mail_text";

    public static String getVerificationLink(String email) {
        String url = null;
        for (int i = 0; i < 5; i++) {
            url = tryToExtractVerificationUrl(email);
            if(Objects.nonNull(url)){
                break;
            }
        }
        return url;
    }

    private static String tryToExtractVerificationUrl(String email) {
        try {
            Response response = given().
                    header("x-rapidapi-host", HEADER_API_HOST).
                    header("x-rapidapi-key", HEADER_API_KEY).
                    when().
                    get(API_GET_EMAIL_URL + DigestUtils.md5Hex(email) + "/").
                    then().
                    extract().response();
            String jsonResponseAsString = response.asString();
            JsonPath jsonPath = new JsonPath(jsonResponseAsString);
            return StringUtils.substringBetween(jsonPath.get(MAIL_PATH), "посиланням\n[", "]");

        } catch (JsonPathException e) {
            e.printStackTrace();
            sleep(20000);
        }
        return null;
    }

    private static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
