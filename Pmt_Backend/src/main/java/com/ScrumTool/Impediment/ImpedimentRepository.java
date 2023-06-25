package com.ScrumTool.Impediment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpedimentRepository extends JpaRepository<Impediment,Long> {

public Optional<Impediment> findById(long i);
}