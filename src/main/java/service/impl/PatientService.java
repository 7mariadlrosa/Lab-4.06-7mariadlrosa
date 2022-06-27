package service.impl;

import model.Employee;
import model.Patient;
import repository.PatientRepository;
import service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class PatientService implements IPatientService {

    @Autowired
    private PatientRepository patientRepository;

    //CREATE ROUTE NEW PATIENT
    public Patient addNewPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    //CREATE ROUTE UPDATE PATIENT INFORMATION
    public void updateAnyPatientInformation(Integer patientId, Patient patient){
        if (patientRepository.findById(patientId).isPresent()){
            patient.setPatientId(patientId);
            patientRepository.save(patient);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
    }
}