
package dominio;

/**
 *
 * @author guilh
 */
public class Sala {
    
    private int id, nAssentos;
    private String nSala;

    public Sala(String nSala, int nAssentos) {
        this.nSala = nSala;
        this.nAssentos = nAssentos;
    }
        
    public Sala(int id, String nSala, int nAssentos) {
        this.id = id;
        this.nSala = nSala;
        this.nAssentos = nAssentos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setnSala(String nSala) {
        this.nSala = nSala;
    }
    
    public String getnSala() {
        return nSala;
    }

    public void setnAssentos(int nAssentos) {
        this.nAssentos = nAssentos;
    }
    
    public int getnAssentos() {
        return nAssentos;
    }
    
}
