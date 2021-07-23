package ejercicio3;

public class Libro {

    private boolean prestado;
    private String titulo;
    private long isbn;
    private String autor;

    public void prestamo() {
        if(!this.prestado){
            this.prestado = true;
            System.out.println("Se presto: " + this.titulo);
        }
        else {
            System.out.println(this.titulo + " ya esta prestado");
        }
    }

    public void devolucion() {
        if(this.prestado){
            this.prestado = false;
            System.out.println("Se devolvio: " + this.titulo);
        }
        else {
            System.out.println(this.titulo + " no esta prestado");
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "prestado=" + prestado +
                ", titulo='" + titulo + '\'' +
                ", isbn=" + isbn +
                ", autor='" + autor + '\'' +
                '}';
    }
}
