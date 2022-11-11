package EmployeeDummy.Employee.request.Builder;

import EmployeeDummy.Employee.request.EmployeeRequest;

public class BuildNewEmployee extends EmployeeRequestBuilder {
    public BuildNewEmployee(){
        super.employee=new EmployeeRequest();
    }

    @Override
    public void Buildname() {
        employee.setName("Daniela");
    }


    @Override
    public void Buildsalary() {
        employee.setSalary("0");
    }

    @Override
    public void Buildage() {
        employee.setAge("17 años");
    }
}
