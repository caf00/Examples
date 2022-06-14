package com.alexDev.employeespecification.web;

import com.alexDev.employeespecification.application.SearchEmployeeUseCase;
import com.alexDev.employeespecification.domain.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/employees")
public class SearchEmployeeController {

    private final SearchEmployeeUseCase searchEmployeeUseCase;

    public SearchEmployeeController(SearchEmployeeUseCase searchEmployeeUseCase) {
        this.searchEmployeeUseCase = searchEmployeeUseCase;
    }

    @GetMapping
    public ResponseEntity<Page<Employee>> listEmployee(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) Integer cityId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate

    ) {
        Page<Employee> employees = searchEmployeeUseCase.execute(
                PageRequest.of(page, size), name, lastName, cityId, fromDate, toDate);

        return ResponseEntity.ok(employees);
    }
}
