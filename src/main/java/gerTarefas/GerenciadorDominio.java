/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas;

import gerDados.ClienteDAO;
import gerDados.ConexaoHibernate;
import gerDados.GenericDAO;
import gerDados.PedidoDAO;
import java.util.Date;
import java.util.List;
import javax.swing.Icon;
import modelo.Cliente;
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
    
//    public int inserirPedido(Cliente cli, char entrega, JTable tblPedidos) throws HibernateException {
//
//        Pedido ped = new Pedido(new Date(), entrega, 0, cli);
//        List lista = ped.getItensPedidos();
//        float valorTotal = 0;
//
//        int tam = tblPedidos.getRowCount();
//        if (tam > 0) {
//            for (int lin = 0; lin < tam; lin++) {
//                int col = 0;
//                Lanche lanche = (Lanche) tblPedidos.getValueAt(lin, col++);
//                int qtde = (int) tblPedidos.getValueAt(lin, col++);
//                int maisBife = (int) tblPedidos.getValueAt(lin, col++);
//                int maisQueijo = (int) tblPedidos.getValueAt(lin, col++);
//                int maisPresunto = (int) tblPedidos.getValueAt(lin, col++);
//                int maisOvo = (int) tblPedidos.getValueAt(lin, col++);
//                String observacao = tblPedidos.getValueAt(lin, col++).toString();
//
//                ItemPedido item = new ItemPedido(lanche, ped, qtde, observacao, maisBife, maisOvo, maisPresunto, maisQueijo);
//                lista.add(item);
//                valorTotal = valorTotal + lanche.getValor() * qtde;
//            }
//            ped.setValorTotal(valorTotal);
//            genDao.inserir(ped);
//            return ped.getIdPedido();
//        } else {
//            return -1;
//        }
//
//    }
}
