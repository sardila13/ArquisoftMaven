/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package logica.ejb;

import Entites.ConfiguracionEntity;
import Entites.HospitalEntity;
import dto.AlertaDTO;
import dto.ConfiguracionDTO;
import dto.HospitalDTO;
import dto.PacienteDTO;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import logica.interfaces.IHospital;


/**
 *
 * @author gc.andrade10
 */
//@Stateless
@Singleton
public class ConfiguracionlLogic implements IHospital
{
    @PersistenceContext(unitName = "Oracle final" , type = PersistenceContextType.TRANSACTION)
    protected EntityManager em = Persistence.createEntityManagerFactory("Oracle final", System.getProperties()).createEntityManager();
    
    @Resource
            UserTransaction userTran;
    
    //= PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    //
    
    public ConfiguracionlLogic()
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
    
    
    public void crear(ConfiguracionDTO hospitalDTO)
    {
//        hospitalDTO.setId(0L);
        ConfiguracionEntity he =hospitalDTO.toEntity();
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
