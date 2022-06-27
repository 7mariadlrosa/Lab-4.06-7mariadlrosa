package service.interfaces;

import enums.Status;
import model.Employee;

public interface IEmployeeService {

    //CREATE ROUTE TO ADD NEW EMPLOYEE
    public Employee addNewEmployee(Employee employee);

    //CREATE ROUTE CHANGE EMPLOYEE STATUS
    public void changeEmployeeStatus(Integer employeeId, Status status);

    //CREATE ROUTE CHANGE EMPLOYEE NAME
    public void changeEmployeeName(Integer employeeId, String name);

    //CREATE ROUTE CHANGE EMPLOYEE DEPARTMENT
    public void changeEmployeeDepartment(Integer employeeId, String department);
}