package com.app.api.controller;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.app.api.entities.Patient;
import com.app.api.service.PatientService;

@CrossOrigin(origins = {"http://localhost:3000", "https://endearing-cascaron-25820e.netlify.app"})
@RestController
public class PatientController {
	
	@Autowired
	private PatientService service;

	@RequestMapping("/patients")
	List<Patient> patients() {
		return service.getPatients();
	}

	@RequestMapping("/patients/{id}")
	Patient getPatient(@PathVariable int id) {
		return service.getPatient(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/patients")
	void addPatient(@RequestBody Patient patient) {
		service.addPatient(patient);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/patients")
	void updatePost(@RequestBody Patient patient) {
		service.updatePatient(patient);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/patients/{id}")
	void updatePost(@PathVariable int id) {
		service.deletePatient(id);
	}
}
