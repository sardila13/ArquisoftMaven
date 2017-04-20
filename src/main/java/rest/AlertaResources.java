package rest;

import dto.AlertaDTO;
import dto.ConfiguracionDTO;
import dto.DispositivoDTO;
import dto.HospitalDTO;
import dto.MedicoDTO;
import dto.PacienteDTO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import logica.ejb.AlertaLogic;
import logica.ejb.ConfiguracionlLogic;
import logica.ejb.DispositivoLogic;
import logica.ejb.HospitalLogic;
import logica.ejb.MedicoLogic;
import logica.ejb.PacienteLogic;
import logica.interfaces.IAlertaLogic;
import logica.interfaces.IDispositivo;
/**
 *
 * @author s.ardila13
 */

@Path("alertas")
@Produces("application/json")
@Consumes(MediaType.APPLICATION_JSON)

public class AlertaResources
{
    protected PacienteLogic pacienteLogic;
    
    protected HospitalLogic hospitalLogic;
    
    protected MedicoLogic medicoLogic;
    
    protected IAlertaLogic logic;
    
    protected IDispositivo dispositivologic;
    
    protected ConfiguracionlLogic configuracionlogic;
    
    //Requerimiento 1 Recibe info de los sensores...
    
    @PostConstruct
    public void init(){
        logic = new AlertaLogic();
        pacienteLogic = new PacienteLogic();
        hospitalLogic = new HospitalLogic();
        medicoLogic = new MedicoLogic();
        dispositivologic = new DispositivoLogic();
        configuracionlogic = new ConfiguracionlLogic();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{idDispositivo:\\d+}")
    public void createAlerta(AlertaDTO alerta,@PathParam("idDispositivo") Long idDispositivo)
    {
//        System.out.println("La instancia es " + logic.hashCode());
       System.out.println("Hola " + idDispositivo);
       dispositivologic.agregarAlerta(idDispositivo, alerta);
//        logic.crearAlerta(alerta, idDispositivo);
    }
    
    @GET
    public List<AlertaDTO> darAlertas() {
        return logic.darAlertas();
    }
    
    @GET
    @Path("/ejemplo")
    public AlertaDTO ejemplo()
    {
        Integer[] presion = new Integer[2];
        presion[0] = 60;
        presion[1] = 80;
        
        Long[] ubicacion = new Long[2];
        ubicacion[0] = 60L;
        ubicacion[1] = 80L;
        
        Integer frecuencia = 85;
        Integer estres = 65;
        
        
        HospitalDTO h = new HospitalDTO("Uniandes");
        hospitalLogic.crear(h);
        
        medicoLogic.crearMedico(new MedicoDTO("German", 0));
        
        h.setId(1L);
        PacienteDTO p = new PacienteDTO("Brandon", 20 , h);
        p.setId(1L);
        PacienteDTO e = pacienteLogic.crearPaciente(p);
       
        
        ConfiguracionDTO config = new ConfiguracionDTO("config ");
        config.setId(1L);
        
//        configuracionlogic.crear(config);
        
        
        DispositivoDTO dispositivo = new DispositivoDTO( e, p.getHospital(), config);
//        config.setDispositivo(dispositivo);


        dispositivo.setConfiguration(config);
        dispositivo.setId(1L);
        System.out.println("Paciente en dispositivo" + dispositivo.getPaciente().getId());
        dispositivologic.crearDispositivo(dispositivo);
        
        AlertaDTO a = new AlertaDTO(0, presion,frecuencia, estres, /*dispositivo ,*/ AlertaDTO.AMARILLO, ubicacion);
        
        return a;
    }
    
}
