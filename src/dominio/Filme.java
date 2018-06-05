package dominio;

/**
 *
 * @author guilh
 */
public class Filme {
   
    private int id;
    private String codigo, nome, genero, sinopse;

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

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
     
    public String getNome() {
        return nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
     
    public String getGenero() {
        return genero;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    
    public String getSinopse() {
        return sinopse;
    }

}
