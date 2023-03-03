package algoritmos;

import java.util.Random;

import resources.implementaciones.ColaEstatica;
import resources.implementaciones.ConjuntoEstatico;
import resources.implementaciones.GrafoEstatico;
import resources.interfaces.ConjuntoTDA;
import resources.interfaces.GrafoTDA;
import resources.interfaces.ColaTDA;
import resources.implementaciones.metodos;

public class BFS {

    metodos m = new metodos();

    public void BreathFirstSearch(GrafoTDA grafo, int nActual, ConjuntoTDA visitados, ColaTDA cola) {

        cola.Acolar(nActual);
        visitados.Agregar(nActual);

        while (!cola.ColaVacia()) {

            int v = cola.Primero();
            System.out.print("(" + v + ") ");
            cola.Desacolar();

            ConjuntoTDA adyacentes = m.Adyacentes(grafo, v);

            while (!adyacentes.ConjuntoVacio()) {

                int n = adyacentes.Elegir();
                adyacentes.Sacar(n);

                if (!visitados.Pertenece(n)) {

                    visitados.Agregar(n);
                    cola.Acolar(n);
                }

            }
        }

    }

    public void ForestBFS(GrafoTDA grafo, ConjuntoTDA visitados, ColaTDA cola) {

        ConjuntoTDA verticesGrafo = new ConjuntoEstatico();
        verticesGrafo.InicializarConjunto();
        verticesGrafo = grafo.Vertices();

        while (!verticesGrafo.ConjuntoVacio()) {

            int x = verticesGrafo.Elegir();
            verticesGrafo.Sacar(x);

            if (!visitados.Pertenece(x)) {
                BreathFirstSearch(grafo, x, visitados, cola);
            }

        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        GrafoEstatico g1 = new GrafoEstatico();
        g1.InicializarGrafo();

        g1.AgregarVertice(0);
        g1.AgregarVertice(1);
        g1.AgregarVertice(2);
        g1.AgregarVertice(3);
        g1.AgregarVertice(4);
        g1.AgregarVertice(5);

        g1.AgregarArista(1, 2, 4);
        g1.AgregarArista(1, 3, 2);
        g1.AgregarArista(2, 4, 3);
        g1.AgregarArista(3, 4, 1);
        g1.AgregarArista(3, 5, 5);
        g1.AgregarArista(4, 5, 2);

        ConjuntoEstatico visitados = new ConjuntoEstatico();
        visitados.InicializarConjunto();

        ColaEstatica cola = new ColaEstatica();
        cola.InicializarCola();

        int n = 1;

        System.out.println("====================== Inicio de algoritmo BFS ======================\n");
        System.out.println("Los nodos alcanzables a partir del nodo recibido " + n + " son: ");
        BFS bfs = new BFS();
        bfs.BreathFirstSearch(g1, n, visitados, cola);
        System.out.println("\nLos nodos aislados son:");
        bfs.ForestBFS(g1, visitados, cola);
        System.out.println("\n================================ END ================================");

    }
}
