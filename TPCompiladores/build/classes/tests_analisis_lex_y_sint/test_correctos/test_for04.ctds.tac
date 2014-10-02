LMEM A temp1
LCON 2 temp2
STR temp1 temp2
RET
LBL BI1
LCON 0 temp3
STR i0 temp3 r4
LCON 10 temp6
OPP temp6 temp5
LCON 11 temp7
LCON 2 temp8
MUL temp7 temp8 temp9
ADD temp5 temp9 temp10
LMEM A temp11
LMEM i temp12
LCON 2 temp13
ADD temp12 temp13 temp14
STR temp11 temp14
JMP BI1
LBL EI2
EXCALL null
RET
