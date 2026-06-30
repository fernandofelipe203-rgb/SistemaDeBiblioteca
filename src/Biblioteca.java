import java.util.ArrayList;
import java.util.Scanner;
public class Biblioteca {


    Scanner scanner = new Scanner(System.in);
    ArrayList<Livro> livros = new ArrayList<>();
    ArrayList<Usuario> usuarios = new ArrayList<>();

    public void menu() {

        int opcao = -1;
        while (opcao != 7) {
            System.out.println("Biblioteca de livros ");
            System.out.println(" 1 - Cadastrar livro ");
            System.out.println(" 2 - Listar livros ");
            System.out.println(" 3 - Cadastrar Usuario ");
            System.out.println(" 4 - Listar Usuarios ");
            System.out.println(" 5 - Buscar livro ");
            System.out.println(" 6 - Emprestar livro ");
            System.out.println(" 7 - Sair ");

            System.out.print(" Digite sua opçao: ");
            opcao = scanner.nextInt();
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
                    Livro livro = new Livro(autor, titulo, preco,true);
                    adicionarLivro(livro);

                    break;


                case 2:
                    System.out.println(" Quantidade de livros cadastrados: " + livros.size());
                    if(livros.isEmpty()){
                        System.out.println("Nenhum livro cadastrado");
                    }else{
                        listarLivro();

                    }
                    break;

                case 3:
                    System.out.print(" Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print(" CPF: ");
                    String cpf = scanner.nextLine();
                    Usuario usuario = new Usuario(nome, cpf);
                    adicionarUsuario(usuario);


                    break;
                case 4:
                    System.out.println("Quantidade de usuarios cadastrado " + usuarios.size());
                    if(usuarios.isEmpty()){
                        System.out.println("Nenhum usuario cadastrado");
                    }else {
                       listarUsuarios();
                    }
                    break;
                case 5:
                        System.out.print("Digite o titulo do livro ");
                        String nomeLivro = scanner.nextLine();
                        System.out.println("Quantidade de livros " + livros.size());

                        boolean encontrou = false;
                        for(Livro l : livros){

                            if(l.getTitulo().equalsIgnoreCase(nomeLivro)){
                                encontrou = true;
                                System.out.println("Livro encontrado com sucesso");
                                System.out.println(l.toString());
                            }
                        }
                    if(!encontrou){
                        System.out.println("Nao encontrado");
                    }

                        break;

                case 6:
                    Usuario usuarioencontrado = null;
                    Livro livroEncontrado = null;
                    System.out.print(" Digite seu cpf:");
                    String nCpf = scanner.nextLine();
                    System.out.print("Digite o titulo do livro que deseja");
                    String nomeTitulo = scanner.nextLine();

                    for(Usuario u: usuarios){
                        if(u.getCpf().equalsIgnoreCase(nCpf)){
                            usuarioencontrado = u;
                        }
                    }
                    if(usuarioencontrado==null) {
                        System.out.println("Usuario nao econtrado");
                        break;
                    }
                    for(Livro l:livros){
                        if(l.getTitulo().equalsIgnoreCase(nomeTitulo)){
                            livroEncontrado=l;
                        }
                    }
                    if (livroEncontrado==null){
                        System.out.print("Livro nao encontrado");
                        break;
                    }
                    if(livroEncontrado.isDisponivel()){
                        livroEncontrado.setDisponivel(false);
                        System.out.print("Livro emprestado com sucesso para " + usuarioencontrado.getNome());
                    } else{
                        System.out.print("Livro ja foi emprestado");
                    }
                    break;

                case 7:
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



}
