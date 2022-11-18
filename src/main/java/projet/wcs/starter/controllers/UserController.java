package projet.wcs.starter.controllers;

import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projet.wcs.starter.dao.User;
import projet.wcs.starter.dto.UserDto;
import projet.wcs.starter.repositories.UserRepository;
import projet.wcs.starter.services.UserDetailsImpl;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repo;

    @Autowired private ModelMapper modelMapper;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<User> list() {
        return repo.findAll();
    }

    @GetMapping("/me")
    public UserDto me() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> user =  repo.findById(userDetails.getId());
        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDto.class);
        }else {
            throw new ObjectNotFoundException(UserDto.class.toString(), userDetails.getId());
        }
    }


}
