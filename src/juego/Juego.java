package juego;

import java.awt.Color;
import java.util.Random;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	
	private Entorno entorno;
	
	// Variables y metodos propios de cada grupo
	
	Princesa princesa;
	Soldado[] soldados;
	Obstaculo[] obstaculos;
	Fuego[] fuego;
	Suelo[] suelo;
	Fondo[] fondo;
	Extras extra;
    VidaExtra vidaE;
    Menu menu;
    boolean fin = false;

	

	
	
	public Juego() {
		
		// Inicializa el objeto entorno
		entorno = new Entorno(this, "Super Elizabeth Sis - Grupo 3 - v1", 800, 600);
		

		
		
		
		// Inicializar lo que haga falta para el juego
		
		princesa = new Princesa();
		soldados = new Soldado[100];
		obstaculos= new Obstaculo[100];
		fuego = new Fuego[100];
		suelo = new Suelo[100];
		fondo = new Fondo[100];
		extra = new Extras();
		vidaE = new VidaExtra();
		menu = new Menu();

		
		Random generador = new Random();  //para la ubicación aleatoria de soldados
		
		double x=800;  //posición primer soldado
		double o=600;  //pos obstáculos
		int s=410;     //pos suelo
		int f=406;     //pos fondo

		//for para crear los soldados
		for (int i = 0; i < soldados.length; i++) {
			int y = 463; 
			soldados[i] = new Soldado(x , y);
			x+=70+(double)generador.nextInt(800-70); //a x se le suma un número aleatorio entre 70 y 799
		}
		
		//for para crear los obstáculos
		for (int i = 0; i < obstaculos.length; i++) {
			int y = 470; 
			obstaculos[i] = new Obstaculo(o, y);
			o+=350;			
		}
		
		//suelo
		for (int i = 0; i < suelo.length; i++) {
			int y = 470; 
			suelo[i] = new Suelo(s, y);
			s+=400;
		}
		
		//fondo
		for (int i = 0; i < fondo.length; i++) {
			int y = 500;
			fondo[i] = new Fondo(f, y);
			f+=400;
		}
		
		
		
		// Inicia el juego
		entorno.iniciar();
		
		//música
		Herramientas.loop("fondo.wav");

		
		}
	
	
	
	
	
	public void tick() {

		// Procesamiento de un instante de tiempo
		
		
		
		
		
//      :::::::::::::::::::::::::DIBUJOS::::::::::::::::::::::::::::
		
		
		//fondo
		for (int i = 0; i < fondo.length; i++) {
			if (fondo[i] != null)
				fondo[i].dibujarFondo(entorno);
		}
		
		//vidas (ícono y cantidad)
		entorno.cambiarFont("arial black", 25, Color.BLUE);   //esta sería 
		entorno.escribirTexto(" " + princesa.vida, 700, 65);  //la sombra
		entorno.cambiarFont("arial black", 25, Color.RED);
		entorno.escribirTexto(" " + princesa.vida, 699, 64);  
		extra.dibujarCorazon(entorno);
		
		//puntos (ícono y cantidad)
		entorno.cambiarFont("arial black", 25, Color.BLUE);
		entorno.escribirTexto(" " + princesa.puntos, 700, 110);
		entorno.cambiarFont("arial black", 25, Color.RED);
		entorno.escribirTexto(" " + princesa.puntos, 699, 109);
		extra.dibujarCopa(entorno);
		
		
		//for para dibujar los obstáculos
		for (int i = 0; i < obstaculos.length; i++) {
			if (obstaculos[i] != null)
				obstaculos[i].dibujarObstaculo(entorno);
		}
				
		
		//suelo
		for (int i = 0; i < suelo.length; i++) {
			if (suelo[i] != null)
				suelo[i].dibujarSuelo(entorno);
		}
		

		//soldados
		for (int i = 0; i < soldados.length; i++) {
			if (soldados[i] != null)
				soldados[i].dibujarSoldado(entorno);
		}
		 
		//objeto que puede agarrarse para vida extra
		vidaE.dibujarVidaE(entorno);  
		
		
		//fuego
		for (int i = 0; i < fuego.length; i++) {
			if (fuego[i] != null)
				fuego[i].dibujarse(entorno);
		}
		
		
		//para que desaparezca el fuego al salir de pantalla y no siga matando
		for (int i = 0; i < fuego.length; i++) {
			if (fuego[i] != null && fuego[i].fueraPantalla()) {
				fuego[i]=null;
			}
		}
		
		//princesa
		princesa.dibujarPrincesa(entorno);
		
		//pantalla de inicio
		menu.dibujarMenu(entorno);
		if(entorno.estaPresionada(entorno.TECLA_ENTER)) {
			menu.mover();
		}
		
		
		
//      :::::::::::::::::::MOVIMIENTOS:::::::::::::::::::::
		
		
		
		//fuego
		for (int i = 0; i < fuego.length; i++) {
			if (fuego[i] != null && fin==false)
				fuego[i].moverse();
		}
		
		//salto princesa
		if (entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
			princesa.saltar();
			}
		else {
			princesa.quieta();
		}
		
		
		//soldados
		for (int i = 0; i < soldados.length; i++) {
			if (soldados[i] != null && entorno.estaPresionada(entorno.TECLA_DERECHA) && fin==false) {
				soldados[i].avanzar();
			}
			if  (soldados[i] != null && entorno.estaPresionada(entorno.TECLA_IZQUIERDA) && fin==false) {
				soldados[i].retroceder();
				princesa.imagenReves();   //la princesa se da vuelta cuando retrocede
				princesa.dibujarPrincesa(entorno);
			}
			else {
				princesa.imagenNormal();
			}
		}
		
		//obstáculos
		for (int i = 0; i < obstaculos.length; i++) {
			if (obstaculos[i] != null && entorno.estaPresionada(entorno.TECLA_DERECHA) && fin==false) {
				obstaculos[i].avanzar();
			}
			if (obstaculos[i] != null && entorno.estaPresionada(entorno.TECLA_IZQUIERDA) && fin==false) {
				obstaculos[i].retroceder();
			}
		}
		
		//vida extra
		if(entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			vidaE.avanzar();
		}
		if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			vidaE.retroceder();
		}
		
		
		//suelo
		for (int i = 0; i < suelo.length; i++) {
			if (suelo[i] != null && entorno.estaPresionada(entorno.TECLA_DERECHA)) {
				suelo[i].avanzar();
			}
			if  (suelo[i] != null && entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
				suelo[i].retroceder();
				princesa.imagenReves();
				princesa.dibujarPrincesa(entorno);
			}
			else {
				princesa.imagenNormal();
			}
		}
		
		
		//fondo
		for (int i = 0; i < fondo.length; i++) {
			if (fondo[i] != null && entorno.estaPresionada(entorno.TECLA_DERECHA)) {
				fondo[i].avanzar();
				
			}
			if  (fondo[i] != null && entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
				fondo[i].retroceder();
				princesa.imagenReves();
				princesa.dibujarPrincesa(entorno);
			}
			else {
				princesa.imagenNormal();
			}
		}
				
		//disparo princesa
		if (entorno.sePresiono(entorno.TECLA_ESPACIO)){
			for (int i = 0; i < fuego.length; i++) {
				if (fuego[i] == null && !entorno.estaPresionada(entorno.TECLA_ARRIBA)){
					fuego[i] = princesa.disparar();
					break;
				}
			}
		}
		
		
		
//      ::::::::::::::::::::::::::::::::::::COLISIONES::::::::::::::::::::::::::::::::::::::::::::::::::::::::::		
		
		
		
		//fuego-soldado
		for (int j = 0; j < soldados.length; j++) {
			for (int i = 0; i < fuego.length; i++) {
				if (soldados[j] != null && fuego[i] != null && soldados[j].tocaFuego(fuego[i])){
					fuego[i] = null;
					soldados[j] = null;
					princesa.puntos=princesa.puntos+5;
				}
			}
		}

	
				
		//soldado-princesa
		for (int j = 0; j < soldados.length; j++) {
			//si ... el soldado llega al espacio que ocupa la princesa (entre 80 y 90)..
			if (soldados[j] != null && !entorno.estaPresionada(entorno.TECLA_ARRIBA) && princesa.tocaSoldado(soldados[j])){  
				if(princesa.vida!=0) {
					princesa.vida--;
					soldados[j].adelantaPrincesa();  //cambia la posición imperceptiblemente hacia atrás de la princesa					
				}	
			}
		}
		
		
		
		//obstáculo-princesa
		for (int j = 0; j < obstaculos.length; j++) {
			if (obstaculos[j] != null && princesa.tocaObstaculo(obstaculos[j]) && princesa.noSaltaObs()){
				if(princesa.vida!=0) {
					princesa.vida--;
					obstaculos[j].adelantaPrincesa();
				}	
			}
		}
		
		//princesa agarra vida
		if (princesa.agarraVida(vidaE)) {
			vidaE.seVa();  //la mando lejos
			princesa.vida+=1;
		}
		

		
//      :::::::::::::::::::::::::::::::::GANADO O PERDIDO:::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		
		
		
		//controlo si el el juego está ganado o perdido
		if(princesa.vida==0){
			extra.dibujarFondoNegro(entorno);
			extra.dibujarReyGano(entorno);
			entorno.cambiarFont("tahoma", 40, Color.ORANGE);
			entorno.escribirTexto("RESCATE FRACASADO", 200, 200);
			entorno.escribirTexto("¡EL REY HA GANADO!", 200, 250);
			fin=true; 
			princesa.puntos=200; //para que no llegue al puntaje ganador
		}
		

		
		if(princesa.puntos==100){
			extra.dibujarFondoNegro(entorno);
			extra.dibujarGato(entorno);
			extra.dibujarPrinGano(entorno);
			extra.dibujarReyPerdio(entorno);
			entorno.cambiarFont("tahoma", 40, Color.YELLOW);
			entorno.escribirTexto("   FELICITACIONES", 150, 200);
			entorno.escribirTexto("¡¡¡RESCATE EXITOSO!!!", 150, 250);
			fin=true; //para que no se sigan moviendo las cosas al apretar teclas 
		}
			

	}
	

	
	
	
	public static void main(String[] args) {
		
		Juego juego = new Juego();

	}

}