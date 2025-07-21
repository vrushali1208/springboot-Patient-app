package com.example.Patient;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	PatientRepository patientRepository;

	@Override
	public List<PatientEntity> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public PatientEntity savePatient(PatientEntity patientEntity) {
		return patientRepository.save(patientEntity);
	}

	@Override
	public Optional<PatientEntity> getPatientById(String pid) {
		return patientRepository.findById(pid);
	}

	@Override
	public PatientEntity updatePatientById(String pid, PatientEntity patientEntity) {
		PatientEntity patient = patientRepository.findById(pid).orElseThrow();
		patient.setFname(patientEntity.getFname());
		patient.setLname(patientEntity.getLname());
		patient.setAge(patientEntity.getAge());
		patient.setPhone(patientEntity.getPhone());
		patient.setAddress(patientEntity.getAddress());
		PatientEntity updatePatientById = patientRepository.save(patient);
		return updatePatientById;
	}

	@Override
	public void deletePatientById(String pid) {
		patientRepository.deleteById(pid);	
	}

}
