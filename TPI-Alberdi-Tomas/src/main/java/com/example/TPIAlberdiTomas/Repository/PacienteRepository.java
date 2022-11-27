package com.example.TPIAlberdiTomas.Repository;

import com.example.TPIAlberdiTomas.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
