
package dao;

import dominio.Sessao;
import java.util.List;

/**
 *
 * @author guilh
 */
public interface SessaoDao extends Dao<Sessao> {
    
    @Override
    public void salvar(Sessao sessao);
    @Override
    public void deletar(Sessao sessao);
    @Override
    public void atualizar(Sessao sessao);
    
    /**
     *
     * @return
     */
    public List<Sessao> listarAtivas(); 
    @Override
    public List<Sessao> listar();
    public void retiraIngresso(Sessao sessao);
}
