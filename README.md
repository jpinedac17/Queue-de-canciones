# 🎵 Simulación tipo Spotify usando Cola (FIFO) Manual en Java

## 📌 Descripción General

Este proyecto implementa una simulación de reproducción de canciones
similar a Spotify utilizando una **estructura de datos Cola (FIFO)**
desarrollada completamente desde cero en Java.

El sistema está dividido en dos módulos Maven:

-   📦 `umg.edu.gt.data-structure.queue` → Librería con la
    implementación manual de la cola.
-   🎵 `queueHandler` → Proyecto consumidor que utiliza la librería para
    simular la reproducción.

No se utilizan estructuras del JDK como `Queue`, `LinkedList`,
`ArrayDeque` ni `PriorityQueue`.

------------------------------------------------------------------------

# 🧱 Arquitectura del Proyecto

    /umg.edu.gt.data-structure.queue
    /queueHandler

------------------------------------------------------------------------

# ⚙️ Cómo compilar la librería

Ubicarse dentro del proyecto:

    umg.edu.gt.data-structure.queue

Ejecutar:

``` bash
mvn clean package
```

------------------------------------------------------------------------

# 📦 Cómo instalar la librería en local

Para que el proyecto `queueHandler` pueda usar la estructura de datos,
se debe instalar la librería en el repositorio local de Maven:

``` bash
mvn clean install
```

Esto generará el `.jar` e instalará la dependencia en el repositorio
local (`.m2`).

------------------------------------------------------------------------

# 🎵 Cómo compilar el handler

Ubicarse dentro del proyecto:

    queueHandler

Ejecutar:

``` bash
mvn clean package
```

Esto generará un archivo ejecutable:

    target/queueHandler-0.0.1-SNAPSHOT.jar

El jar incluye todas las dependencias necesarias.

------------------------------------------------------------------------

# ▶️ Cómo ejecutar desde consola

Desde la carpeta `queueHandler`, ejecutar:

``` bash
java -jar target/queueHandler-0.0.1-SNAPSHOT.jar
```

El sistema iniciará la simulación mostrando:

-   Inicio de playlist
-   Canción actual
-   Progreso segundo a segundo
-   Finalización de cada canción
-   Resumen total

------------------------------------------------------------------------

# 🧠 Explicación del Diseño

## Librería (Estructura de Datos)

Se implementó una **cola enlazada genérica (`QueueLinked<T>`)**,
compuesta por:

-   Clase `Node<T>`
-   Referencias privadas `head` y `tail`
-   Variable interna `size`

Métodos implementados:

-   `enqueue(T item)` → Inserción en O(1)
-   `dequeue()` → Eliminación en O(1)
-   `peek()`
-   `isEmpty()`
-   `size()`
-   `enqueuePriority(T item)` (extensión para prioridad)

La estructura no recorre la lista para insertar, garantizando eficiencia
constante.

------------------------------------------------------------------------

## Handler (Simulación)

Se creó una clase `Song` con:

-   `title`
-   `artist`
-   `duration` (entre 5 y 30 segundos)
-   `priority`

Se creó una clase controladora que:

-   Maneja las colas
-   Controla el flujo de reproducción
-   Muestra logs
-   Lleva estadísticas

------------------------------------------------------------------------

# 🛠 Decisiones Técnicas

-   Se utilizó arquitectura modular con Maven.
-   Se implementó la estructura de datos manualmente sin usar clases del
    JDK.
-   Se usó una implementación genérica `<T>` para reutilización.
-   Se utilizó `Thread.sleep(1000)` para simular tiempo real.
-   Se generó un **fat jar** usando `maven-shade-plugin` para permitir
    ejecución standalone.

------------------------------------------------------------------------

# 🔥 Cómo se implementó la Prioridad

Se implementó utilizando **dos colas internas**:

-   Cola de prioridad alta
-   Cola de prioridad normal

Reglas:

-   Si existe una canción en la cola de prioridad alta, se reproduce
    primero.
-   Dentro de cada prioridad se respeta FIFO.
-   No se utilizó `PriorityQueue`.

Ejemplo:

Alta:

    A1, A2

Normal:

    N1, N2, N3

Salida:

    A1, A2, N1, N2, N3

------------------------------------------------------------------------

# ⏱ Cómo se manejó la Simulación de Duración

Cada canción tiene una duración variable entre 5 y 30 segundos.

Durante la reproducción:

-   Se muestra el mensaje `[LOG] Now playing`
-   Se ejecuta un ciclo `for`
-   Se utiliza `Thread.sleep(1000)` para simular 1 segundo real
-   Se imprime el progreso segundo a segundo:

```
    Playing... 1s / 14s
    Playing... 2s / 14s
    ...
```

Al finalizar:

    [LOG] Finished: Song X

Al terminar todas:

    [LOG] Playlist finished.

------------------------------------------------------------------------

# 📊 Extensiones Implementadas

-   ✔ Contador total de canciones reproducidas
-   ✔ Tiempo total acumulado reproducido

------------------------------------------------------------------------

# 📸 Evidencias

La carpeta `/evidencias` incluye:

-   Captura de `mvn clean install` en la librería
-   Captura de `mvn clean package` en el handler
-   Ejecución desde consola con `java -jar`
-   Logs mostrando reproducción segundo a segundo
-   Evidencia del sistema de prioridad funcionando
