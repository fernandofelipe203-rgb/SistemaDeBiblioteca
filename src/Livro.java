public class Livro {
    private String autor;
    private String titulo;
    private double preco;


    @Override
    public String toString() {
        return "Livro{" +
                "autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", preco=" + preco +
                '}';
    }

    public void exibirLivro(){


    }
    public Livro(String autor, String titulo ,double preco) {
        this.autor = autor;
        this.titulo = titulo;
        this.preco = preco;
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

}
