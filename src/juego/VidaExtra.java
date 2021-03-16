package juego;


import entorno.Entorno;
import java.awt.Image;
import entorno.Herramientas;

public class VidaExtra {

	double x;
	int y;
	int altura;
	Image img;
			
	public VidaExtra() {
		super();

		this.x = 1400;  
		this.y = 400;
		this.altura = 10;
		this.img = Herramientas.cargarImagen("vidaE.png");

	}
	
	public void avanzar() {
		this.x-=2;
	}
	
	public void retroceder() {
		this.x+=2;
	}
	
	public void seVa() {
		this.y=800;
	}
	
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void dibujarVidaE(Entorno entorno) {
		entorno.dibujarImagen(img, x, y, 0, 0.1);
		}

	

}
