package projet.wcs.starter.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.dao.Restaurant;
import projet.wcs.starter.repositories.RestaurantRepository;

import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
@CrossOrigin
public class RestaurantController {

    @Autowired private RestaurantRepository restaurantRepository;

    @Autowired private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Integer id) {
        Restaurant restaurant = new Restaurant();
        if (id != null) {
            Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
            if (optionalRestaurant.isPresent()){
                restaurant = optionalRestaurant.get();
            }
        }
        return restaurant;
    }

}
