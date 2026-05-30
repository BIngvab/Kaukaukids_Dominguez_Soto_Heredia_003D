package com.kaukaukids.evento.repository;

import com.kaukaukids.evento.model.evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface eventoRepository extends JpaRepository<evento, Long> {
}