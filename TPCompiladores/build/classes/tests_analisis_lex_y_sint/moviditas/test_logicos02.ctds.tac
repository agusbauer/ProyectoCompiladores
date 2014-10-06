CMP nota1 nota3 temp1
CMP nota2 nota3 temp2
AND temp1 temp2 temp3
JAND LIF1
RET nota1 + nota2 / 2.0
LBL LIF1
CMP nota1 nota2 temp4
CMP nota3 nota2 temp5
AND temp4 temp5 temp6
JAND LIF2
RET nota1 + nota3 / 2.0
LBL LIF2
CMP nota2 nota1 temp7
CMP nota3 nota1 temp8
AND temp7 temp8 temp9
JAND LIF3
RET nota3 + nota2 / 2.0
LBL LIF3
CMP nota1 nota2 temp10
CMP nota1 nota3 temp11
AND temp10 temp11 temp12
CMP nota2 nota3 temp13
AND temp12 temp13 temp14
JAND LIF4
RET nota1
LBL LIF4
EXCALL printf
RET 1
