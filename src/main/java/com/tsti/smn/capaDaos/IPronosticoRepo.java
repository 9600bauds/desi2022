package com.tsti.smn.capaDaos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Pronostico;

@Repository
public interface IPronosticoRepo extends JpaRepository<Pronostico, Long>{
	public Optional<Pronostico> findById(Long id);

	public Optional<Pronostico> findByCiudadAndFecha(Ciudad c, Date d);
	
	//Pronóstico extendido:
	//Requiere una Ciudad, una fecha de inicio, y una fecha de fin
	@Query("SELECT p FROM Pronostico p WHERE p.ciudad = :c AND p.fecha BETWEEN :start AND :end ORDER BY fecha")
	public List<Pronostico> getPronosticoExtendido(@Param("c") Ciudad c, @Param("start") Date start, @Param("end") Date end);
}
