package com.alexDev.employeespecification.domain;

import com.alexDev.employeespecification.domain.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityJpaRepository extends JpaRepository<City, Integer> {
}
