import EmployeeDummy.Employee.request.Builder.Build;
import EmployeeDummy.Employee.request.Builder.EmployeeRequestBuilder;
import EmployeeDummy.Employee.request.EmployeeRequest;
import EmployeeDummy.Employee.response.EmployeeResponse;
import EmployeeDummy.Employee.request.Builder.BuildNewEmployeeFake;
import EmployeeDummy.Employee.request.Builder.BuildNewEmployee;
import EmployeeDummy.post.request.PostRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import model.Post.Response.PostResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static data.reader.managerData.getData;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class EmployeeTest {
    String bearerToken="e99413b1c415ad6d592d5f2bef758493fc68c59188d9274a38219b8fc9cb5c55";
    ObjectMapper objectMapper = new ObjectMapper();

    Build buildEmployee= new Build();
    EmployeeRequestBuilder employeenew=new BuildNewEmployee();
    EmployeeResponse responseBodyEmployee;
    EmployeeRequestBuilder employeeFake=new BuildNewEmployeeFake();
    PostResponse responseBodyPostEmployee;
    @BeforeEach
    public void setup(){

        RestAssured.baseURI= getData("base.url.dummy");
        RestAssured.basePath=getData("base.path.dummy");
        RestAssured.filters(new RequestLoggingFilter(),new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).build();

    }
    @Test
    @Description("New Employee")
    @Epic("Create Employee")
    @Feature("Employee")
    public void createEmployeeNew() throws JsonProcessingException {
        buildEmployee.setEmployeeRequestBuilder(employeenew);
        buildEmployee.buildEmployeeRequest();
        EmployeeRequest employeeRequest = buildEmployee.getEmployeeRequest();
        String response=
                given()
                        .body(employeeRequest)
                        .header("Authorization",
                                "Bearer " + bearerToken)
                        .when()
                        .post("create")
                        .then()
                        .statusCode(200)
                        .extract().asString();

        responseBodyEmployee = objectMapper.readValue(response, EmployeeResponse.class);
        assertThat(responseBodyEmployee.getData().getName(),equalTo(responseBodyEmployee.getData().getName()));
    }

    @Test
    @Description("Employee Fake")
    @Epic("Create EMployee")
    @Feature("User fake")
    public void createEmployeeFake() throws JsonProcessingException {
        buildEmployee.setEmployeeRequestBuilder(employeeFake);
        buildEmployee.buildEmployeeRequest();
        EmployeeRequest employeeRequest = buildEmployee.getEmployeeRequest();
        String response=
                given()
                        .body(employeeRequest)
                        .header("Authorization",
                                "Bearer " + bearerToken)
                        .when()
                        .post("create")
                        .then()
                        .statusCode(200)
                        .extract().asString();

        responseBodyEmployee = objectMapper.readValue(response, EmployeeResponse.class);
        assertThat(responseBodyEmployee.getMessage(),equalTo(responseBodyEmployee.getMessage()));

    }

}
