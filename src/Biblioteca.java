import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Biblioteca {
    private Livro livro;

    private final DateTimeFormatter formato =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private Scanner scanner;
    ArrayList<Livro> livros = new ArrayList<>();
    ArrayList<Usuario> usuarios = new ArrayList<>();

    public Biblioteca(Scanner scanner) {
        this.scanner = scanner;
    }

    public void devolverLivro(){
        Livro livro = null;
        System.out.print(" TITULO DO LIVRO: ");
        String tituloLivro = scanner.nextLine();

        for(Livro l : livros){
            if(l.getTitulo().equalsIgnoreCase(tituloLivro)){
                livro = l;
                break;
            }
        }
        if(livro == null){
            System.out.println(" Livro nao encontrado ");
            return;

        }
        if(livro.isDisponivel()){
            System.out.println("Esse livro esta disponivel");
        }else{
            livro.setDisponivel(true);
            System.out.println("Livro devolvido com sucesso de ");
            //REGISTRO
            LocalDateTime agora = LocalDateTime.now();
            System.out.println("Data da devolucao: " + agora.format(formato));
        }


    }

    public void buscarLivro(){
        System.out.print(" TITULO DO LIVRO ");
         String nomeLivro = scanner.nextLine();

        System.out.println(" Quantidade de livros " + livros.size());
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
    }
    public void emprestarLivro(){
        Usuario usuarioencontrado = null;
        Livro livroEncontrado = null;
        System.out.print(" CPF:");
        String nCpf = scanner.nextLine();
        System.out.print("Digite o titulo do livro que deseja pegar emprestado ");
        String nomeTitulo = scanner.nextLine();

        for(Usuario u: usuarios){
            if(u.getCpf().equalsIgnoreCase(nCpf)){
                usuarioencontrado = u;
            }
        }
        if(usuarioencontrado==null) {
            System.out.println("Usuario nao econtrado");
            return;
        }
        for(Livro l:livros){
            if(l.getTitulo().equalsIgnoreCase(nomeTitulo)){
                livroEncontrado=l;
            }
        }
        if (livroEncontrado==null){
            System.out.println("Livro nao encontrado");
            return;
        }
        if(livroEncontrado.isDisponivel()){
            livroEncontrado.setDisponivel(false);
            System.out.println(" Livro emprestado com sucesso para " + usuarioencontrado.getNome()) ;
            //REGISTRO
            LocalDateTime agora = LocalDateTime.now();

            System.out.println("Data do emprestimo: " + agora.format(formato));
        } else{
            System.out.println(" Livro ja foi emprestado ");
        }
    }
    public  void cadastrarLivro(){

        System.out.print(" AUTOR: ");
        String autor = scanner.nextLine();
        System.out.print(" TITULO: ");
        String titulo = scanner.nextLine();
        System.out.print(" PRECO ");
        double preco = scanner.nextInt();
        scanner.nextLine();
        Livro livro = new Livro(autor, titulo, preco,true);
        livro.setDataDeCadastro(LocalDateTime.now());
        adicionarLivro(livro);
        //REGISTRO
        LocalDateTime agora = LocalDateTime.now();

        System.out.println("Livro cadastrado em " + agora.format(formato));

    }
    public void cadastrarUsuario(){
        System.out.print(" NOME: ");
        String nome = scanner.nextLine();
        System.out.print(" CPF: ");
        String cpf = scanner.nextLine();
        Usuario usuario = new Usuario(nome, cpf);
        usuario.setDataDeCadastro(LocalDateTime.now());
        adicionarUsuario(usuario);
        //REGISTRO
        LocalDateTime agora = LocalDateTime.now();

        System.out.println("Usuario cadastrado em " + agora.format(formato));
    }
    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }
    public void listarLivro(){
        System.out.println(" Quantidade de livros cadastrados: " + livros.size());
        if(livros.isEmpty()){
            System.out.println("Nenhum livro cadastrado");
            return; }
        for(Livro livro: livros){
            if(livro.isDisponivel()){
            System.out.println("Autor: " + livro.getAutor() + " |  Titulo: " + livro.getTitulo() + " | Preco: " + livro.getPreco() + " | Status: Disponivel");
            System.out.println("Data de cadastro: " + livro.getDataDeCadastro().format(formato));
            }else{
                System.out.println("Autor: " + livro.getAutor() + " |  Titulo: " + livro.getTitulo() + " | Preco: " + livro.getPreco() + " | Status: Emprestado");


            }
    }

        }
    public void adicionarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    public void listarUsuarios(){

        System.out.println(" ===Usuarios cadastrados=== ");
        for(Usuario u: usuarios){
            System.out.println("Nome: " + u.getNome() + " - CPF: " + u.getCpf() + " | Data de cadastro: " + u.getDataDeCadastro().format(formato));
            if(u.getDataDeCadastro() == null){
            return;}
        }

    }
}
