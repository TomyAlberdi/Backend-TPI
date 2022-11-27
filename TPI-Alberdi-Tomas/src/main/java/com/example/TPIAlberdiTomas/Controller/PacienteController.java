package com.example.TPIAlberdiTomas.Controller;

import com.example.TPIAlberdiTomas.Model.Paciente;
import com.example.TPIAlberdiTomas.Service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService ps;

    @PostMapping("/add")
    public ResponseEntity<Paciente> addPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok().body(ps.addPaciente(paciente));
    }
    @GetMapping("/search/{id}")
    public Optional<Paciente> buscarPaciente(@PathVariable Integer id) {
        return ps.searchPaciente(id);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Paciente>> listOdontologos() {
        return ResponseEntity.ok().body(ps.listPacientes());
    }
    @DeleteMapping(value = "/delete/{id}")
    public void deletePaciente(@PathVariable Integer id) {
        ps.deletePaciente(id);
    }
    @PutMapping("/modify")
    public ResponseEntity<Paciente> modifyPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok().body(ps.modifyPaciente(paciente));
    }
}
