package EmployeeDummy.Employee.request.Builder;

import EmployeeDummy.Employee.request.EmployeeRequest;

public class BuildNewEmployee extends EmployeeRequestBuilder {
    public BuildNewEmployee(){
        super.employee=new EmployeeRequest();
    }

    @Override
    public void Buildname() {
        employee.setName("luissa");
    }


    @Override
    public void Buildsalary() {
        employee.setSalary("90");
    }

    @Override
    public void Buildage() {
        employee.setAge("22");
    }
}
