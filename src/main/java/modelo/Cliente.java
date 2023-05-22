/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import gerTarefas.FuncoesUteis;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mathe
 */
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    @Column(length = 200)
    private String nome;

    @Column(unique = true, updatable = false, length = 14, nullable = false)
    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date dtNasc;

    @Column(length = 1)
    private char sexo;
    
    private String rua;
    private int numero; 
    private String complemento;
    private String bairro;
    private String referencia;
    private String telFixo;
    private String celular;
    private String email;
    
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Pedido> pedidos = new ArrayList();

    public Cliente() {
    }

    public Cliente(int idCliente, String nome, String cpf, Date dtNasc, char sexo, String rua, int numero, String complemento, String bairro, String referencia, String telFixo, String celular, String email) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.sexo = sexo;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.referencia = referencia;
        this.telFixo = telFixo;
        this.celular = celular;
        this.email = email;
    }

    public Cliente(String nome, String cpf, Date dtNasc, char sexo, String rua, int numero, String complemento, String bairro, String referencia, String telFixo, String celular, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.sexo = sexo;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.referencia = referencia;
        this.telFixo = telFixo;
        this.celular = celular;
        this.email = email;
    }
    
    

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(String telFixo) {
        this.telFixo = telFixo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    public String getDataFormatada() throws ParseException {
        return FuncoesUteis.dateToStr(dtNasc);
    }
    
    public Object[] toArray() throws ParseException {
        return new Object[]{this, celular};
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
}
