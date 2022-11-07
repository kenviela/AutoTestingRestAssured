import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.factory.CreatePostDataFactory;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import model.Post.Request.PostRequest;
import model.Post.Response.PostResponse;
import model.User.Request.Builder.*;
import model.User.Request.UserRequest;
import model.User.Response.UserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GoRest {

    String bearerToken="e99413b1c415ad6d592d5f2bef758493fc68c59188d9274a38219b8fc9cb5c55";
    ObjectMapper objectMapper = new ObjectMapper();
    Build buildUserRequest = new Build();
    UserRequestBuilder userMale= new BuildNewUserMale();
    UserRequestBuilder userMaleFake= new BuildNewUserFake();
    UserRequestBuilder userFemale= new BuildNewUserFemale();
    UserResponse responseBodyUser;
    PostResponse responseBodyPost;
    @BeforeEach
    public void setup(){

        RestAssured.baseURI="https://gorest.co.in";
        RestAssured.basePath="/public/v2";
        RestAssured.filters(new RequestLoggingFilter(),new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).build();

    }
    @Test
    public void createUserFamale() throws JsonProcessingException {
        buildUserRequest.setUserRequestBuilder(userFemale);
        buildUserRequest.buildUserRequest();
        UserRequest userRequest = buildUserRequest.getUserRequest();
       String response=
                given()
                        .body(userRequest)
                        .header("Authorization",
                                "Bearer " + bearerToken)
                        .when()
                        .post("users")
                        .then()
                        .statusCode(201)
                        .extract().asString();

        responseBodyUser = objectMapper.readValue(response, UserResponse.class);
        assertThat(responseBodyUser.getEmail(),equalTo(responseBodyUser.getEmail()));

    }
    @Test
    public void createUsermale() throws JsonProcessingException {
        buildUserRequest.setUserRequestBuilder(userMale);
        buildUserRequest.buildUserRequest();
        UserRequest userRequest = buildUserRequest.getUserRequest();
        String response=
                given()
                        .body(userRequest)
                        .header("Authorization",
                                "Bearer " + bearerToken)
                        .when()
                        .post("users")
                        .then()
                        .statusCode(201)
                        .extract().asString();

        responseBodyUser = objectMapper.readValue(response, UserResponse.class);
        assertThat(responseBodyUser.getEmail(),equalTo(responseBodyUser.getEmail()));

    }

    @Test
    public void createUsermaleFake() throws JsonProcessingException {
        buildUserRequest.setUserRequestBuilder(userMaleFake);
        buildUserRequest.buildUserRequest();
        UserRequest userRequest = buildUserRequest.getUserRequest();
        String response=
                given()
                        .body(userRequest)
                        .header("Authorization",
                                "Bearer " + bearerToken)
                        .when()
                        .post("users")
                        .then()
                        .statusCode(201)
                        .extract().asString();

        responseBodyUser = objectMapper.readValue(response, UserResponse.class);
        assertThat(responseBodyUser.getEmail(),equalTo(responseBodyUser.getEmail()));

    }

    @Test
    public void createPostHistory() throws JsonProcessingException {
        PostRequest postRequest = new PostRequest.Builder().postHistory().build();
        Integer idUser=5943;
        String response=
                given()
                        .body(postRequest)
                        .header("Authorization",
                                "Bearer " + bearerToken)
                        .when()
                        .post("users/"+ idUser+"/posts")
                        .then()
                        .statusCode(201)
                        .extract().asString();

        responseBodyPost = objectMapper.readValue(response, PostResponse.class);
        assertThat(responseBodyPost.getUserId(),equalTo(idUser));

    }
    @Test
    public void createPostFitcion() throws JsonProcessingException {
        PostRequest postRequest = new PostRequest.Builder().postFitccion().build();
        Integer idUser=5943;
        String response=
                given()
                        .body(postRequest)
                        .header("Authorization",
                                "Bearer " + bearerToken)
                        .when()
                        .post("users/"+ idUser+"/posts")
                        .then()
                        .statusCode(201)
                        .extract().asString();

        responseBodyPost = objectMapper.readValue(response, PostResponse.class);
        assertThat(responseBodyPost.getUserId(),equalTo(responseBodyUser.getId()));

    }

    @Test
    public void createPostFitcionFakeMissingAllInformation() throws JsonProcessingException {
        PostRequest postRequest = CreatePostDataFactory.missingAllinformation();
        Integer idUser=5943;
        String response=
                given()
                        .body(postRequest)
                        .header("Authorization",
                                "Bearer " + bearerToken)
                        .when()
                        .post("users/"+ idUser+"/posts")
                        .then()
                        .statusCode(422)
                        .extract().asString();

        responseBodyPost = objectMapper.readValue(response, PostResponse.class);
        assertThat(responseBodyPost.getUserId(),equalTo(responseBodyUser.getId()));

    }
    @Test
    public void createPostFitcionFakeNews() throws JsonProcessingException {
        PostRequest postRequest = CreatePostDataFactory.news();
        Integer idUser=5943;
        String response=
                given()
                        .body(postRequest)
                        .header("Authorization",
                                "Bearer " + bearerToken)
                        .when()
                        .post("users/"+ idUser+"/posts")
                        .then()
                        .statusCode(422)
                        .extract().asString();

        responseBodyPost = objectMapper.readValue(response, PostResponse.class);
        assertThat(responseBodyPost.getUserId(),equalTo(responseBodyUser.getId()));

    }
}
