RET
LMEM x temp1
LCON 3 temp2
LCON 2 temp3
MUL temp2 temp3 temp4
CMP temp1 temp4 temp5
JG LIF1
LMEM res temp6
LMEM x temp7
LCON 3 temp8
DIV temp7 temp8 temp9
STR temp6 temp9
LBL LIF1
LMEM res temp10
LMEM x temp11
LCON 2 temp12
MOD temp11 temp12 temp13
STR temp10 temp13
RET
LMEM res temp14
LCON False temp15
STR temp14 temp15
LMEM A temp16
CALL resto(inc(5,),10.0,) temp17
STR temp16 temp17
