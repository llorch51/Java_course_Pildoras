package colecciones;

public class Dos_Equals_HashCode {

	public static void main(String[] args) {
		
		Libro libro1 = new Libro("P en java", "Juan", 25);
		Libro libro2 = new Libro("P en java", "Juan", 25);
		
		if (libro1.equals(libro2)) {
			System.out.println("yes");
			System.out.println(libro1.hashCode());
			System.out.println(libro2.hashCode());
		}else {
			System.out.println("no");
			System.out.println(libro1.hashCode());
			System.out.println(libro2.hashCode());
		}

	}

}


class Libro{
	
	public Libro(String titulo, String autor, int iSBN) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		ISBN = iSBN;
	}
	
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", ISBN=" + ISBN + "]";
	}
	
	
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ISBN;
//		return result;
//	}

	//Sobreescritra de Eclipse
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Libro other = (Libro) obj;
//		if (ISBN != other.ISBN)
//			return false;
//		return true;
//	}

	//Sobreescritura mio
	public boolean equals(Object objeto) {
		
		if (objeto instanceof Libro) {//si el objeto que le pasamos es una instancia de Libro
			Libro otro = (Libro) objeto;//instanciamos temporalmente una variable de tipo libro para el objeto que estamos pasando
			if (this.ISBN==otro.ISBN) {//comparamos la propiedad ISBN de la primera instancia(this) con la que pasamos por parametro(recien hecha arriba)
				return true;
			}else {
				return false;
			}
		}else {//Si no es una instancia de Libro
			return false;
		}
	}


	private String titulo;
	private String autor;
	private int ISBN;
}