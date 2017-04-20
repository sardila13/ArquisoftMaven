/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.ejb;

import Persitence.PersistenceManager;
import dto.ConfiguracionDTO;
import dto.ConsejoDTO;
import dto.MedicoDTO;
import dto.PacienteDTO;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.UserTransaction;
import logica.interfaces.IMedicoLogic;

/**
 *
 * @author Sneider Velandia G
 */
@Singleton
public class MedicoLogic implements IMedicoLogic{

    private PacienteLogic pacienteLogic = new PacienteLogic();
    private DispositivoLogic dispositivoLogic = new DispositivoLogic();
    
    @PersistenceContext(unitName = "Oracle final", type = PersistenceContextType.TRANSACTION)
    protected EntityManager em = Persistence.createEntityManagerFactory("Oracle final", System.getProperties()).createEntityManager();
    
    @Resource
            UserTransaction userTran;
    
    @Override
    public void crearMedico(MedicoDTO medico) 
    {
         try {
            userTran.begin();
            em.persist(medico.toEntity());
            userTran.commit();
            
        } catch (Exception e) {
        }
    }

    @Override
    public MedicoDTO buscarMedico(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<MedicoDTO> darMedicos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarMedico(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConfiguracionDTO configurarMarcapasos(long idDispositivo, ConfiguracionDTO configuracion) 
    {
        return dispositivoLogic.setConfiguracion( configuracion, idDispositivo);
    }

    public ConsejoDTO enviarConsejo(long idPaciente, ConsejoDTO consejo)
    {
        PacienteDTO p = pacienteLogic.agregarConsejo(idPaciente, consejo);
        return consejo;
    }
    
}
