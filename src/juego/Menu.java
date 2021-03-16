package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;


public class Menu {

	private int x;
	private int y;
	private Image img;

	
	
	public Menu() {
		super();
		this.x = 406;
		this.y = 500;
		this.img = Herramientas.cargarImagen("Menu.jpg");
	}
	
	public void mover() {
		this.x += 1000;
	}
	
	public void dibujarMenu(Entorno entorno) {
		entorno.dibujarImagen(img, x, 300, 0, 1);
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
		
	

}

