/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import Entites.AlertaEntity;
import Entites.ConfiguracionEntity;
import Entites.ConsejoEntity;
import Entites.DispositivoEntity;
import Entites.HistorialEntity;
import Entites.HospitalEntity;
import Entites.MedicoEntity;
import Entites.PacienteEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import logica.ejb.DispositivoLogic;

/**
 *
 * @author s.ardila13
 */
public class PacienteDTO {
    
    private String nombre;
    
    private Long id;
    
    private int edad;
    
    private DispositivoDTO dispositivo;
    
    private List<MedicoDTO> medicos;
    
    private HospitalDTO hospital;
    
    private HistorialDTO historial;
    
    private List<AlertaDTO> alertas;
    
    private List<ConsejoDTO> consejos;
    
    @Inject
    private DispositivoLogic dispositivoLoigc;
    
    public PacienteDTO()
    {
    }

    public PacienteDTO(String nombre, int edad, HospitalDTO h) 
    {
        this.nombre = nombre;
        
        this.edad = edad;
        
        this.medicos = new ArrayList<MedicoDTO>();
        
        this.hospital = h;
        
        this.historial = new HistorialDTO();
        
        consejos = new ArrayList<>();
        
        alertas = new ArrayList<>();
    }

    
    public void agregarAlerta(AlertaDTO alerta)
    {
        System.out.println("Agregando Alerta");
        alertas.add(alerta);
    }
    
    public void eliminarAlertaPorIndex(int index){
        alertas.remove(index);
    }
    
    public void eliminarAlertaPorObjeto(AlertaDTO alerta){
        alertas.remove(alerta);
    }
    
    public void cambiarAlerta(int index, AlertaDTO alerta){
        alertas.set(index, alerta);
    }
    
    public void agregarMedico(MedicoDTO medico){
        medicos.add(medico);
    }
    
    public void eliminarMedicoPorIndex(int index){
        medicos.remove(index);
    }
    
    public void eliminarMedicoPorObjeto(MedicoDTO medico){
        medicos.remove(medico);
    }
    
    public void cambiarMedico(int index, MedicoDTO medico){
        medicos.set(index, medico);
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public void setDispositivo(DispositivoDTO dispositivo){
        this.dispositivo = dispositivo;
    }
    
    public void setMedicos(ArrayList<MedicoDTO> medicos){
        this.medicos = medicos;
    }
    
    public void setHospital(HospitalDTO hospital){
        this.hospital = hospital;
    }
    
    public void setAlertas(ArrayList<AlertaDTO> alertas){
        this.alertas = alertas;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public Long getId(){
        return id;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public DispositivoDTO getDispositivo(){
        return dispositivo;
    }
    
    public List<MedicoDTO> getMedicos(){
        return medicos;
    }
    
    public HospitalDTO getHospital(){
        return hospital;
    }
    
    public HistorialDTO getHistorialClinico(){
        return historial;
    }
    
    public List<AlertaDTO> getAlertas(){
        return alertas;
    }

    public void setHistorial(HistorialDTO historial)
    {
        this.historial = historial;
    }

    public List<ConsejoDTO> getConsejos()
    {
        return consejos;
    }

    public void setConsejos(ArrayList<ConsejoDTO> consejos)
    {
        this.consejos = consejos;
    }

    public ConsejoDTO recibirConsejo(ConsejoDTO consejo)
    {
        consejos.add(consejo);
        return consejo;
    }

    @Override
    public String toString() {
        return "PacienteDTO{" + "nombre=" + nombre + ", id=" + id + ", edad=" + edad + ", dispositivo=" + dispositivo + ", medicos=" + medicos + ", hospital=" + hospital + ", historial=" + historial + ", alertas=" + alertas + ", consejos=" + consejos + '}';
    }

    public void agregarConsejo(ConsejoDTO consejo) {
        consejos.add(consejo);
    }

    public ArrayList<MedicoEntity> medicosEntities(){
        ArrayList<MedicoEntity> nMedicos = new ArrayList<MedicoEntity>();
        if(medicos != null){
            for(int i = 0; i < medicos.size(); i++){
                nMedicos.add(medicos.get(i).toEntity());
            }
        }
        return nMedicos;
    }
    
    public ArrayList<AlertaEntity> alertasEntities(){
            ArrayList<AlertaEntity> nAlertas = new ArrayList<AlertaEntity>();
        if(alertas != null){
            for(int i = 0; i < alertas.size(); i++){
                nAlertas.add(alertas.get(i).toEntity());
        }
        }
        return nAlertas;
    }
    
    public ArrayList<ConsejoEntity> consejosEntities(){
        ArrayList<ConsejoEntity> nConsejos = new ArrayList<ConsejoEntity>();
        if(consejos != null){
            for(int i = 0; i < consejos.size(); i++){
                nConsejos.add(consejos.get(i).toEntity());
            }
        }
        return nConsejos;
    }
    
    public PacienteEntity toEntity() 
    {
         HospitalEntity h =null;
        if(hospital!=null)
        {
            h=hospital.toEntity();
        }
        HistorialEntity his =null;
        if(historial!=null)
        {
            his=historial.toEntity();
        }
        DispositivoEntity d =null;
        if(dispositivo!=null)
        {
            d=dispositivo.toEntity();
        }
        
        PacienteEntity ent = new PacienteEntity(nombre, edad, d, medicosEntities(), h,his , alertasEntities(), consejosEntities());
//        ent.setId(id);
        
        return ent;
    }

    
    
    
}
