/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import Entites.ConsejoEntity;
import java.util.Date;

/**
 *
 * @author s.ardila13
 */
public class ConsejoDTO {
    
    private String consejo;
    
    private Date fecha;

    public ConsejoDTO() {
    }

    public ConsejoDTO(String consejo, Date fecha) {
        this.consejo = consejo;
        this.fecha = fecha;
    }

    public String getConsejo() {
        return consejo;
    }

    public void setConsejo(String consejo) {
        this.consejo = consejo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "CnosejoDTO{" + "consejo=" + consejo + ", fecha=" + fecha + '}';
    }

    public ConsejoEntity toEntity() 
    {
        return new ConsejoEntity(consejo, fecha);
    }
    
    
    
}
