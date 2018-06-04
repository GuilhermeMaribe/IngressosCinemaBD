
package dao;
import java.util.List;
import dominio.Filme;
/**
 *
 * @author guilh
 */
public interface FilmeDao extends Dao<Filme> {
    
     public Filme procurarPorCodigo(String codigo);
     
     public List<Filme> listarPorNome(String nome);
}
