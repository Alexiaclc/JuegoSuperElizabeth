package juego;

import entorno.Entorno;
import java.awt.Image;
import entorno.Herramientas;


public class Princesa {

	private double x;
	private int y;
	private int altura;
	private Image img;
	int vida;
	int puntos;
//	private Image img2;
      
			
	public Princesa() {
		super();

		this.x = 100;
		this.y = 470;
		this.img = Herramientas.cargarImagen("princesa1.png");
		this.vida = 3;
		this.puntos = 0;

	}
	

	
	void saltar() {
		while(this.y>360) {
			this.y -= 10;
		}
	}
	void quieta() {
		this.y = 470;
	}
	
	public Fuego disparar() {
		double x_fuego = this.x;
		int y_fuego = this.y - this.altura/2;
		return new Fuego(x_fuego, y_fuego);
	}
	
	public boolean tocaSoldado(Soldado soldado) {
		return soldado.getX()<=90 && soldado.getX()>=80;
		}
	
	
    //para que no me saque vidas si pasa sobre el obstáculo
	public boolean noSaltaObs() {
		 return this.y == 470;
	}
	
	public boolean tocaObstaculo(Obstaculo obstaculo) {
		return obstaculo.getX()<=90  && obstaculo.getX()>=80;
		}
	
	//si agarra el objeto que le da una vida más
	public boolean agarraVida(VidaExtra vida) {
		return this.x == vida.getX();
	}
	
	public void dibujarPrincesa(Entorno entorno) {
		entorno.dibujarImagen(img, x, y, 0, 0.24);
		}
	
	//para cuando retrocede
	public void imagenReves() {
		this.img=Herramientas.cargarImagen("princesaReves.png");
	}
	
	public void imagenNormal() {
		this.img=Herramientas.cargarImagen("princesa1.png");
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


}
