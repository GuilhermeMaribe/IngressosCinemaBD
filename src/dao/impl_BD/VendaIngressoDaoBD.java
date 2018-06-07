
package dao.impl_BD;

import dao.VendaIngressoDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dominio.Sessao;
import dominio.VendaIngresso;
/**
 *
 * @author guilh
 */
public class VendaIngressoDaoBD extends DaoBd<VendaIngresso> implements VendaIngressoDao {
    @Override
    public void salvar(VendaIngresso ing) {
        int id = 0;
        try {
            String sql = "INSERT INTO vendaIngresso (id_sessao) "
                    + "VALUES (?)";

            conectarObtendoId(sql);
            comando.setInt(1, ing.getSessao().getId());           
            comando.executeUpdate();
            
            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
                
                id = resultado.getInt(1);
                ing.setId(id);
            }
            else{
                System.err.println("Erro de Sistema - Nao gerou o id conforme esperado!");
                throw new BDException("Nao gerou o id conforme esperado!");
            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao salvar ingresso no Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void deletar(VendaIngresso ing) {
        try {
            String sql = "DELETE FROM vendaIngresso WHERE id = ?";

            conectar(sql);
            comando.setInt(1, ing.getId());
            comando.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("O ingresso não pode ser ");
            
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void atualizar(VendaIngresso ing) {
      
    }

    @Override
    public List<VendaIngresso> listar() {
                List<VendaIngresso> listaIngresso = new ArrayList<>();

        String sql = "SELECT * FROM vendaIngresso";

        try {
            conectar(sql);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");

                int idSessao = resultado.getInt("id_sessao");
                
                Sessao s = new SessaoDaoBD().procurarPorId(idSessao);

                VendaIngresso ing = new VendaIngresso(id, s);
                
                listaIngresso.add(ing);

            }
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar os ingressos no Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
        return (listaIngresso);
    }

    @Override
    public VendaIngresso procurarPorId(int id) {
                String sql = "SELECT * FROM vendaIngresso WHERE id = ?";
        try {
            conectar(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
 
                int idSessao = resultado.getInt("id_sessao");
                
                Sessao s = new SessaoDaoBD().procurarPorId(idSessao);

                VendaIngresso ing = new VendaIngresso(id, s);

                return ing;

            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar o ingresso pelo id no Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }

        return (null);
    }

    @Override
    public List<VendaIngresso> listarPorSessao(int id) {
        List<VendaIngresso> listaIngresso = new ArrayList<>();
        String sql = "SELECT * FROM vendaIngresso WHERE id_sessao=?";

        try {
            conectar(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                
                int idx = resultado.getInt("id");
                int idSessao = resultado.getInt("id_sessao");
                Sessao s = new SessaoDaoBD().procurarPorId(idSessao);
                
                VendaIngresso ing = new VendaIngresso(idx, s);                

                listaIngresso.add(ing);

            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar os ingressos pelo titulo no Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
        return (listaIngresso); 
    }
    
}
