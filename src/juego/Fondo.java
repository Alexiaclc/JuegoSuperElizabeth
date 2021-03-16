package juego;

import entorno.Entorno;
import java.awt.Image;
import entorno.Herramientas;


public class Fondo {
	private int x;
	private int y;
	private Image img;

	
	public Fondo(int x, int y) {
		super();
		this.x = x;
		this.y = 500;
		this.img = Herramientas.cargarImagen("cielos.jpg");

	}
	
	
	public void avanzar() 	{
		this.x-=1;
	}
	
	public void retroceder() 	{
		this.x+=1;
		}
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	public void dibujarFondo(Entorno entorno) {
		entorno.dibujarImagen(img, x, y, 0, 0.3);
		}
	
}