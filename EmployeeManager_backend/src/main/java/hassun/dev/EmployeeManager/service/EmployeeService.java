package hassun.dev.EmployeeManager.service;

import hassun.dev.EmployeeManager.exception.UserNotFoundException;
import hassun.dev.EmployeeManager.model.Employee;
import hassun.dev.EmployeeManager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final   EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id ){
        employeeRepo.deleteEmployeeById(id);
    }

    public Employee findEmployee(Long id ){
        return employeeRepo.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("user with id :"+ id +" not found"));
    }
}
