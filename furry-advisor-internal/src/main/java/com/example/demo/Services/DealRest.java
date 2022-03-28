package com.example.demo.Services;

import java.net.URI;
import java.net.http.HttpResponse;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.Entidades.DealDB;
import com.example.demo.Entidades.DealDBJson;
import com.example.demo.Entidades.PlaceDB;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class DealRest {
	
	interface DealComplete extends DealDB.Basico,DealDB.Completo{}
	
	@Autowired
	private DealService dealRepository;
	
	@Autowired
	private PlaceService placeRepository;
	
	@JsonView(DealDB.Basico.class)
	@GetMapping("/existingDeal")
	public ResponseEntity<List<DealDB>> findAllByPlaceOriginIsNotNull(){
		DealDB newDeal = new DealDB("cabecera2","descripcion23",null,null);
		dealRepository.save(newDeal);
		List<DealDB> deals = dealRepository.findAllByPlaceOriginIsNotNull();
		if(deals!=null) {
			return ResponseEntity.ok(deals);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//@JsonView(DealDB.Basico.class)
	@PostMapping("/deal")
	public ResponseEntity<DealDBJson> save(@RequestBody DealDBJson deal){
		PlaceDB place = placeRepository.findByName(deal.getPlaceName()).get(0);
		DealDB newDeal = new DealDB(deal.getHeader(),deal.getDescription(),place);
		dealRepository.save(newDeal);
		System.out.println("Añadido");
		return new ResponseEntity<DealDBJson>(deal,HttpStatus.OK);
	}
}
