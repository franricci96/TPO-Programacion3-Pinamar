package algoritmos;

import resources.implementaciones.ConjuntoEstatico;
import resources.interfaces.ConjuntoTDA;
import resources.implementaciones.GrafoEstatico;
import resources.interfaces.GrafoTDA;
import resources.implementaciones.metodos;

public class Dijkstra {
	
	metodos m = new metodos();
	
	public GrafoTDA dijkstra(GrafoTDA g, int s) { // Toma como parametro un grafo y un vertice a partir del cual 
		
		
		//Instanciación de un conjunto para guardar los grafos visitados (S)
		ConjuntoTDA visitados = new ConjuntoEstatico();
		visitados.InicializarConjunto(); 
		// Se agrega al conjunto el vertice del cual se parte.
		visitados.Agregar(s);
		
		// Se crea un conjunto para los vertices del grafo 
		ConjuntoTDA verticesGrafo = new ConjuntoEstatico(); 
		verticesGrafo.InicializarConjunto();
		copiarConjuntos(g.Vertices(), verticesGrafo);
		
		GrafoTDA grafoAux = new GrafoEstatico(); //creo un grafo auxiliar
		grafoAux.InicializarGrafo();
		
		//lleno el grafo auxiliar solamente con los vertices del grafo original
		while(!verticesGrafo.ConjuntoVacio()) { 
			int v = verticesGrafo.Elegir();
			grafoAux.AgregarVertice(v);
			verticesGrafo.Sacar(v);
		}
		
		ConjuntoTDA adyA = new ConjuntoEstatico(); //adyacentes al vertice pasado por parametro (s)
		adyA.InicializarConjunto();
		adyA = m.Adyacentes(g, s);
		
		//agrego las aristas entre el vertice pasado por parametro y sus adyacentes, al grafo auxiliar
		while(!adyA.ConjuntoVacio()) {
			int v = adyA.Elegir();
			int peso = g.PesoArista(s, v); //obtengo peso de esa arista entre vertice_parametro y v
			grafoAux.AgregarArista(s, v, peso); //la agrego al grafo auxiliar
			adyA.Sacar(v);//saco de adyacentes para que el while itere
		}
		
		/*Creo el conjunto de vertices pendientes
		 *con todos los vertices del grafo_parametro menos el vertice_parametro*/
		copiarConjuntos(g.Vertices(), verticesGrafo);
		verticesGrafo.Sacar(s);
		ConjuntoTDA pendientes = new ConjuntoEstatico();
		pendientes.InicializarConjunto();
		copiarConjuntos(verticesGrafo, pendientes);
		
		//adyacentes a vertice_parametro
		ConjuntoTDA ady = new ConjuntoEstatico(); 
		ady.InicializarConjunto();
		ady = m.Adyacentes(grafoAux, s);
		
		//comienzo a llenar el grafo auxiliar con las aristas que correspondan a dijkstra
		while(!pendientes.ConjuntoVacio() && !ady.ConjuntoVacio()) {
			//busco el nodo con la arista de menor peso conectada al vertice_parametro usando adyacentes
			int menor = ady.Elegir(); //elijo un vertice aleatorio adyacente a vertice_parametro
			
			ConjuntoTDA adyWhile = new ConjuntoEstatico();
			adyWhile.InicializarConjunto();
			copiarConjuntos(ady, adyWhile);
			
			while(!adyWhile.ConjuntoVacio()) {
				int x = adyWhile.Elegir();
				if(grafoAux.PesoArista(s, x) <= grafoAux.PesoArista(s, menor)) {
					menor = x; //lo guardo si es menor o igual
				}
				adyWhile.Sacar(x);
			}
			/* Verifico si hay un camino mejor del vertice_parametro a p pasando por el menor */
			visitados.Agregar(menor);
			pendientes.Sacar(menor);
			ady.Sacar(menor);
			
			// Conjunto el cual va a contener los vertices que aun no fueron visitados
			ConjuntoTDA q = new ConjuntoEstatico();
			q.InicializarConjunto();
			copiarConjuntos(pendientes, q);
			
			while(!q.ConjuntoVacio()) {
				int p = q.Elegir();
				q.Sacar(p);
				if(g.ExisteArista(menor, p)) {
					if(grafoAux.ExisteArista(s, p)) {
						if((grafoAux.PesoArista(s, menor) + g.PesoArista(menor, p)) <= grafoAux.PesoArista(s, p)) {
							grafoAux.AgregarArista(s, p, grafoAux.PesoArista(s, menor) + g.PesoArista(menor, p));
						}
					}
					else {
						grafoAux.AgregarArista(s, p, grafoAux.PesoArista(s, menor) + g.PesoArista(menor, p));
					}
				}
			}
		}
		return grafoAux;
	}
		
	// Funcion auxiliar para llevar lo contenido de un conjunto a otro.
	public void copiarConjuntos(ConjuntoTDA a, ConjuntoTDA b) {
		ConjuntoTDA auxA = new ConjuntoEstatico();
		auxA.InicializarConjunto();
		
		while(!a.ConjuntoVacio()) {
			int elem = a.Elegir();
			auxA.Agregar(elem);
			a.Sacar(elem);
		}
		
		while(!auxA.ConjuntoVacio()){
			int elem = auxA.Elegir();
			a.Agregar(elem);
			b.Agregar(elem);
			auxA.Sacar(elem);
		}
	}
}
