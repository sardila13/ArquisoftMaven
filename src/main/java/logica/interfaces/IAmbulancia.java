package logica.interfaces;

import dto.AmbulanciaDTO;
/**
 *
 * @author Sneider Velandia G
 */
public interface IAmbulancia 
{
    public void crearAmbulancia(AmbulanciaDTO ambulancia);
    public AmbulanciaDTO buscarAmbulancia(int id);
    public AmbulanciaDTO[] darAmbulancias ();
    public void eliminarAmbulancia(int id);
        
}
