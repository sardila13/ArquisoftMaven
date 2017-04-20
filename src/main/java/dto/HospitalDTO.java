/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package dto;

import Entites.DispositivoEntity;
import Entites.HospitalEntity;
import Entites.PacienteEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gc.andrade10
 */
public class HospitalDTO
{
    private String nombre;
    private Long id;
    private List<DispositivoDTO> dispositivos;
    private List<PacienteDTO> pacientes;
    
    public HospitalDTO()
    {
    }
    
    public HospitalDTO(String nombre)
    {
        this.nombre = nombre;
        dispositivos= new ArrayList<>();
        pacientes = new ArrayList<>();
    }
    
    /**
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * @return the id
     */
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long pId)
    {
        id=pId;
    }
    
    public ArrayList<DispositivoEntity> dispositivosEntities()
    {
        ArrayList<DispositivoEntity> nAlertas = new ArrayList<DispositivoEntity>();
        for(int i = 0; i < dispositivos.size(); i++){
            nAlertas.add(dispositivos.get(i).toEntity());
        }
        return nAlertas;
    }
    
     public ArrayList<PacienteEntity> pacientesEntities()
    {
        ArrayList<PacienteEntity> nAlertas = new ArrayList<PacienteEntity>();
        for(int i = 0; i < pacientes.size(); i++){
            nAlertas.add(pacientes.get(i).toEntity());
        }
        return nAlertas;
    }
    
    public HospitalEntity toEntity()
    {
        HospitalEntity h = new HospitalEntity(nombre);
        h.setDispositivos(dispositivosEntities());
        h.setPacientes(pacientesEntities());
        h.setId(id);
        return h;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<DispositivoDTO> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<DispositivoDTO> dispositivos) {
        this.dispositivos = dispositivos;
    }

    public List<PacienteDTO> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<PacienteDTO> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public String toString() {
        return "HospitalDTO{" + "nombre=" + nombre + ", id=" + id + ", dispositivos=" + dispositivos + ", pacientes=" + pacientes + '}';
    }
    
    
    
}
