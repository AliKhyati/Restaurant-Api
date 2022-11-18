package projet.wcs.starter.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.dao.Reservation;
import projet.wcs.starter.dao.RestaurantTable;

import projet.wcs.starter.dto.ReservationDto;
import projet.wcs.starter.dto.RestaurantTableDto;
import projet.wcs.starter.repositories.RestaurantTableRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tables")
@CrossOrigin
public class RestaurantTableController {
    @Autowired private RestaurantTableRepository repo;
    @Autowired private ModelMapper modelMapper;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<RestaurantTableDto> getAll() {
        return repo.findAll().stream().map(
                restaurantTable -> modelMapper.map(restaurantTable, RestaurantTableDto.class)
        ).collect(Collectors.toList());
    }

    @PostMapping
    public RestaurantTableDto create(@RequestBody @Valid RestaurantTableDto table) {
        RestaurantTable savedTable = repo.save(modelMapper.map(table, RestaurantTable.class));
        return modelMapper.map(savedTable, RestaurantTableDto.class);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        if (id != null) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public RestaurantTable getTable(@PathVariable Integer id) {
        RestaurantTable restaurantTable = new RestaurantTable();
        if (id != null) {
            Optional<RestaurantTable> optionalRestaurantTable = repo.findById(id);
            if (optionalRestaurantTable.isPresent()) {
                restaurantTable = optionalRestaurantTable.get();
            }
        }
        return restaurantTable;
    }
}
