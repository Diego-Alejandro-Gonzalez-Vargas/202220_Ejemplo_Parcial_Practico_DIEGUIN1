package co.edu.uniandes.dse.parcialejemplo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialejemplo.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialejemplo.entities.EspecialidadEntity;
import co.edu.uniandes.dse.parcialejemplo.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialejemplo.exceptions.ErrorMessage;
import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialejemplo.repositories.MedicoRepository;
import co.edu.uniandes.dse.parcialejemplo.repositories.EspecialidadRepository;



@Service
public class MedicoEspecialidadService {
    @Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	private EspecialidadRepository especialidadRepository;

    @Transactional
	public EspecialidadEntity addEspecialidad(Long medicoId, Long especialidadId) throws EntityNotFoundException {
		Optional<MedicoEntity> medicoEntity = medicoRepository.findById(medicoId);
		Optional<EspecialidadEntity> especialidadEntity = especialidadRepository.findById(especialidadId);

		if (medicoEntity.isEmpty())
			throw new EntityNotFoundException(ErrorMessage.MEDICO_NOT_FOUND);

		if (especialidadEntity.isEmpty())
			throw new EntityNotFoundException(ErrorMessage.ESPECIALIDAD_NOT_FOUND);

		medicoEntity.get().getEspecialidades().add(especialidadEntity.get());
		return especialidadEntity.get();
	}
    
}
