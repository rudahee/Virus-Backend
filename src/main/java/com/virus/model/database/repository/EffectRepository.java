package com.virus.model.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virus.model.database.entity.EffectEntity;

@Repository
public interface EffectRepository extends JpaRepository<EffectEntity, Long> {

}
