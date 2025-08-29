package estrutura;

import java.util.HashSet;
import java.util.Set;

public class Catalogo {
    private Set<Midia> midias;


    public Catalogo() {
        this.midias = new HashSet<>();
    }


    public void adicionarMidia(Midia m) {
        if (midias.add(m)) {
            System.out.println("Adicionado: " + m.getTitulo());
        } else {
            System.out.println("Essa mídia já existe no catálogo.");
        }
    }


    public void buscarPorTitulo(String titulo) {
        boolean achei = false;
        for (Midia m : midias) {
            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Achei: " + m);
                achei = true;
            }
        }
        if (!achei) {
            System.out.println("Nenhuma mídia com esse título.");
        }
    }


    public void buscarPorArtista(String artista) {
        boolean achei = false;
        for (Midia m : midias) {
            if (m.getArtista().equalsIgnoreCase(artista)) {
                System.out.println("Achei: " + m);
                achei = true;
            }
        }
        if (!achei) {
            System.out.println("Nenhuma mídia desse artista.");
        }
    }


    public void buscarPorGenero(Genero genero) {
        boolean achei = false;
        for (Midia m : midias) {
            if (m.getGenero() == genero) {
                System.out.println("Achei: " + m);
                achei = true;
            }
        }
        if (!achei) {
            System.out.println("Nenhuma mídia desse gênero.");
        }
    }

}
