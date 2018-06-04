
package view.menu;

/**
 *
 * @author guilh
 */
public class FilmeMenu {
    
    public static final int OP_CADASTRAR = 1;
    public static final int OP_DELETAR = 2;
    public static final int OP_ATUALIZAR = 3;
    public static final int OP_LISTAR = 4;
    public static final int OP_CONSULTAR = 5;
    public static final int OP_SAIR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Cadastrar Filme\n"
                + "2- Deletar Filme\n"
                + "3- Atualizar dados do Filme\n"
                + "4- Listar Filmes\n"                
                + "5- Consultar Filmes por Titulo\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }     
}

