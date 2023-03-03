package resources.implementaciones;

import resources.interfaces.ConjuntoTDA;
import resources.interfaces.GrafoTDA;

public class metodos {

    public ConjuntoTDA Adyacentes(GrafoTDA grafo, int nodoAct) {

        ConjuntoTDA vertices = new ConjuntoEstatico();
        vertices.InicializarConjunto();
        ConjuntoTDA vAdyacentes = new ConjuntoEstatico();
        vAdyacentes.InicializarConjunto();

        vertices = grafo.Vertices();

        if (vertices.Pertenece(nodoAct)) {
            vertices.Sacar(nodoAct);

            while (!vertices.ConjuntoVacio()) {

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
