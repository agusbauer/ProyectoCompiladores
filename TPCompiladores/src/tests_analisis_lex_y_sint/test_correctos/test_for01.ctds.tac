MNAME pruArreglos
STR A 2
RET A
LBL BI1
STR i0 5 r1
MUL i 10 temp2
CMP 5 temp2 temp3
JLE EI2
ADD i 2 temp4
STR A temp4
JMP BI1
LBL EI2
MNAME main
EXCALL printf
RET 1
