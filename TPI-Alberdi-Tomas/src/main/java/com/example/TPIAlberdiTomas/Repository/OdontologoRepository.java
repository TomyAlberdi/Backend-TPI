package com.example.TPIAlberdiTomas.Repository;

import com.example.TPIAlberdiTomas.Model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Integer> {
}
