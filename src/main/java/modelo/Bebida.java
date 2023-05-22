/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Bebida implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBebida;
    private String sabor;
    private float valorbeb;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Pedido_Bebida", joinColumns = {
    @JoinColumn(name = "idBebida")}, inverseJoinColumns = {
    @JoinColumn(name = "idPedido")})
    private List<Pedido> pedidos = new ArrayList();

    public Bebida(int idBebida, String tsabor, float valorbeb) {
        this.idBebida = idBebida;
        this.sabor = tsabor;
        this.valorbeb = valorbeb;
    }

    public int getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(int idBebida) {
        this.idBebida = idBebida;
    }

    public String getTsabor() {
        return sabor;
    }

    public void setTsabor(String tsabor) {
        this.sabor = tsabor;
    }

    public float getValorbeb() {
        return valorbeb;
    }

    public void setValorbeb(float valorbeb) {
        this.valorbeb = valorbeb;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    
    
}
