package EmployeeDummy.Employee.request.Builder;

import EmployeeDummy.Employee.request.EmployeeRequest;

public abstract class EmployeeRequestBuilder {
    protected EmployeeRequest employee;

    public EmployeeRequest getEmployee(){
        return  employee;
    }


    public abstract  void Buildname();
    public abstract  void Buildsalary();
    public abstract  void Buildage();
}
