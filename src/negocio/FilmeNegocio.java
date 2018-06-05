
package negocio;
import dao.FilmeDao;
import dao.impl_BD.FilmeDaoBD;
import java.util.List;
import dominio.Filme;

/**
 *
 * @author guilh
 */
public class FilmeNegocio {
    
    private FilmeDao filmeDao;

    public FilmeNegocio() {
        filmeDao = new FilmeDaoBD();
    }
    
    public void salvar(Filme f) throws NegocioException {
        this.validarCamposObrigatorios(f);
        this.validarCodigoExistente(f);    
        filmeDao.salvar(f);
        
    }

    public List<Filme> listar() {
        return (filmeDao.listar());
    }
    
    public void deletar(Filme filme) throws NegocioException {
        if (filme == null || filme.getCodigo() == null) {
            throw new NegocioException("Filme nao existe!");
        }
        filmeDao.deletar(filme);
    }

    public void atualizar(Filme filme) throws NegocioException {
        if (filme == null || filme.getCodigo() == null) {
            throw new NegocioException("Filme nao existe!");
        }
        this.validarCamposObrigatorios(filme);
        filmeDao.atualizar(filme);
    }

    public Filme procurarPorCodigo(String codigo) throws NegocioException {
        if (codigo == null || codigo.isEmpty()) {
            throw new NegocioException("Campo codigo nao informado");
        }
        Filme filme = filmeDao.procurarPorCodigo(codigo);
        if (filme == null) {
            throw new NegocioException("Codigo nao encontrado");
        }
        return (filme);
    }

    public boolean filmeExiste(String codigo) {
        Filme filme = filmeDao.procurarPorCodigo(codigo);
        return (filme != null);
    }

    private void validarCamposObrigatorios(Filme f) throws NegocioException {
        if (f.getCodigo() == null || f.getCodigo().isEmpty()) {
            throw new NegocioException("Campo Codigo nao informado");
        }
        if (f.getNome() == null || f.getNome().isEmpty()) {
            throw new NegocioException("Campo Nome nao informado");
        }
        if (f.getGenero() == null || f.getGenero().isEmpty()) {
            throw new NegocioException("Campo Genero nao informado");
        }
        if (f.getSinopse() == null || f.getSinopse().isEmpty()) {
            throw new NegocioException("Campo Sinopse nao informado");
        }
    }

    private void validarCodigoExistente(Filme f) throws NegocioException {
        if (filmeExiste(f.getCodigo())) {
            throw new NegocioException("Filme ja existente");
        }
    }

    public List<Filme> listarPorNome(String nome) throws NegocioException {
        if (nome == null || nome.isEmpty()) {
            throw new NegocioException("Campo nome nao informado");
        }
        return(filmeDao.listarPorNome(nome));
    }    
}
