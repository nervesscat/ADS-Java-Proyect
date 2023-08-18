# ADS Java Application

- **Name:** Marlon Enrique Avila Madrid
- **Account Number:** 20211021353
- **Classname:** Algorithms and Data Structures

# Aclaración

El ADS-Java-Proyect.jar es para java 17 (openjdk 17) y el prueba.jar es para java 20

# Screenshots

![screenshot of a console](https://i.ibb.co/jhp2dct/image.png)
![screenshot of a console](https://i.ibb.co/gV3hjVy/image.png)
![screenshot of a console](https://i.ibb.co/6BXc9Ff/image.png)


# Requirements

Una vez ejecutado su sistema mediante una consola de Linux, este deberá mostrar en la terminal la siguiente información. Todos los comandos funcionan, reciben y muestran información en la misma terminal.

- Poseer un mensaje propio, único y original de bienvenida. 

- Cada comando que se ejecuta en la terminal deberá ser guardado en una representación de lista permanente en disco, donde se pueda convertir esta representación nuevamente en una lista en memoria de ejecución, como memoria persistente utilizable cuando se vuelva a ejecutar el programa, de acuerdo con lo aprendido en esta asignatura. 

- Su sistema de simulación debe ser persistente y no debe finalizar hasta el que usuario lo indique mediante un comando de salida.

Su sistema deberá incluir los siguientes comandos:

- exit: permite finalizar el programa.

- author: imprime la información del autor del sistema. Debe incluir nombre, correo institucional, número de cuenta, periodo académico , asignatura y docente.

- version: imprime la versión y fecha del sistema.

- welcome: imprime nuevamente el mensaje de bienvenida.

- history: imprime el contenido del histórico de comandos generados en la consola. El historial de comandos es persistente de acuerdo con lo descrito anteriormente.

- linkedlist: imprime el contenido de una LinkedList global dentro de la consola. Esta estructura de datos debe ser permanente, similar al historial.

- tree: imprime el contenido de un Tree basado en un BST, global dentro de la consola. Esta estructura de datos debe ser permanente, similar al historial. El árbol se debe imprimir con tabulados y saltos de línea.

- graph: imprime el contenido de un Graph basado en estructuras MAP, global dentro de la consola. Esta estructura de datos debe ser permanente, similar al historial. El grafo se debe imprimir con tabulados y saltos de línea.

Su sistema deberá incluir los siguientes sub-comandos:

## LinkedList

- linkedlist push <values>: agrega un valor a la lista enlazada. El valor a agregar puede ser uno o múltiples elementos separados por comas. Eg. linkedlist push 1,2,3,4,5,6,7

- linkedlist pop position <value>: elimina el valor de una posición de la lista.

- linkedlist pop value <value>: elimina el elemento que coincide con el valor entregado.

- linkedlist order quicksort asc: imprime la lista enlazada con valores ordenados ascendentemente, usando el algoritmo en mención.

- linkedlist order quicksort desc: imprime la lista enlazada con valores ordenados descendentemente, usando el algoritmo en mención.

- linkedlist order mergesort asc: imprime la lista enlazada con valores ordenados ascendentemente, usando el algoritmo en mención.

- linkedlist order mergesort desc: imprime la lista enlazada con valores ordenados descendentemente, usando el algoritmo en mención.

## Tree

- tree push <values>: agrega el valor en el árbol. El valor a agregar puede ser uno o múltiples elementos separados por comas. E.g. tree push 2,25,6,89

- tree remove <value>: elimina el valor del árbol sin eliminar los hijos de dicho valor eliminado. El árbol se debe volver a ordenar.

- tree greatest: imprime el mayor valor guardado en el árbol.

- tree smallest: imprime el menor valor guardado en el árbol.

- tree height: imprime la altura del árbol.

- tree external: imprime los nodos externos del árbol.

## Graph

- graph push vertex <value>: agrega un vértice al árbol.

- graph push edge <valueOrigin> <valueDestination> <weight>: agrega una arista entre los vértices. Si el vértice origen no existe entonces lo crea. Si el vértice destino no existe entonces lo crea.

## Misc

El sistema debe poseer, cuatro archivos de memoria en donde se leen y se escriben los valores entre sesiones. Las extensiones de estos archivos dependen de las iniciales del nombre del estudiante (e.g. Linus Torvalds -> lt). Una sesión es la acción de iniciar y finalizar su programa de simulación de consola.

- History: guarda la representación serializada de la lista de comandos ejecutados.

- LinkedList: guarda la representación serializada de la lista enlazada del comando LinkedList.

- BSTTree: guarda la representación serializada del árbol del comando Tree. 

- Graph: guarda la representación serializada del grafo del comando Graph.

# Implementación

## LinkedList

- linkedlist push <values>: agrega un valor a la lista enlazada. El valor a agregar puede ser uno o múltiples elementos separados por comas. Eg. linkedlist push 1,2,3,4,5,6,7

Si se encuentran varios valores separados por comas, se agregan a la lista enlazada iterando el proceso, usando split e iterator entonces:

```java
String[] pushItems = values.split(",");
    for (String value : pushItems) {
    linkedList.add(Integer.parseInt(value));
    }
```

- linkedlist pop position <value>: elimina el valor de una posición de la lista.

Para eliminar un valor de una posición de la lista, usamos el método remove de la clase LinkedList de la siguiente forma:

```java
linkedList.remove(Integer.parseInt(key[4]));
```

Donde key[4] es el valor de la posición a eliminar.

- linkedlist pop value <value>: elimina el elemento que coincide con el valor entregado.

Para eliminar un valor de la lista, usamos el método remove de la clase LinkedList de la siguiente forma:

```java
linkedList.remove(Integer.parseInt(key[3]));
```

Donde key[3] es el valor a eliminar.

- linkedlist order quicksort asc: imprime la lista enlazada con valores ordenados ascendentemente, usando el algoritmo en mención.

Para ordenar la lista enlazada, usamos el método quicksort de la clase LinkedList de la siguiente forma:

```java
list.quickSortAsc();
System.out.println(list);
```

- linkedlist order quicksort desc: imprime la lista enlazada con valores ordenados descendentemente, usando el algoritmo en mención.

```java
list.quickSortDesc();
System.out.println(list);
```

La diferencia entre quickSort y quickSortDesc es que ambos usan el mismo método de ordenamiento (que es ascendente) pero quickSortDesc invierte la lista enlazada al final.

- linkedlist order mergesort asc: imprime la lista enlazada con valores ordenados ascendentemente, usando el algoritmo en mención.

Para ordenar la lista enlazada, usamos el método mergeSort de la clase LinkedList de la siguiente forma:

```java
list.mergeSortAsc();
System.out.println(list);
```

- linkedlist order mergesort desc: imprime la lista enlazada con valores ordenados descendentemente, usando el algoritmo en mención.

```java
list.mergeSortDesc();
System.out.println(list);
```

### Quick Sort

Tenemos que usar un algoritmo recursivo que se llama quicksort, el cual es un algoritmo de ordenamiento muy eficiente y de complejidad O(n log n). El algoritmo consiste en lo siguiente:

1. Elegir un elemento de la lista de elementos a ordenar, al que llamaremos pivote. (El pivot es el último elemento de la lista)

2. Resituar los demás elementos de la lista a cada lado del pivote, de manera que a un lado queden todos los menores que él, y al otro los mayores. Los elementos iguales al pivote pueden ser colocados tanto a su derecha como a su izquierda, dependiendo de la implementación deseada. En este momento, el pivote ocupa exactamente el lugar que le corresponderá en la lista ordenada.

3. La lista queda separada en dos sublistas, una formada por los elementos a la izquierda del pivote, y otra por los elementos a su derecha.

4. Repetir este proceso de forma recursiva para cada sublista mientras éstas contengan más de un elemento. Una vez terminado este proceso todos los elementos estarán ordenados.

Este algoritmo es recursivo, por lo que se debe llamar a si mismo para ordenar las sublistas. El caso base de la recursión es cuando se tiene una lista de un solo elemento, en cuyo caso no se hace nada.

Con esto el usuario podrá imprimir la lista enlazada ordenada ascendentemente o descendentemente.

### Merge Sort

El algoritmo de ordenamiento por mezcla o merge sort es un algoritmo de divide y vencerás. Fue inventado por John von Neumann en 1945. Consiste en dividir el problema en subproblemas de menor tamaño, de forma recursiva, hasta llegar a problemas de un tamaño suficientemente pequeño que pueden resolverse trivialmente. A partir de ahí, se recombina la solución de cada subproblema hasta obtener la solución al problema inicial.

El algoritmo consta de dos procesos principales:

1. Dividir: el proceso de dividir consiste en tomar la lista a ordenar de tamaño n y dividirlo en dos listas de tamaño n/2, cada una de estas listas se divide a su vez en dos listas más pequeñas y así sucesivamente, hasta llegar a tener n listas de tamaño 1.

2. Mezclar: en este proceso se toman las listas de tamaño 1 y se mezclan entre ellas dos a dos, de forma que se creen listas de tamaño 2, las cuales se mezclan con otras dos listas de tamaño 2 para crear listas de tamaño 4 y así sucesivamente, hasta obtener una única lista ordenada.

Con esto el usuario podrá imprimir la lista enlazada ordenada ascendentemente o descendentemente.

## Tree 

- tree push <values>: agrega el valor en el árbol. El valor a agregar puede ser uno o múltiples elementos separados por comas. E.g. tree push 2,25,6,89

Repitiendo el proceso que hicimos con el linkedlist, lo hacemos para el tree:

```java
String[] pushItems = values.split(",");
    for (String value : pushItems) {
    map.add(Integer.parseInt(value));
    }
```

## Graph

Usando JSON y otras clases creadas anteriormente.

- graph push vertex : agrega un vértice al árbol.

Facilmente vemos que cuando el usuario ingrese este método, agregamos el 4rto elemento del comando a addVertex de la siguiente forma:

```java
    graph.addVertex(key[3])
```

- graph push edge <valueOrigin> <valueDestination> <weight>: agrega una arista entre los vértices. Si el vértice origen no existe entonces lo crea. Si el vértice destino no existe entonces lo crea.

Aca usamos el método addEdge que nos ofrece la clase graph de la siguiente forma:

```java
    graph.addEdge(key[3], key[4], Double.parseDouble(key[5]));
```

Donde key[3] el vertice inicial o source, key[4] el endpoint y key[5] que es el peso y tiene que ser convertido de String a double.
