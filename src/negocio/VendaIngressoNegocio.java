
package negocio;

import dao.VendaIngressoDao;
import dao.SessaoDao;
import dao.impl_BD.VendaIngressoDaoBD;
import dao.impl_BD.SessaoDaoBD;
import java.util.List;
import dominio.VendaIngresso;
/**
 *
 * @author guilh
 */
public class VendaIngressoNegocio {
    
    private VendaIngressoDao vendaIngressoDao;
    private SessaoDao sessaoDao;


    public VendaIngressoNegocio() {
        vendaIngressoDao = new VendaIngressoDaoBD();
        sessaoDao = new SessaoDaoBD();
    }
    
    public void salvar(VendaIngresso i) throws NegocioException {
        this.validarCamposObrigatorios(i);
       if(i.getSessao().getQtdIngresso()<1){
       System.out.println("Ingressos esgotados para essa sessão");
       }else{
           
        sessaoDao.retiraIngresso(i.getSessao());
        vendaIngressoDao.salvar(i);
       }       
    }    
    
    public List<VendaIngresso> listar() {
        return (vendaIngressoDao.listar());
    }    

    public void deletar(VendaIngresso ing) throws NegocioException {
        if (ing == null) {
            throw new NegocioException("Ingresso nao existe!");
        }
        vendaIngressoDao.deletar(ing);
    }
    
        public VendaIngresso procurarPorId(String id) throws NegocioException {
        if (id == null || id.isEmpty()) {
            throw new NegocioException("Campo ID nao informado");
        }
        try {
            int i = Integer.parseInt(id);
            VendaIngresso ing = vendaIngressoDao.procurarPorId(i);
        if (ing == null) {
            throw new NegocioException("Ingresso nao encontrado");
        }
        return (ing);
                    }catch(NumberFormatException e){
                        System.err.println("para o ID, escrever apenas numeros");
                    }
        return (null);
    }
    
    private void validarCamposObrigatorios(VendaIngresso i) throws NegocioException {
        
        if (i.getSessao() == null) {
            throw new NegocioException("Campo Sessao nao informado");
        }      
    }
    
    public List<VendaIngresso> listarPorSessao(String id) throws NegocioException {
        if (id == null || id.isEmpty()) {
            throw new NegocioException("Campo ID Sessao nao informado");
        }
        try{
        int i = Integer.parseInt(id);
        return(vendaIngressoDao.listarPorSessao(i));
        }catch(Exception e){
        System.out.println("Verificar informações concedidas.");
        }
        return (null);
    }      
}
