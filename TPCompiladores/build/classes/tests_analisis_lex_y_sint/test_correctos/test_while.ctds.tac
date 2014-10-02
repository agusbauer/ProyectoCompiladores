LMEM resto temp1
LCON 1 temp2
STR temp1 temp2
LBL BI1
LMEM resto temp3
LCON 0 temp4
CMP temp3 temp4 temp5
JNE EI2
LMEM resto temp6
LMEM dividendo temp7
LMEM divisor temp8
MOD temp7 temp8 temp9
ADD temp6 temp9 temp6
LMEM dividendo temp10
LMEM divisor temp11
SUB temp10 temp11 temp10
JMP BI1
JMP BI1
LBL EI2
LBL BI3
LMEM resto temp12
LCON 0 temp13
CMP temp12 temp13 temp14
JNE EI4
JMP BI4
JMP BI3
LBL EI4
LBL BI5
LMEM resto temp15
LCON 0 temp16
CMP temp15 temp16 temp17
JNE EI6
JMP BI5
LBL EI6
RET
EXCALL null
