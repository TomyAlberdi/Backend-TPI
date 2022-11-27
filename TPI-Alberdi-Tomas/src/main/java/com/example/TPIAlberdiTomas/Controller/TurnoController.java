package com.example.TPIAlberdiTomas.Controller;

import com.example.TPIAlberdiTomas.Exceptions.OdontologoNotFoundException;
import com.example.TPIAlberdiTomas.Exceptions.PacienteNotFoundException;
import com.example.TPIAlberdiTomas.Model.Turno;
import com.example.TPIAlberdiTomas.Service.TurnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/turnos")
public class TurnoController {
    private final TurnoService ts;

    @PostMapping("/add/{matricula}/{dni}")
    public ResponseEntity<Turno> agregarTurno(@RequestBody LocalDateTime fecha, @PathVariable Integer matricula, @PathVariable Integer dni) throws OdontologoNotFoundException, PacienteNotFoundException {
        return ResponseEntity.ok().body(ts.addTurno(matricula,dni,fecha));
    }
    @GetMapping("/search/{id}")
    public Optional<Turno> buscarTurno(@PathVariable Integer id) {return ts.searchTurno(id);}
    @GetMapping("/list")
    public ResponseEntity<List<Turno>> listarTurnos() {return ResponseEntity.ok().body(ts.listTurnos());}
    @DeleteMapping("/delete/{id}")
    public void deleteTurno(@PathVariable Integer id) {ts.deleteTurno(id);}
    @PatchMapping("/update/{matricula}/{dni}")
    public void updateFecha(@RequestBody LocalDate fecha, @PathVariable Integer dni, @PathVariable Integer matricula) {
        ts.updateFecha(fecha,dni,matricula);
    }
}
