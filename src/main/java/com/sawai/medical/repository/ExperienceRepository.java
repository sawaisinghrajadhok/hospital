package com.sawai.medical.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sawai.medical.model.Experience;
import com.sawai.medical.model.Provider;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {

	public List<Experience> getByProvider(@Param("provider") Provider provider);
	
	@Transactional
	public void deleteByProvider(@Param("provider") Provider provider);
}
