package projet.wcs.starter.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.dao.Command;
import projet.wcs.starter.dao.Item;
import projet.wcs.starter.dto.CommandDto;
import projet.wcs.starter.dto.ItemDto;
import projet.wcs.starter.repositories.CommandRepository;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/commands")
@CrossOrigin
public class CommandController {
    @Autowired CommandRepository repo;
     @Autowired ModelMapper modelMapper;

    @GetMapping
    public List<CommandDto> getAll() {
        return repo.findAll().stream().map(
                command -> modelMapper.map(command, CommandDto.class)
        ).collect(Collectors.toList());
    }

    @PostMapping("/create")
    public CommandDto create(@RequestBody CommandDto command) {
        Command savedItem = repo.save(modelMapper.map(command, Command.class));
        return modelMapper.map(savedItem, CommandDto.class);
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
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public CommandDto update(@PathVariable int id, @RequestBody CommandDto command) {
        Command savedItem = repo.save(modelMapper.map(command, Command.class));
        return modelMapper.map(savedItem, CommandDto.class);
    }
}
