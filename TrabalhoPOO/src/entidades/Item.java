package entidades;

/**
 * Classe ABSTRATA que representa qualquer item do acervo da biblioteca.
 * Guarda os atributos comuns (id, título e ano) e obriga as subclasses
 * (Livro e Dvd) a implementarem o cálculo da multa por dia de atraso.
 * Não pode ser instanciada diretamente: só suas subclasses podem.
 */


public abstract class Item {
    private Integer id;    
    private String titulo;
    private Integer ano;



  /**Cria um item com os dados comuns a todos os tipos.
     Chamado pelas subclasses através de super(...).  */
    public Item(Integer id, String titulo, Integer ano) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
    }
    
    //cada subclasse define o valor da sua multa por dia
    public abstract Double calcularMultaPorDia ();

    public Integer getId() {
        return id;
    }

    public void setId (Integer id) {
     this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}


