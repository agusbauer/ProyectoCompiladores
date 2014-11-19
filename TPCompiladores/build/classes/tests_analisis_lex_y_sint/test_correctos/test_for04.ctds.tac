MNAME pruArreglos
STR A 2
RET A
LBL BI1
STR i 0
OPP 10 temp1
MUL 11 2 temp2
ADD temp1 temp2 temp3
CMP 0 temp3 temp4
JLE EI2
ADD i 2 temp5
STR A temp5
JMP BI1
LBL EI2
MNAME main
EXCALL printf
RET 1
