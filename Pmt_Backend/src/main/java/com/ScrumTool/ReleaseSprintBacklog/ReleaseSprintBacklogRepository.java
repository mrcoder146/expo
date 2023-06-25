package com.ScrumTool.ReleaseSprintBacklog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseSprintBacklogRepository extends JpaRepository<ReleaseSprintBacklog , Long> {

}
