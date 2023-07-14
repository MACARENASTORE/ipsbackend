package com.IpsAtenea.IpsAtenea.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCita;


    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "pacienteCedula")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medicoTarjetaProfesional")
    private Medico medico;

    

    public Cita() {
    }

    public Cita(int idCita, LocalDate fecha, Paciente paciente, Medico medico) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.paciente = paciente;
        this.medico = medico;
    }

    public int getIdCita() {
        return idCita;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    
}
