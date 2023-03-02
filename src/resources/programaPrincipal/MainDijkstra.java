package resources.programaPrincipal;
import algoritmos.Dijkstra;

import resources.implementaciones.ConjuntoEstatico;
import resources.implementaciones.GrafoEstatico;
import resources.interfaces.ConjuntoTDA;
import resources.interfaces.GrafoTDA;


public class MainDijkstra {

	public static void main(String[] args) {
		
		//CREA UN GRAFO
		GrafoTDA grafo = new GrafoEstatico();
		grafo.InicializarGrafo();
		
		//LE INSERTA LOS VERTICES
		grafo.AgregarVertice(1);
		grafo.AgregarVertice(2);
		grafo.AgregarVertice(3);
		grafo.AgregarVertice(4);
		grafo.AgregarVertice(5);
		grafo.AgregarVertice(6);
		
		// UNE LOS VERTICES
		grafo.AgregarArista(1, 2, 2);
		grafo.AgregarArista(1, 4, 15);
		grafo.AgregarArista(1, 5, 4);
		grafo.AgregarArista(1, 6, 3);
		grafo.AgregarArista(2, 5, 2);
		grafo.AgregarArista(2, 3, 3);
		grafo.AgregarArista(3, 4, 6);
		grafo.AgregarArista(5, 6, 3);
		grafo.AgregarArista(5, 4, 1);
		grafo.AgregarArista(6, 4, 1);
		
		// CREA UN OBJETO DIJKSTRA
		Dijkstra d = new Dijkstra();
		GrafoTDA graph = new GrafoEstatico();
		graph.InicializarGrafo();
		
		int verticeInicial = 1;
		
		// APLICA DIJKSTRA A UN OBJETO DIJKSTRA
		graph = d.dijkstra(grafo, verticeInicial);
		// CREA EL CONJUNTO PARA PODER IMPRIMIRLO LUEGO PODER PRINTEAR 
		ConjuntoTDA vertices = new ConjuntoEstatico();
		vertices.InicializarConjunto();
		// COPIA LOS VERTICES DENTRO DE UN GRAFO
		vertices = graph.Vertices();
		
		
		// LO MUESTRA POR PANTALLA
		while(!vertices.ConjuntoVacio()) {
			int elem = vertices.Elegir();
			System.out.println("Vertice inicial: "+ verticeInicial +  " ----- Costo: "+graph.PesoArista(1, elem)+"-----> Vertice de llegada: "+elem);
			vertices.Sacar(elem);
		}
	}


}
