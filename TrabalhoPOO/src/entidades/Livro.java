package entidades;

public class Livro extends Item {

    private Autor autor;

    public Livro(Integer id, String titulo, Integer ano, Autor autor) {
        super(id, titulo, ano);
        this.autor = autor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public Double calcularMultaPorDia() {
        return 1.0;
    }
}
