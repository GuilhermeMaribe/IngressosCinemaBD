
package view;

import dominio.Filme;
import java.util.InputMismatchException;
import java.util.List;
import negocio.FilmeNegocio;
import negocio.NegocioException;
import util.Console;
import view.menu.FilmeMenu;

/**
 *
 * @author guilh
 */
public class FilmeUI {
  private FilmeNegocio filmeNegocio;

    public FilmeUI() {
        filmeNegocio = new FilmeNegocio();       
    }    
    
     public void menu() {
        int opcao = -1;
        do {
            try{
                System.out.println(FilmeMenu.getOpcoes());                
                opcao = Console.scanInt("Digite sua opção:");
                switch (opcao) {
                    case FilmeMenu.OP_CADASTRAR:
                        cadastrarFilme();
                        break;
                    case FilmeMenu.OP_DELETAR:
                        deletarFilme();
                        break;
                    case FilmeMenu.OP_ATUALIZAR:
                        atualizarFilme();
                        break;
                    case FilmeMenu.OP_LISTAR:
                        mostrarFilme();
                        break;
                    case FilmeMenu.OP_CONSULTAR:
                        consultarFilmePorNome();
                        break;
                    case FilmeMenu.OP_SAIR:
                        System.out.println("Finalizando a aplicacao..");
                        break;
                    default:
                        System.out.println("Opção inválida..");
                }
            } catch (InputMismatchException ex) {
                UIUtil.mostrarErro("Somente numeros sao permitidos!");
            }

        } while (opcao != FilmeMenu.OP_SAIR);
    }

     private void cadastrarFilme() {
        String codigo = Console.scanString("Codigo: ");
        String nome = Console.scanString("Nome: ");
        String genero = Console.scanString("Genero: ");
        String sinopse = Console.scanString("Sinopse: ");        
        try {
            filmeNegocio.salvar(new Filme(codigo, nome, genero, sinopse));
            System.out.println("Filme " + nome + " cadastrado com sucesso!");
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        } 
    }
     
     public void mostrarFilme() {
        List<Filme> listaFilmes = filmeNegocio.listar();
        this.mostrarFilmes(listaFilmes);
     }

     private void deletarFilme() {
        String codigo = Console.scanString("Codigo do filme a ser deletada: ");
        try {
            Filme film = filmeNegocio.procurarPorCodigo(codigo);
            this.mostrarFilme(film);
            if (UIUtil.getConfirmacao("Realmente deseja excluir esse Filme?")) {
                filmeNegocio.deletar(film);
                System.out.println("deletado com sucesso!");
            } else {
                System.out.println("Operacao cancelada!");
            }
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        }
    }
     
    private void atualizarFilme() {
        String codigo = Console.scanString("Codigo do filme a ser alterado: ");
        try {
            Filme film = filmeNegocio.procurarPorCodigo(codigo);
            this.mostrarFilme(film);

            System.out.println("Digite os dados do filme que deseja alterar"); 

            String nome = Console.scanString("Nome: ");
            String genero = Console.scanString("Genero: ");
            String sinopse = Console.scanString("Sinopse: ");

            if (!nome.isEmpty()) {
                film.setNome(nome);
            }
            if (!genero.isEmpty()) {
                film.setGenero(genero);
            }
            if (!sinopse.isEmpty()) {
                film.setSinopse(sinopse);
            }            
            
            filmeNegocio.atualizar(film);
            System.out.println("Filme " + nome + " atualizado com sucesso!");
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        } 
    }
    
        private void consultarFilmePorNome() {
        String nome = Console.scanString("Nome: ");
        try {
            List<Filme> listaFilm = filmeNegocio.listarPorNome(nome);
            this.mostrarFilmes(listaFilm);
        } catch (NegocioException ex) {
            UIUtil.mostrarErro(ex.getMessage());
        }
        }
        
    private void mostrarFilme(Filme filme) {
        System.out.println("-----------------------------");
        System.out.println("Filme");
        System.out.println("Condigo: " + filme.getCodigo());
        System.out.println("Nome: " + filme.getNome());
        System.out.println("Genero: " + filme.getGenero());
        System.out.println("Sinopse: " + filme.getSinopse());        
        System.out.println("-----------------------------");
    }
    
    private void mostrarFilmes(List<Filme> listaFilmes) {
        if (listaFilmes.isEmpty()) {
            System.out.println("Filmes nao encontrados!");
        } else {
            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-10s", "Codigo") + "\t"
                    + String.format("%-20s", "|Nome") + "\t"
                    + String.format("%-20s", "|Genero") + "\t"
                    + String.format("%-20s", "|Sinopse"));
            for (Filme filme : listaFilmes) {
                System.out.println(String.format("%-10s", filme.getCodigo()) + "\t"
                        + String.format("%-20s", "|" + filme.getNome()) + "\t"
                        + String.format("%-20s", "|" + filme.getGenero()) + "\t"
                        + String.format("%-20s", "|" + filme.getSinopse()));
            }
        }
    }     
}
