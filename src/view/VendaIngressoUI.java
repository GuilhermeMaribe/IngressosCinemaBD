
package view;

import java.util.InputMismatchException;
import java.util.List;
import dominio.VendaIngresso;
import dominio.Sessao;
import negocio.VendaIngressoNegocio;
import negocio.NegocioException;
import negocio.SessaoNegocio;
import util.Console;
import static util.DateTimeUtil.timeToString;
import view.menu.VendaIngressoMenu;
/**
 *
 * @author guilh
 */
public class VendaIngressoUI {
    private SessaoUI sessaoUI;
    private VendaIngressoNegocio ingressoNegocio;
    private SessaoNegocio sessaoNegocio;   

    public VendaIngressoUI() {
        ingressoNegocio = new VendaIngressoNegocio();
        sessaoNegocio = new SessaoNegocio();
        sessaoUI = new SessaoUI();
    }    
    
    public void menu() {
        int opcao = -1;
        do {
            try{
                System.out.println(VendaIngressoMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opção:");
                switch (opcao) {
                    case VendaIngressoMenu.OP_CADASTRAR:
                        venderIngresso();
                        break;
                    case VendaIngressoMenu.OP_DELETAR:
                        deletarIngresso();
                        break;
                    case VendaIngressoMenu.OP_LISTAR:
                        mostrarIngresso();
                        break;
                    case VendaIngressoMenu.OP_CONSULTAR:
                        consultarIngressoPorSessao();
                        break;
                    case VendaIngressoMenu.OP_SAIR:
                        System.out.println("Finalizando a aplicacao..");
                        break;
                    default:
                        System.out.println("Opção inválida..");
                }
            } catch (InputMismatchException ex) {
                UIUtil.mostrarErro("Somente numeros sao permitidos!");
            }

        } while (opcao != VendaIngressoMenu.OP_SAIR);
    }

    private void venderIngresso() {          
        try {
            sessaoUI.listarSessao(sessaoNegocio.listar());            
            String sessao = Console.scanString("Id da sessao: ");
            Sessao s = sessaoNegocio.procurarPorId(sessao);            
            ingressoNegocio.salvar(new VendaIngresso(s));            
            if(s.getQtdIngresso() > 0){
            this.mostrarIngresso(new VendaIngresso(s));
            System.out.println("Compra efetudda com sucesso! \n");
            }
            
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        } catch (Exception ex) {
           System.out.println("Cadastrar as informações de acordo com o item solicitado"); 
    }
    }
    
     private void mostrarIngresso(VendaIngresso i) { 
        if (i == null) {
            System.out.println("Sessao nao encontrada!");
        } else {
            System.out.println("-----------------------------------\n");
            System.out.println(String.format("Ingresso para o filme: "+i.getSessao().getFilme().getNome())+ "\n"
                    + String.format("Horário da sessão: "+i.getSessao().getHorario()+" | sala: "+i.getSessao().getSala().getnSala()+"."));
    }
     }

    public void mostrarIngresso() {
        List<VendaIngresso> listaIngresso = ingressoNegocio.listar();
        this.mostrarIngresso(listaIngresso);
    }
    
    private void mostrarIngresso(List<VendaIngresso> listaIngresso) { 
        if (listaIngresso.isEmpty()) {
            System.out.println("Ingresso nao encontrado!");
        } else {
            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-10s", "ID") + "\t"
                    + String.format("%-10s", "|HORARIO")+ "\t"
                    + String.format("%-10s", "|SALA")+ "\t"
                    + String.format("%-20s", "|FILME"));
            for (VendaIngresso ing : listaIngresso) {
                System.out.println(String.format("%-10s", ing.getId()) + "\t"
                        + String.format("%-10s", ing.getSessao().getHorario()) + "\t"
                        + String.format("%-10s", ing.getSessao().getSala().getnSala()) + "\t"
                        + String.format("%-20s", "|" + ing.getSessao().getFilme().getNome()));
            }
        }
    }
    
    private void consultarIngressoPorSessao() {
        String sessao = Console.scanString("ID da sessao: ");
        try {
            this.mostrarIngresso(ingressoNegocio.listarPorSessao(sessao));
        } catch (Exception ex) {
            System.out.println("Ingressos não encontrados");
        }

    }
    
        private void deletarIngresso() {
        String id = Console.scanString("Id do ingresso a ser deletado: ");
        try {
            VendaIngresso ing = ingressoNegocio.procurarPorId(id);
            this.mostrarIngresso(ing);
               ingressoNegocio.deletar(ing);
                System.out.println("deletado com sucesso!");

        } catch (Exception ex) {
            System.out.println();
        }
    } 
    
}
