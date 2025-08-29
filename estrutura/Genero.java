package estrutura;

public enum Genero {
    ROCK("MUSICA"), POP("MUSICA"), MPB("MUSICA"), CLASSICA("MUSICA"), FUNK("MUSICA"),
    ENTREVISTA("PODCAST"), NARRATIVO("PODCAST"), HUMOR("PODCAST"),
    FICCAO("AUDIOBOOK"), INFANTIL("AUDIOBOOK"), LITERATURA("AUDIOBOOK");

    private String tipo;
    
    Genero(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }


}