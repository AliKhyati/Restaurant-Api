package projet.wcs.starter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.entities.Reservation;
import projet.wcs.starter.repositories.ReservationRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
@CrossOrigin
public class ReservationController {

    @Autowired private ReservationRepository repo;

    @GetMapping
    public List<Reservation> getAll() {
        return repo.findAll();
    }

    @PostMapping("/create")
    public Reservation create(@RequestBody Reservation reservation) {
        return repo.save(reservation);
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
