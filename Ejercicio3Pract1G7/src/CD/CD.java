//TRABAJO PRACTICO N°2: 
//INTEGRANTES: PERALTA FRANCO, SOSA TOMAS, SANABRIA RAMIRO
//CLASE CD
package CD;

public class CD {
	private String titulo, genero, comentario, interprete;
    private int duracion, cantidad;
    private boolean tenencia;
    
    // Constructor
    public CD(String titulo, String genero, int duracion, boolean tenencia, String comentario, String interprete, int cantidad) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.tenencia = tenencia;
        this.comentario = comentario;
        this.interprete = interprete;
        this.cantidad = cantidad;
    }
    
    //  getters y setters
    public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

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
	public String getinterprete() {
		return interprete;
	}
    public void setinterprete(String interprete) {
    	this.interprete = interprete;
    }

    // Metodo toString
	public String toString() {
		return "CD [Titulo = " + titulo + ", Genero = " + genero + ", Duracion = " + duracion + ", Tenencia = 1" + tenencia
				+ ", Comentario = " + comentario + ", interprete = " + interprete + ", Cantidad = " + cantidad +"]";
	}





}
