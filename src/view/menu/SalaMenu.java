
package view.menu;

/**
 *
 * @author guilh
 */
public class SalaMenu {
    
    public static final int OP_CADASTRAR = 1;
    public static final int OP_DELETAR = 2;
    public static final int OP_ATUALIZAR = 3;
    public static final int OP_LISTAR = 4;
    public static final int OP_CONSULTAR = 5;
    public static final int OP_SAIR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Cadastrar Sala\n"
                + "2- Deletar Sala\n"
                + "3- Atualizar dados da Sala\n"
                + "4- Listar Salas\n"                
                + "5- Consultar Salas por Numero\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }   
}
