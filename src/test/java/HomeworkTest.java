import org.junit.BeforeClass;
import org.junit.Test;
import specifications.SpecificationsRest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

//Написать тесты используя RestAssured:
// 1.) Получить юзера по username (Get(path = "/users/findByUsername/{username}"
// 2.) Проверить что у всех Users поле почта не пустое (Get(path = "/users"))
public class HomeworkTest {
    static final String URL = "http://127.0.0.1:8080/";
    @BeforeClass
    public static void init() {
        SpecificationsRest.setSpecForRestAssured(SpecificationsRest.setReqSpec(URL),
                SpecificationsRest.setResponceSpec200());
    }
    @Test
    public void test1(){
         given()
                .when()
                .get(URL + "users/findByUsername/Kim")
                .then().log().all();//log in console
      //  http://127.0.0.1:8080/users/findByUsername/Kylie
    }
@Test
    public void test2(){
        given()
                .when()
                .get(URL + "users")
                .then().log().all()//вывод в консоль
                .body("email",notNullValue());;
}






}
