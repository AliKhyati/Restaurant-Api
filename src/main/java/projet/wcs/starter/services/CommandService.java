package projet.wcs.starter.services;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import projet.wcs.starter.dao.Command;
import projet.wcs.starter.dao.Item;
import projet.wcs.starter.dto.CommandDto;
import projet.wcs.starter.dto.ItemDto;
import projet.wcs.starter.repositories.CommandRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandService {

    @Autowired ModelMapper modelMapper;
    @Autowired CommandRepository repo;

    public CommandDto create() {
        CommandDto command = new CommandDto();
        Command savedCommand = repo.save(modelMapper.map(command, Command.class));
        return modelMapper.map(savedCommand, CommandDto.class);
    }

    public List<CommandDto> getAll() {
        return repo.findAll().stream().map(
                command -> modelMapper.map(command, CommandDto.class)
        ).collect(Collectors.toList());
    }

    public CommandDto updateItems(@PathVariable Integer id, @RequestBody @Valid List<ItemDto> items) {
        CommandDto commandDtoUpdate = modelMapper.map(repo.findById(id).get(), CommandDto.class);
        commandDtoUpdate.setItems(items);
        repo.save(modelMapper.map(commandDtoUpdate, Command.class));
        return modelMapper.map(commandDtoUpdate, CommandDto.class);
    }

    public CommandDto deleteItem(@PathVariable Integer commandId, @PathVariable Integer itemId) {
        CommandDto command = modelMapper.map(repo.findById(commandId).get(), CommandDto.class);
        command.getItems().removeIf(i -> i.getId() == itemId);
        repo.save(modelMapper.map(command, Command.class));
        return modelMapper.map(command, CommandDto.class);
    }
}
