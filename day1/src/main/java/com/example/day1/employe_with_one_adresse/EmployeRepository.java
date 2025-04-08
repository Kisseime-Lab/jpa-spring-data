package com.example.day1.employe_with_one_adresse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, String> {
}
