
package dao.impl_BD;

import dao.SessaoDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import dominio.Filme;
import dominio.Sala;
import dominio.Sessao;

/**
 *
 * @author guilh
 */
public class SessaoDaoBD extends DaoBd<Sessao> implements SessaoDao {
    
 @Override
    public void salvar(Sessao sessao) {
        int id = 0;
        try {
            String sql = "INSERT INTO sessao (qtd_ingresso, horario, id_sala, id_filme) "
                    + "VALUES (?,?,?,?)";

            
            conectarObtendoId(sql);
                        
            comando.setInt(1, sessao.getQtdIngresso());
            comando.setTime(2, Time.valueOf(sessao.getHorario()));
            comando.setInt(3, sessao.getSala().getId());
            comando.setInt(4, sessao.getFilme().getId());           
            comando.executeUpdate();
            
            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
                
                id = resultado.getInt(1);
                sessao.setId(id);
            }
            else{
                System.err.println("Erro de Sistema - Nao gerou o id conforme esperado!");
                throw new BDException("Nao gerou o id conforme esperado!");
            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao salvar sessao no Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void deletar(Sessao sessao) {
                try {
            String sql = "DELETE FROM sessao WHERE id = ?";

            conectar(sql);
            comando.setInt(1, sessao.getId());
            comando.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("A sessao não pode ser ");
            
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void atualizar(Sessao sessao) { 
        
    }

    @Override
    public List<Sessao> listar() {
                List<Sessao> listaSessao = new ArrayList<>();

        String sql = "SELECT * FROM sessao";

        try {
            conectar(sql);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                
                Time dataSql = resultado.getTime("horario");
                LocalTime hora = dataSql.toLocalTime();
                
                int qtdIngresso = resultado.getInt("qtd_ingresso");
                
                int idSala = resultado.getInt("id_sala");
                
                
                Sala s = new SalaDaoBD().procurarPorId(idSala);
                
                int idFilme = resultado.getInt("id_filme");
                
                
                Filme f = new FilmeDaoBD().procurarPorId(idFilme);
                

                Sessao sess = new Sessao(id, qtdIngresso, hora, s, f);
                
                listaSessao.add(sess);

            }
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar os sessaoes no Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
        return (listaSessao);
    }

    @Override
    public Sessao procurarPorId(int id) {
                String sql = "SELECT * FROM sessao WHERE id = ?";

        try {
            conectar(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                
                Time dataSql = resultado.getTime("horario");
                LocalTime hora = dataSql.toLocalTime();
                
                int qtdIngresso = resultado.getInt("qtd_ingresso");
                
                int idSala = resultado.getInt("id_sala");
                                
                Sala s = new SalaDaoBD().procurarPorId(idSala);
                
                int idFilme = resultado.getInt("id_filme");
                                
                Filme f = new FilmeDaoBD().procurarPorId(idFilme);
                

                Sessao sess = new Sessao(id, qtdIngresso, hora, s, f);

                return sess;

            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar a sessao pelo id no Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }

        return (null);
    }
    
    @Override    
    public void retiraIngresso(Sessao sessao) { 
                try {
            String sql = "UPDATE sessao SET qtd_ingresso=?, horario=?, id_sala=?, id_filme=?"
                    + "WHERE id=?";

            conectar(sql);
            
            int i = (sessao.getQtdIngresso() - 1);
                       
            comando.setInt(1, i);
            comando.setTime(2, Time.valueOf(sessao.getHorario()));
            comando.setInt(3, sessao.getSala().getId());
            comando.setInt(4, sessao.getFilme().getId());
            System.out.println(sessao.getId());
            comando.setInt(5, sessao.getId());
            comando.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao atualizar filme no Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
    }
    
    @Override
    public List<Sessao> listarAtivas() {
                List<Sessao> listaSessao = new ArrayList<>();

        String sql = "SELECT * FROM sessao";

        try {
            conectar(sql);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                
                Time dataSql = resultado.getTime("horario");
                LocalTime hora = dataSql.toLocalTime();
                
                int qtdIngresso = resultado.getInt("qtd_ingresso");
                
                int idSala = resultado.getInt("id_sala");
                                
                Sala s = new SalaDaoBD().procurarPorId(idSala);
                
                int idFilme = resultado.getInt("id_filme");
                                
                Filme f = new FilmeDaoBD().procurarPorId(idFilme);
                
                LocalTime horaNow = LocalTime.now(); 
                
                if(horaNow.isBefore(hora)){
                Sessao sess = new Sessao(id, qtdIngresso, hora, s, f);
                listaSessao.add(sess);
                }

            }
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar os sessaoes no Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
        return (listaSessao);
    }

}
