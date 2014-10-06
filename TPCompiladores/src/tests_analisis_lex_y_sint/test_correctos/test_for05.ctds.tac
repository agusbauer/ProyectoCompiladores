RET 15
STR A 2
RET A
LBL BI1
CALL par() temp1
STR i0 temp1 r2
CALL par() temp3
ADD temp3 5 temp4
CMP temp1 temp4 temp5
JLE EI2
ADD i 2 temp6
STR A temp6
JMP BI1
LBL EI2
EXCALL printf
RET 1
