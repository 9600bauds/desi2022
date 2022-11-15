package com.tsti.smn.capaDaos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Suscripcion;

@Repository
public interface ISuscripcionRepo extends JpaRepository<Suscripcion, Long> {

	List<Suscripcion> findByCiudad(Ciudad ciudad);
}
