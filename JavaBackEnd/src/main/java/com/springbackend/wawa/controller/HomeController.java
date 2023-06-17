package com.springbackend.wawa.controller;

/*
 * @author Wahyu Nugroho Indrawinata
 * Backend dengan SpringBoot Hibernate/JPA
 * 
 */

import com.springbackend.wawa.component.Constants;
import com.springbackend.wawa.model.Parkiran;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbackend.wawa.service.ParkiranService;

@RestController
public class HomeController extends BaseController {

	@Autowired
	private ParkiranService parkirService;
	
	@Override
	String authKeys(String Appkeys) throws Exception {
		if(!Appkeys.equals(Constants.APPKEYS)) {
			throw new Exception("App Keys is Invalid....");
		}
		return "";
	}

	@GetMapping("/total")
	public ResponseEntity<Parkiran> getTotal(@RequestParam("noPlat") String no_plat,
											 @RequestHeader("Authorization") String Appkeys) {
		Parkiran listParkir = new Parkiran();
		try {
			authKeys(Appkeys);
			listParkir = parkirService.getTotal(no_plat);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listParkir, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listParkir, HttpStatus.OK);
	}

	@PostMapping("/checkin")
	public ResponseEntity<?> insertData(@RequestBody String content, @RequestHeader("Authorization") String Appkeys) {
		try {
			authKeys(Appkeys);
			Parkiran p = new ObjectMapper().readValue(content, Parkiran.class);
			Parkiran result = parkirService.insert(p);
			return new ResponseEntity<>(result.getNoTransaksi(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/checkout")
	public ResponseEntity<?> updateData(@RequestBody String content, @RequestHeader("Authorization") String Appkeys) {
		try {
			authKeys(Appkeys);
			Parkiran p = new ObjectMapper().readValue(content, Parkiran.class);
			parkirService.update(p);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Berhasil", HttpStatus.OK);
	}

}
