package projet.wcs.starter.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.dao.Item;
import projet.wcs.starter.dto.ItemDto;
import projet.wcs.starter.repositories.ItemRepository;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
@CrossOrigin
public class ItemController {

    @Autowired private ItemRepository repo;
    @Autowired private ModelMapper modelMapper;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<ItemDto> getAll() {
        return repo.findAll().stream().map(
                item -> modelMapper.map(item, ItemDto.class)
        ).collect(Collectors.toList());
    }

    @PostMapping("/create")
    public ItemDto create(@RequestBody @Valid ItemDto item) {
        Item savedItem = repo.save(modelMapper.map(item, Item.class));
        return modelMapper.map(savedItem, ItemDto.class);
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
    public Item getItem(@PathVariable Integer id) {
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
