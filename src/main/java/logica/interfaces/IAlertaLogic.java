/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import dto.AlertaDTO;
import java.util.List;

/**
 *
 * @author ba.bohorquez10
 */
public interface IAlertaLogic 
{
//    public AlertaDTO crearAlerta(AlertaDTO nueva,Long idDispositivo);
    
    
    public List<AlertaDTO> darAlertas();
    /**
    public AlertaDTO buscarAlerta(Long id);
    public void modificarAlerta(Long id, AlertaDTO nueva);
    public void eliminarAlerta(Long id);
     * 
     */
    
}
