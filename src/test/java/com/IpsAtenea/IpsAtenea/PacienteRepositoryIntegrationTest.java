package com.IpsAtenea.IpsAtenea;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.IpsAtenea.IpsAtenea.entity.Paciente;
import com.IpsAtenea.IpsAtenea.repository.PacienteRepositorio;

@DataJpaTest
public class PacienteRepositoryIntegrationTest {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @BeforeEach
    public void setUp() {
        // Aquí puedes insertar datos de prueba si es necesario
    }

    @AfterEach
    public void tearDown() {
        // Aquí puedes limpiar datos de prueba si es necesario
    }

    @Test
    public void testGuardarPaciente() {
        // Arrange
        Long cedula = 1L;
        String nombre = "John";
        String apellido = "Doe";
        LocalDate fechaDeNacimiento = LocalDate.of(1990, 1, 1);
        String telefono = "1234567890";

        Paciente paciente = new Paciente();
        paciente.setCedula(cedula);
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setFechaDeNacimiento(fechaDeNacimiento);
        paciente.setTelefono(telefono);

        // Act
        pacienteRepositorio.save(paciente);

        // Assert
        Paciente pacienteGuardado = pacienteRepositorio.findById(cedula).orElse(null);
        assertThat(pacienteGuardado).isNotNull();
        assertThat(pacienteGuardado.getNombre()).isEqualTo(nombre);
        assertThat(pacienteGuardado.getApellido()).isEqualTo(apellido);
        assertThat(pacienteGuardado.getFechaDeNacimiento()).isEqualTo(fechaDeNacimiento);
        assertThat(pacienteGuardado.getTelefono()).isEqualTo(telefono);
    }

    @Test
    public void testBuscarPacientesPorNombre() {
        // Arrange
        String nombreBuscado = "John";

        Paciente paciente1 = new Paciente();
        paciente1.setCedula(1L);
        paciente1.setNombre(nombreBuscado);
        paciente1.setApellido("Doe");
        paciente1.setFechaDeNacimiento(LocalDate.of(1990, 1, 1));
        paciente1.setTelefono("1234567890");

        Paciente paciente2 = new Paciente();
        paciente2.setCedula(2L);
        paciente2.setNombre("Jane");
        paciente2.setApellido("Smith");
        paciente2.setFechaDeNacimiento(LocalDate.of(1985, 5, 15));
        paciente2.setTelefono("9876543210");

        pacienteRepositorio.save(paciente1);
        pacienteRepositorio.save(paciente2);

        // Act
        List<Paciente> pacientesEncontrados = pacienteRepositorio.findAllById(nombreBuscado);

        // Assert
        assertThat(pacientesEncontrados).hasSize(1);
        assertThat(pacientesEncontrados.get(0).getNombre()).isEqualTo(nombreBuscado);
    }

    // Agrega más pruebas de integración según tus necesidades.

}
