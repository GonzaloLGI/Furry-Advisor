package com.example.demo.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entidades.DealDB;
import com.example.demo.Entidades.PlaceDB;
import com.example.demo.Interfaces.DealDBInterface;
import com.example.demo.Interfaces.PlaceDBInterface;

//Clase del controlador encargado de gestionar las peticiones surgidas en el HTML Place
@Controller
public class PlaceController {

@Autowired
private PlaceDBInterface placeRepository;

@Autowired
private DealDBInterface dealRepository;


@GetMapping("/place")
public String place(Model model, @RequestParam String place_name) {    
    List<PlaceDB> places = placeRepository.findByName(place_name);
    PlaceDB aux = places.get(0);
    model.addAttribute("place_name",aux.getName());
    model.addAttribute("place_address",aux.getAddress());
    model.addAttribute("place_desc",aux.getDescription());
    model.addAttribute("place_type",aux.getType());
    model.addAttribute("place_rating",aux.getRating());
    model.addAttribute("place_url",aux.getPlace_url());
    model.addAttribute("place_schedule",aux.getSchedule());
    List<DealDB> deals = dealRepository.findAllByPlaceOrigin(aux);
    model.addAttribute("deal1",deals.get(0).getHeader());
    return "place";
    
 
}



}
