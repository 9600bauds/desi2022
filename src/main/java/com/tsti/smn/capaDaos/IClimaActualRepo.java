package com.tsti.smn.capaDaos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tsti.smn.pojos.ClimaActual;

@Repository
public interface IClimaActualRepo extends JpaRepository<ClimaActual, Long>  {

	@Query("SELECT c FROM ClimaActual c WHERE c.ciudad.id = :id")
	Optional<ClimaActual> climaActualFromCityID(Long id);
}
