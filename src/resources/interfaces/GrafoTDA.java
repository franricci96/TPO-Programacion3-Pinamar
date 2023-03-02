package resources.interfaces;


import resources.interfaces.ConjuntoTDA;

public interface GrafoTDA {
	void InicializarGrafo(); // Metodo para inicializar el TDA.
	void AgregarVertice(int v); // Agregar un vertice al grafo.
	void EliminarVertice(int v); // Eliminar un vertice del grafo.
	void AgregarArista(int v1, int v2, int p); // Agrega una arista entre dos vertices, con un peso dado. Siempre que no exista una arista previamente.
	void EliminarArista(int v1, int v2); // Elimina la arista
	int PesoArista(int v1, int v2); // Devuelve el peso de la arista entre dos grafos dados.
	ConjuntoTDA Vertices(); // Grafo inicializado
	boolean ExisteArista(int v1, int v2); // Grafo inicializado y 9 nodos v1, v2
}
