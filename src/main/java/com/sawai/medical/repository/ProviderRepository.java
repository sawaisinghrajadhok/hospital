package com.sawai.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sawai.medical.model.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long>{

}
