package estrutura;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import estrutura.midias.Audiobook;
import estrutura.midias.Podcast;
import exceptions.EntradaVaziaException;
import exceptions.InvalidOptionException;
import exceptions.PlaylistInvalidaException;
import exceptions.UsuarioInexistentException;
import estrutura.Playlist;


public class Sistema {
    
    Scanner scanner = new Scanner(System.in);

    private ArrayList<Usuario> usuarios; // Lista de usuário
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    Usuario user = null;
    
    Catalogo catalogo = new Catalogo();


    public Sistema() {
        this.usuarios = new ArrayList<Usuario>();
    }
    public boolean usuarioExiste(String nome) {
        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }
    // Cadastra novo usuario á sua lista.
    public void cadastrarUsuario(String nome, String email) {
        this.user = new Usuario(nome, email);
        usuarios.add(user);
        return;
    }

    // Criar usuário:
    public void criarUsuario(Scanner scanner) throws EntradaVaziaException {

        System.out.print("Digite o seu nome de usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        if (nome.isEmpty() || email.isEmpty() ) {
            throw new EntradaVaziaException("O espaço não pode estar vazio.");
        }
        cadastrarUsuario(nome, email); 
        System.out.println("Usuário criado com sucesso!");
        
    }

    // Criar uma nova playlist:
    public void criarPlaylist(Scanner scanner) throws UsuarioInexistentException, PlaylistInvalidaException {
        
        if (user == null) {
            throw new UsuarioInexistentException("Crie um usuário antes de adicionar playlists.");
        } else {
           
            System.out.print("Insira seu nome de usuário: ");
            String nome = scanner.nextLine();

            if (usuarioExiste(nome)) {
                System.out.print("Digite o nome da playlist: ");
                String nomePlaylist = scanner.nextLine();
               
                if (nomePlaylist == null || nomePlaylist.trim().isEmpty()) {
                    throw new PlaylistInvalidaException("Nome da playlist inválido.");
                }
                
                
                Playlist novaPlaylist = new Playlist(nomePlaylist, user);
                user.criarPlaylist(nomePlaylist);
                System.out.println("Playlist criada com sucesso!");
               

            } else {
                System.out.println("Usuário não encontrado!");
                System.out.println(usuarios);
            }
        }
    }
    
    // Listar playlists
    public void listarPlaylists(Scanner scanner) throws UsuarioInexistentException {
        if (user == null) {
            throw new UsuarioInexistentException("Crie um usuário antes de listar playlists.");
        } else {
            System.out.print("Insira seu nome de usuário: ");
            String nome = scanner.nextLine();
            
            Usuario usuarioEncontrado = null;
            for (Usuario u : usuarios) {
                if (u.getNome().equalsIgnoreCase(nome)) {
                    usuarioEncontrado = u;
                    break;
                }
            }
            
            if (usuarioEncontrado == null) {
                throw new UsuarioInexistentException("Não existe usuário com esse nome:" + nome);
            } else {
                usuarioEncontrado.exibirPlaylist();
            }
            
        }
    }


    // Adicionar midia:
    public void adicionarMidiaCatalogo(Scanner scanner) throws InvalidOptionException {
        
        if (user == null) {
            System.out.println("Você precisa criar um usuário antes de adicionar uma midia.");
        } else {

            System.out.println("""
                -------- Escolha o tipo de midia --------
                |   1 ) Audiobook;                                      
                |   2 ) Podcast;                                           
                |   3 ) Musica;
                    """);
            System.out.print("Insira uma das 3 opções: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                
                //Audiobook:
                case 1:
                
                    System.out.print("Digite o titulo do Audiobook: ");
                    String titulo = scanner.nextLine();
                    
                    System.out.print("Autor da obra: ");
                    String artista = scanner.nextLine();    
                    
                    System.out.print("Duração: ");
                    double duracao = scanner.nextDouble();
                   
                    // Exibe apenas os generos de Audiobook
                    System.out.print("Escolha um genero para o Audiobook: ");
                    Genero[] generosAudiobook = Genero.values();
                    for (int i = 0; i < generosAudiobook.length; i++) {
                        if (generosAudiobook[i].getTipo().equals("AUDIOBOOK")) {
                            System.out.println(i + " - " + generosAudiobook[i]);
                        }
                    }
                    System.out.print("Digite sua escolha: ");
                    int escolha = scanner.nextInt();
                    scanner.nextLine();
            
                    Genero generoEscolhido = generosAudiobook[escolha];

                    System.out.print("Narrador: ");
                    String narrador = scanner.nextLine();
                    
                    Audiobook audiobook = new Audiobook(titulo, artista, duracao, generoEscolhido, narrador);
                    catalogo.adicionarMidia(audiobook);

                    System.out.println("Audiobook adicionado com sucesso!");
                    break;
                
                // Podcast:
                case 2:
                   
                    System.out.print("Digite o nome do Podcast: ");
                    titulo = scanner.nextLine();
                    
                    System.out.print("O(s) apresentador(s): ");
                    artista = scanner.nextLine();    
                    
                    System.out.print("Duração: ");
                    duracao = scanner.nextDouble();

                    // Exibe apenas os generos de Podcast
                    System.out.print("Escolha um genero para o seu podcast: ");
                    Genero[] generosPodcast = Genero.values();
                    for (int i = 0; i < generosPodcast.length; i++) {
                        if (generosPodcast[i].getTipo().equals("PODCAST")) {
                            System.out.println(i + " - " + generosPodcast[i]);
                        }
                    }

                    System.out.print("Digite sua escolha: ");
                    escolha = scanner.nextInt();
                    scanner.nextLine();

                    Genero generoSelecionado = generosPodcast[escolha];

                    try {
                        System.out.print("Possui convidado(s)? 1) Sim | 2) Não: ");
                        int option = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (option == 1) {
                            System.out.print("Insira o(s) nome(s): ");
                            String convidado = scanner.nextLine();
                            Podcast podcast1 = new Podcast(titulo, artista, duracao, generoSelecionado, convidado);
                            catalogo.adicionarMidia(podcast1);
                        } else if (option == 2) {
                            Podcast podcast2 = new Podcast(titulo, artista, duracao, generoSelecionado, "Sem convidados.");
                            catalogo.adicionarMidia(podcast2);
                        } else {
                            System.out.println("Opção inválida!");
                        }                       
                    } catch (Exception e) {
                        System.out.println("Insira apenas número!");
                    }
                    

                    break;
                default:
                    break;
            }
        }
    }
}
