MNAME promedio
CMP nota1 nota3 temp1
CMP nota2 nota3 temp2
AND temp1 temp2 temp3
JAND LIF1 temp3
ADD nota1 nota2 temp4
DIV temp4 2.0 temp5
RET temp5
LBL LIF1
CMP nota1 nota2 temp6
CMP nota3 nota2 temp7
AND temp6 temp7 temp8
JAND LIF2 temp8
ADD nota1 nota3 temp9
DIV temp9 2.0 temp10
RET temp10
LBL LIF2
CMP nota2 nota1 temp11
CMP nota3 nota1 temp12
AND temp11 temp12 temp13
JAND LIF3 temp13
ADD nota3 nota2 temp14
DIV temp14 2.0 temp15
RET temp15
LBL LIF3
CMP nota1 nota2 temp16
CMP nota1 nota3 temp17
AND temp16 temp17 temp18
CMP nota2 nota3 temp19
AND temp18 temp19 temp20
JAND LIF4 temp20
RET nota1
LBL LIF4
MNAME main
EXCALL printf
RET 1
