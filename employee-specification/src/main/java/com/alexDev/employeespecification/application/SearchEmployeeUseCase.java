package com.alexDev.employeespecification.application;

import com.alexDev.employeespecification.domain.entity.City;
import com.alexDev.employeespecification.domain.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface SearchEmployeeUseCase {
    Page<Employee> execute(Pageable pageable, String name, String lastName, Integer cityId, LocalDate fromDate, LocalDate toDate);
}
