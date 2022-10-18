package apimethods;

import data.User;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class GetRest {
    @Step ("GET USER BY ID {id}")
    @Attachment
    @Description("given()\n" +
            "                .when()\n" +
            "                .get(\"users/\" + id)\n" +
            "                .then().log().all()\n" +
            "                .extract().body().jsonPath().get().toString();")
    public static String getUserById(String id){
        String str = given()
                .when()
                .get("users/"+id)
                .then().log().all()
                .extract().body().jsonPath().get().toString();
        return str;

    }
}
