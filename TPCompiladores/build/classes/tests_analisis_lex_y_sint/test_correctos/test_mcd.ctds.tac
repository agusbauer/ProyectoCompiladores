LMEM a temp1
LMEM b temp2
CMP temp1 temp2 temp3
JG LIF1
LMEM dividendo temp4
LMEM a temp5
STR temp4 temp5
LMEM divisor temp6
LMEM b temp7
STR temp6 temp7
LBL LIF1
LMEM dividendo temp8
LMEM b temp9
STR temp8 temp9
LMEM divisor temp10
LMEM a temp11
STR temp10 temp11
LMEM resto temp12
LCON 1 temp13
STR temp12 temp13
LBL BI2
LMEM resto temp14
LCON 0 temp15
CMP temp14 temp15 temp16
JNE EI3
LMEM resto temp17
LMEM dividendo temp18
LMEM divisor temp19
MOD temp18 temp19 temp20
STR temp17 temp20
LMEM dividendo temp21
LMEM divisor temp22
STR temp21 temp22
LMEM divisor temp23
LMEM resto temp24
STR temp23 temp24
JMP BI2
LBL EI3
RET
EXCALL null
