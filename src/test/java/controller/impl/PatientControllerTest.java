package controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import enums.Status;
import model.Employee;
import model.Patient;
import service.impl.EmployeeService;
import service.impl.PatientService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
class PatientControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PatientService patientService;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void findAll() throws Exception {
        MvcResult result = mockMvc.perform(get("/all-patients")).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Alvaro"));
        assertTrue(result.getResponse().getContentAsString().contains("Fran"));
    }

    @Test
    void findByName() throws Exception {
        MvcResult result = mockMvc.perform(get("/patients/Alvaro Benito")).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Alvaro"));
    }


    @Test
    void findByDoctorName() throws Exception {
        MvcResult result = mockMvc.perform(get("/patient-by-doctor/Jaime de la Rosa")).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Alvaro"));
    }

    @Test
    void findByDateOfBirthBetween() throws Exception {
        String startDate="1995-10-04";
        String dateEnd="2022-06-26";
        MvcResult result = mockMvc.perform(get("/patient-by-range/"+startDate+"/"+dateEnd)).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Alvaro"));
    }

    @Test
    void findByDoctorDepartment() throws Exception {
        MvcResult result = mockMvc.perform(get("/patients-by-department/pediatry")).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Alvaro"));
    }

    @Test
    void findByDoctorStatusOff() throws Exception {
        MvcResult result = mockMvc.perform(get("/patients-by-doctor-status/OFF")).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Fran"));
    }

}
