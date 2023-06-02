package com.app.security.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.models.Structure;
import com.app.repository.StructureRepository;
@Service
@Transactional
public class StructureService {
	private final StructureRepository structureRepository;

	public StructureService(StructureRepository structureRepository) {
	    this.structureRepository = structureRepository;
	}

	public Structure createStructure(Structure newStructure) {
	    Structure parentStructure = null;
	    if (newStructure.getMinistere() != null) {
	        parentStructure = structureRepository.findById(newStructure.getMinistere().getId())
	            .orElseThrow(() -> new EntityNotFoundException("Parent structure not found"));
	    }
	    Structure existingStructure = structureRepository.findByCode(newStructure.getCode());
	    if (existingStructure != null) {
	        throw new RuntimeException("Structure with the same code already exists");
	    }
	    Structure existingStructure2 = structureRepository.findByLibelle(newStructure.getLibelle());
	    if (existingStructure2 != null) {
	        throw new RuntimeException("Structure with the same libelle already exists");
	    }
	    
	    newStructure.setMinistere(parentStructure);
	    return structureRepository.save(newStructure);
	}

   /* public Structure createStructure(Structure newStructure) {
        Structure parentStructure = structureRepository.findById(newStructure.getMinistere().getId())
                .orElseThrow(() -> new EntityNotFoundException("Parent structure not found"));

        newStructure.setMinistere(parentStructure);

        return structureRepository.save(newStructure);
    }*/
    
    public List<Structure> getStructuresWithNullMinistere() {
        return structureRepository.findByMinistereIsNull();
    }

    public List<Structure> getStructuresWithMinistere() {
        return structureRepository.findByMinistereIsNotNull();
    }
   
    public void deleteChildStructureById(Long id) {
        Structure child = structureRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Structure not found"));

        child.setMinistere(null); // Remove relationship with parent

        structureRepository.deleteById(id); // Delete the child entity
    }
    

public Structure updateStructure(Long id, Structure updatedStructure) {
    Structure existingStructure = structureRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Structure not found"));
    
    existingStructure.setCode(updatedStructure.getCode());
    existingStructure.setLibelle(updatedStructure.getLibelle());
    
    if (updatedStructure.getMinistere() != null) {
        Structure parentStructure = structureRepository.findById(updatedStructure.getMinistere().getId())
                .orElseThrow(() -> new EntityNotFoundException("Parent structure not found"));
        existingStructure.setMinistere(parentStructure);
    } else {
        existingStructure.setMinistere(null);
    }
    
    return structureRepository.save(existingStructure);
}
}

    /*public Structure createStructure(Structure structure) {
        if (structure.getId_ministere() != null) {
            Structure existingStructure = structureRepository.findById(structure.getId_ministere()).orElse(null);
            if (existingStructure != null) {
                structure.setId_ministere(existingStructure.getId());
            }
        }
        return structureRepository.save(structure);
    }
}*/
   /* public List<Structure> getAllStructures() {
        return structureRepository.findAll();
    }

    public List<Structure> getStructuresWithNullMinistere() {
        return structureRepository.findByMinistereIsNull();
    }*/

