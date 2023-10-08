package com.app.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.api.entities.Patient;

@Repository
public interface PatientRepository extends CrudRepository <Patient, Integer> {

	List <Patient> findByDeletedAtNull();
}
