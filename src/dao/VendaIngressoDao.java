
package dao;

import java.util.List;
import dominio.VendaIngresso;
/**
 *
 * @author guilh
 */
public interface VendaIngressoDao extends Dao<VendaIngresso> {
    @Override
    public void salvar(VendaIngresso vendaingresso);
    @Override
    public void deletar(VendaIngresso vendaingresso);
    @Override
    public void atualizar(VendaIngresso vendaingresso);
    public List<VendaIngresso> listarPorSessao(int Id);
    @Override
    public VendaIngresso procurarPorId(int Id);
}
