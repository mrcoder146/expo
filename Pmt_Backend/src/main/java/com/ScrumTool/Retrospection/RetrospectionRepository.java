package com.ScrumTool.Retrospection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetrospectionRepository extends JpaRepository<Retrospection, Long>{

}
