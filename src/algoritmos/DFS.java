package algoritmos;

import resources.implementaciones.ConjuntoEstatico;
import resources.interfaces.ConjuntoTDA;
import resources.interfaces.GrafoTDA;
import resources.implementaciones.metodos;

public class DFS {
	
	metodos m = new metodos(); 
	
	public void  dfs (GrafoTDA grafo, int nodoActual, ConjuntoTDA visitados ) {
		
		if(!visitados.Pertenece(nodoActual)) {
			visitados.Agregar(nodoActual);
			System.out.println(nodoActual);
			ConjuntoTDA adyacentes=m.Adyacentes(grafo,nodoActual); //voy a buscar los adyacentes del nodoActual
		
			while(!adyacentes.ConjuntoVacio()) {
				int n=adyacentes.Elegir();
				adyacentes.Sacar(n);
			
				if(!visitados.Pertenece(n)) {
					dfs(grafo,n,visitados);
				}
			}	
		}
		
	}
	
	
	public void dfs_forest(GrafoTDA grafo,ConjuntoTDA visitados) {
		
		ConjuntoTDA verticesGrafo=new ConjuntoEstatico();
		verticesGrafo.InicializarConjunto();
		verticesGrafo=grafo.Vertices();
		
		while(!verticesGrafo.ConjuntoVacio()) {	
			int x=verticesGrafo.Elegir();
			verticesGrafo.Sacar(x);
			
			if(!visitados.Pertenece(x)) {
				dfs(grafo,x,visitados);
			}
		}
	}
	
}
