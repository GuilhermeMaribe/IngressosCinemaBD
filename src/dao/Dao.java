
package dao;

import java.util.List;

/**
 *
 * @author guilh
 */
public interface Dao<T> {
    public void salvar(T objeto);
    public void deletar(T objeto);
    public void atualizar(T objeto);
    public List<T> listar();
    public T procurarPorId(int id);
}
