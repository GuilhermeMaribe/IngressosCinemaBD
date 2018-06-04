package view.menu;

/**
 *
 * @author guilh
 */
public class MainMenu {
  
    public static final int OP_SALAS = 1;
        public static final int OP_FILMES = 2;
        public static final int OP_SESSOES = 3;
        public static final int OP_INGRESSO = 4;        
	public static final int OP_SAIR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "----------------CINEMA----------------\n"
                + "1- Menu Salas\n"
                + "2- Menu Filmes\n"
                + "3- Menu Sessoes\n"
                + "4- Menu Ingresso\n"
                + "0- Sair da Aplicação"
                + "\n--------------------------------------");
    }

}
