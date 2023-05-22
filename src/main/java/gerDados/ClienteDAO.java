
package gerDados;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import modelo.Cliente;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ClienteDAO extends GenericDAO  {

    private List<Cliente> pesquisar(String txtPesq) throws HibernateException {

        Session sessao = null;
        List lista = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Cliente.class);
            Root tabela = consulta.from(Cliente.class);
            Predicate restricoes = null;
            tabela.fetch("pedidos", JoinType.INNER);
            consulta.distinct(true);
            
            restricoes = builder.like(tabela.get("nome"), txtPesq + "%");
                    
            consulta.where(restricoes);
            lista = sessao.createQuery(consulta).getResultList();

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException erro) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(erro);
        }
        return lista;
    }

    public List<Cliente> pesquisarPorNome(String txtPesq) throws HibernateException {
        return pesquisar(txtPesq);
    }
    
}
