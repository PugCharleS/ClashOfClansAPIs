package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.model.Layout;

public interface LayoutRepository extends JpaRepository<Layout, Long>{

//	SELECT * FROM layout WHERE th_level = th_level;
	
	@Query("SELECT l FROM Layout l WHERE l.thLevel=?1")
	List<Layout> getLayoutByThLevel(int thLevel);

}
