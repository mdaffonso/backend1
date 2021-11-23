package com.dh.jpa.persistence.repository;

import com.dh.jpa.persistence.entity.MovimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentoRepository extends JpaRepository<MovimentoEntity, Integer> {

}
