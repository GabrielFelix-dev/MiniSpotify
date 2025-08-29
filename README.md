# MiniSpotify 🎵

Este projeto é uma implementação simples em **Java POO** que simula algumas funcionalidades básicas de um serviço de streaming de música, inspirado no Spotify.  
Ele foi desenvolvido para treinar conceitos de **Programação Orientada a Objetos** como encapsulamento, herança e polimorfismo.

---

## Estrutura do Projeto

### `Usuario`
Representa o usuário da aplicação.  
- É responsável por **gerenciar suas playlists** e acessar o catálogo de mídias.  

### `Playlist`
Simula uma playlist criada pelo usuário.  
- É responsável por **armazenar e organizar mídias** (músicas, podcasts, etc.).  

### `Catalogo`
Representa o catálogo geral de mídias disponíveis.  
- É responsável por **centralizar todas as mídias cadastradas** no sistema, permitindo que os usuários encontrem e adicionem às suas playlists.  

### `Midia` (classe base)
Classe abstrata que representa uma mídia genérica.  
- É responsável por **definir atributos comuns** (como título, artista, duração).  
- Serve de base para outras classes específicas.  

### `Musica` (subclasse de `Midia`)
Representa uma música.  
- É responsável por especializar os atributos da classe `Midia` para o contexto musical (álbum, gênero, etc.).  

### `Podcast` (subclasse de `Midia`)
Representa um podcast.  
- É responsável por **armazenar episódios e informações adicionais** sobre programas de áudio.  

---

## Como Executar 🚀

1. Compile os arquivos Java:
   ```bash
   javac *.java
