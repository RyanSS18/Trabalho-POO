package entidades;

/**
 * Representa o autor de um livro.
 * Esta classe é usada em COMPOSIÇÃO pela classe Livro: o Autor é criado
 * dentro do Livro e não existe de forma independente dele.
 */
public class Autor {

    private String nome;
    private String nacionalidade;

    public Autor(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }


}

