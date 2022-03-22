package com.example.demo.Services;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.Entidades.DealDB;
import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Interfaces.DealDBInterface;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class DealRest {
	
	interface DealComplete extends DealDB.Basico,DealDB.Completo,PlaceDB.Basico{}
	
	@Autowired
	private DealDBInterface dealRepository;
	
	@JsonView(DealDB.Basico.class)
	@GetMapping("/getDealByHeader/{header}")
	public ResponseEntity<List<DealDB>> findByHeader(@PathVariable String header){
		List<DealDB> deals = dealRepository.findByHeader(header);
		if(deals!=null) {
			return ResponseEntity.ok(deals);
		}else {
			return  ResponseEntity.notFound().build();
		}
	}
	
	@JsonView(DealDB.Completo.class)
	@GetMapping("/getExistingDeal")
	public ResponseEntity<List<DealDB>> findAllByPlaceOriginIsNotNull(){
		List<DealDB> deals = dealRepository.findAllByPlaceOriginIsNotNull();
		if(deals!=null) {
			return ResponseEntity.ok(deals);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@JsonView(DealDB.Basico.class)
	@GetMapping("/getDealByPlace/{place}")
	public ResponseEntity<List<DealDB>> findAllByPlaceOrigin(@PathVariable PlaceDB placeOrigin){
		List<DealDB> deals = dealRepository.findAllByPlaceOrigin(placeOrigin);
		if(deals!=null) {
			return ResponseEntity.ok(deals);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@JsonView(DealComplete.class)
	@PostMapping("/addDeal/{deal}")
	public ResponseEntity<DealDB> save(@RequestBody DealDB deal){
		dealRepository.save(deal);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(deal.getDeal_id()).toUri();
		return ResponseEntity.created(location).body(deal);
	}
}
