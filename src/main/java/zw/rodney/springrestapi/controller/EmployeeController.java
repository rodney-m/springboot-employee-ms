package zw.rodney.springrestapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Employee>>  getEmployees(){
        return new ResponseEntity<List<Employee>>(eService.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee>  getEmployee(@PathVariable Long id){
        return new ResponseEntity<Employee>(this.eService.getSingleEmployee(id), HttpStatus.OK) ;
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<Employee>(eService.saveEmployee(employee), HttpStatus.CREATED) ;
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee.setId(id);
        return new ResponseEntity<Employee>(eService.updateEmployee(employee), HttpStatus.OK ) ;
    }

    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("id") Long id){
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT) ;
    }

    @GetMapping("/employees/filterByName")
    public ResponseEntity<List <Employee>> getEmployeesByName(@RequestParam String name){
        return new ResponseEntity<List <Employee>>(eService.getEmployeesByName(name), HttpStatus.OK);
    }
}
