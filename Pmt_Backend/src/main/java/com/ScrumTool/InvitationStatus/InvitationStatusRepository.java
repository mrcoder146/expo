package com.ScrumTool.InvitationStatus;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface InvitationStatusRepository extends JpaRepository<InvitationStatus, Long> {

}
