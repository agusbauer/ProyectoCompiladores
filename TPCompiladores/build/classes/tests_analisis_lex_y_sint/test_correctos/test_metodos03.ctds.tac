MNAME inc
ADD x 1 temp1
RET temp1
MNAME resto
MUL 3 2 temp2
CMP x temp2 temp3
JG LIF1
DIV x 3 temp4
STR res temp4
LBL LIF1
MOD x 2 temp5
STR res temp5
RET res
MNAME main
STR res False
CALL resto(inc(5,),10.0,) temp6
STR A temp6
