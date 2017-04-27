package logica.ejb;
import Entites.DispositivoEntity;
import Persitence.PersistenceManager;
import dto.AlertaDTO;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import logica.interfaces.IAlertaLogic;
/**
 *
 * @author ba.bohorquez10
 */
@Singleton
//@Stateless
public class AlertaLogic implements IAlertaLogic
{
    //private AlertaMock persistence;
    
    @Inject
    private HospitalLogic hospitalLogic;
    
    @PersistenceContext(unitName = "Derby")
    protected EntityManager em = Persistence.createEntityManagerFactory("Derby", System.getProperties()).createEntityManager();
    
    @Resource
            UserTransaction userTran;
    
//    = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    //type = PersistenceContextType.TRANSACTION
    
    public AlertaLogic()
    {
    }
    
  
    
//    public AlertaDTO crearAlerta(AlertaDTO alerta, Long idDispositivo)
//    {
//        //Requerimiento 2
//        
//        
//        if(alerta.getFrecuenciaCardica()>100 ||alerta.getFrecuenciaCardica()<60
//                || alerta.getPresionSanguinea()[0]>120 || alerta.getPresionSanguinea()[1]<80
//                ||alerta.getNivelEstres()>70)
//        {
//            alerta.setEsEmergencia(1);
//            hospitalLogic.notificarEmergencia(alerta);
//        }
//        System.out.println("Buscar");
//        DispositivoEntity dis = em.find(DispositivoEntity.class, idDispositivo );
//        System.out.println("Encontró");
//        System.out.println("Dispositivo Entity: " + dis);
//        
//        dis.agregarAlerta(alerta);
//        alerta.setDispositivo(dis.toDTO());
//        System.out.println(alerta.toString());
//        System.out.println("e: "+alerta.toEntity());
//        em.persist(alerta.toEntity());
//        return alerta;
//    }
    
    //No se necesita public AlertaDTO buscarAlerta(int pId)

    
    public List<AlertaDTO> darAlertas()
    {
        Query q = em.createQuery("select u from AlertaEntity u");
        return q.getResultList();
    }
    
// no se necesita    public void modificarAlerta(Long id, AlertaDTO nueva)
    
   //no se necesita public void eliminarAlerta(Long id)

}
