package com.alexDev.employeespecification.domain;

import com.alexDev.employeespecification.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer>,
        JpaSpecificationExecutor<Employee> {
}
