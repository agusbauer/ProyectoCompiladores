LMEM A temp1
LCON 2 temp2
STR temp1 temp2
RET
LBL BI1
LCON 5 temp3
STR i0 temp3 r4
LCON 10 temp6
OPP temp6 temp5
JNOT EI2
LMEM A temp7
LMEM i temp8
LCON 2 temp9
ADD temp8 temp9 temp10
STR temp7 temp10
JMP BI1
LBL EI2
EXCALL null
RET
