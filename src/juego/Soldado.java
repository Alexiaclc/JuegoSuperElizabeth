package juego;

import entorno.Entorno;
import java.awt.Image;
import entorno.Herramientas;

public class Soldado {

	double x;
	int y;
	Image img;
	
			
	public Soldado(double x, double y) {
		super();

		this.x = x;
		this.y = 470;
		this.img = Herramientas.cargarImagen("sol.png");
	}
	
	public void avanzar() {
		this.x-=7;	
	}
		
	public void retroceder() {
		this.x+=5;
		}

	public boolean tocaFuego(Fuego fuego) {
		return this.x <= fuego.getX();
	}
	
	public void adelantaPrincesa() {
		this.x=79;
	}
	
	public void dibujarSoldado(Entorno entorno) {
		entorno.dibujarImagen(img, x, y, 0, 0.12);
		}
	

	public int getY() {
		return y;
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

	
}
