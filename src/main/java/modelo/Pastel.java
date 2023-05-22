/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Pastel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPastel;
    private String recheio;
    private float valor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Pedido_Pastel", joinColumns = {
    @JoinColumn(name = "idPastel")}, inverseJoinColumns = {
    @JoinColumn(name = "idPedido")})
    private List<Pedido> pedidos = new ArrayList();

    
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
