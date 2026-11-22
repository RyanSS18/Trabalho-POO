// FORÇA GREMIOOOO, MAIS SORTE NA PROXIMA
package repositorio;

import entidades.Item;
import java.util.List;
import java.util.ArrayList;

/**
 * Implementação da interface Repositorio que guarda os itens em memória,
 * usando um ArrayList como estrutura de dados.
 * Os dados são perdidos quando o programa é encerrado.
 */


public class RepositorioEmMemoria implements Repositorio {
    private List<Item> itens;

    // Estrutura de dados que armazena os itens cadastrados
    private List<Item> itens;

     /** Cria o repositório com a lista de itens vazia. */
    public RepositorioEmMemoria() {
        this.itens = new ArrayList<>();
    }
       /**
     * Adiciona o item ao final da lista.
     */
    @Override
    public void salvar(Item item) {
        itens.add(item);
    }
   //Remove o item no final da lista
    @Override
    public void remover(Item item) {
        itens.remove(item);
    }
//Retorna todos os itens adicionaddos
    @Override
    public List<Item> listarTodos() {
        return new ArrayList<>(itens);
    }
}
