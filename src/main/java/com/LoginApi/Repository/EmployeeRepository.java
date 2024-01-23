package com.LoginApi.Repository;

import com.LoginApi.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Employee findByEmail(String email);

    Optional<Employee> findByEmailAndPassword(String email,String password);
}
