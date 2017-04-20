/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Sneider Velandia G
 */
public class AmbulanciaDTO 
{
    //atributos
    private int id;
    
    //constructor
    public void AmbulanciaDTO()
    {}
    
    //constructor con parametros
    public void AmbulanciaDTO(int id)
    {
        this.id=id;
    }
    
    //metodos Set
    public void setAmbulancia(int id)
    {
        this.id=id;
    }
    //metodos Get
    public int darId()
    {
        return id;
    }
}
