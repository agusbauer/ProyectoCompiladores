ProyectoCompiladores
====================

Integrantes:
	Luciano Putruele
	Agustin Bauer
	Alan Gonzalez

Compilacion y ejecucion:

Para correr los tests utilizando el compilador se debe ejecutar el archivo runTests.sh que se encuentra en el directorio src/tests_analisis_lex_y_sint/ 
utilizando el comando "./runTests.sh"

Si se necesita compilar los archivos CTDS.flex y CTDS.cup hay que ir al directorio src/parser y ejecutar los siguientes comandos: 
	para CTDS.cup "java -jar java-cup-11a.jar CTDS.cup"
	para CTDS.flex "java -jar jflex-1.6.0.jar CTDS.flex"


