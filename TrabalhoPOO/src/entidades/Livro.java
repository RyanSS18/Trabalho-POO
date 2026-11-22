package entidades;

/**
 * Representa um livro do acervo.
 * HERDA de Item (id, título, ano) e TEM um Autor (COMPOSIÇÃO).
 */

public class Livro extends Item {

    private Autor autor;
    
   //Cria um livro e, junto com ele, o seu autor
   public Livro(Integer id, String titulo, Integer ano,
                 String nomeAutor, String nacionalidadeAutor) {
        super(id, titulo, ano);
        this.autor = new Autor(nomeAutor, nacionalidadeAutor);
    }

    public Autor getAutor() {
        return autor;
    }
    //Implementação do método abstrato de Item
    @Override
    public Double calcularMultaPorDia() {
        return 1.0;
    }
}
