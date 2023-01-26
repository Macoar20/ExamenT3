package fraccion;

/**
 * Utilizaremos la clase Fraccion para operar con fracciones
 * @author mcosano
 *
 */
public class Fraccion {
	// Variable que será el numerador de la fracción
	private int num;

	// Variable que será el denominador de la fracción
	private int den;

	/**
	 * 
	 * Para generar valaros neutros
	 * 
	 */

	public Fraccion() { // debe generar el valor neutro que es 0/1
		num = 0;
		den = 1;

	}

	/**
	 * Lo utilizaremos para evitar que exista el 0 como divisor ya que eso generaría operaciones con el infinito
	 * @param num
	 * @param den
	 */
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0)
			this.den = 1;
		else
			this.den = den;
		// devuelvo la fracci�n simplificada
		simplificar();
	}

	/**
	 * Encargado de la fracción final
	 * @param f
	 */
	public Fraccion(final Fraccion f) {
		num = f.num;
		den = f.den;
	}

	/**
	 * 
	 * @param num
	 */

	public void setNum(int num) {
		this.num = num;

	}
	/**
	 * Lo utilizaremos para mostrar el numerador
	 * @return
	 */
	public int getNum() {
		return num;

	}
	/**
	 * 
	 * @param den
	 */
	public void setDen(int den) {
		this.den = den;
	}
	/**
	 * Lo utilizaremos para mostrar el denominador
	 * @return
	 */
	public int getDen() {
		return den;
	}

	// Cálculo del máximo común divisor por el algoritmo de Euclides
	private int mcd() {
		int u = (Math.abs(num)); // valor absoluto del numerador
		int v = (Math.abs(den)); // valor absoluto del denominador
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

	// método para simplificar fracciones
	public void simplificar() {
		int n = mcd();
		num = num / n;
		den = den / n;
	}

	// Método toString

	public String toString() {
		String mensaje = num + "/" + den;
		return mensaje;

	}

	// suma de fracciones
	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den + den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	// Restar fracciones

	public Fraccion restar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den - den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

//Multiplicar fracciones

	public Fraccion multiplicar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

//Dividir fracciones

	public Fraccion dividir(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den;
		aux.den = den * f.num;
		aux.simplificar();
		return aux;

	}

}
