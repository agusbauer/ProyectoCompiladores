MNAME par
RET 15
MNAME pruArreglos
STR A 2
RET A
LBL BI1
CALL par() temp1
STR i temp1
CALL par() temp2
ADD temp2 5 temp3
CMP temp1 temp3 temp4
JLE EI2
ADD i 2 temp5
STR A temp5
JMP BI1
LBL EI2
MNAME main
EXCALL printf
RET 1
