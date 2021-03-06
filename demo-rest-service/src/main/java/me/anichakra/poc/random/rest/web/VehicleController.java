package me.anichakra.poc.random.rest.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.random.rest.domain.Vehicle;
import me.anichakra.poc.random.rest.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	@Qualifier("default")
	private VehicleService vehicleService;

	@PostMapping
	public Vehicle saveVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.saveVehicle(vehicle);		
	}

	@GetMapping ("/search")
	public List<Vehicle> searchVehicle(@RequestParam("manufacturer") String manufacturer) {
		return vehicleService.searchVehicle(manufacturer);
	}
	
	@GetMapping("/{id}")
	public Vehicle getVehicle(@PathVariable("id") Long id){
		return vehicleService.getVehicle(id);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteVehicle(@RequestParam("id") Long id) {
		vehicleService.deleteVehicle(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
