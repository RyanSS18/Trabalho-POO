package aplicaçao;

import entidades.Dvd;
import entidades.Item;
import entidades.Livro;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import repositorio.Repositorio;
import repositorio.RepositorioEmMemoria;

/**
 * Classe principal do sistema de gerenciamento de acervo (Livros e DVDs).
 * Aplica Inversão de Controle e Injeção de Dependência ao receber a interface Repositorio,
 * carrega os registros iniciais, exibe o menu textual e formata as saídas em tabela.
 */
public class Programa {

    // Atributo tipado com a interface Repositorio (Inversão de Controle / Injeção de Dependência)
    private Repositorio repositorio;
    private Scanner scanner;

    // Construtor que injeta a dependência do repositório na classe principal
    public Programa(Repositorio repositorio) {
        this.repositorio = repositorio;
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        // Cria o repositório em memória e injeta na classe Programa
        Repositorio repo = new RepositorioEmMemoria();
        Programa sistema = new Programa(repo);

        // Cadastra automaticamente 7 Livros e 7 DVDs antes de iniciar o menu (Requisito 8)
        sistema.carregarDadosIniciais();

        // Inicia o menu interativo no console (Requisito 7)
        sistema.iniciarMenu();
    }

    // Cadastra 7 objetos de cada classe concreta para testes imediatos (Requisito 8)
    public void carregarDadosIniciais() {
        repositorio.salvar(new Livro(1, "Dom Casmurro", 1899, "Machado de Assis", "Brasileira"));
        repositorio.salvar(new Livro(2, "A Hora da Estrela", 1977, "Clarice Lispector", "Brasileira"));
        repositorio.salvar(new Livro(3, "1984", 1949, "George Orwell", "Britânica"));
        repositorio.salvar(new Livro(4, "O Senhor dos Anéis", 1954, "J.R.R. Tolkien", "Britânica"));
        repositorio.salvar(new Livro(5, "Capitães da Areia", 1937, "Jorge Amado", "Brasileira"));
        repositorio.salvar(new Livro(6, "Clean Code", 2008, "Robert C. Martin", "Americana"));
        repositorio.salvar(new Livro(7, "O Pequeno Príncipe", 1943, "Antoine de Saint-Exupéry", "Francesa"));

        repositorio.salvar(new Dvd(8, "Interestelar", 2014, 169));
        repositorio.salvar(new Dvd(9, "Matrix", 1999, 136));
        repositorio.salvar(new Dvd(10, "O Poderoso Chefão", 1972, 175));
        repositorio.salvar(new Dvd(11, "Cidade de Deus", 2002, 130));
        repositorio.salvar(new Dvd(12, "A Origem", 2010, 148));
        repositorio.salvar(new Dvd(13, "O Auto da Compadecida", 2000, 104));
        repositorio.salvar(new Dvd(14, "Clube da Luta", 1999, 139));
    }

    // Loop principal do menu textual (Requisito 7)
    public void iniciarMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== MENU DO ACERVO ===");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Listar (Tabela)");
            System.out.println("5 - Buscar por Título");
            System.out.println("6 - Listar Ordenado por Título");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    incluir();
                    break;
                case 2:
                    alterar();
                    break;
                case 3:
                    excluir();
                    break;
                case 4:
                    exibirTabela(repositorio.listarTodos());
                    break;
                case 5:
                    buscarPorTitulo();
                    break;
                case 6:
                    listarOrdenado();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // Cadastra um novo Livro ou DVD (Requisito 3)
    private void incluir() {
        System.out.print("Tipo (1-Livro / 2-DVD): ");
        int tipo = Integer.parseInt(scanner.nextLine());

        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Ano: ");
        int ano = Integer.parseInt(scanner.nextLine());

        if (tipo == 1) {
            System.out.print("Autor: ");
            String autor = scanner.nextLine();
            System.out.print("Nacionalidade: ");
            String nac = scanner.nextLine();
            repositorio.salvar(new Livro(id, titulo, ano, autor, nac));
        } else {
            System.out.print("Duração (min): ");
            int duracao = Integer.parseInt(scanner.nextLine());
            repositorio.salvar(new Dvd(id, titulo, ano, duracao));
        }
        System.out.println("Cadastrado com sucesso!");
    }

    // Busca pelo ID e altera os dados do registro (Requisito 3)
    private void alterar() {
        System.out.print("ID para alterar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Item item = buscarPorId(id);

        if (item == null) {
            System.out.println("Item não encontrado.");
            return;
        }

        System.out.print("Novo Título: ");
        item.setTitulo(scanner.nextLine());
        System.out.print("Novo Ano: ");
        item.setAno(Integer.parseInt(scanner.nextLine()));

        if (item instanceof Livro) {
            Livro livro = (Livro) item;
            System.out.print("Novo Autor: ");
            livro.getAutor().setNome(scanner.nextLine());
            System.out.print("Nova Nacionalidade: ");
            livro.getAutor().setNacionalidade(scanner.nextLine());
        } else if (item instanceof Dvd) {
            Dvd dvd = (Dvd) item;
            System.out.print("Nova Duração (min): ");
            dvd.setDuracaoMinutos(Integer.parseInt(scanner.nextLine()));
        }
        System.out.println("Alterado com sucesso!");
    }

    // Busca pelo ID e remove o registro da lista (Requisito 3)
    private void excluir() {
        System.out.print("ID para excluir: ");
        int id = Integer.parseInt(scanner.nextLine());
        Item item = buscarPorId(id);

        if (item == null) {
            System.out.println("Item não encontrado.");
            return;
        }

        repositorio.remover(item);
        System.out.println("Excluído com sucesso!");
    }

    // Filtra os registros pelo atributo Título e exibe na tabela (Requisito 5)
    private void buscarPorTitulo() {
        System.out.print("Digite o Título para buscar: ");
        String busca = scanner.nextLine().toLowerCase();

        List<Item> encontrados = new ArrayList<>();
        for (Item item : repositorio.listarTodos()) {
            if (item.getTitulo().toLowerCase().contains(busca)) {
                encontrados.add(item);
            }
        }
        exibirTabela(encontrados);
    }

    // Ordena uma cópia da lista por Título (A-Z) e exibe na tabela (Requisito 6)
    private void listarOrdenado() {
        List<Item> ordenados = new ArrayList<>(repositorio.listarTodos());
        ordenados.sort(Comparator.comparing(Item::getTitulo, String.CASE_INSENSITIVE_ORDER));
        exibirTabela(ordenados);
    }

    // Localiza um item pelo ID na lista do repositório
    private Item buscarPorId(int id) {
        for (Item item : repositorio.listarTodos()) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    // Exibe qualquer lista de itens em formato tabular no console (Requisito 4)
    private void exibirTabela(List<Item> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum registro encontrado.");
            return;
        }

        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("ID\tTIPO\tANO\tMULTA\tTÍTULO\t\t\tDETALHES");
        System.out.println("-------------------------------------------------------------------------");

        for (Item item : lista) {
            String tipo = (item instanceof Livro) ? "Livro" : "DVD";
            String detalhes = (item instanceof Livro)
                    ? "Autor: " + ((Livro) item).getAutor().getNome()
                    : "Duração: " + ((Dvd) item).getDuracaoMinutos() + " min";

            System.out.println(
                    item.getId() + "\t" +
                            tipo + "\t" +
                            item.getAno() + "\t" +
                            "R$" + item.calcularMultaPorDia() + "\t" +
                            item.getTitulo() + "\t\t" +
                            detalhes
            );
        }
        System.out.println("-------------------------------------------------------------------------");
    }
}