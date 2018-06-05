
package dao;

import dominio.Sala;
import java.util.List;

/**
 *
 * @author guilh
 */
public interface SalaDao extends Dao<Sala> {

    /**
     *
     * @param numero
     * @return
     */
    public Sala procurarPorNumero(String numero);

    public List<Sala> listarPorNumero(String numero);
}
