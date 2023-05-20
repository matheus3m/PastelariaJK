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
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class GerenciadorInterGraf {

    private FrmPrincipal princ;
    private DlgCadCliente cli;
    private DlgCadPedido ped;
    private DlgPesqCliente pesqCli;
    private DlgPesqPedido pesqPed;
    private GerenciadorDominio gerDom;
    
    public GerenciadorInterGraf() {
       gerDom = new GerenciadorDominio();
       princ = null;
       cli = null;
       ped = null;
       pesqCli = null;
       pesqPed = null; 
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
    
    public void abrirPesqCliente() {
        pesqCli = (DlgPesqCliente) abrirJanela(princ, pesqCli, DlgPesqCliente.class);
    }
    
    public void abrirPesqPedido() {
        pesqPed = (DlgPesqPedido) abrirJanela(princ, pesqPed, DlgPesqPedido.class);
    }
    
    public static void main(String args[]) {
        GerenciadorInterGraf gerIG = new GerenciadorInterGraf();
        gerIG.abrirJanPrincipal();
    }
}
