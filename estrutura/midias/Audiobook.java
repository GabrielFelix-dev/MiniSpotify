package estrutura.midias;

import estrutura.Genero;
import estrutura.Midia;

public class Audiobook extends Midia {
    
    private String narrador;

    public Audiobook(String titulo, String artista, double duracao, Genero genero, String narrador) {
        super(titulo, artista, duracao, genero);
    
        this.narrador = narrador;
    }

    public String getNarrador() {
         return narrador;
         }
    public void setNarrador(String narrador) { 
        this.narrador = narrador; 
    }

    @Override
    public String toString() {
        return super.toString() + " | Narrador: " + narrador;
    }
}
