package com.example.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

	List<PatientEntity> getAllPatients();

	PatientEntity savePatient(PatientEntity patientEntity);

	Optional<PatientEntity> getPatientById(String pid);

	PatientEntity updatePatientById(String pid, PatientEntity patientEntity);

	void deletePatientById(String pid);

}
