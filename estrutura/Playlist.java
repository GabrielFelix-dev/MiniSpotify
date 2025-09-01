package estrutura;
import java.util.ArrayList;

public class Playlist {
  
  private String nomePlaylist;
  private Usuario proprietario;
  private ArrayList<Midia> midias;

  
  public Playlist(String nomePlaylist, Usuario proprietario) {
    this.nomePlaylist = nomePlaylist;
    this.proprietario = proprietario;
    this.midias = new ArrayList<>();
  }

  public void addMidia(Midia nomeMidia) {
    midias.add(nomeMidia);
  }
  
  public void removeMidia(Midia nomeMidia) {
    midias.remove(nomeMidia);
  }


  public double calculatorTime() {
    double sum = 0.0;
    for (Midia Midia2 : midias) {
      sum += Midia2.getDuracao();
      System.out.println(sum);
    }
    return sum;
  }




  // getters & setters
  public ArrayList<Midia> getMidias() {
    return midias;
  }

  public void setMidias(ArrayList<Midia> midias) {
    this.midias = midias;
  }
  
  public Usuario getproprietario() {
    return proprietario;
  }
  
  public void setproprietario(Usuario proprietario) {
    this.proprietario = proprietario;
  }

  public String getnomePlaylist() {
    return nomePlaylist;
  }

  public void setnomePlaylist(String nomePlaylist) {
    this.nomePlaylist = nomePlaylist;
  }
  
}