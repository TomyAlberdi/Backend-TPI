package com.example.TPIAlberdiTomas.Controller;

import com.example.TPIAlberdiTomas.Model.Odontologo;
import com.example.TPIAlberdiTomas.Service.OdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/odontologos")
public class OdontologoController {
    private final OdontologoService os;

    @PostMapping("/add")
    public ResponseEntity<Odontologo> addOdontologo(@RequestBody Odontologo odontologo) {
        return ResponseEntity.ok().body(os.addOdontologo(odontologo));
    }
    @GetMapping("/search/{id}")
    public Optional<Odontologo> buscarOdontologo(@PathVariable Integer id) {
        return os.searchOdontologo(id);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Odontologo>> listOdontologos() {
        return ResponseEntity.ok().body(os.listOdontologos());
    }
    @DeleteMapping(value = "/delete/{id}")
    public void deleteOdontologo(@PathVariable Integer id) {
        os.deleteOdontologo(id);
    }
    @PutMapping("/modify")
    public ResponseEntity<Odontologo> modifyOdontologo(@RequestBody Odontologo odontologo) {
        return ResponseEntity.ok().body(os.modificarOdontologo(odontologo));
    }
}
