[1]: https://raw.githubusercontent.com/ftrianakast/s4n/master/specs/uml.png

## Herramientas

El programa fue resuelto con __Java 8__. En algunas partes del programa se utilizan __Optionals__ y __expresiones lambda__.

## ¿Cómo ejecutarlo?

La clase __Launcher__ tiene un main que ejecuta el programa.

## Diagrama de clases

El siguiente diagrama representa las clases relevantes del problema. Los __assemblers__, no se incluyen, porque son utilidades para construir el mapa a partir de los datos suministrados en los dos archivos. Los __Sensores__ fueron implementados como __Observadores__. Uno de los muchos posibles __Observables__ por ejemplo es el __Robot__ que es observado por el __Mine Detector__, y se actualiza cada vez que el robot intenta moverse.

 ![Alt text][1]
