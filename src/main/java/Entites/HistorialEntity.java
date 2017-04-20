/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import dto.HistorialDTO;
import dto.PacienteDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author s.ardila13
 */
@Entity
public class HistorialEntity implements Serializable
{
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="historial_seq_gen")
    @SequenceGenerator(name="historial_seq_gen", sequenceName="HISTORIAL_SEQU")
    private Long id;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) 
    private List<AlertaEntity> alertas;
    
    @PodamExclude
    @OneToOne(mappedBy = "historial", cascade = CascadeType.ALL)
    private PacienteEntity paciente;
    
    private List<String> tratamientos;
    
    private List<String> examenes;

    public HistorialEntity(List<AlertaEntity> alertas, PacienteEntity paciente, List<String> tratamientos, List<String> examenes) {
        this.alertas = alertas;
        this.paciente = paciente;
        this.tratamientos = tratamientos;
        this.examenes = examenes;
    }

    public HistorialEntity()
    {
        
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AlertaEntity> getAlertas() {
        return alertas;
    }

    public void setAlertas(ArrayList<AlertaEntity> alertas) {
        this.alertas = alertas;
    }

    public PacienteEntity getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteEntity paciente) {
        this.paciente = paciente;
    }

    public List<String> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(ArrayList<String> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public List<String> getExamenes() {
        return examenes;
    }

    public void setExamenes(ArrayList<String> examenes) {
        this.examenes = examenes;
    }
    
    public HistorialDTO toDto()
    {
        PacienteDTO p=null;
        if(paciente!=null)
            p=paciente.toDTO();
        
        return new HistorialDTO(p);
    }
 
    
    
}
