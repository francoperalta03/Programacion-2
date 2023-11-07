//TRABAJO PRACTICO N°2: 
//INTEGRANTES: PERALTA FRANCO, SOSA TOMAS, SANABRIA RAMIRO
//CLASE: DVD
package DVD;

public class Dvd {
    private String titulo, genero, comentario, director;
    private int duracion;
    private boolean tenencia;
    
    // Constructor
    public Dvd(String titulo, String genero, int duracion, boolean tenencia, String comentario, String director) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.tenencia = tenencia;
        this.comentario = comentario;
        this.director = director;
    }
    
    // creamos getters y setters
    public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public boolean istenencia() {
		return tenencia;
	}
	public void settenencia(boolean tenencia) {
		this.tenencia = tenencia;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getDirector() {
		return director;
	}
    public void setDirector(String director) {
    	this.director = director;
    }

    // Metodo toString
	public String toString() {
		return "Dvd [Titulo = " + titulo + ", Genero = " + genero + ", Duracion = " + duracion + ", Tenencia = 1" + tenencia
				+ ", Comentario = " + comentario + ", Director = " + director + "]";
	}

}
