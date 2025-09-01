package estrutura;

import java.util.ArrayList;
import java.util.Scanner;
import exceptions.*;
import estrutura.midias.Musica;
import estrutura.midias.Podcast;
import estrutura.midias.Audiobook;

public class Sistema {

    private Scanner scanner = new Scanner(System.in);

    private ArrayList<Usuario> usuarios; // Lista de todos os usuários do sistema
    private Catalogo catalogo;           // Catálogo global de mídias

    public Sistema() {
        this.usuarios = new ArrayList<>();
        this.catalogo = new Catalogo();
    }

    // ======================
    // Usuários
    // ======================

    // Verifica se um usuário existe pelo nome
    public boolean usuarioExiste(String nome) {
        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    // Busca e retorna um usuário pelo nome
    public Usuario buscarUsuario(String nome) {
        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(nome)) {
                return u;
            }
        }
        return null;
    }

    // Cadastra um novo usuário
    public void cadastrarUsuario(String nome, String email) throws EntradaVaziaException {
        if (nome.isEmpty() || email.isEmpty()) {
            throw new EntradaVaziaException("O espaço não pode estar vazio.");
        }
        Usuario user = new Usuario(nome, email);
        usuarios.add(user);
        System.out.println("Usuário criado com sucesso!");
    }

    // Cria usuário via menu
    public void criarUsuario(Scanner scanner) throws EntradaVaziaException {
        System.out.print("Digite o seu nome de usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        cadastrarUsuario(nome, email);
    }

    // ======================
    // Playlists
    // ======================

    // Criar playlist para um usuário específico
    public void criarPlaylist(Scanner scanner) throws UsuarioInexistentException, PlaylistInvalidaException {
        System.out.print("Digite seu nome de usuário: ");
        String nome = scanner.nextLine();
        Usuario user = buscarUsuario(nome);

        if (user == null) {
            throw new UsuarioInexistentException("Não existe usuário com esse nome: " + nome);
        }

        System.out.print("Digite o nome da playlist: ");
        String nomePlaylist = scanner.nextLine();

        if (nomePlaylist == null || nomePlaylist.trim().isEmpty()) {
            throw new PlaylistInvalidaException("Nome da playlist inválido.");
        }

        user.criarPlaylist(nomePlaylist);
        System.out.println("Playlist criada com sucesso!");
    }

    // Remover playlist de um usuário
    public void removerPlaylist(Scanner scanner) throws UsuarioInexistentException, PlaylistInvalidaException {
        System.out.print("Digite seu nome de usuário: ");
        String nome = scanner.nextLine();
        Usuario user = buscarUsuario(nome);

        if (user == null) {
            throw new UsuarioInexistentException("Não existe usuário com esse nome: " + nome);
        }

        System.out.print("Digite o nome da playlist que deseja remover: ");
        String nomePL = scanner.nextLine();

        Playlist playlistRemovida = null;
        for (Playlist p : user.getPlaylist()) {
            if (p.getnomePlaylist().equalsIgnoreCase(nomePL)) {
                playlistRemovida = p;
                break;
            }
        }

        if (playlistRemovida != null) {
            user.getPlaylist().remove(playlistRemovida);
            System.out.println("Playlist '" + nomePL + "' removida com sucesso!");
        } else {
            throw new PlaylistInvalidaException("Playlist não encontrada.");
        }
    }

    // Listar playlists de um usuário específico
    public void listarPlaylists(Scanner scanner) throws UsuarioInexistentException {
        System.out.print("Digite seu nome de usuário: ");
        String nome = scanner.nextLine();
        Usuario user = buscarUsuario(nome);

        if (user == null) {
            throw new UsuarioInexistentException("Não existe usuário com esse nome: " + nome);
        }

        user.exibirPlaylist();
    }
 

    // Adicionar mídia ao catálogo global
    public void adicionarMidiaCatalogo(Scanner scanner) throws UsuarioInexistentException {
        System.out.println("""
                -------- Escolha o tipo de midia --------
                1) Audiobook
                2) Podcast
                3) Musica
                """);
        System.out.print("Escolha: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1 -> { // Audiobook
                System.out.print("Digite o título do Audiobook: ");
                String titulo = scanner.nextLine();
                System.out.print("Autor da obra: ");
                String artista = scanner.nextLine();
                System.out.print("Duração: ");
                double duracao = scanner.nextDouble();
                scanner.nextLine();

                // Escolher gênero
                System.out.println("Escolha um gênero para o Audiobook:");
                Genero[] generos = Genero.values();
                for (int i = 0; i < generos.length; i++) {
                    if (generos[i].getTipo().equals("AUDIOBOOK")) {
                        System.out.println(i + ") " + generos[i]);
                    }
                }
                int escolha = scanner.nextInt();
                scanner.nextLine();
                Genero generoEscolhido = generos[escolha];

                System.out.print("Narrador: ");
                String narrador = scanner.nextLine();

                Audiobook audiobook = new Audiobook(titulo, artista, duracao, generoEscolhido, narrador);
                catalogo.adicionarMidia(audiobook);
            }
            case 2 -> { // Podcast
                System.out.print("Digite o título do Podcast: ");
                String titulo = scanner.nextLine();
                System.out.print("Apresentador(es): ");
                String artista = scanner.nextLine();
                System.out.print("Duração: ");
                double duracao = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Escolha um gênero:");
                Genero[] generos = Genero.values();
                for (int i = 0; i < generos.length; i++) {
                    if (generos[i].getTipo().equals("PODCAST")) {
                        System.out.println(i + ") " + generos[i]);
                    }
                }
                int escolha = scanner.nextInt();
                scanner.nextLine();
                Genero generoEscolhido = generos[escolha];

                System.out.print("Possui convidado(s)? 1) Sim 2) Não: ");
                int opt = scanner.nextInt();
                scanner.nextLine();
                String convidados = (opt == 1) ? scanner.nextLine() : "Sem convidados";

                Podcast podcast = new Podcast(titulo, artista, duracao, generoEscolhido, convidados);
                catalogo.adicionarMidia(podcast);
            }
            case 3 -> { // Música
                System.out.print("Digite o nome da música: ");
                String titulo = scanner.nextLine();
                System.out.print("Artista(s): ");
                String artista = scanner.nextLine();
                System.out.print("Duração: ");
                double duracao = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Escolha um gênero:");
                Genero[] generos = Genero.values();
                for (int i = 0; i < generos.length; i++) {
                    if (generos[i].getTipo().equals("MUSICA")) {
                        System.out.println(i + ") " + generos[i]);
                    }
                }
                int escolha = scanner.nextInt();
                scanner.nextLine();
                Genero generoEscolhido = generos[escolha];

                System.out.print("Pertence a algum álbum? 1) Sim 2) Não: ");
                int opt = scanner.nextInt();
                scanner.nextLine();
                String album = (opt == 1) ? scanner.nextLine() : "Não possui álbum";

                Musica musica = new Musica(titulo, artista, duracao, generoEscolhido, album);
                catalogo.adicionarMidia(musica);
            }
            default -> System.out.println("Opção inválida!");
        }
    }


    // Adicionar mídia a uma playlist
    public void addMidiaPlaylist(Scanner scanner) throws UsuarioInexistentException, PlaylistInvalidaException {
        System.out.print("Digite seu nome de usuário: ");
        String nome = scanner.nextLine();
        Usuario user = buscarUsuario(nome);

        if (user == null) {
            throw new UsuarioInexistentException("Usuário não encontrado!");
        }

        System.out.print("Digite o nome da playlist: ");
        String nomePL = scanner.nextLine();

        Playlist playlistSelecionada = null;
        for (Playlist pl : user.getPlaylist()) {
            if (pl.getnomePlaylist().equalsIgnoreCase(nomePL)) {
                playlistSelecionada = pl;
                break;
            }
        }

        if (playlistSelecionada == null) {
            throw new PlaylistInvalidaException("Playlist não encontrada.");
        }

        // Mostrar todas as mídias do catálogo
        System.out.println("\nMídias disponíveis no catálogo:");
        catalogo.exibirMidia();

        System.out.print("Digite o título da mídia que deseja adicionar: ");
        String tituloMidia = scanner.nextLine();

        // Buscar a mídia no catálogo
        Midia midiaSelecionada = catalogo.buscarMidiaPorTitulo(tituloMidia);
        if (midiaSelecionada != null) {
            playlistSelecionada.addMidia(midiaSelecionada);
            System.out.println("Mídia adicionada com sucesso à playlist '" + nomePL + "'!");
        } else {
            System.out.println("Mídia não encontrada no catálogo.");
        }
    }

}
