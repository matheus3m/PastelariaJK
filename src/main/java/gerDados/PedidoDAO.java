package gerDados;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import modelo.Cliente;
import modelo.Pedido;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class PedidoDAO extends GenericDAO {

    private List<Pedido> pesquisar(String txtPesq) {
//        Session sessao = null;
//        List lista = null;
//        try {
//            sessao = ConexaoHibernate.getSessionFactory().openSession();
//            sessao.beginTransaction();
//
//            // CONSULTA COM CRITERIA
//            CriteriaBuilder builder = sessao.getCriteriaBuilder();
//            CriteriaQuery consulta = builder.createQuery(Pedido.class);
//
//            // ASSOCIAR e PEGAR A TABELA
//            Root tabela = consulta.from(Pedido.class);
//
//            // MUDAR o FETCH
//            tabela.fetch("produto", JoinType.INNER);
//            consulta.distinct(true);
//
//            Predicate restricoes = null;
//
//            restricoes = builder.equal(tabela.get("idPedido"), txtPesq);
//
//            consulta.where(restricoes);
//            lista = sessao.createQuery(consulta).getResultList();
//
//            sessao.getTransaction().commit();
//            sessao.close();
//        } catch (HibernateException erro) {
//            if (sessao != null) {
//                sessao.getTransaction().rollback();
//                sessao.close();
//            }
//            throw new HibernateException(erro);
//        }
//        return lista;
        List lista = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Pedido.class);

            Root tabela = consulta.from(Pedido.class);

            Predicate restricoes = null;
            restricoes = builder.equal(tabela.get("idPedido"), txtPesq);

            consulta.where(restricoes);
            // EXECUTAR
            lista = sessao.createQuery(consulta).getResultList();

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return lista;
    }


    public List<Pedido> pesquisarPorID(String pesq) {
         return pesquisar(pesq);             
    }
    
}
