package com.LoginApi.Controller;

import com.LoginApi.Model.Employee;
import com.LoginApi.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/register")
    public String registerEmployee1(@RequestBody  Employee employee){
         employeeService.registerEmployee(employee);
         return "Employee Register successfully";
    }

    @PostMapping("/login")
    public <LoginResponse> ResponseEntity<?> loginEmployee(@RequestBody Employee employee){
        LoginResponse loginEmployee= (LoginResponse) employeeService.loginEmployee(employee);
        return ResponseEntity.ok(loginEmployee);
    }
}
