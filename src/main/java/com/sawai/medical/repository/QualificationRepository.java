package com.sawai.medical.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sawai.medical.model.Person;
import com.sawai.medical.model.Qualification;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long> {

	public List<Qualification> getByPerson(@Param("person") Person person);
}
