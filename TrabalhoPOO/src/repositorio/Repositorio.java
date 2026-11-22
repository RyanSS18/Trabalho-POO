package repositorio;

/**
 * INTERFACE que define o contrato de armazenamento dos itens do acervo.
 * A classe Programa depende apenas desta interface (e não de uma implementação),
 * o que permite a INVERSÃO DE CONTROLE e a INJEÇÃO DE DEPENDÊNCIA:
 * é possível trocar a forma de armazenar sem alterar o Programa.
 */

import entidades.Item;
import java.util.List;

public interface Repositorio {
    //Guarda um item no repositório.
    public void salvar(Item item);
    //Remove um item do repositorio
    public void remover(Item item);
    //Lista todps os itens do repositório
    public List<Item> listarTodos();

}
