STR A 2
RET
LBL BI1
STR i0 0 r1
OPP 10 temp2
MUL 11 2 temp3
ADD temp2 temp3 temp4
ADD i 2 temp5
STR A temp5
JMP BI1
LBL EI2
EXCALL null
RET
