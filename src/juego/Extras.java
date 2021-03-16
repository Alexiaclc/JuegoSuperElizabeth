package juego;

import java.awt.Color;
import entorno.Entorno;
import java.awt.Image;
import entorno.Herramientas;


public class Extras {
	private int x;
	private int y;
	private Image corazon;
	private Image copa;
	private Image gato;
	private Image princesaGano;
	private Image reyGano;
	private Image reyPerdio;
	private Color color;

	
	public Extras() {
		super();
		this.x = 670; //406;
		this.y = 57;
		this.corazon = Herramientas.cargarImagen("corazon.png");
		this.copa = Herramientas.cargarImagen("copa.png");
		this.princesaGano = Herramientas.cargarImagen("princesaGano.png");
		this.reyPerdio = Herramientas.cargarImagen("reyEnojado.png");
		this.gato = Herramientas.cargarImagen("gato.png");
		this.reyGano = Herramientas.cargarImagen("reyeGano.png");
		this.color= Color.BLACK;
	}
	
	
	public void dibujarCorazon(Entorno entorno) {
		entorno.dibujarImagen(corazon, x, y, 0, 0.06);
		}

	public void dibujarCopa(Entorno entorno) {
		entorno.dibujarImagen(copa, 670, 100, 0, 0.06);
		}
	
//	::::::::::::::::::::::::::GANO::::::::::::::::::::::::::::::::::::
	
	public void dibujarGato(Entorno entorno) {
		entorno.dibujarImagen(gato, 300, 530, 0, 0.2);
		}

	public void dibujarPrinGano(Entorno entorno) {
		entorno.dibujarImagen(princesaGano, 500, 460, 0, 0.25);
		}

	public void dibujarReyPerdio(Entorno entorno) {
		entorno.dibujarImagen(reyPerdio, 740, 150, 0, 0.2);
		}

	public void dibujarFondoNegro(Entorno entorno) {
		entorno.dibujarRectangulo(450, 300, 900, 700, 0, color);
		}
	
//::::::::::::::::::::::::PERDIO::::::::::::::::::::::::::::::::::::::

	public void dibujarReyGano(Entorno entorno) {
		entorno.dibujarImagen(reyGano, 400, 450, 0, 1);
		}
	

}