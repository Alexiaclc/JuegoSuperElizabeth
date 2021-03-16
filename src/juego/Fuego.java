package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Fuego 
{
	private double x;
	private int y;
	private Image img;
	
	public Fuego(double x_fuego, int y_fuego) {
		this.x = x_fuego;
		this.y = y_fuego;
		this.img = Herramientas.cargarImagen("5.png");
	}

	public void moverse() 	{
		this.x += 15;
	}
		
	public boolean fueraPantalla() {
		return this.x >= 800;
	}
	
	public void dibujarse(Entorno entorno) 	{
		entorno.dibujarImagen(img, x, y, 0, 0.03);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

}
