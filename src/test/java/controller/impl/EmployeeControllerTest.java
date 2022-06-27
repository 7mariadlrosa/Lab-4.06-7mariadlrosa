package controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import enums.Status;
import model.Employee;
import service.impl.EmployeeService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class EmployeeControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private EmployeeService employeeService;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void findAll_NoParams_AllEmployees() throws Exception {
        MvcResult result = mockMvc.perform(get("/all-doctors")).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Laura"));
        assertTrue(result.getResponse().getContentAsString().contains("Ana"));
    }

    @Test
    void findByEmployeeId_CorrectId_Found() throws Exception {
        MvcResult result = mockMvc.perform(get("/doctor-by-id/456345")).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Laura"));

    }

    @Test
    void findByStatus() throws Exception {
        MvcResult result = mockMvc.perform(get("/doctors-by-status/ON")).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Laura"));
        assertFalse(result.getResponse().getContentAsString().contains("Ana"));
    }

    @Test
    void findByDepartment() throws Exception {
        MvcResult result = mockMvc.perform(get("/doctors-by-department/cardiology")).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Laura"));
        assertFalse(result.getResponse().getContentAsString().contains("Ana"));
    }
//NO SÉ POR QUÉ DA ERROR EL ENUM AL METER LOS TEST
    @Test
    void addNewEmployee() throws Exception {
        Employee employee = new Employee(657234, "pediatry", "Ana González", Status.ON);
        String body = objectMapper.writeValueAsString(employee);
        MvcResult result = mockMvc.perform(
                post("/employee")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("González"));
    }

    @Test
    void changeEmployeeStatus() throws Exception {
        String body = "{\"status\": \"OFF\"}";
        MvcResult result = mockMvc.perform(
                patch("/employee-status/123456")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNoContent()).andReturn();
    }

    @Test
    void changeEmployeeName() throws Exception {
        String body = "{\"name\": \"Coneja\"}";
        MvcResult result = mockMvc.perform(
                patch("/employee-name/657234")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNoContent()).andReturn();
    }

    @Test
    void changeEmployeeDepartment() throws Exception {
        String body = "{\"department\": \"pediatry\"}";
        MvcResult result = mockMvc.perform(
                patch("/employee-department/657234")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNoContent()).andReturn();
    }
}
