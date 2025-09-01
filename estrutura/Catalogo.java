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
    
    public void exibirMidia() {
        if (midias.isEmpty()) {
            System.out.println("Não há midias cadastradas.");
        } else {
            System.out.println("\nTodas as midias: ");
            for (Midia midia2 : midias) {
                System.out.println(" - " + midia2.getTitulo());
            }
        }
    }
    
    // Busca e retorna a mídia pelo título
    public Midia buscarMidiaPorTitulo(String titulo) {
        for (Midia m : midias) {
            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                return m; // Retorna a mídia encontrada
            }
        }
        return null; // Retorna null se não encontrar
    }
    
        
    public Set<Midia> getMidias() {
        return midias;
    }
}
