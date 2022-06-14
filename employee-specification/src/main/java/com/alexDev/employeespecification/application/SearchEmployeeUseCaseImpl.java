package com.alexDev.employeespecification.application;

import com.alexDev.employeespecification.domain.CityJpaRepository;
import com.alexDev.employeespecification.domain.EmployeeJpaRepository;
import com.alexDev.employeespecification.domain.EmployeeSpecification;
import com.alexDev.employeespecification.domain.entity.City;
import com.alexDev.employeespecification.domain.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class SearchEmployeeUseCaseImpl implements SearchEmployeeUseCase{

    private final EmployeeJpaRepository employeeJpaRepository;
    private final CityJpaRepository cityJpaRepository;

    public SearchEmployeeUseCaseImpl(EmployeeJpaRepository employeeJpaRepository,
                                     CityJpaRepository cityJpaRepository) {
        this.employeeJpaRepository = employeeJpaRepository;
        this.cityJpaRepository = cityJpaRepository;
    }

    @Override
    public Page<Employee> execute(Pageable pageable,
                                  String name,
                                  String lastName,
                                  Integer cityId,
                                  LocalDate fromDate,
                                  LocalDate toDate) {

        City city = (Objects.nonNull(cityId)) ? findCity(cityId): null;

        Specification<Employee> employeeSpec = EmployeeSpecification
                .createSearchSpecification(name, lastName, city, fromDate, toDate);

        return employeeJpaRepository.findAll(employeeSpec, pageable);
    }

    private City findCity(Integer cityId) {
        return cityJpaRepository.findById(cityId)
                .orElse(null);
    }
}
