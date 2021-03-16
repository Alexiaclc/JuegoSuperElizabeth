package juego;

import entorno.Entorno;
import java.awt.Image;
import entorno.Herramientas;

public class Obstaculo {

	double x;
	int y;
	Image img;
			
	public Obstaculo(double x, int y) {
		super();
		this.x = x;   //800;
		this.y = 475;
		this.img = Herramientas.cargarImagen("pipe.png");
	}
	
	public void avanzar() 	{
		this.x-=4;
	}
	
	public void retroceder() 	{
		this.x+=2;
	}
	
	public void adelantaPrincesa() {
		this.x=79;
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

	public void dibujarObstaculo(Entorno entorno) {
		entorno.dibujarImagen(img, x, y, 0, 0.36);
		}
	

}
