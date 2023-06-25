package com.ScrumTool.BacklogItems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BacklogItemsRepository extends JpaRepository<BacklogItems, Long> {

}
