package controller.interfaces;

import model.Patient;

public interface IPatientController {

    //CREATE NEW PATIENT
    public Patient addNewPatient(Patient patient);

    //CREATE PATIENT INFORMATION
    public void updateAnyPatientInformation(Integer patientId, Patient patient);

}
