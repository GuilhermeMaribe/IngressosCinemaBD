
package view.menu;

/**
 *
 * @author guilh
 */
public class VendaIngressoMenu {
   
    public static final int OP_CADASTRAR = 1;
    public static final int OP_DELETAR = 2;
    public static final int OP_LISTAR = 3;
    public static final int OP_CONSULTAR = 4;
    public static final int OP_SAIR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Vender ingressos\n"
                + "2- Deletar ingresso\n"
                + "3- Listar ingressos\n"                
                + "4- Consultar ingressos por sessao\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }      
}
