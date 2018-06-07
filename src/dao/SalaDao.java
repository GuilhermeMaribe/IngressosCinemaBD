
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
     * @param sala
     */
    @Override
    public void salvar(Sala sala);
    @Override
    public void deletar(Sala sala);
    @Override
    public void atualizar(Sala sala);
    public Sala procurarPorNumero(String numero);

    public List<Sala> listarPorNumero(String numero);
}
