package view;

import util.Console;
import view.menu.MainMenu;

/**
 *
 * @author guilh
 */
public class MainUI {
    
    public MainUI() {
	    }
	    
	    public void executar() {
	        int opcao = -1;
	        do {
	            System.out.println(MainMenu.getOpcoes());
                    try{
	            opcao = Console.scanInt("Digite sua opção:");
                    }catch(Exception e){
                        opcao = 9;//invalida
                    }
	            switch (opcao) {
	                case MainMenu.OP_SALAS:
	                    new SalaUI().menu();
	                    break;
                        case MainMenu.OP_FILMES:
	                    new FilmeUI().menu();
	                    break;
                        case MainMenu.OP_SESSOES:
	                    new SessaoUI().menu();
	                    break;       
                        case MainMenu.OP_INGRESSO:
	                    new VendaIngressoUI().menu();
	                    break;                            
	                case MainMenu.OP_SAIR:
	                    System.out.println("Aplicação finalizada!!!");
	                    break;
	                default:
	                    System.out.println("Opção inválida..");

	            }
	        } while (opcao != MainMenu.OP_SAIR);
	    }
}
