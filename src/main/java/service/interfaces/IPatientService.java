package service.interfaces;

import model.Patient;

public interface IPatientService {

    //CREATE ROUTE TO ADD NEW PATIENT
    public Patient addNewPatient(Patient patient);

    //CREATE PATIENT INFORMATION
    public void updateAnyPatientInformation(Integer patientId, Patient patient);
}
