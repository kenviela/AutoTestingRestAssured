package EmployeeDummy.Employee.request.Builder;

import EmployeeDummy.Employee.request.EmployeeRequest;
import com.github.javafaker.Faker;

public class BuildNewEmployeeFake extends EmployeeRequestBuilder {
    private static final Faker faker = new Faker();

    public BuildNewEmployeeFake(){
        super.employee=new EmployeeRequest();
    }
    public void Buildname() {
        employee.setName(faker.internet().domainName());
    }


    public void Buildsalary()  {
        employee.setSalary("4000");
    }

    public void Buildage() {
        employee.setAge(faker.number().digit().toString());
    }
}
