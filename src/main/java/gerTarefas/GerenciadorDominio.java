/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas;

import gerDados.ClienteDAO;
import gerDados.ConexaoHibernate;
import gerDados.GenericDAO;
import gerDados.PedidoDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JTable;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produtos;
import org.hibernate.HibernateException;


/**
 *
 * @author mathe
 */
public class GerenciadorDominio {
    
    private GenericDAO genDao;
    private ClienteDAO cliDao;
    private PedidoDAO pedDao;
    
    public GerenciadorDominio() throws HibernateException {
        
        ConexaoHibernate.getSessionFactory().openSession();
        genDao = new GenericDAO();
        cliDao = new ClienteDAO();
        pedDao = new PedidoDAO();
    }
    
    public List listar(Class classe) throws HibernateException {
        return genDao.listar(classe);
    }
    
    public List<Cliente> pesquisarCliente(String txtPesq) throws HibernateException {

        List<Cliente> lista = null;  
        lista = cliDao.pesquisarPorNome(txtPesq);
        return lista;

    }
    
    public void excluir(Object obj) throws HibernateException {
        genDao.excluir(obj);
    }
    
    public int inserirCliente(String nome, String cpf, Date dtNasc, char sexo, String rua,
            int numero, String complemento, String bairro, String referencia, String telFixo,
            String celular, String email) throws HibernateException {

        Cliente cli = new Cliente(nome, cpf, dtNasc, sexo, rua, numero,
                complemento, bairro, referencia, telFixo, celular, email);

        cliDao.inserir(cli);
        return cli.getIdCliente();
    }
    
    public void alterarCliente(Cliente cli, String nome, String cpf, Date dtNasc, char sexo, String rua,
            int numero, String complemento, String bairro, String referencia, String telFixo,
            String celular, String email) throws HibernateException {

        cli.setNome(nome);
        cli.setCpf(cpf);
        cli.setDtNasc(dtNasc);
        cli.setSexo(sexo);
        cli.setRua(rua);
        cli.setNumero(numero);
        
        cli.setComplemento(complemento);
        cli.setBairro(bairro);
        cli.setReferencia(referencia);
        cli.setTelFixo(telFixo);
        cli.setCelular(celular);
        cli.setEmail(email);

        cliDao.alterar(cli);
    }
    
    public int inserirPedido(Cliente cli, double total) throws HibernateException {

        
        Pedido ped = new Pedido(new Date(), 0, cli);
        float valorTotal = 0;
        valorTotal = (float) total;
        
        ped.setTotal(valorTotal);
        genDao.inserir(ped);
        return ped.getIdPedido();
    }

    public List<Pedido> pesquisarPedido(String txtPesq) {
        List<Pedido> lista = null;
        lista = pedDao.pesquisarPorID(txtPesq);
        return lista;
    }
    
    
    
}
