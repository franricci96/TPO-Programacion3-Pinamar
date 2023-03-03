package resources.programaPrincipal;

import algoritmos.DFS;
import resources.implementaciones.ConjuntoEstatico;
import resources.implementaciones.GrafoEstatico;
import resources.interfaces.ConjuntoTDA;
import resources.interfaces.GrafoTDA;

public class MainBFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConjuntoTDA visitados=new ConjuntoEstatico();
		visitados.InicializarConjunto();
		GrafoTDA grafo=new GrafoEstatico();
		
		grafo.InicializarGrafo();
		grafo.AgregarVertice(0);
		grafo.AgregarVertice(1);
		grafo.AgregarVertice(2);
		grafo.AgregarVertice(3);
		grafo.AgregarVertice(4);
		grafo.AgregarVertice(5);
		grafo.AgregarVertice(6);
		grafo.AgregarVertice(7);
		grafo.AgregarVertice(8);
		
		
		grafo.AgregarArista(0, 1, 1);
		grafo.AgregarArista(0, 2, 1);
		grafo.AgregarArista(1, 5, 1);
		grafo.AgregarArista(2, 3, 1);
		grafo.AgregarArista(3, 4, 1);
		grafo.AgregarArista(4, 5, 1);
		grafo.AgregarArista(5, 6, 1);
		grafo.AgregarArista(7, 8, 1);
		
		System.out.println("DFS");
		System.out.println("Los nodos del grafo son:" + "\n");
		
		DFS alg=new DFS();
		alg.dfs(grafo, 0, visitados); //llamo a dfs
		System.out.println("\n" + "Nodos aislados:" + "\n");
		alg.dfs_forest(grafo, visitados); // llamo a dfs_forest por si faltaron recorrer vertices
	}			
}