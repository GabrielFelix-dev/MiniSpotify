package estrutura;
import java.util.ArrayList;

public class Usuario {
  
  private String nome;
  private String email;
  private ArrayList<Playlist> playlists; // Lista de playlists
       
  public Usuario(String nome, String email) {
    this.nome = nome;
    this.email = email;
    this.playlists = new ArrayList<>();
    
  }

  // Criar Playlist
  public Playlist criarPlaylist(String nomePL) {
    Playlist novaPlaylist = new Playlist(nomePL, this);
    playlists.add(novaPlaylist);
    return novaPlaylist;
  }

  // Remover  Playlist
  public Playlist removerPlaylist(String nomePL) {
    Playlist deletePlaylist = new Playlist(nomePL, this);
    playlists.remove(deletePlaylist);                                                                                                                                 
    return deletePlaylist;
  }
  
  // Exibir Playlist
  public void exibirPlaylist() {
    if (playlists.isEmpty()) {
      System.out.println("Não há playlists cadastradas!");
    } else {
      System.out.println("\nPlaylist de: " + getNome());
      for (Playlist playlist : playlists) {
        System.out.println(" - " + playlist.getnomePlaylist());
      }
    }
  }

  public String toString(){
    return "nome: " + nome + " | Email: " + email ;
  }

  // Getters & Setters:
  public ArrayList<Playlist> getPlaylist() {
    return playlists;
  }
  

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

}
