/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;
import dto.AlertaDTO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author s.ardila13
 */
@Entity
public class AlertaEntity implements Serializable
{
    @Id
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="alerta_seq_gen")
//    @SequenceGenerator(name="alerta_seq_gen", sequenceName="ALERTA_SEQU")
    private Long id;
    
    private Integer esEmergencia;
    
    private Integer[] presionSanguinea;
    
    private Integer frecuenciaCardica;
    
    private Integer nivelEstres;
    
//    @ManyToOne
//    @PodamExclude
//    private DispositivoEntity dispositivo;
    
//    @ManyToOne
//    @PodamExclude
//    private HistorialEntity historial;
    
    private Integer tipo;
    
    private Long[] ubicacion;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
//    @ManyToOne
//    @PodamExclude
//    private PacienteEntity paciente;

    public AlertaEntity()
    {
        
    }

    public AlertaEntity(Integer esEmergencia, Integer[] presionSanguinea, Integer frecuenciaCardica, Integer nivelEstres,/* DispositivoEntity dispositivo,*/ Integer tipo, Long[] ubicacion, Date fecha) {
        this.esEmergencia = esEmergencia;
        this.presionSanguinea = presionSanguinea;
        this.frecuenciaCardica = frecuenciaCardica;
        this.nivelEstres = nivelEstres;
//        this.dispositivo = dispositivo;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEsEmergencia() {
        return esEmergencia;
    }

    public void setEsEmergencia(Integer esEmergencia) {
        this.esEmergencia = esEmergencia;
    }

    public Integer[] getPresionSanguinea() {
        return presionSanguinea;
    }

    public void setPresionSanguinea(Integer[] presionSanguinea) {
        this.presionSanguinea = presionSanguinea;
    }

    public Integer getFrecuenciaCardica() {
        return frecuenciaCardica;
    }

    public void setFrecuenciaCardica(Integer frecuenciaCardica) {
        this.frecuenciaCardica = frecuenciaCardica;
    }

    public Integer getNivelEstres() {
        return nivelEstres;
    }

    public void setNivelEstres(Integer nivelEstres) {
        this.nivelEstres = nivelEstres;
    }

//    public DispositivoEntity getDispositivo() {
//        return dispositivo;
//    }
//
//    public void setDispositivo(DispositivoEntity dispositivo) {
//        this.dispositivo = dispositivo;
//    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Long[] getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Long[] ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public AlertaDTO toDTO() 
    {
//        DispositivoDTO pDispositivo = null;
//        if(dispositivo != null){
//            pDispositivo = dispositivo.toDTO();
//        }
        return new AlertaDTO(getEsEmergencia(), getPresionSanguinea(), frecuenciaCardica, nivelEstres, /*pDispositivo,*/ tipo, ubicacion);
    }

    @Override
    public String toString() {
        return "AlertaEntity{" + "id=" + id + ", esEmergencia=" + esEmergencia + ", presionSanguinea=" + presionSanguinea + ", frecuenciaCardica=" + frecuenciaCardica + ", nivelEstres=" + nivelEstres + ", tipo=" + tipo + ", ubicacion=" + ubicacion + ", fecha=" + fecha + '}';
    }


    
    
}
