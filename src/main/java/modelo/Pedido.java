 package modelo;

import gerTarefas.FuncoesUteis;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Pedido implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;

    @Temporal(TemporalType.DATE)
    private Date dataPedido;
    
    private float total;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Pedido_Produto", joinColumns = {
    @JoinColumn(name = "idPedido")}, inverseJoinColumns = {
    @JoinColumn(name = "idProduto")})
    private List<Produtos> produto = new ArrayList();

    public Pedido() {
    }

    public Pedido(Date dataPedido, float total, Cliente cliente) {
        this.dataPedido = dataPedido;
        this.total = total;
        this.cliente = cliente;
    }
    
    public Pedido(int idPedido, Date dataPedido, float total, Cliente cliente) {
        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
        this.total = total;
        this.cliente = cliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produtos> getProduto() {
        return produto;
    }

    public void setProduto(List<Produtos> produto) {
        this.produto = produto;
    }

    public Object[] toArray() throws ParseException {

        // FORMATAR MOEDA
        NumberFormat formNum = NumberFormat.getCurrencyInstance();

        /*
        // FORMATAR CASAS DECIMAIS 
        DecimalFormat formNum = new DecimalFormat();
        formNum.setMaximumFractionDigits(2);
        formNum.setMinimumFractionDigits(2);
         */
        return new Object[]{this, cliente,
            FuncoesUteis.dateToStr(getDataPedido()),
            formNum.format(total)};
    }
    
    
    
}
