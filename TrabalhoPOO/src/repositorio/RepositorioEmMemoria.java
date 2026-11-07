package repositorio;

import entidades.Item;
import java.util.List;
import java.util.ArrayList;


public class RepositorioEmMemoria implements Repositorio {
    private List<Item> itens;

    public RepositorioEmMemoria() {
        this.itens = new ArrayList<>();
    }

    @Override
    public void salvar(Item item) {
        itens.add(item);
    }

    @Override
    public void remover(Item item) {
        itens.remove(item);
    }

    @Override
    public List<Item> listarTodos() {
        return new ArrayList<>(itens);
    }
}
