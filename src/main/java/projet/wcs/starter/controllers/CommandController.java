package projet.wcs.starter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.entities.Command;
import projet.wcs.starter.repositories.CommandRepository;

import java.util.*;

@RestController
@RequestMapping("/commands")
@CrossOrigin
public class CommandController {
    @Autowired CommandRepository repo;

    @GetMapping
    public List<Command> getAll() {
        return repo.findAll();
    }

    @PostMapping("/create")
    public Command create(@RequestBody Command command) {
        return repo.save(command);
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
    public Command getTable(@PathVariable Integer id) {
        Command command = new Command();
        if (id != null) {
            Optional<Command> optionalOrder = repo.findById(id);
            if (optionalOrder.isPresent()) {
                command = optionalOrder.get();
            }
        }
        return command;
    }
}
