package projet.wcs.starter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.entities.Category;
import projet.wcs.starter.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoryController {

    @Autowired private CategoryRepository repo;

    @GetMapping
    public List<Category> getAll() {
        return repo.findAll();
    }

    @PostMapping("/create")
    public Category create(@RequestBody Category category) {
        return repo.save(category);
    }

    @PutMapping("/edit/{id}")
    public Category edit(@PathVariable Integer id, @RequestBody Category category) {
        return repo.save(category);
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
    public Category getTable(@PathVariable Integer id) {
        Category category = new Category();
        if (id != null) {
            Optional<Category> optionalCategory = repo.findById(id);
            if (optionalCategory.isPresent()) {
                category = optionalCategory.get();
            }
        }
        return category;
    }
}
