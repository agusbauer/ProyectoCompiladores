#!/bin/bash

#
#                           ******************                           
#*****************************     test     ****************************************
#**                         ******************                                    **
#**                                                                               **
#**Descripcion : Script que corre los casos de prueba definidos en la carpeta     **
#**              tests. cada test tiene su propio main.                          **
#**                                                                               **
#***********************************************************************************   
echo "*********************************************************************************** "
echo "**                                                                               ** " 
echo "**                            Corriendo casos de prueba . . .                    ** "                
echo "**                                                                               ** "
echo "**                                                                               ** "
echo "*********************************************************************************** "
echo "     " 
echo "     " 

comp="/home/luciano/Desktop/CompiUltimo/ProyectoCompiladores/TPCompiladores/dist/TPCompiladores.jar"
#comp="/home/alan/UNRC/4to_anio/2do_cuatrimestre/Compiladores/Proyecto/ProyectoCompiladores/TPCompiladores/dist/TPCompiladores.jar"

echo "///////////////////////// TESTS CORRECTOS ////////////////////////////////////////" 
files=`ls *.ctds`


for file in $files ; do 
	echo "---------------- Test $file ... -------------------" 
        java -jar $comp $file 
	echo "---------------------------------------------------" 
        echo "  "
        echo "  "
done




exit 0

