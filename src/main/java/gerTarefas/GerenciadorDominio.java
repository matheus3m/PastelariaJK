/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas;

import gerDados.ConexaoHibernate;
import org.hibernate.HibernateException;

/**
 *
 * @author mathe
 */
public class GerenciadorDominio {
    
    public GerenciadorDominio() throws HibernateException {
        
        ConexaoHibernate.getSessionFactory().openSession();
    }
    
}
