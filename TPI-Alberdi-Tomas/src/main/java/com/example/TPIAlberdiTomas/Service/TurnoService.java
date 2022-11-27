package com.example.TPIAlberdiTomas.Service;

import com.example.TPIAlberdiTomas.Exceptions.OdontologoNotFoundException;
import com.example.TPIAlberdiTomas.Exceptions.PacienteNotFoundException;
import com.example.TPIAlberdiTomas.Model.Odontologo;
import com.example.TPIAlberdiTomas.Model.Paciente;
import com.example.TPIAlberdiTomas.Model.Turno;
import com.example.TPIAlberdiTomas.Repository.OdontologoRepository;
import com.example.TPIAlberdiTomas.Repository.PacienteRepository;
import com.example.TPIAlberdiTomas.Repository.TurnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TurnoService {
    private final TurnoRepository repo;
    private final OdontologoRepository repoOdont;
    private final PacienteRepository repoPac;

    public Turno addTurno(Integer matricula_od, Integer dni_pac, LocalDateTime fecha) throws OdontologoNotFoundException, PacienteNotFoundException {
        Optional<Odontologo> od = repoOdont.findById(matricula_od);
        Optional<Paciente> pa = repoPac.findById(dni_pac);

        if (od.isEmpty()) {
            throw new OdontologoNotFoundException();
        } else if (pa.isEmpty()) {
            throw new PacienteNotFoundException();
        }

        Odontologo o1 = od.get();
        Paciente p1 = pa.get();

        Turno turno = new Turno();
        turno.setFecha(fecha);
        turno.setOdontologo(o1);
        turno.setPaciente(p1);

        return repo.save(turno);
    }
    public List<Turno> listTurnos() {return repo.findAll();}
    public void deleteTurno(Integer id) {repo.deleteById(id);}
    public Optional<Turno> searchTurno(Integer id) {return repo.findById(id);}
    public void updateFecha(LocalDate fecha, Integer dni, Integer matricula) {
        repo.updateFecha(fecha,dni,matricula);
    }
}
