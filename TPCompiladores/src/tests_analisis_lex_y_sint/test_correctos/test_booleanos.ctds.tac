RET ! b
RET a && b
RET a || b
STR a True
STR b False
CALL neg(a,) temp1
STR b temp1
CALL or(and(a,b,),neg(b,),) temp2
STR c temp2
EXCALL null
