package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidades.DealDB;
import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Interfaces.DealDBInterface;

@Service
public class DealService {

	@Autowired
	private DealDBInterface dealRepository;
	
	public List<DealDB> findByHeader(String header){
		return dealRepository.findByHeader(header);
	}
	
	public List<DealDB> findAllByPlaceOriginIsNotNull(){
		return dealRepository.findAllByPlaceOriginIsNotNull();
	}
	
	public List<DealDB> findAllByPlaceOrigin(PlaceDB placeOrigin){
		return dealRepository.findAllByPlaceOrigin(placeOrigin);
	}
	
	public void save(DealDB deal){
		dealRepository.save(deal);
	}
	
	public void delete(DealDB deal) {
		dealRepository.delete(deal);
	}
}
