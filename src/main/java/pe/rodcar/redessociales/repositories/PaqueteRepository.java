package pe.rodcar.redessociales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.rodcar.redessociales.entities.Paquete;

@Repository
public interface PaqueteRepository extends JpaRepository<Paquete, Long> {

}
