package juego;

import entorno.Entorno;
import java.awt.Image;
import entorno.Herramientas;


public class Suelo {
	private int x;
	private int y;
	private Image img;

	
	public Suelo(int x, int y) {
		super();
		this.x = x;  //410;
		this.y = 720;
		this.img = Herramientas.cargarImagen("piso.jpg");
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

	public void avanzar() {
		this.x-=5;
	}
	
	public void retroceder() 	{
		this.x+=5;
	}
	
	public void dibujarSuelo(Entorno entorno) {
		entorno.dibujarImagen(img, x, y, 0,01);
		}

}
