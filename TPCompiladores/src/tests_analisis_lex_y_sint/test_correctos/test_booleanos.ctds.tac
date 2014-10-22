MNAME neg
NOT b temp1
RET temp1
MNAME and
AND a b temp2
RET temp2
MNAME or
OR a b temp3
RET temp3
MNAME main
STR a True
STR b False
CALL neg(a,) temp4
STR b temp4
CALL or(and(a,b,a,),neg(b,),) temp5
STR c temp5
EXCALL printf
