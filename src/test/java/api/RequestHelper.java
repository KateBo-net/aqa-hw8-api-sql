package api;

import data.AuthInfo;
import data.CardInfo;
import data.TransferInfo;
import data.VerifyInfo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RequestHelper {

    private RequestHelper() {
    }

    private static final RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(9999)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static void postAuth(AuthInfo user) {
        given()
                .spec(requestSpec)
                .body(user)
                .when()
                .post("/api/auth")
                .then()
                .statusCode(200);
    }

    public static String postVerify(VerifyInfo info) {
        return given()
                .spec(requestSpec)
                .body(info)
                .when()
                .post("/api/auth/verification")
                .then()
                .statusCode(200)
                .log().body()
                .extract().jsonPath().getString("token");
    }

    public static List<CardInfo> getCards(String token) {
        return given()
                .spec(requestSpec)
                .header("Authorization",
                        "Bearer " + token)
                .when()
                .get("/api/cards")
                .then()
                .statusCode(200)
                .log().body()
                .extract().jsonPath().getList("", CardInfo.class);
    }

    public static void postTransfer(String token, TransferInfo info) {
        given()
                .spec(requestSpec)
                .header("Authorization",
                        "Bearer " + token)
                .body(info)
                .when()
                .post("/api/transfer")
                .then()
                .statusCode(200);
    }
}
