LMEM A temp1
LCON 2 temp2
STR temp1 temp2
RET
LBL BI1
LCON 5 temp3
STR i0 temp3 r4
LMEM i temp5
LCON 10 temp6
MUL temp5 temp6 temp7
LMEM A temp8
LMEM i temp9
LCON 2 temp10
ADD temp9 temp10 temp11
STR temp8 temp11
JMP BI1
LBL EI2
EXCALL null
RET
