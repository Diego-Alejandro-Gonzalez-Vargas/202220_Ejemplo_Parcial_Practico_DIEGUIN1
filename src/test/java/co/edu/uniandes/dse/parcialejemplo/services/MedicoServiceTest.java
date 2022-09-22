package co.edu.uniandes.dse.parcialejemplo.services;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.parcialejemplo.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialejemplo.entities.EspecialidadEntity;
import co.edu.uniandes.dse.parcialejemplo.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialejemplo.services.MedicoService;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(MedicoService.class)

public class MedicoServiceTest {
    @Autowired
	private MedicoService medicoService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<MedicoEntity> medicoList = new ArrayList<>();

    @BeforeEach
	void setUp() {
		clearData();
		insertData();
	}

    private void clearData() {
		entityManager.getEntityManager().createQuery("delete from MedicoEntity");
		entityManager.getEntityManager().createQuery("delete from EspecialidadEntity");
	}
    private void insertData() {
		

		for (int i = 0; i < 3; i++) {
			MedicoEntity medicoEntity = factory.manufacturePojo(MedicoEntity.class);
			entityManager.persist(medicoEntity);
			medicoList.add(medicoEntity);
		}

		EspecialidadEntity especialidadEntity = factory.manufacturePojo(EspecialidadEntity.class);
		entityManager.persist(especialidadEntity);
		especialidadEntity.getMedicos().add(medicoList.get(0));
		medicoList.get(0).getEspecialidades().add(especialidadEntity);
	}
    @Test
	void testCreateMedico() throws EntityNotFoundException, IllegalOperationException {
		MedicoEntity newEntity = factory.manufacturePojo(MedicoEntity.class);
		newEntity.setNombre("Cristiano");
		MedicoEntity result = medicoService.createMedico(newEntity);
		assertNotNull(result);
		MedicoEntity entity = entityManager.find(MedicoEntity.class, result.getId());
		assertEquals(newEntity.getId(), entity.getId());
		assertEquals(newEntity.getNombre(), entity.getNombre());
		assertEquals(newEntity.getApellido(), entity.getApellido());
		assertEquals(newEntity.getEspecialidades(), entity.getEspecialidades());
	}
    
}
