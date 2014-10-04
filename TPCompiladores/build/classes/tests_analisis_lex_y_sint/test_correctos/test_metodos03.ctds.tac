RET
MUL 3 2 temp1
CMP x temp1 temp2
JG LIF1
DIV x 3 temp3
STR res temp3
LBL LIF1
MOD x 2 temp4
STR res temp4
RET
STR res False
CALL resto(inc(5,),10.0,) temp5
STR A temp5
