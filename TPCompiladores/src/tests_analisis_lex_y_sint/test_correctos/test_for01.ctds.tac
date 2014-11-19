MNAME pruArreglos
STR A 2
RET A
LBL BI1
STR i 5
MUL i 10 temp1
CMP 5 temp1 temp2
JLE EI2
ADD i 2 temp3
STR A temp3
JMP BI1
LBL EI2
MNAME main
EXCALL printf
RET 1
