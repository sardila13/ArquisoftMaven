/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package logica.ejb;

import Entites.HospitalEntity;
import Persitence.PersistenceManager;
import dto.AlertaDTO;
import dto.HospitalDTO;
import dto.PacienteDTO;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import javax.ws.rs.core.Response;
import logica.interfaces.IHospital;


/**
 *
 * @author gc.andrade10
 */
//@Stateless
@Singleton
public class HospitalLogic implements IHospital
{
    @PersistenceContext(unitName = "Derby" , type = PersistenceContextType.TRANSACTION)
    protected EntityManager em = Persistence.createEntityManagerFactory("Derby", System.getProperties()).createEntityManager();
    
    @Resource
            UserTransaction userTran;
    
    //= PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    //
    
    public HospitalLogic()
    {
    }
    
//    @PostConstruct
//    public void init()
//    {
//        try
//        {
//            em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//    }
    
    
    public void notificarEmergencia(AlertaDTO alerta)
    {
        System.out.println("EMERGENCIA "+alerta.toString());
    }
    
    public void crear(HospitalDTO hospitalDTO)
    {
//        hospitalDTO.setId(0L);
        HospitalEntity he =hospitalDTO.toEntity();
        try {
            userTran.begin();
            em.persist(he);
            userTran.commit();
            
        } 
        catch (Exception e) {
        }
        
    }
    
    public List<HospitalEntity> findAll()
    {
        Query q = em.createQuery("select u from HospitalEntity u");
        return q.getResultList();
    }

    void agregarPaciente(PacienteDTO paciente) 
    {
        HospitalEntity h;
        h = find(paciente.getHospital().getId());
        h.addPaciente(paciente.toEntity());
        update(h);
    }
    
      public HospitalEntity update (HospitalEntity adminEntity)
    {
        try{
            userTran.begin();
            HospitalEntity he = em.merge(adminEntity);
            userTran.commit();
            return he;
        }
        catch(Exception e){
            return null;
        }
    }
      public HospitalEntity find(Long id)
    {
        return em.find(HospitalEntity.class, id);
    }
}
