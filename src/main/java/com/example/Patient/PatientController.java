package com.example.Patient;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@GetMapping("/all")
	public List<PatientEntity> getAllPatients(){
		return patientService.getAllPatients();
	}
	
	@PostMapping("/new")
	public PatientEntity createPatient(@RequestBody PatientEntity patientEntity) {
		return patientService.savePatient(patientEntity);
	}
	
	@GetMapping("/{pid}")
	public ResponseEntity<PatientEntity> getPatientById(@PathVariable String pid){
		Optional<PatientEntity> patientById = patientService.getPatientById(pid);
		return patientById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{pid}")
	public ResponseEntity<PatientEntity> updatePatientById(@PathVariable String pid, @RequestBody PatientEntity patientEntity){
		try {
			PatientEntity updatedPatientById = patientService.updatePatientById(pid, patientEntity);
			return ResponseEntity.ok(updatedPatientById);
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{pid}")
	public ResponseEntity<Void> deletePatientById(@PathVariable String pid){
		patientService.deletePatientById(pid);
		return ResponseEntity.noContent().build();
	}
}




