
package dao;

import dominio.Sessao;
import java.util.List;

/**
 *
 * @author guilh
 */
public interface SessaoDao extends Dao<Sessao> {
    
    public List<Sessao> listarAtivas();    
    public void retiraIngresso(Sessao sessao);
}
