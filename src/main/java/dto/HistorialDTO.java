/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import Entites.AlertaEntity;
import Entites.HistorialEntity;
import Entites.PacienteEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gc.andrade10
 */
public class HistorialDTO 
{
    private List<AlertaDTO> alertas;
    
    private PacienteDTO paciente;
    
    private ArrayList<String> tratamientos;
    
    private ArrayList<String> examenes;

    public HistorialDTO()
    {
        this.alertas = new ArrayList<AlertaDTO>();
        
        this.tratamientos = new ArrayList<String>();
        
        this.examenes = new ArrayList<String>();
    }
    
    public HistorialDTO(PacienteDTO paciente){
        this.paciente = paciente;
        
        this.alertas = new ArrayList<AlertaDTO>();
        
        this.tratamientos = new ArrayList<String>();
        
        this.examenes = new ArrayList<String>();
    }

    public ArrayList<String> getTratamientos()
    {
        return tratamientos;
    }

    public void setTratamientos(ArrayList<String> tratamientos)
    {
        this.tratamientos = tratamientos;
    }

    public ArrayList<String> getExamenes()
    {
        return examenes;
    }

    public void setExamenes(ArrayList<String> examenes)
    {
        this.examenes = examenes;
    }
    
    
    

    /**
     * @return the alertas
     */
    public List getAlertas()
    {
        return alertas;
    }

    /**
     * @param alertas the alertas to set
     */
    public void setAlertas(List alertas)
    {
        this.alertas = alertas;
    }

    /**
     * @return the paciente
     */
    public PacienteDTO getPaciente()
    {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(PacienteDTO paciente)
    {
        this.paciente = paciente;
    }
    
     public ArrayList<AlertaEntity> alertasEntities(){
        ArrayList<AlertaEntity> nAlertas = new ArrayList<AlertaEntity>();
        for(int i = 0; i < alertas.size(); i++)
        {
            AlertaDTO actual=(AlertaDTO) alertas.get(i);
            nAlertas.add(actual.toEntity());
        }
        return nAlertas;
    }

    public HistorialEntity toEntity() {
        PacienteEntity p  = null;
        if(paciente != null){
            p  =paciente.toEntity();
        }
        return new HistorialEntity(alertasEntities(), p, tratamientos, examenes);
    }
    
    
    
}
