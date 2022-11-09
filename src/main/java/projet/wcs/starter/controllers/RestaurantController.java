package projet.wcs.starter.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.entities.Restaurant;
import projet.wcs.starter.models.AuthRestaurantRequest;
import projet.wcs.starter.models.MessageResponse;
import projet.wcs.starter.repositories.RestaurantRepository;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {

    @Autowired RestaurantRepository restaurantRepository;



}
