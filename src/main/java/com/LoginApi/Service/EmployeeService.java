package com.LoginApi.Service;

import com.LoginApi.Model.Employee;
import com.LoginApi.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired

    private EmployeeRepository employeeRepository;




    public Employee registerEmployee(Employee employee) {
            return employeeRepository.save(employee);
    }


    public String loginEmployee(Employee employee) {
        String msg = "";
        Employee employee1 = employeeRepository.findByEmail(employee.getEmail());
        if (employee1 != null) {
            String password = employee.getPassword();
            boolean isRight = password.matches(password);


            if (isRight){
                Optional<Employee>employee2=employeeRepository.findByEmailAndPassword(employee.getEmail(),employee.getPassword());

                if (employee2.isPresent()){
                    return new String("Login Success");
                }else {
                    return new String("Login Failed");
                }
            }else {
                return new String("Password Not Matched");
            }

        }else {
            return new String("Email Not Found");
        }

    }
}

