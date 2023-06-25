package com.ScrumTool.RetrospectionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetrospectionDetailsRepository extends JpaRepository<RetrospectionDetails, Long> {

}