package projet.wcs.starter.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.dao.Command;
import projet.wcs.starter.dto.CommandDto;
import projet.wcs.starter.dto.ItemDto;
import projet.wcs.starter.repositories.CommandRepository;
import projet.wcs.starter.services.CommandService;

import java.util.*;

@RestController
@RequestMapping("/commands")
@CrossOrigin
public class CommandController {
    @Autowired CommandRepository repo;
    @Autowired CommandService commandService;

    @GetMapping
    public List<CommandDto> getAll() {
        return commandService.getAll();
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

    @PutMapping("/{id}/status")
    public CommandDto updateStatus(@PathVariable int id, @RequestBody String status) {
       return commandService.updateStatus(id, status);
    }

    @PutMapping("/{id}/items")
    public CommandDto updateItems(@PathVariable Integer id, @RequestBody @Valid List<ItemDto> items) {
      return commandService.updateItems(id, items);
    }

    @DeleteMapping("/{commandId}/{itemId}")
    public CommandDto deleteItem(@PathVariable Integer commandId, @PathVariable Integer itemId, @RequestParam Float total) {
        return commandService.deleteItem(commandId, itemId, total);
    }

    @PutMapping("/{id}/total")
    public CommandDto updateTotal(@PathVariable Integer id, @RequestBody @Valid Float total) {
        return commandService.updateTotal(id, total);
    }

    @GetMapping("/status")
    public List<CommandDto> getKitchenCommand() {
        return commandService.getKitchenCommand();
    }

}
