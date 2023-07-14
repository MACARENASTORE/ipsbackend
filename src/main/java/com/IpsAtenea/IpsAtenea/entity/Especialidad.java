package com.IpsAtenea.IpsAtenea.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idEspecialidad;
    private String nombre;
    private String code;   
    
  

    @OneToMany(mappedBy = "especialidad")
    private List<Medico> medicos;



    public Especialidad() {
    }



    public Especialidad(int idEspecialidad, String nombre, String code, List<Medico> medicos) {
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
        this.code = code;
        this.medicos = medicos;
    }



    public int getIdEspecialidad() {
        return idEspecialidad;
    }



    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getCode() {
        return code;
    }



    public void setCode(String code) {
        this.code = code;
    }



    public List<Medico> getMedicos() {
        return medicos;
    }



    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    
    
}
