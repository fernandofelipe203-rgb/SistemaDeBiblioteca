import java.time.LocalDateTime;

public class Livro {
    private String autor;
    private String titulo;
    private double preco;
    private boolean disponivel;
    private LocalDateTime dataDeCadastro;
    private LocalDateTime dataDeEmprestimo;
    private LocalDateTime dataDeDevolucao;


    @Override
    public String toString() {
        return "Livro{" +
                "autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", preco=" + preco +
                '}';
    }


    public Livro(String autor, String titulo ,double preco, boolean disponivel) {
        this.autor = autor;
        this.titulo = titulo;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public LocalDateTime getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDateTime dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public LocalDateTime getDataDeEmprestimo() {
        return dataDeEmprestimo;
    }

    public LocalDateTime getDataDeDevolucao() {
        return dataDeDevolucao;
    }
}
