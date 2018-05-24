package me.anichakra.poc.random.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.anichakra.poc.random.rest.domain.Vehicle;



@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoRestServiceApplicationTests {
	
    
    private MockMvc mockMvc;
    
    @Autowired
    WebApplicationContext context;
    
   

    @Before
    public void setup() {
        //this.mockMvc = MockMvcBuilders.standaloneSetup(new WeatherApiController()).build();
    	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


	@Test
	public void retrievetest_ok() throws Exception {
		saveVehicle_ok();
		 mockMvc.perform(get("/vehicle/10" )).andDo(print())
	                .andExpect(status().isOk())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(10))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.manufacturer").value("Nissan"))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.year").value(2015))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.model").value("Ultima"));

	}
	
	
	@Test
	public void saveVehicle_ok() throws Exception {
		Vehicle v1=new Vehicle();
		v1.setManufacturer("Nissan");
		v1.setModel("Ultima");
		v1.setYear(2015);
		byte[] v1Json = toJson(v1);
		Vehicle v2=new Vehicle ();
		v1.setManufacturer("Nissan");
		v1.setModel("Micra");
		v1.setYear(2016);
		byte[] v2Json = toJson(v2);
		 mockMvc.perform(post("/vehicle" )//.andDo(print())
		 			.content(v1Json)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
		 mockMvc.perform(post("/vehicle" )//.andDo(print())
		 			.content(v2Json)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());          
	}
	
	
	@Test
	public void deleteVehicle_ok() throws Exception {
		saveVehicle_ok() ;
		Vehicle v1=new Vehicle();
		v1.setId(10l);
		v1.setManufacturer("Nissan");
		v1.setModel("Ultima");
		v1.setYear(2015);
		byte[] v1Json = toJson(v1);
		mockMvc.perform(delete("/vehicle" )//.andDo(print())
	 			.content(v1Json)
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
		
	}

	 private byte[] toJson(Object r) throws Exception {
	        ObjectMapper map = new ObjectMapper();
	        return map.writeValueAsString(r).getBytes();
	    }
}
