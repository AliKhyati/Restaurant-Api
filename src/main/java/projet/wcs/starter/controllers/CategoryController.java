package projet.wcs.starter.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.dao.Category;
import projet.wcs.starter.dto.CategoryDto;
import projet.wcs.starter.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoryController {

    @Autowired private CategoryRepository repo;
    @Autowired private ModelMapper modelMapper;

    @GetMapping
    public List<CategoryDto> getAll() {
        return repo.findAll().stream().map(
                category -> modelMapper.map(category, CategoryDto.class)
        ).collect(Collectors.toList());
    }

    @PostMapping
    public CategoryDto create(@RequestBody @Valid CategoryDto category) {
        Category savedCategory = repo.save(modelMapper.map(category, Category.class));
        return modelMapper.map(savedCategory, CategoryDto.class);
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
    public Category getCategory(@PathVariable Integer id) {
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
