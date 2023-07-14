package com.IpsAtenea.IpsAtenea.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.IpsAtenea.IpsAtenea.entity.Medico;

@RepositoryRestResource(collectionResourceRel = "medicos", path="medicos")
@CrossOrigin(origins="http://localhost:3000")
public interface MedicoRepositorio extends CrudRepository<Medico, Long>{

}