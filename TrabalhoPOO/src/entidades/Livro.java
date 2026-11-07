package entidades;

public class Livro extends Item {

    private Autor autor;

   public Livro(Integer id, String titulo, Integer ano,
                 String nomeAutor, String nacionalidadeAutor) {
        super(id, titulo, ano);
        this.autor = new Autor(nomeAutor, nacionalidadeAutor);
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public Double calcularMultaPorDia() {
        return 1.0;
    }
}
