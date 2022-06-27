package controller.interfaces;

import dto.DepartmentDto;
import dto.NameDto;
import dto.StatusDto;
import enums.Status;
import model.Employee;

public interface IEmployeeController {

    //CREATE NEW EMPLOYEE
    public Employee addNewEmployee(Employee employee);

    //CHANGE EMPLOYEE STATUS
    public void changeEmployeeStatus(Integer employeeId, StatusDto status);

    //UPTADE EMPLOYEE NAME
    public void changeEmployeeName(Integer employeeId, NameDto name);

    //UPDATE EMPLOYEE DEPARTMENT
    public void changeEmployeeDepartment(Integer employeeId, DepartmentDto department);
}
