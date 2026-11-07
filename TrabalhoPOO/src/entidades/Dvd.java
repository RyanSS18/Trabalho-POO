package entidades;

public class Dvd extends Item {

    private Integer duracaoMinutos;

    public Dvd(Integer id, String titulo, Integer ano, Integer duracaoMinutos) {
        super(id, titulo, ano);
        this.duracaoMinutos = duracaoMinutos;
    }

    public Integer getDuracaoMinutos() {
        return duracaoMinutos;
    }

    @Override
    public Double calcularMultaPorDia() {
        return 2.0;
    }

    public void setDuracaoMinutos(Integer duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }
}