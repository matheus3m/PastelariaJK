/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "Pastel", schema= "Pastelaria")
public class Pastel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPastel;
    @Column
    private String recheio;
    @Column
    private float valor;

    public Pastel(int idPastel, String recheio, float valor) {
        this.idPastel = idPastel;
        this.recheio = recheio;
        this.valor = valor;
    }

    public int getIdPastel() {
        return idPastel;
    }

    public void setIdPastel(int idPastel) {
        this.idPastel = idPastel;
    }

    public String getRecheio() {
        return recheio;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
   
    
}
