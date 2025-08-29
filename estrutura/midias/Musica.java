package estrutura.midias;

import estrutura.Genero;
import estrutura.Midia;

public class Musica extends Midia {
    private String album;

    public Musica(String titulo, String artista, double duracao, Genero genero, String album) {
        super(titulo, artista, duracao, genero);
        this.album = album;
    }

    public String getAlbum() { return album; }
    public void setAlbum(String album) { this.album = album; }

    @Override
    public String toString() {
        return super.toString() + " | Álbum: " + album;
    }
}