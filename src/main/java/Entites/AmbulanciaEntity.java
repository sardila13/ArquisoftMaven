/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author s.ardila13
 */

@Entity
public class AmbulanciaEntity implements Serializable
{
    @Id
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ambulancia_seq_gen")
//    @SequenceGenerator(name="ambulancia_seq_gen", sequenceName="AMBULANCIA_SEQU")
    private Long id;
    
    public AmbulanciaEntity()
    {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
