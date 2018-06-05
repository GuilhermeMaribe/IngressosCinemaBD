package negocio;

import dominio.Sala;
import dao.SalaDao;
import dao.impl_BD.SalaDaoBD;
import java.util.List;
/**
 *
 * @author guilh
 */
public class SalaNegocio {
    private SalaDao salaDao;

    public SalaNegocio() {
        salaDao = new SalaDaoBD();
    }
    
    public void salvar(Sala s) throws NegocioException {
        this.validarCamposObrigatorios(s);
        this.validarNumeroExistente(s);
        salaDao.salvar(s);
        
    }

    /**
     *
     * @return
     */
    public List<Sala> listar() {
        return (salaDao.listar());
    }
    
    public void deletar(Sala sala) throws NegocioException {
        if (sala == null || sala.getnSala() == null) {
            throw new NegocioException("Sala nao existe!");
        }
        salaDao.deletar(sala);
    }

    public void atualizar(Sala sala) throws NegocioException {
        if (sala == null || sala.getnSala() == null) {
            throw new NegocioException("Sala nao existe!");
        }
        this.validarCamposObrigatorios(sala);
        salaDao.atualizar(sala);
    }

    public Sala procurarPorNumero(String nSala) throws NegocioException {
        if (nSala == null || nSala.isEmpty()) {
            throw new NegocioException("Campo Numero nao informado");
        }
        Sala sala = salaDao.procurarPorNumero(nSala);
        if (sala == null) {
            throw new NegocioException("Sala nao encontrado");
        }
        return (sala);
    }

    public boolean salaExiste(String nSala) {
        Sala sala = salaDao.procurarPorNumero(nSala);
        return (sala != null);
    }

    private void validarCamposObrigatorios(Sala s) throws NegocioException {
        if (s.getnSala() == null || s.getnSala().isEmpty()) {
            throw new NegocioException("Campo Numero nao informado");
        }

        if (s.getnAssentos() < 1) {   
            throw new NegocioException("Campo Quantidade de Assentos nao informado");
        }
    }

    private void validarNumeroExistente(Sala s) throws NegocioException {
        if (salaExiste(s.getnSala())) {
            throw new NegocioException("Sala ja existente");
        }
    }

    public List<Sala> listarPorNumero(String nSala) throws NegocioException {
        if (nSala == null || nSala.isEmpty()) {
            throw new NegocioException("Campo numero nao informado");
        }
        return(salaDao.listarPorNumero(nSala));
    }    
}
