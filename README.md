El diseño de clases está hecho para que el sistema sea configurado por base, de esta forma es más fácil la modificación, especialmente de los valores de los tipos de alquiler o las promociones. 
El diseño permite que un cliente alquile todos las bicicletas que quiera y cada una puede tener un tipo de alquiler distinto.
En caso de que sea un alquiler con Promoción se valida que la cantidad de bicicletas seleccionadas este dentro de los parámetros de configuración.

Los únicos datos que quedan fijos en el sistema son el tipo de renta, para poder hacer los cálculos de cantidad de períodos. El resto de los datos de configuración, valores de renta y promociones se almacenan en la base.

La implementación está hecha con Spring-Boot, lo cual permite de manera mas facil y rapida tener un sistema funcional.

Para correr los test se debe ejecutar la clase AppTest.java
