package co.edu.uniandes.dse.parcialejemplo.services;

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
public class EspecialidadService {
    @Autowired
	EspecialidadRepository especialidadRepository;

    
    @Transactional
	public EspecialidadEntity createEspecialidad(EspecialidadEntity especialidadEntity) throws EntityNotFoundException, IllegalOperationException {
		//String  x = "RM";
		if (especialidadEntity.getNombre() == null){
            throw new IllegalOperationException("Nombre is not valid");
        }
        if (especialidadEntity.getDescripcion() == null){
            throw new IllegalOperationException("Descripcion is not valid");
        }
        if (especialidadEntity.getDescripcion().length()<10){
            throw new IllegalOperationException("Descripcion is not valid");
        }
		return especialidadRepository.save(especialidadEntity);
	}

}
