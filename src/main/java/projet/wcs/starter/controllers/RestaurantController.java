package projet.wcs.starter.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.dto.RestaurantDto;
import projet.wcs.starter.repositories.RestaurantRepository;

@RestController
@RequestMapping("/restaurants")
@CrossOrigin
public class RestaurantController {

    @Autowired private RestaurantRepository repo;
    @Autowired private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public RestaurantDto getRestaurantById(@PathVariable Integer id) {
        return modelMapper.map(repo.findById(id).get(), RestaurantDto.class);
    }
}
