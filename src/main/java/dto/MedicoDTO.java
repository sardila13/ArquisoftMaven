/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import Entites.MedicoEntity;

/**
 *
 * @author Sneider Velandia G
 */
public class MedicoDTO 
{
    //atributos
    private String nombre;
    private Long id;
    private int especialista;
    
    //constrcutor vacio
    public MedicoDTO()
    {}
    
    //contructor con atributos
    public MedicoDTO(String nombre, int i) 
    {
        this.nombre=nombre;
        this.especialista=especialista;
    }
    
    // metodos Get
    public String getNombre()
    {
        return nombre;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public int especialista()
    {
        return especialista;
    }
    //metodos Set
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public void setEspecialista(int especialista)
    {
        this.especialista=especialista;
    }

    public MedicoEntity toEntity() 
    {
        MedicoEntity m = new MedicoEntity(nombre, especialista);
        m.setId(id);
        return m;
    }

    
}
