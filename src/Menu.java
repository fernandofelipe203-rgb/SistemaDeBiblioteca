import java.util.Scanner;


public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Biblioteca biblioteca = new Biblioteca(scanner);

    public void menu() {

        int opcao = -1;
        while (opcao != 8) {
            System.out.println("Biblioteca de livros ");
            System.out.println(" 1 - Cadastrar livro ");
            System.out.println(" 2 - Listar livros ");
            System.out.println(" 3 - Cadastrar Usuario ");
            System.out.println(" 4 - Listar Usuarios ");
            System.out.println(" 5 - Buscar livro ");
            System.out.println(" 6 - Emprestar livro ");
            System.out.println(" 7 - Devolver livro ");
            System.out.println(" 8 - Sair ");
            System.out.print(" Digite sua opçao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {

                case 1:
                    biblioteca.cadastrarLivro();

                    break;
                case 2:
                    biblioteca.listarLivro();
                    break;
                case 3:
                    biblioteca.cadastrarUsuario();
                    break;
                case 4:
                    biblioteca.listarUsuarios();
                    break;
                case 5:
                    biblioteca.buscarLivro();
                    break;
                case 6:
                    biblioteca.emprestarLivro();
                    break;
                case 7:
                    biblioteca.devolverLivro();
                    break;

                case 8:
                    System.out.println("===Finalizando===");
                    System.exit(0);
                default:
                    System.out.println(" Opcao invalida ");
            }
        }
    }
}
