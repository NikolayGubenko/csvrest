package com.example.csvrest.repository;

import com.example.csvrest.model.MsiMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MsiMasterRepository extends JpaRepository<MsiMaster, Long> {
}
