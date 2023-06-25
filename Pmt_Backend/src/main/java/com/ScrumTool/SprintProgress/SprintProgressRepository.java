package com.ScrumTool.SprintProgress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintProgressRepository extends JpaRepository<SprintProgress, Long> {

}
