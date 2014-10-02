LMEM x temp1
LMEM x temp2
LCON 1 temp3
ADD temp2 temp3 temp4
STR temp1 temp4
RET
CALL alo(x,)
LMEM x temp5
LMEM x temp6
LCON 1 temp7
ADD temp6 temp7 temp8
STR temp5 temp8
RET
LMEM y temp9
LCON 7 temp10
STR temp9 temp10
LMEM c temp11
LCON 8.0 temp12
STR temp11 temp12
LMEM y temp13
CALL alo2(y,) temp14
STR temp13 temp14
LMEM y temp15
CALL alo2(3 * y,) temp16
STR temp15 temp16
RET
