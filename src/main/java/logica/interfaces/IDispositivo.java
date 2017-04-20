/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import com.sun.media.jfxmediaimpl.MediaDisposer;
import dto.AlertaDTO;
import dto.ConfiguracionDTO;
import dto.DispositivoDTO;
import dto.PacienteDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s.ardila13
 */
public interface IDispositivo {
    
    public void crearDispositivo(DispositivoDTO dispositivo);
    
    public DispositivoDTO buscarDispositivo(Long id);
    
    public List<DispositivoDTO> darDispositivos();
    
    public void eliminarDispositivo(Long id);
    
    public void modificarDispositivo(Long id, DispositivoDTO paciente);
    
    public ConfiguracionDTO setConfiguracion(ConfiguracionDTO confi, Long idDispositivo);

    public void agregarAlerta(Long idDispositivo, AlertaDTO alerta);

    
}
