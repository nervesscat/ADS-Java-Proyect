# ADS Java Application

- **Name:** Marlon Enrique Avila Madrid
- **Account Number:** 20211021353
- **Classname:** Algorithms and Data Structures

# Screenshots

![screenshot of a console](https://i.ibb.co/jhp2dct/image.png)
![screenshot of a console](https://i.ibb.co/gV3hjVy/image.png)
![](https://i.ibb.co/6BXc9Ff/image.png)


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
