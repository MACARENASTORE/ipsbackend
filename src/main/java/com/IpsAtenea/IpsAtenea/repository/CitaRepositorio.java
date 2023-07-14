package com.IpsAtenea.IpsAtenea.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.IpsAtenea.IpsAtenea.entity.Cita;

@RepositoryRestResource(collectionResourceRel = "citas", path="citas")
@CrossOrigin(origins="http://localhost:3000")
public interface CitaRepositorio extends CrudRepository<Cita, Long>{

}