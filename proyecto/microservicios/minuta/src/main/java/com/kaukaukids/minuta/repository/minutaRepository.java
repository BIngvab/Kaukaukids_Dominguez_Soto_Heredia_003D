package com.kaukaukids.minuta.repository;

import com.kaukaukids.minuta.model.minutaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface minutaRepository extends JpaRepository<minutaModel, Long> {

}