/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Entites;

import dto.DispositivoDTO;
import dto.HospitalDTO;
import dto.MedicoDTO;
import dto.PacienteDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author s.ardila13
 */
@Entity
public class PacienteEntity implements Serializable
{
//    @Inject
//    DispositivoLogic dispositivoLogic;
    
    @Id
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="paciente_seq_gen")
//    @SequenceGenerator(name="paciente_seq_gen", sequenceName="PACIENTE_SEQU")
    private Long id;
    
    private String nombre;
    
    private int edad;
    
    @OneToOne
    @PodamExclude
    private DispositivoEntity dispositivo;
    
    @ManyToMany
    private List<MedicoEntity> medicos;
    
    @ManyToOne
    @PodamExclude
    private HospitalEntity hospital;
    
    @PodamExclude
    @OneToOne(cascade = CascadeType.ALL)
    private HistorialEntity historial;
    
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlertaEntity> alertas;
    
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConsejoEntity> consejos;
    
    public PacienteEntity()
    {
        
    }
    
    public PacienteEntity(String nombre, int edad, DispositivoEntity dispositivo, List<MedicoEntity> medicos, HospitalEntity hospital, HistorialEntity historial, List<AlertaEntity> alertas, List<ConsejoEntity> consejos) {
        this.nombre = nombre;
        this.edad = edad;
        this.dispositivo = dispositivo;
        this.medicos = medicos;
        this.hospital = hospital;
        this.historial = historial;
        this.alertas = alertas;
        this.consejos = consejos;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public DispositivoEntity getDispositivo() {
        return dispositivo;
    }
    
    public void setDispositivo(DispositivoEntity dispositivo) {
        this.dispositivo = dispositivo;
    }
    
    public List<MedicoEntity> getMedicos() {
        return medicos;
    }
    
    public void setMedicos(List<MedicoEntity> medicos) {
        this.medicos = medicos;
    }
    
    public HospitalEntity getHospital() {
        return hospital;
    }
    
    public void setHospital(HospitalEntity hospital) {
        this.hospital = hospital;
    }
    
    public HistorialEntity getHistorial() {
        return historial;
    }
    
    public void setHistorial(HistorialEntity historial) {
        this.historial = historial;
    }
    
    public List<AlertaEntity> getAlertas() {
        return alertas;
    }
    
    public void setAlertas(List<AlertaEntity> alertas) {
        this.alertas = alertas;
    }
    
    public List<ConsejoEntity> getConsejos() {
        return consejos;
    }
    
    public void setConsejos(List<ConsejoEntity> consejos) {
        this.consejos = consejos;
    }
    
    
    
    public PacienteDTO toDTO()
    {
        ArrayList<MedicoDTO> pMedicos = new ArrayList<MedicoDTO>();
        if(medicos != null)
        {
            for(int i = 0; i < medicos.size(); i++){
                pMedicos.add(medicos.get(i).toDTO());
            }
        }
        HospitalDTO pHospital = null;
        if(hospital != null){
            pHospital = hospital.toDTO();
        }
        DispositivoDTO pDispositivo = null;
        if(dispositivo != null){
            pDispositivo = dispositivo.toDTO();
        }
        PacienteDTO p = new PacienteDTO(nombre, edad, pHospital);
        p.setId(id);
        p.setDispositivo(pDispositivo);
        
        return p;
    }

    @Override
    public String toString() {
        return "PacienteEntity{" + "id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", dispositivo=" + dispositivo + ", medicos=" + medicos + ", hospital=" + hospital + ", historial=" + historial + ", alertas=" + alertas + ", consejos=" + consejos + '}';
    }

    public void agregarConsejo(ConsejoEntity toEntity) {
        consejos.add(toEntity);
    }

    public PacienteDTO toDTODetail() 
    {
        return new PacienteDTO(nombre, edad, hospital.toDTO());
    }
    
    
    
}
