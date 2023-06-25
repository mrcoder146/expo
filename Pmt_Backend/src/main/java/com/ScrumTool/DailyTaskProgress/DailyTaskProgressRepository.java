package com.ScrumTool.DailyTaskProgress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyTaskProgressRepository extends JpaRepository<DailyTaskProgress,Long>{

}
