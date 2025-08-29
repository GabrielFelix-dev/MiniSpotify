package estrutura.midias;

import estrutura.Genero;
import estrutura.Midia;

public class Podcast extends Midia {
    private String convidado;

    public Podcast(String titulo, String artista, double duracao, Genero genero, String convidado) {
        super(titulo, artista, duracao, genero);
        this.convidado = convidado;
    }

    public String getConvidado() { return convidado; }
    public void setConvidado(String convidado) { this.convidado = convidado; }

    @Override
    public String toString() {
        return super.toString() + " | Convidado: " + convidado;
    }
}