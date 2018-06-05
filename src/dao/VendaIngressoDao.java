
package dao;

import java.util.List;
import dominio.VendaIngresso;
/**
 *
 * @author guilh
 */
public interface VendaIngressoDao extends Dao<VendaIngresso> {
    public List<VendaIngresso> listarPorSessao(int Id);
}
