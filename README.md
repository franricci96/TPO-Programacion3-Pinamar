# PROGRAMACION 3 MRI PINAMAR INTENSIVO | 2023 | UADE - TPO GRUPAL |

## Consigna 📒

### MRI Programación III – Cursada 2023

#### Trabajo Práctico Especial

#### Carácter: Obligatorio

Fecha de Entrega: 02/02/2023 por correo electrónico a guirodriguez@uade.edu.ar. El entregable consiste en la entrega del link del repositorio GitHub con el proyecto Java y un informe describiendo cada una de las etapas del proyecto.
El trabajo se puede realizar en grupo de hasta 2 personas o individual.

### Enunciado

Usted va a recibir la Clase Grafo en Java y deberá implementar 3 (tres) de los siguientes algoritmos:

- [x] Algoritmo Breadth-First Search (BFS)
- [x] Algoritmo Depth-First Search (DFS)
- []Algoritmo de Prim
- []Algoritmo de Kruskal
- [x] Algoritmo de Dijsktra
- [] Algoritmo de Floyd

Tenga en cuenta la representación del grafo (dinámica o estática) para la implementación de los algoritmos elegidos.

## - Algoritmo de Dijsktra

El algoritmo Dijkstra se utiliza para calcular el camino de menos costo partiendo desde un vertice ingresado por parametro.
Se apoya en la funcion adyasentes, a partir de la cual obtiene los vertices a los cuales se puede llegar a partir del vertice actual.
Guarda todos los vertices en un conjunto y luego va sacando uno por uno. Cuando itera los vertices, obtiene los adyasentes del mismo y actualiza (si se tiene un menor costo) la distancia de partir desde el vertice original hasta el vertice en cuesti�n y el padre del mismo hasta que se queda con el conjunto vacio.

#### Nota: Todos los archivos de configuración, ejemplos de entrada y cualquier otro recurso deben ser anexados al proyecto dentro de una carpeta /resources
