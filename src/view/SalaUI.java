
package view;

import java.util.InputMismatchException;
import java.util.List;
import dominio.Sala;
import negocio.NegocioException;
import negocio.SalaNegocio;
import util.Console;
import view.menu.SalaMenu;

/**
 *
 * @author guilh
 */
public class SalaUI {
    private SalaNegocio salaNegocio;

    public SalaUI() {
        salaNegocio = new SalaNegocio();
    }
    
     public void menu() {
        int opcao = -1;
        do {
            try{
                System.out.println(SalaMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opção:");
                switch (opcao) {
                    case SalaMenu.OP_CADASTRAR:
                        cadastrarSala();
                        break;
                    case SalaMenu.OP_DELETAR:
                        deletarSala();
                        break;
                    case SalaMenu.OP_ATUALIZAR:
                        atualizarSala();
                        break;
                    case SalaMenu.OP_LISTAR:
                        mostrarSalas();
                        break;
                    case SalaMenu.OP_CONSULTAR:
                        consultarSalaPorNumero();
                        break;
                    case SalaMenu.OP_SAIR:
                        System.out.println("Finalizando a aplicacao..");
                        break;
                    default:
                        System.out.println("Opção inválida..");
                }
            } catch (InputMismatchException ex) {
                UIUtil.mostrarErro("Somente numeros sao permitidos!");
            }

        } while (opcao != SalaMenu.OP_SAIR);
    }

    private void cadastrarSala() {
        String nSala = Console.scanString("Numero da Sala: ");
        String nAssentos = Console.scanString("Quantodade de Assentos: ");
        if (nAssentos == null || nAssentos.isEmpty()) {
            System.out.println("Preencha todos os campos");
        }else{

        try {
            int qtdAssentos = Integer.parseInt(nAssentos);
            salaNegocio.salvar(new Sala(nSala, qtdAssentos));
            System.out.println("Sala numero " + nSala + " cadastrada com sucesso!");
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        }catch(Exception e){
        System.out.println("em Quantidade de Assentos, digitar apenas numeros");
        } 
        }
    }
     
    public void mostrarSalas() {
        List<Sala> listaSalas = salaNegocio.listar();
        this.mostrarSalas(listaSalas);
    }
 
    private void deletarSala() {
        String nSala = Console.scanString("Numero da sala a ser deletada: ");
        try {
            Sala sal = salaNegocio.procurarPorNumero(nSala);
            this.mostrarSala(sal);
            if (UIUtil.getConfirmacao("Realmente deseja excluir essa sala?")) {
                salaNegocio.deletar(sal);
                System.out.println("deletada com sucesso!");
            } else {
                System.out.println("Operacao cancelada!");
            }
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        }
    }    
    
    private void atualizarSala() {
        String nSala = Console.scanString("Numero da sala a ser alterada: ");
        try {
            Sala sal = salaNegocio.procurarPorNumero(nSala);
            this.mostrarSala(sal);

            System.out.println("Digite os dados da sala que quer alterar"); 
            int nAssentos = Integer.parseInt(Console.scanString("Quantidade de Assentos: "));
            if(nAssentos < 1){
               System.out.println("A capacidade deve ser superior a 0 lugares"); 
            }else{
                
                salaNegocio.atualizar(sal);
                System.out.println("Sala numero " + nSala + " atualizada com sucesso!");
            }
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        }catch(Exception e){
        System.out.println("em lugares, digitar apenas números");
        }  
    }

    private void consultarSalaPorNumero() {
        String nSala = Console.scanString("Numero da Sala: ");
        try {
            List<Sala> listaSal = salaNegocio.listarPorNumero(nSala);
            this.mostrarSalas(listaSal);
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        }

    } 
    
    private void mostrarSala(Sala sala) {
        System.out.println("-----------------------------");
        System.out.println("Sala");
        System.out.println("Numero: " + sala.getnSala());
        System.out.println("Assentos: " + sala.getnAssentos());
        System.out.println("-----------------------------");
    }    
    
      private void mostrarSalas(List<Sala> listaSalas) {
        if (listaSalas.isEmpty()) {
            System.out.println("Salas nao encontradas!");
        } else {
            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-10s", "NUMERO") + "\t"
                    + String.format("%-10s", "|ASSENTOS"));
            for (Sala sala : listaSalas) {
                System.out.println(String.format("%-10s", sala.getnSala()) + "\t"
                        + String.format("%-20s", "|" + sala.getnAssentos()));
            }
        }
    }
      
      
}
