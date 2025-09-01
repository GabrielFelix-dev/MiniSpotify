package estrutura;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.EntradaVaziaException;
import exceptions.PlaylistInvalidaException;


public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        Sistema sistema = new Sistema();
        int opcao = 0;

        do {
            try {
                System.out.println("\n===== MENU =====");
                System.out.println("1 - Criar Usuário");
                System.out.println("2 - Criar Playlist");
                System.out.println("3 - Remover Playlist");// Remover PL especifica.
                System.out.println("4 - Listar Playlists ou uma especifica"); // Listar todas as PL.
                System.out.println("5 - Adicionar midia ao catalogo"); // Add midia ao catalogo global.
                System.out.println("6 - Adicionar midia a uma playlist"); // Add midia a uma PL especifica.
                System.out.println("7 - Remover midia"); // Remover midia de uma PL ou do catalogo(Interfere TODAS as playlist).
                System.out.println("8 - Listar midias"); 
                System.out.println("9 - Listar midias de uma playlist");
                System.out.println("10 - Buscar midia"); // Busca midia por titulo
                System.out.println("11 - Sair");
                System.out.print("Escolha uma opção: ");

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    // ok
                    case 1 -> {
                        sistema.criarUsuario(scanner);
                    }
                    // ok
                    case 2 -> {
                        sistema.criarPlaylist(scanner);
                    }
                    // ok
                    case 3 -> {
                        sistema.removerPlaylist(scanner);
                    }
                    // ok
                    case 4 -> {
                        sistema.listarPlaylists(scanner);
                    }
                    // ok +/-
                    case 5 -> {
                        sistema.adicionarMidiaCatalogo(scanner);
                    }
                    case 6 -> {
                        sistema.addMidiaPlaylist(scanner);
                    }
                    case 7 -> { // Remover mídia
                        sistema.removerMidia(scanner);
                    }
                    case 8 -> { // Listar todas as mídias do catálogo
                        sistema.listarMidias();
                    }
                    case 9 -> { // Listar mídias de uma playlist
                        sistema.listarMidiasPlaylist(scanner);
                    }
                    case 10 -> { // Buscar mídia
                        sistema.buscarMidia(scanner);
                    }
                    default -> System.out.println("Opção inválida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine();
            } catch (EntradaVaziaException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        } while (opcao != 11);

        scanner.close();
    }
}