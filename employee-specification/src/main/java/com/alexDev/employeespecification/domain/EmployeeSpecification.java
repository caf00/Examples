package com.alexDev.employeespecification.domain;

import com.alexDev.employeespecification.domain.entity.City;
import com.alexDev.employeespecification.domain.entity.Employee;
import com.alexDev.employeespecification.domain.entity.Employee_;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class EmployeeSpecification {

    public static Specification<Employee> createSearchSpecification(String name,
                                                      String lastName,
                                                      City city,
                                                      LocalDate fromDate,
                                                      LocalDate toDate) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(Objects.nonNull(name)) {
                predicates.add(criteriaBuilder.like(root.get(Employee_.name), "%" + name + "%"));
            }
            if(Objects.nonNull(lastName)) {
                predicates.add(criteriaBuilder.like(root.get(Employee_.lastName), "%" + lastName + "%"));
            }
            if(Objects.nonNull(city)) {
                predicates.add(criteriaBuilder.equal(root.get(Employee_.city), city));
            }
            if(Objects.nonNull(fromDate) || Objects.nonNull(toDate)) {
                predicates.add(criteriaBuilder.between(root.get(Employee_.hiringDate), fromDate, toDate));
            }
            query.orderBy(criteriaBuilder.desc(root.get(Employee_.id)));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
