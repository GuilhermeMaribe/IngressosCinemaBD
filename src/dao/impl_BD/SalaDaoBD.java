
package dao.impl_BD;

import dao.SalaDao;
import dominio.Sala;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guilh
 */
public class SalaDaoBD extends DaoBd<Sala> implements SalaDao {
    
 @Override
    public void salvar(Sala sala) {
        int id = 0;
        try {
            String sql = "INSERT INTO Sala (nSala, nAssentos) "
                    + "VALUES (?,?)";

            
            conectarObtendoId(sql);
            comando.setString(1, sala.getnSala());
            comando.setInt(2, sala.getnAssentos());
            comando.executeUpdate();
            
            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
               
                id = resultado.getInt(1);
                sala.setId(id);
            }
            else{
                System.err.println("Erro de Sistema - Nao gerou o id conforme esperado!");
                throw new BDException("Nao gerou o id conforme esperado!");
            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao salvar Salas no Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void deletar(Sala sala) {
        try {
            String sql = "DELETE FROM sala WHERE id = ?";

            conectar(sql);
            comando.setInt(1, sala.getId());
            comando.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("A sala não pode ser ");
            
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void atualizar(Sala sala) {
                try {
            String sql = "UPDATE sala SET nSala=?, nAssentos=? "
                    + "WHERE id=?";

            conectar(sql);
            comando.setString(1, sala.getnSala());
            comando.setInt(2, sala.getnAssentos());
            comando.setInt(3, sala.getId());
            comando.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao atualizar sala no Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public List<Sala> listar() {
        List<Sala> listaSalas = new ArrayList<>();

        String sql = "SELECT * FROM sala";

        try {
            conectar(sql);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nSala = resultado.getString("nSala");
                int nAssentos = resultado.getInt("nAssentos");

                Sala sal = new Sala(id, nSala, nAssentos);
                listaSalas.add(sal);

            }
        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar as salas do Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
        return (listaSalas);
    }

    @Override
    public Sala procurarPorId(int id) {
        String sql = "SELECT * FROM sala WHERE id = ?";

        try {
            conectar(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                String nSala = resultado.getString("nSala");
                int nAssentos = resultado.getInt("nAssentos");

                Sala sal = new Sala(id, nSala, nAssentos);

                return sal;

            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar a sala pelo id do Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }

        return (null);
    }

    @Override
    public Sala procurarPorNumero(String nSala) {
        String sql = "SELECT * FROM sala WHERE nSala = ?";

        try {
            conectar(sql);
            comando.setString(1, nSala);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                int id = resultado.getInt("id");
                int nAssentos = resultado.getInt("nAssentos");
                
                Sala Sal = new Sala(id, nSala, nAssentos);

                return Sal;

            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar sala pelo numero no Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }

        return (null);
    }

    @Override
    public List<Sala> listarPorNumero(String nSala) {
        List<Sala> listaSalas = new ArrayList<>();
        String sql = "SELECT * FROM sala WHERE nSala LIKE ?";

        try {
            conectar(sql);
            comando.setString(1, "%" + nSala + "%");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                
                String nSalaX = resultado.getString("nSala");
                
                int nAssentos = resultado.getInt("nAssentos");

                Sala sal = new Sala(id, nSalaX, nAssentos);

                listaSalas.add(sal);

            }

        } catch (SQLException ex) {
            System.err.println("Erro de Sistema - Problema ao buscar as salas pelo numero no Banco de Dados!");
            throw new BDException(ex);
        } finally {
            fecharConexao();
        }
        return (listaSalas);        
    }
    
}
