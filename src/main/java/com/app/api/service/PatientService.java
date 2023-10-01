package com.app.api.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.entities.Patient;
import com.app.api.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository repository;

	public List<Patient> getPatients() {

		List<Patient> list = new ArrayList<Patient>();
		for (Patient patient : repository.findByDeletedAtNull()) {
			list.add(patient);
		}
		return list;
	}

	public Patient getPatient(int id) {

		return repository.findById(id).get();
	}

	public void addPatient(Patient patient) {

		repository.save(patient);
	}

	public void updatePatient(Patient patient) {

		repository.save(patient);

	}

	public void deletePatient(int id) {

		Patient patient = repository.findById(id).get();
		patient.setDeletedAt(new Timestamp(System.currentTimeMillis()));
		repository.save(patient);
	}
}
