package com.simplilearn.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.simplilearn.entity.purchases;

@Repository
public interface PurchaseReportRepository extends JpaRepository<purchases, Integer> {
	@Query(value = "select * from purchases p where p.category like %:keyword% or p.date like %:keyword%", nativeQuery = true)
	public List<purchases> findByKeyword(@Param("keyword") String keyword);
	
}
