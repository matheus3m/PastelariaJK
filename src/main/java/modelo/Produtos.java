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
public class Produtos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduto;
    private String produto;
    private float valor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Pedido_Produto", joinColumns = {
    @JoinColumn(name = "idProduto")}, inverseJoinColumns = {
    @JoinColumn(name = "idPedido")})
    private List<Pedido> pedidos = new ArrayList();

    
    public Produtos(int idProduto, String produto, float valor) {
        this.idProduto = idProduto;
        this.produto = produto;
        this.valor = valor;
    }

    public Produtos() {
    }
    
    

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return produto;
    }
    
   public String formataPreco(){
       return "R$ " + Double.toString(getValor())+ "0";
    }
}
