package co.edu.uniandes.dse.parcialejemplo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 * Clase que representa un autor en la persistencia
 *
 * @author da.gonzalezv1 - 202110240
 */

@Getter
@Setter
@Entity

public class EspecialidadEntity extends BaseEntity {

    private String nombre;
    private String descripcion;

    @PodamExclude
	@ManyToMany(mappedBy = "especialidades")
	private List<MedicoEntity> medicos = new ArrayList<>();
    
}
