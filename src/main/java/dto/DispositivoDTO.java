/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package dto;

import Entites.AlertaEntity;
import Entites.ConfiguracionEntity;
import Entites.DispositivoEntity;
import Entites.HospitalEntity;
import Entites.PacienteEntity;
import java.util.ArrayList;

/**
 *
 * @author s.ardila13
 */
public class DispositivoDTO {
    
    private Long id;
    
    private PacienteDTO paciente;
    
    private ArrayList<AlertaDTO> alertas;
    
    private HospitalDTO hospital;
    
    private ConfiguracionDTO configuracion;
    

    public DispositivoDTO(PacienteDTO p, HospitalDTO h, ConfiguracionDTO c) 
    {
        paciente = p;
        hospital = h;
        configuracion = c;
        alertas = new ArrayList<>();
    }

    public void agregarAlerta(AlertaDTO alerta){
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
    
    public void setId(Long id){
        this.id = id;
    }
    
    public void setPaciente(PacienteDTO paciente){
        this.paciente = paciente;
    }
    
    public void setAlertas(ArrayList<AlertaDTO> alertas){
        this.alertas = alertas;
    }
    
    public void setHospital(HospitalDTO hospital){
        this.hospital = hospital;
    }
    
    public Long getId(){
        return id;
    }
    
    public PacienteDTO getPaciente(){
        return paciente;
    }
    
    public ArrayList<AlertaDTO> getAlertas(){
        return alertas;
    }
    
    public HospitalDTO getHospital(){
        return hospital;
    }
    
    public void setConfiguration(ConfiguracionDTO confi)
    {
        configuracion=confi;
    }
    
    public ConfiguracionDTO getConfiguration(String confi)
    {
        return configuracion;
    }
    
     public ArrayList<AlertaEntity> alertasEntities(){
        ArrayList<AlertaEntity> nAlertas = new ArrayList<AlertaEntity>();
        for(int i = 0; i < alertas.size(); i++){
            nAlertas.add(alertas.get(i).toEntity());
        }
        return nAlertas;
    }
    
    public DispositivoEntity toEntity() {
        PacienteEntity p =null;
        if(paciente!=null)
        {
            p=paciente.toEntity();
        }
        HospitalEntity h =null;
        if(hospital!=null)
        {
            h=hospital.toEntity();
        }
        ConfiguracionEntity c =null;
        if(configuracion!=null)
        {
            c=configuracion.toEntity();
        }
        return new DispositivoEntity(p, alertasEntities(), h, c);
    }

    @Override
    public String toString() {
        return "DispositivoDTO{" + "id=" + id + ", paciente=" + paciente + ", alertas=" + alertas + ", hospital=" + hospital + ", configuracion=" + configuracion + '}';
    }
    
    
    
}
