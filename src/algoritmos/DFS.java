package algoritmos;

import resources.implementaciones.ConjuntoEstatico;
import resources.interfaces.ConjuntoTDA;
import resources.interfaces.GrafoTDA;

public class DFS {
	
	public void  dfs (GrafoTDA grafo, int nodoActual, ConjuntoTDA visitados ) {
		
		if(!visitados.Pertenece(nodoActual)) {
			visitados.Agregar(nodoActual);
			System.out.println(nodoActual);
			ConjuntoTDA adyacentes=Adyacentes(grafo,nodoActual); //voy a buscar los adyacentes del nodoActual
		
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
	


	public ConjuntoTDA Adyacentes(GrafoTDA grafo, int nodoAct) {
	    ConjuntoTDA vertices = new ConjuntoEstatico(); 
	    vertices.InicializarConjunto();
	    ConjuntoTDA vAdyacentes = new ConjuntoEstatico(); 
	    vAdyacentes.InicializarConjunto();
	    vertices = grafo.Vertices();
	     
	    if (vertices.Pertenece(nodoAct)){
	          vertices.Sacar(nodoAct);
	     
	          while (!vertices.ConjuntoVacio()){
	        	  int vertice = vertices.Elegir();
	              vertices.Sacar(vertice);
	              if (grafo.ExisteArista(nodoAct, vertice)) {
	            	  vAdyacentes.Agregar(vertice);
	              }
	          }
	    }
	    return vAdyacentes;
	}

}
