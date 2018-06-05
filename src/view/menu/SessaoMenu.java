
package view.menu;

/**
 *
 * @author guilh
 */
public class SessaoMenu {
    
    public static final int OP_CADASTRAR = 1;
    public static final int OP_DELETAR = 2;
    public static final int OP_LISTAR = 3;
    public static final int OP_CONSULTAR = 4;
    public static final int OP_SAIR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Cadastrar Sessao\n"
                + "2- Deletar Sessao\n"
                + "3- Listar Sessao\n"                
                + "4- Consultar Sessao por ID\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    } 
}
