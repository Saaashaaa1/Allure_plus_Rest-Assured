import apimethods.GetRest;
import data.User;
import data.UserForPost;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import specifications.SpecificationsRest;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@DisplayName("REST ASSURED TEST")
public class RestAssuredTest {
    static final String URL = "http://127.0.0.1:8080/";

    @BeforeClass
    public static void init() {
        SpecificationsRest.setSpecForRestAssured(SpecificationsRest.setReqSpec(URL), SpecificationsRest.setResponceSpec200());

    }

    @Test
    @Description("given()\n" +
            "                .when()\n" +
            "                .get(\"users/\" + id)\n" +
            "                .then().log().all()\n" +
            "                .extract().body().jsonPath().get().toString();")
    @DisplayName("GET USER BY ID")
    public void test1() {//get reqBODY in String format
        String id = "123456780";
        System.out.println("JSON BODY " + GetRest.getUserById(id));
    }

    @Test

    public void test2() {
        given()

                .when()
                .get("users/123456780")
                .then().log().all()//log in console
                .body("email", equalTo("sss"));

    }

    @Test
    public void test3() {
        given()
                .when()

                .get("users")//get LIst
                .then().log().all()//log in console
                .body("email", equalTo("sss"));

    }

    @Test
    public void test4() {
        given()
                .when()

                .get("users")
                .then().log().all()//log in console
                .body("email", notNullValue())
                .body("id", notNullValue());
    }

    @Test
    public void test5() {
        User user = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "users/123456780")
                .then().log().all()//log in console
                .extract().as(User.class);
        System.out.println(user.username);
    }

    @Test
    public void test6() {
        List<User> users = given()
                .when()

                .get("users")
                .then().log().all()//log in console
                .extract().body().jsonPath().getList(".", User.class);
        for (User x : users) {
            System.out.println(x.username);
        }
    }

    @Test
    public void test7() {
        SpecificationsRest.setSpecForRestAssured(SpecificationsRest.setReqSpec(URL), SpecificationsRest.setResponceSpec201());

        UserForPost user = new UserForPost("Nikolay", "nikolay@mail.com", "nik999");
        Response response = given()
                .when()
                .body(user)
                .post("users")
                .then().log().all()
                .extract().response();
        System.out.println((String) response.jsonPath().get("id"));
    }

}
