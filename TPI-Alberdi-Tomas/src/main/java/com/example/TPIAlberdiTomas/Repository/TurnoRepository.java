package com.example.TPIAlberdiTomas.Repository;

import com.example.TPIAlberdiTomas.Model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Turno t SET t.fecha = ?1 WHERE t.paciente.dni = ?2 AND t.odontologo.matricula = ?3")
    void updateFecha(LocalDate fecha, Integer dni, Integer matricula);
}
