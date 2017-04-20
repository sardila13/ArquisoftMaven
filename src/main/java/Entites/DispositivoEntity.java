/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Entites;

import dto.ConfiguracionDTO;
import dto.DispositivoDTO;
import dto.HospitalDTO;
import dto.PacienteDTO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author s.ardila13
 */
@Entity
public class DispositivoEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dispositivo_seq_gen")
    @SequenceGenerator(name="dispositivo_seq_gen", sequenceName="DISPOSITIVO_SEQU")
    
    
    
    private Long id;
    
    @OneToOne(mappedBy = "dispositivo", cascade = CascadeType.ALL, orphanRemoval = true)
    @PodamExclude
    private PacienteEntity paciente;
    
    @OneToMany(/*mappedBy = "dispositivo",*/ cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlertaEntity> alertas;
    
    @ManyToOne
    @PodamExclude
    private HospitalEntity hospital;
    
    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
//    @PodamExclude
    private ConfiguracionEntity configuracion;
    
    public DispositivoEntity()
    {
        
    }
    
    public DispositivoEntity( PacienteEntity paciente, List<AlertaEntity> alertas, HospitalEntity hospital, ConfiguracionEntity configuracion) {
        this.paciente = paciente;
        this.alertas = alertas;
        this.hospital = hospital;
        this.configuracion = configuracion;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public PacienteEntity getPaciente() {
        return paciente;
    }
    
    public void setPaciente(PacienteEntity paciente) {
        this.paciente = paciente;
    }
    
    public List<AlertaEntity> getAlertas() {
        return alertas;
    }
    
    public void setAlertas(List<AlertaEntity> alertas) {
        this.alertas = alertas;
    }
    
    public HospitalEntity getHospital() {
        return hospital;
    }
    
    public void setHospital(HospitalEntity hospital) {
        this.hospital = hospital;
    }
    
    public ConfiguracionEntity getConfiguracion() {
        return configuracion;
    }
    
    public void setConfiguracion(ConfiguracionEntity configuracion) {
        this.configuracion = configuracion;
    }
    
    public DispositivoDTO toDTO()
    {
        PacienteDTO pPaciente = null;
        if(paciente != null){
            pPaciente = paciente.toDTO();
        }
        HospitalDTO pHospital = null;
        if(hospital != null){
            pHospital = hospital.toDTO();
        }
        ConfiguracionDTO pConfiguracion = null;
        if(configuracion != null){
            pConfiguracion = configuracion.toDTO();
        }
        DispositivoDTO d = new DispositivoDTO( pPaciente, pHospital, pConfiguracion);
        d.setId(id);
        return d;
    }
    
    @Override
    public String toString() {
        return "DispositivoEntity{" + "id=" + id + ", paciente=" + paciente.getId() + ", alertas=" + alertas.size() + ", hospital=" + hospital.getId() + ", configuracion=" + configuracion.getConfiguracion() + '}';
    }
    
    public void agregarAlerta(AlertaEntity alerta) {
        alertas.add(alerta);
    }
    
    
}
