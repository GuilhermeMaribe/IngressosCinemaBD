package dominio;

/**
 *
 * @author guilh
 */
public class Filme {
   
           private int id;    
           private String codigo; 
           private String nome;
           private String genero;
           private String sinopse;

           public void setCodigo(String codigo) {
               this.codigo = codigo;
           }

           public void setNome(String nome) {
               this.nome = nome;
           }

           public void setGenero(String genero) {
               this.genero = genero;
           }

           public void setSinopse(String sinopse) {
               this.sinopse = sinopse;
           }

               public Filme(String codigo, String nome, String genero, String sinopse) {
               this.codigo = codigo;
               this.nome = nome;
               this.genero = genero;
               this.sinopse = sinopse;
           }

               public Filme(int id, String codigo, String nome, String genero, String sinopse) {
               this.id = id;    
               this.codigo = codigo;
               this.nome = nome;
               this.genero = genero;
               this.sinopse = sinopse;
           }

           public void setId(int id) {
               this.id = id;
           }

           public int getId() {
               return id;
           }


           public String getCodigo() {
               return codigo;
           }

           public String getNome() {
               return nome;
           }

           public String getGenero() {
               return genero;
           }

           public String getSinopse() {
               return sinopse;
           }

           @Override
           public String toString() {
               return codigo+" - "+nome+" - "+genero+" - "+sinopse;
           }    
      
}
