package com.examly.springapp;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class SpringappApplicationTests {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	@Transactional
    public void BE_Add_User() throws Exception {
        String newUser = "{\"email\":\"test@gmail.com\",\"password\":\"Test@123\",\"username\":\"test\",\"mobileNumber\":\"9876543210\",\"qualification\":\"swift dezire\",\"active\":\"true\",\"role\":\"frontend developer\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/signup")
		.contentType(MediaType.APPLICATION_JSON)
		.content(newUser)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
    }
	
	@Test
	@Transactional
    public void BE_Get_User() throws Exception {
	 	mockMvc.perform(MockMvcRequestBuilders.get("/admin")
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
		.andReturn();
    }
	
	@Test
	@Transactional
    public void BE_Add_Resource() throws Exception {
        String newResource = "{\"resourceId\":\"01\",\"resourceName\":\"Angular\",\"resourceLink\":\"angular.in\",\"imageUrl\":\"angularImage.com\",\"resourceCategory\":\"Frontend\",\"createdOn\":\"13-09-2021\",\"createdBy\":\"User1\",\"verified\":\"true\",\"active\":\"true\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/home")
		.contentType(MediaType.APPLICATION_JSON)
		.content(newResource)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
    }

	@Test
	@Transactional
    public void BE_Update_Resource() throws Exception {
        String newResource = "{\"resourceId\":\"01\",\"resourceName\":\"Angular\",\"resourceLink\":\"angular.in\",\"imageUrl\":\"angularImage.com\",\"resourceCategory\":\"Frontend\",\"createdOn\":\"15-09-2021\",\"createdBy\":\"User1\",\"verified\":\"true\",\"active\":\"true\"}";
        mockMvc.perform(MockMvcRequestBuilders.put("/admin/resource")
		.param("resourceId","01")
		.contentType(MediaType.APPLICATION_JSON)
		.content(newResource)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
    }
	
}
