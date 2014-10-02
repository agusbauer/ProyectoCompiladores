LMEM i temp1
LCON 0 temp2
STR temp1 temp2
LBL BI1
LMEM i temp3
LCON 10 temp4
CMP temp3 temp4 temp5
JL EI2
LMEM i temp6
LMEM i temp7
LCON 1 temp8
ADD temp7 temp8 temp9
STR temp6 temp9
LMEM g temp10
LCON 0 temp11
CMP temp10 temp11 temp12
JL LIF3
JMP BI2
LBL LIF3
JMP BI1
JMP BI1
LBL EI2
RET
EXCALL null
RET
