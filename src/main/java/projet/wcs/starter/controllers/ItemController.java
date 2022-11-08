package projet.wcs.starter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.entities.Item;
import projet.wcs.starter.repositories.ItemRepository;

import java.util.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired private ItemRepository repo;

    @GetMapping
    public List<Item> getAll() {
        return repo.findAll();
    }

    @PostMapping("/create")
    public Item create(@RequestBody Item item) {
        item.setCreatedAt(new Date());
        item.setUpdatedAt(new Date());
        return repo.save(item);
    }

    @DeleteMapping
    public boolean delete(@RequestParam Integer id) {
        if (id != null) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public Item getTable(@PathVariable Integer id) {
        Item item = new Item();
        if (id != null) {
            Optional<Item> optionalItem = repo.findById(id);
            if (optionalItem.isPresent()) {
                item = optionalItem.get();
            }
        }
        return item;
    }
}
