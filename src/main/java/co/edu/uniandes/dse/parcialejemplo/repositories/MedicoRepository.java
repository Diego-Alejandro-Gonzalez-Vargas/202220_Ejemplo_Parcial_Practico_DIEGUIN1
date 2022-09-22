package co.edu.uniandes.dse.parcialejemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.parcialejemplo.entities.MedicoEntity;

/**
 * Interface that persists an ESPECIALIDAD
 *
 * @author da.gonzalezv1
 *
 */
@Repository
public interface MedicoRepository extends JpaRepository<MedicoEntity, Long> {

}