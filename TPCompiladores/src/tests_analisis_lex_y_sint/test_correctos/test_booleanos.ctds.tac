RET
RET
RET
LMEM a temp1
LCON True temp2
STR temp1 temp2
LMEM b temp3
LCON False temp4
STR temp3 temp4
LMEM b temp5
CALL neg(a,) temp6
STR temp5 temp6
LMEM c temp7
CALL or(and(a,b,),neg(b,),) temp8
STR temp7 temp8
EXCALL null
