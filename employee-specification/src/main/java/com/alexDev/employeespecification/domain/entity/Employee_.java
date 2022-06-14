package com.alexDev.employeespecification.domain.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@StaticMetamodel(Employee.class)
public abstract class Employee_ {
    public static volatile SingularAttribute<Employee, Integer> id;
    public static volatile SingularAttribute<Employee, String> name;
    public static volatile SingularAttribute<Employee, String> lastName;
    public static volatile SingularAttribute<Employee, City> city;
    public static volatile SingularAttribute<Employee, LocalDate> hiringDate;
}
