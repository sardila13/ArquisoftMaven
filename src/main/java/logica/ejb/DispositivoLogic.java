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
import dto.ConfiguracionDTO;
import dto.DispositivoDTO;
import dto.PacienteDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import logica.interfaces.IDispositivo;

/**
 *
 * @author s.ardila13
 */
@Singleton
//@Stateless
public class DispositivoLogic implements IDispositivo {
    
    //private DispositivoMock persistence;
    
    @PersistenceContext(unitName = "Oracle final", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em = Persistence.createEntityManagerFactory("Oracle final", System.getProperties()).createEntityManager();
    
    @Resource
//            UserTransaction userTran;
    
    @Inject
    PacienteLogic pacienteLogic;
    
    
    public DispositivoLogic(){
        //persistence = new DispositivoMock();
    }
    
    @Override
    public void crearDispositivo(DispositivoDTO dispositivo)
    {
        try {
//            userTran.begin();
            DispositivoEntity de = dispositivo.toEntity();
            de.setPaciente(em.find(PacienteEntity.class, dispositivo.getPaciente().getId()));
            em.persist(de);
//            userTran.commit();
            
            /*???*/
            pacienteLogic.agregarDispositivo(de);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public DispositivoDTO buscarDispositivo(Long id)
    {
        return em.find(DispositivoEntity.class, id).toDTO();
        
    }
    
    @Override
    public List<DispositivoDTO> darDispositivos() {
        Query q = em.createQuery("select u from DispositivoEntity u");
        return q.getResultList();
    }
    
    @Override
    public void eliminarDispositivo(Long id) {
        em.remove(em.find(Long.class,id));
    }
    
    @Override
    public void modificarDispositivo(Long id, DispositivoDTO paciente) {
        em.merge(paciente);
    }
    
    @Override
    public ConfiguracionDTO setConfiguracion(ConfiguracionDTO confi, Long idDispositivo)
    {
        DispositivoDTO dispositivo = em.find(DispositivoDTO.class, idDispositivo);
        dispositivo.setConfiguration(confi);
        em.merge(dispositivo);
        return confi;
    }

    @Override
    public void agregarAlerta(Long idDispositivo, AlertaDTO alerta) {
//        System.out.println("Buscando "+idDispositivo);
        DispositivoEntity dispositivo = em.find(DispositivoEntity.class, idDispositivo);
        alerta.setFecha(new Date());
        AlertaEntity a = alerta.toEntity();
//        System.out.println("alerta Entity: "+a);
//        System.out.println("dispositivo Entity: "+dispositivo);
        dispositivo.agregarAlerta(a);
        try{
//            userTran.begin();
            em.merge(dispositivo);
//            userTran.commit();
        }
        catch(Exception e){
            
        }
    }
    
    
    
}
