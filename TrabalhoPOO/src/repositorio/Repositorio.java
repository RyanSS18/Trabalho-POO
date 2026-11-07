package repositorio;

import entidades.Item;
import java.util.List;

public interface Repositorio {
    public void salvar(Item item);
    public void remover(Item item);
    public List<Item> listarTodos();

}
