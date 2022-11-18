package projet.wcs.starter.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.dao.Reservation;
import projet.wcs.starter.dto.ReservationDto;
import projet.wcs.starter.repositories.ReservationRepository;
import projet.wcs.starter.services.CommandService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservations")
@CrossOrigin
public class ReservationController {

    @Autowired private ReservationRepository repo;
    @Autowired private ModelMapper modelMapper;

    @Autowired private CommandService commandService;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<ReservationDto> getAll() {
        return repo.findAll().stream().map(
                reservation -> modelMapper.map(reservation, ReservationDto.class)
        ).collect(Collectors.toList());
    }

    @PostMapping
    public ReservationDto create(@RequestBody @Valid ReservationDto reservation) {
        reservation.setCommand(commandService.create());
        Reservation savedReservation = repo.save(modelMapper.map(reservation, Reservation.class));
        return modelMapper.map(savedReservation, ReservationDto.class);
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
    public Reservation getTable(@PathVariable Integer id) {
        Reservation reservation = new Reservation();
        if (id != null) {
            Optional<Reservation> optionalOrder = repo.findById(id);
            if (optionalOrder.isPresent()) {
                reservation = optionalOrder.get();
            }
        }
        return reservation;
    }
}
