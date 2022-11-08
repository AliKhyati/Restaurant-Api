package projet.wcs.starter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.entities.Category;
import projet.wcs.starter.entities.Item;
import projet.wcs.starter.repositories.CategoryRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired private CategoryRepository repo;

    @GetMapping
    public List<Category> getAll() {
        return repo.findAll();
    }

    @PostMapping("/create")
    public Category create(@RequestBody Category category) {
        category.setCreatedAt(new Date());
        category.setUpdatedAt(new Date());
        return repo.save(category);
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
