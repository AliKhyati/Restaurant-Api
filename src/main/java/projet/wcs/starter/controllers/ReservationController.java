package projet.wcs.starter.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.dao.Reservation;
import projet.wcs.starter.dto.ReservationDto;
import projet.wcs.starter.repositories.ReservationRepository;
import projet.wcs.starter.repositories.RestaurantTableRepository;
import projet.wcs.starter.services.CommandService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Autowired private RestaurantTableRepository tableRepository;

    @GetMapping
    public List<ReservationDto> getAll() {
        return repo.findAll().stream().map(
                reservation -> modelMapper.map(reservation, ReservationDto.class)
        ).collect(Collectors.toList());
    }

    @PostMapping("/{date}")
    public ReservationDto create(@PathVariable String date, @RequestBody @Valid ReservationDto reservation) throws ParseException {
        reservation.setCommand(commandService.create());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date formatedDate = simpleDateFormat.parse(date);
        reservation.setDate(formatedDate);
        Reservation savedReservation = repo.save(modelMapper.map(reservation, Reservation.class));
        return modelMapper.map(savedReservation, ReservationDto.class);
    }

    @GetMapping("/get/{date}")
    public List<ReservationDto> getReservationsByDate(@PathVariable String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date formatedDate = simpleDateFormat.parse(date);
        System.out.println(date);
        return repo.findByDate(formatedDate).stream().map(
                reservation -> modelMapper.map(reservation, ReservationDto.class)
        ).collect(Collectors.toList());
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
