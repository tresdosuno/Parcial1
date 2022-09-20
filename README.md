# Parcial 1
### Autor: Juan López
&nbsp;

## Git
* Este proyecto es una versión del juego Nanogramo, lo realizó un amigo mío y se encuentra en un repositorio de GitHub. ([Nanogramo](https://github.com/edisonlunagutierrez/Nonograma))
* ![](fotos/originalrepo.png)
* Lo que se hizo fue crear una carpeta en el PC local, sobre la cual se clonó el repositorio con el siguiente comando: 
* ![](fotos/gitclone.png)
* Una vez clonado el repositorio de tal forma que esté guardado en una carpeta local, se crea este README junto con una carpeta con fotos para completar este archivo.
* Los añadimos con los comandos ```git add .```, y realizamos el primer commit con ```git commit -m "Se añade README y la carpeta de fotos."```.
* ![](fotos/primercommit.png)
&nbsp;

## CraftsmanShip
* En esta sección vamos a ver si se implementan o no las buenas prácticas vistas en clase. Verificamos si los principios SOLID están siendo utilizados en el proyecto, los patrones GoF, etc.
* SOLID:
    * S (Single responsibility principle): 
        * El programa en general aplica bastante bien este principio, pues no hay ninguna clase que tenga más de una responsabilidad. Sin embargo, considero que en la clase InterfazApp su constructor debería estar más organizado. 
        * ![](fotos/constructorInterfazApp.png)
        * En este constructor se debería ejecutar un método distinto para cada parte de la interfaz. Uno para el PanelVidas, otro para cada PanelPistas y un último para el PanelGrilla.

    * O (Open for extension, closed for modification principle):
        * Hay varios ejemplos de cómo no se aplica este principio en este proyecto, en otras palabras, varias instancias en la que no se toma en cuenta la posibilidad de extender a futuro este aplicativo. Uno de estos es el siguiente: 
        * ![](fotos/oPrincipleExample1.png)
        * Aquí vemos que el programa tiene la función de leer partidas previas, sin embargo, está pensado solo para abrir un archivo específico guardado en un directorio local del PC del creador de la aplicación. 
        * Se debería crear la opción de que el usuario escoja el archivo a abrir desde el explorador de archivos.
        * También vemos en la clase PanelGrilla que está creada para tener un tamaño específico, sin embargo, si en el futuro se busca tener modos donde el tablero es más pequeño o más grande, tendríamos que modificar esta clase:
        * ![](fotos/oPrincipleExample2.png)
        * Para solucionar esto tendríamos que convertir esta clase en una clase padre y cambiar el tamaño a ser variable, para así, si llega la ocasión de necesitar tableros de tamaños distintos, hay que crear nuevas clases hijas de esta donde el tamaño cambia.

    *  D (Dependency inversion):
        * En este proyecto tenemos ejemplos claros de cómo sí y, a su vez, no aplicar este principio apropiadamente. En primer lugar, tenemos nuevamente la clase PanelGrilla donde se usan los objetos como argumentos del constructor en lugar de crear nuevas instancias ahí, causando alto acoplamiento:
        * ![](fotos/dPrincipleExample1.png)
        * Y tenemos la clase Controlador en la que no se aplica este principio. Aquí se hace instancia de los objetos LoadNono y Nonograma dentro del constructor de la clase. 
        * ![](fotos/dPrincipleExample2.png)
        * Para corregirlo hay que poner estos objetos como argumentos del constructor. 