package com.ScrumTool.BacklogItemParentChild;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogItemParentChildRepository extends JpaRepository<BacklogItemParentChild, Long> {

}
