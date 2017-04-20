/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;
import dto.ConfiguracionDTO;
import dto.ConsejoDTO;
import dto.MedicoDTO;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Sneider Velandia G
 */
public interface IMedicoLogic 
{
    public void crearMedico(MedicoDTO medico);
    public MedicoDTO buscarMedico(int id);
    public List<MedicoDTO>darMedicos();
    public void eliminarMedico(int id);
    public ConfiguracionDTO configurarMarcapasos(long id, ConfiguracionDTO cofiguracion);
    public ConsejoDTO enviarConsejo(long idPaciente, ConsejoDTO consejo);
    
}
