/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import Entites.*;
import java.util.Date;
import javax.inject.Inject;
import logica.ejb.DispositivoLogic;

/**
 *
 * @author ba.bohorquez10
 */
public class AlertaDTO 
{
    public final static int VERDE = 0;
    public final static int AMARILLO = 1;
    public final static int ROJO = 2;
    
    private Integer esEmergencia;
    private Integer[] presionSanguinea;
    private Integer frecuenciaCardiaca;
    private Integer nivelEstres;
//    private DispositivoDTO dispositivo;
    private Integer tipo;
    private Long[] ubicacion;
    private Date fecha;
    
    @Inject
    private DispositivoLogic logicDispositivo;

    public AlertaDTO()
    {
    }

    public AlertaDTO(Integer esEmergencia, Integer[] presionSanguinea, Integer frecuenciaCardiaca, Integer nivelEstres, /*DispositivoDTO IdDispositivo,*/ Integer tipo, Long[] ubicacion)
    {
        this.esEmergencia = esEmergencia;
        this.presionSanguinea = presionSanguinea;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.nivelEstres = nivelEstres;
//        this.dispositivo = dispositivo;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.fecha = new Date();
    }
    
//    public AlertaDTO(AlertaEntity alerta)
//    {
//        this.esEmergencia = alerta.getEsEmergencia();
//        this.presionSanguinea = alerta.getPresionSanguinea();
//        this.frecuenciaCardiaca = alerta.getFrecuenciaCardica();
//        this.nivelEstres = alerta.getNivelEstres();
//        this.dispositivo = alerta.getDispositivo().toDTO();
//        this.tipo = alerta.getTipo();
//        this.ubicacion = alerta.getUbicacion();
//        this.fecha = alerta.getFecha();
//    }

    public Integer getEsEmergencia()
    {
        return esEmergencia;
    }

    public void setEsEmergencia(Integer esEmergencia)
    {
        this.esEmergencia = esEmergencia;
    }

    public Integer[] getPresionSanguinea()
    {
        return presionSanguinea;
    }

    public void setPresionSanguinea(Integer[] presionSanguinea)
    {
        this.presionSanguinea = presionSanguinea;
    }

    public Integer getFrecuenciaCardica()
    {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardica(Integer frecuenciaCardica)
    {
        this.frecuenciaCardiaca = frecuenciaCardica;
    }

    public Integer getNivelEstres()
    {
        return nivelEstres;
    }

    public void setNivelEstres(Integer nivelEstres)
    {
        this.nivelEstres = nivelEstres;
    }

//    public DispositivoDTO getDispositivo()
//    {
//        return dispositivo;
//    }
//
//    public void setDispositivo(DispositivoDTO pDispositivo)
//    {
//        this.dispositivo = pDispositivo;
//    }

    public Integer getTipo()
    {
        return tipo;
    }

    public void setTipo(Integer tipo)
    {
        this.tipo = tipo;
    }

    public Long[] getUbicacion()
    {
        return ubicacion;
    }

    public void setUbicacion(Long[] ubicacion)
    {
        this.ubicacion = ubicacion;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    @Override
    public String toString()
    {
        return "AlertaDTO{" + "esEmergencia=" + esEmergencia + ", presionSanguinea=" + presionSanguinea + ", frecuenciaCardiaca=" + frecuenciaCardiaca + ", nivelEstres=" + nivelEstres + ", tipo=" + tipo + ", ubicacion=" + ubicacion + ", fecha=" + fecha + '}';
    }

    public AlertaEntity toEntity() 
    {        
//        DispositivoEntity dis = null;
//        if(dispositivo != null){
//            dis = dispositivo.toEntity();
//        }
        return new AlertaEntity(esEmergencia, presionSanguinea, frecuenciaCardiaca, nivelEstres,/*dis,*/ tipo, ubicacion, fecha);
    }
    
    
    
}
