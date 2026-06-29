import java.util.ArrayList;
import java.util.Scanner;
public class Biblioteca {
    private Usuario usuario;
    private Livro livro;

    Scanner scanner = new Scanner(System.in);
    ArrayList<Livro> livros = new ArrayList<>();
    ArrayList<Usuario> usuarios = new ArrayList<>();

    public void menu() {
        Biblioteca biblioteca = new Biblioteca();
        int opcoes = -1;
        while (opcoes != 5) {
            System.out.println("Biblioteca de livros ");
            System.out.println(" 1 - Cadastrar livro ");
            System.out.println(" 2 - Listar livros ");
            System.out.println(" 3 - Cadastrar Usuario ");
            System.out.println(" 4 - Listar Usuarios ");
            System.out.println(" 5 - Sair ");
            System.out.print(" Digite sua opçao: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println(" Digite o autor do livro ");
                    String autor = scanner.nextLine();
                    System.out.print(" Digite o titulo do livro ");
                    String titulo = scanner.nextLine();
                    System.out.print(" Digite o preco do livro ");
                    double preco = scanner.nextInt();
                    scanner.nextLine();
                    Livro livro = new Livro(autor, titulo, preco);
                    biblioteca.adicionarLivro(livro);
                    break;


                case 2:
                    biblioteca.listarLivro();
                    break;

                case 3:
                    System.out.print(" Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print(" CPF: ");
                    int cpf = scanner.nextInt();
                    scanner.nextLine();
                    Usuario usuario = new Usuario(nome, cpf);
                    biblioteca.adicionarUsuario(usuario);
                    break;
                case 4:
                    biblioteca.listarUsuarios();
                    break;
                case 5:
                    System.out.println("===Finalizando===");
                    System.exit(0);
                default:
                    System.out.println(" Opcao invalida ");
            }


        }


    }
    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }
    public void listarLivro(){
        System.out.println(" Livros cadastrados: ");
        for(Livro livro: livros){
            System.out.println("Autor: " + livro.getAutor() + " -  Titulo: " + livro.getTitulo() + " Preco: " + livro.getPreco());
        }
    }
    public void adicionarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    public void listarUsuarios(){
        System.out.println(" ===Usuarios cadastrados=== ");
        for(Usuario u: usuarios){
            System.out.println("Nome: " + u.getNome() + " - CPF: " + u.getCpf());
        }
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
