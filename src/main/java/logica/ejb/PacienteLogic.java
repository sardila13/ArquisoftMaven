/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package logica.ejb;

import Entites.AlertaEntity;
import Entites.DispositivoEntity;
import Entites.PacienteEntity;
import Persitence.PersistenceManager;
import dto.AlertaDTO;
import dto.ConsejoDTO;
import dto.DispositivoDTO;
import dto.HistorialDTO;
import dto.PacienteDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javafx.scene.control.Alert;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.text.html.HTML;
import javax.transaction.UserTransaction;
import logica.interfaces.IPaciente;

/**
 *
 * @author s.ardila13
 */
//@Stateless
@Singleton
public class PacienteLogic implements IPaciente {
    
    @PersistenceContext(unitName = "Oracle final", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em = Persistence.createEntityManagerFactory("Oracle final", System.getProperties()).createEntityManager();
    
//    @Resource
//            UserTransaction userTran;
    
    @Inject
            HospitalLogic hospitalLogic;
    
    public PacienteLogic(){
    }
    
    @Override
    public PacienteDTO crearPaciente(PacienteDTO paciente)
    {
        try{
//            userTran.begin();
            PacienteEntity pe = paciente.toEntity();
            System.out.println("Id antes " + pe.getId());
            em.persist(pe);
//            userTran.commit();
            System.out.println("Id despues " + pe.getId());
            return pe.toDTO();
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
//        hospitalLogic.agregarPaciente(paciente);
    }
    
    @Override
    public PacienteDTO buscarPaciente(Long id) {
        System.out.println("Logic " + id);
        return em.find(PacienteEntity.class, id).toDTODetail();
    }
    
    @Override
    public List<PacienteDTO> darPacientes() 
    {
        List<PacienteDTO> r = new ArrayList<>();
        
        Query q = em.createQuery("select u from PacienteEntity u");
        List<PacienteEntity> rata = q.getResultList();
        for (int i = 0; i < rata.size(); i++) 
        {
            r.add(rata.get(i).toDTODetail());
        }
        return r;
    }
    
    @Override
    public void eliminarPaciente(Long id) {
        try{
//        userTran.begin();
        em.remove(em.find(PacienteEntity.class, id));
//        userTran.commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public PacienteDTO modificarPaciente(Long id, PacienteDTO paciente) 
    {
        try{
//            userTran.begin();
            PacienteEntity p = paciente.toEntity();
            p.setId(id);
            em.merge(p);
//            userTran.commit();
            return p.toDTO();
        }
        catch(Exception e){
            return null;
        }
    }
    
    public ArrayList<AlertaDTO> getHistorialPorRango(Long idPaciente, Date fechaInicio, Date fechaFinal)
    {
        ArrayList<AlertaDTO> r = new ArrayList<>();
        
        PacienteEntity p= em.find(PacienteEntity.class,idPaciente);
        DispositivoEntity d = em.find(DispositivoEntity.class, p.getDispositivo().getId());
        //Funciona historial
        for (int i =0; i<d.getAlertas().size();i++)
        {
            AlertaDTO actual = d.getAlertas().get(i).toDTO();
            
            if(actual.getFecha().after(fechaInicio) && actual.getFecha().before(fechaFinal))
            {
                r.add(actual);
            }
        }
        return r;
    }
//        TypedQuery<AlertaEntity> q = em.createQuery(
//                "SELECT c FROM ("
//                        + " (SELECT u FROM DISPOSITIVOENTITY_ALERTAENTITY u WHERE u.DISPOSITIVOENTITY_ID = :name   ) INNER JOIN"
//                        + "(SELECT v FROM ALERTAENTITY WHERE v.FECHA BETWEEN :fecha1 AND :fecha2 )ON u.ALERTAENTITY_ID = v.ID ) c "
//                ,AlertaEntity.class);
//        q = q.setParameter("name", d.getId());
//        q = q.setParameter("fecha1", fechaInicio);
//        q = q.setParameter("fecha2", fechaFinal);
//        List<AlertaEntity> r = q.getResultList();
//        
//        for (int i = 0; i < r.size(); i++) 
//        {
//            rta.add(r.get(i).toDTO());
//        }
//        return rta;
    
    @Override
    public String toString() {
        return "PacienteLogic{" + '}';
    }
    
    public HistorialDTO modificarHistorialPaciente(Long idPaciente, HistorialDTO p) {
        try 
        {
//            userTran.begin();
        PacienteEntity paciente = em.find(PacienteEntity.class, idPaciente);
        paciente.setHistorial(p.toEntity());
        em.merge(paciente);
//        userTran.commit();
        
        return paciente.getHistorial().toDto();
        }
        catch (Exception e )
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public PacienteDTO agregarConsejo(long idPaciente, ConsejoDTO consejo) {
        PacienteEntity paciente = em.find(PacienteEntity.class, idPaciente);
        paciente.agregarConsejo(consejo.toEntity());
        em.merge(paciente);
        return paciente.toDTO();
    }
    
    public void agregarDispositivo(DispositivoEntity dispositivo) {
        PacienteEntity paciente = em.find(PacienteEntity.class, dispositivo.getPaciente().getId());
        paciente.setDispositivo(dispositivo);
        try{
//            userTran.begin();
            em.merge(paciente);
//            userTran.commit();
        }
        catch(Exception e){

        }
    }

    
    
    
}
