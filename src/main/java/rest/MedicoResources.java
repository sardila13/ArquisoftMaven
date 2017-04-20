/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;



import dto.AlertaDTO;
import dto.ConfiguracionDTO;
import dto.ConsejoDTO;
import java.util.ArrayList;
import java.util.Date;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import logica.ejb.MedicoLogic;
import logica.ejb.PacienteLogic;
import logica.interfaces.IMedicoLogic;


/**
 *
 * @author s.ardila13
 */

@Path("medico")
@Produces("application/json")
@Consumes(MediaType.APPLICATION_JSON)

public class MedicoResources 
{
    @Inject
    private  IMedicoLogic medicoLogic;
    
    //Requerimiento 4 dar consejo a un dispositivo...
    @POST
    @Path("consejo/{idPaciente:\\d+}/")
    public ConsejoDTO enviarConsejo(@PathParam("idPaciente") long idPaciente, ConsejoDTO consejo)  
    {
        return medicoLogic.enviarConsejo(idPaciente,consejo);
        //return "Mensaje enviado satisfactoriamente";
    }
    
    
    @POST
    @Path("configuracion/{idDispositivo:\\d+}")
    public ConfiguracionDTO enviarReconfiguracion(@PathParam("idDispositivo") long idDispositivo, ConfiguracionDTO config)  
    {
        return medicoLogic.configurarMarcapasos(idDispositivo,config );
        //return "Configuración enviada satisfactoriamente";
    }
    
}
