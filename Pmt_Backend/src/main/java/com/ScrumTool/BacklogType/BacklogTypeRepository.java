package com.ScrumTool.BacklogType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogTypeRepository extends JpaRepository<BacklogType , Long> {

}
