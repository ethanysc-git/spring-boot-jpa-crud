package com.ethan.crud.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ethan.crud.backend.entities.GymRecord;

public interface GymRecordsRepository extends JpaRepository<GymRecord, Long> {
}