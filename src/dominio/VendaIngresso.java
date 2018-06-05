
package dominio;

/**
 *
 * @author guilh
 */
public class VendaIngresso {
    
    int id;
    Sessao sessao;
    
    public VendaIngresso(Sessao sessao){
        this.sessao = sessao;
    }

    public VendaIngresso(int id, Sessao sessao) {
        this.id = id;
        this.sessao = sessao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }
    
    
}
