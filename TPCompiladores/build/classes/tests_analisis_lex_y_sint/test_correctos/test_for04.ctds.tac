MNAME pruArreglos
STR A 2
RET A
LBL BI1
STR i0 0 r1
OPP 10 temp2
MUL 11 2 temp3
ADD temp2 temp3 temp4
CMP 0 temp4 temp5
JLE EI2
ADD i 2 temp6
STR A temp6
JMP BI1
LBL EI2
MNAME main
EXCALL printf
RET 1
