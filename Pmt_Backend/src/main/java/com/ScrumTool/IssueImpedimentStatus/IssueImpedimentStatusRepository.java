package com.ScrumTool.IssueImpedimentStatus;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueImpedimentStatusRepository extends JpaRepository<IssueImpedimentStatus, Long> {

}
