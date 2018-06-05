
package dominio;

import java.time.LocalTime;

/**
 *
 * @author guilh
 */
public class Sessao {
    
    private int id, qtdIngresso;
    private LocalTime horario;
    private Sala sala;
    private Filme filme;

    public Sessao(LocalTime horario, Sala sala, Filme filme) {
        this.qtdIngresso = sala.getnAssentos();
        this.horario = horario;
        this.sala = sala;
        this.filme = filme;
    }

    public Sessao(int id, int qtdIngresso, LocalTime horario, Sala sala, Filme filme) {
        this.id = id;
        this.qtdIngresso = qtdIngresso;
        this.horario = horario;
        this.sala = sala;
        this.filme = filme;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtdIngresso() {
        return qtdIngresso;
    }

    public void setQtdIngresso(int qtdIngresso) {
        this.qtdIngresso = qtdIngresso;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    public void retiraIngresso(){
                qtdIngresso--;    
            }
}
