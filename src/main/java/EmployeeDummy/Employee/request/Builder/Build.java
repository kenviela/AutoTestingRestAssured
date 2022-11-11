package EmployeeDummy.Employee.request.Builder;
import EmployeeDummy.Employee.request.EmployeeRequest;


public class Build {
    public EmployeeRequestBuilder employeeRequestBuilder;

    public void setEmployeeRequestBuilder (EmployeeRequestBuilder employee){
        employeeRequestBuilder=employee;
    }
    public EmployeeRequest  getEmployeeRequest(){
        return employeeRequestBuilder.getEmployee();
    }

    public  void buildEmployeeRequest(){
        employeeRequestBuilder.Buildage();
        employeeRequestBuilder.Buildsalary();
        employeeRequestBuilder.Buildname();

    }

}
