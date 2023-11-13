package zw.rodney.springrestapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import zw.rodney.springrestapi.model.Employee;
import zw.rodney.springrestapi.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService eService;


    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return eService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return this.eService.getSingleEmployee(id);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@Valid @RequestBody Employee employee){
        return eService.saveEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee.setId(id);
        return eService.updateEmployee(employee);
    }

    @DeleteMapping("/employees")
    public void deleteEmployee(@RequestParam("id") Long id){
        eService.deleteEmployee(id);
    }
}
