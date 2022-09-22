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
public class MedicoService {
    


    @Autowired
	MedicoRepository medicoRepository;

    
    @Transactional
	public MedicoEntity createMedico(MedicoEntity medicoEntity) throws EntityNotFoundException, IllegalOperationException {
		String  x = "RM";
		if (medicoEntity.getNombre() == null){
            throw new IllegalOperationException("Nombre is not valid");
        }
			
		if (medicoEntity.getRegistromedico() ==null){
            throw new IllegalOperationException("RegistroMedico is not valid");
        }
        boolean z = false;
        String carr = "";
        for(int i = 0; i<x.length(); i++)
        {
            String car = Character.toString(medicoEntity.getRegistromedico().charAt(i));
            carr = carr.concat(car);
        
        }
        z  = x.equals(carr);


        if (!z)
            throw new IllegalOperationException("RegistroMedico is not valid");
		return medicoRepository.save(medicoEntity);
	}

    
}

	
