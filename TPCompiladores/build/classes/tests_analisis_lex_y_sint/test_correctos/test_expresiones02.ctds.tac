LMEM b temp1
LCON 4 temp2
STR temp1 temp2
LMEM c temp3
LCON 5 temp4
STR temp3 temp4
LMEM a temp5
LMEM b temp6
LMEM c temp7
MUL temp6 temp7 temp8
STR temp5 temp8
LMEM p temp9
LMEM a temp10
LMEM p temp11
ADD temp10 temp11 temp12
STR temp9 temp12
LMEM pi temp13
LCON 3.1 temp14
STR temp13 temp14
LMEM f temp15
LCON 2 temp16
LMEM pi temp17
MUL temp16 temp17 temp18
STR temp15 temp18
LMEM a temp19
LMEM f temp20
DIV temp19 temp20 temp21
LCON 5 temp22
CMP temp21 temp22 temp23
JG LIF1
RET
LBL LIF1
RET
EXCALL null
