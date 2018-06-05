
package negocio;

import dominio.Sessao;
import dao.SessaoDao;
import dao.impl_BD.SessaoDaoBD;
import java.util.List;

/**
 *
 * @author guilh
 */
public class SessaoNegocio {
   
    private SessaoDao sessaoDao;

    public SessaoNegocio() {
        sessaoDao = new SessaoDaoBD();
    }
    
    public void salvar(Sessao s) throws NegocioException {
        this.validarCamposObrigatorios(s);
        sessaoDao.salvar(s);        
    }    
    
    public List<Sessao> listar() {
        return (sessaoDao.listar());
    }    

    public void deletar(Sessao sessao) throws NegocioException {
        if (sessao == null) {
            throw new NegocioException("Sessao nao existe!");
        }
        sessaoDao.deletar(sessao);
    }
    
        public Sessao procurarPorId(String id) throws NegocioException {
        if (id == null || id.isEmpty()) {
            throw new NegocioException("Campo ID nao informado");
        }
        try {
            int i = Integer.parseInt(id);
            Sessao sessao = sessaoDao.procurarPorId(i);
        if (sessao == null) {
            throw new NegocioException("Sala nao encontrado");
        }
        return (sessao);
                    }catch(NumberFormatException e){
                        System.err.println("para o ID, escrever apenas numeros");
                    }
        return (null);
    }
    
    private void validarCamposObrigatorios(Sessao s) throws NegocioException {
        if (s.getHorario() == null) {
            throw new NegocioException("Campo Horario nao informado");
        }
        
        if (s.getSala() == null) {
            throw new NegocioException("Campo Sala nao informado");
        }
        
        if (s.getFilme() == null) {
            throw new NegocioException("Campo Filme nao informado");
        }        
    }    
    
    public List<Sessao> listarAtivas() {
        return (sessaoDao.listarAtivas());
    }     
}
