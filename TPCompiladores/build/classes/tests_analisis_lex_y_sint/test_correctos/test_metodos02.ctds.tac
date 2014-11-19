MNAME alo
JNOT LIF1
ADD x 1 temp1
STR x temp1
LBL LIF1
SUB x 1 temp2
STR x temp2
RET
MNAME Alo
RET
MNAME alo2
CALL alo(True,x,) temp3
ADD x 1 temp4
STR x temp4
RET x
MNAME main
STR y 7
STR c 8.0
CALL alo2(y,) temp5
STR y temp5
CALL alo(False,3 * y,) temp6
RET
