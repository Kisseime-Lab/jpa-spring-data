package com.example.day1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.example.day1.employe_with_one_adresse.Adresse;
import com.example.day1.employe_with_one_adresse.Contrat;
import com.example.day1.employe_with_one_adresse.ContratRepository;
import com.example.day1.employe_with_one_adresse.Employe;
import com.example.day1.employe_with_one_adresse.EmployeRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class Day1ApplicationTests {

	@Autowired
	EmployeRepository er;
	@Autowired
	ContratRepository cr;

	@Test
	@Transactional
	void contextLoads() {
		Employe e1 = new Employe();
		String employe_id = e1.getId();
		Adresse a1 = new Adresse();
		a1.setLibelle("40 avenue de la liberation");
		a1.setVille("Lyon");
		a1.setZip("69000");
		e1.setAdresse(a1);
		Contrat c1 = new Contrat();
		String c1_id = c1.getId();
		c1.setEmploye(e1);
		er.save(e1);
		er.delete(e1);
		System.out.println("--- debut appel 1 ------");
		er.findById(employe_id);
		System.out.println("--- Fin appel 1 ------");
		System.out.println("--- debut appel 2 ------");
		er.findById(employe_id);
		System.out.println("--- Fin appel 2 ------");
		System.out.println("--- debut appel 3 ------");
		er.findById(employe_id);
		System.out.println("--- debut appel 4 ------");
		er.findById(employe_id);
		System.out.println("--- Fin appel 4 ------");
		System.out.println(cr.findById(c1_id).stream().count());
	}

}
