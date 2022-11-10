package projet.wcs.starter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.entities.RestaurantTable;
import projet.wcs.starter.repositories.RestaurantTableRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tables")
@CrossOrigin
public class RestaurantTableController {
    @Autowired private RestaurantTableRepository repo;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<RestaurantTable> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public RestaurantTable create(@RequestBody RestaurantTable table) {
        return repo.save(table);
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
