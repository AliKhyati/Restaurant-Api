package projet.wcs.starter.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.dao.Comment;
import projet.wcs.starter.dto.CommentDto;
import projet.wcs.starter.dto.ItemDto;
import projet.wcs.starter.repositories.CommentRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comments")
@CrossOrigin
public class CommentController {

    @Autowired CommentRepository repo;
    @Autowired ModelMapper modelMapper;

    @GetMapping
    public List<CommentDto> getAll() {
        return repo.findAll().stream().map(
                comment -> modelMapper.map(comment, CommentDto.class)
        ).collect(Collectors.toList());
    }

    @PostMapping
    public CommentDto create(@RequestBody @Valid CommentDto comment) {
        Comment savedComment = repo.save(modelMapper.map(comment, Comment.class));
        return modelMapper.map(savedComment, CommentDto.class);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        if (id != null) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
