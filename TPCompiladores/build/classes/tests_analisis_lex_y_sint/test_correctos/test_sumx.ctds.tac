LMEM aux temp1
LCON 0 temp2
STR temp1 temp2
LMEM i temp3
LCON 0 temp4
STR temp3 temp4
LBL BI1
LMEM i temp5
LMEM n temp6
CMP temp5 temp6 temp7
JL EI2
LMEM aux temp8
LMEM aux temp9
LMEM x temp10
ADD temp9 temp10 temp11
STR temp8 temp11
LMEM i temp12
LMEM i temp13
LCON 1 temp14
ADD temp13 temp14 temp15
STR temp12 temp15
JMP BI1
LBL EI2
RET
EXCALL null
