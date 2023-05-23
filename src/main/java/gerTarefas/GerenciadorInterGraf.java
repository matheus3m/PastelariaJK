/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas;

import intergraf.DlgCadCliente;
import intergraf.DlgCadPedido;
import intergraf.DlgPesqCliente;
import intergraf.DlgPesqPedido;
import intergraf.FrmPrincipal;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Pedido;
import org.hibernate.HibernateException;

public class GerenciadorInterGraf {

    private FrmPrincipal princ;
    private DlgCadCliente cli;
    private DlgCadPedido ped;
    private DlgPesqCliente pesqCli;
    private DlgPesqPedido pesqPed;
    private GerenciadorDominio gerDom;
    
    public GerenciadorInterGraf() {
        try {
            gerDom = new GerenciadorDominio();
            princ = null;
            cli = null;
            ped = null;
            pesqCli = null;
            pesqPed = null;
        } catch (HibernateException erro) {
            JOptionPane.showMessageDialog(princ, erro);
            System.exit(-1);
        }
    }
    
    public GerenciadorDominio getGerDominio() {
        return gerDom;
    }
    
    private JDialog abrirJanela(java.awt.Frame parent, JDialog dlg, Class classe) {
        if (dlg == null) {
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class, GerenciadorInterGraf.class).newInstance(parent, true, this);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName());
            }
        }
        dlg.setVisible(true);
        return dlg;
    }
    
    public void abrirJanPrincipal() {
        princ = new FrmPrincipal(this);
        princ.setVisible(true);
    }
    
    public void abrirCadPedido(){
        ped = (DlgCadPedido) abrirJanela(princ, ped, DlgCadPedido.class);
    }
    
    public void abrirCadCliente(){
        cli = (DlgCadCliente) abrirJanela(princ, cli, DlgCadCliente.class);
    }
    
    public Cliente abrirPesqCliente() {
        pesqCli = (DlgPesqCliente) abrirJanela(princ, pesqCli, DlgPesqCliente.class);
        return pesqCli.getClienteSelecionado();
    }
    
    public Pedido abrirPesqPedido() {
        pesqPed = (DlgPesqPedido) abrirJanela(princ, pesqPed, DlgPesqPedido.class);
        return pesqPed.getPedidoSelecionado();
    }
    
    public void carregarCombo(JComboBox combo, Class classe) {
        try {
            List lista = gerDom.listar(classe);
            combo.setModel(new DefaultComboBoxModel(lista.toArray()));

        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(princ, "Erro ao listar itens.");
        }
    }
    
    public static void main(String args[]) {
        GerenciadorInterGraf gerIG = new GerenciadorInterGraf();
        gerIG.abrirJanPrincipal();
    }
}
