JNOT LIF1
ADD x 1 temp1
STR x temp1
LBL LIF1
SUB x 1 temp2
STR x temp2
RET
RET
CALL alo(True,x,)
ADD x 1 temp3
STR x temp3
RET x
STR y 7
STR c 8.0
CALL alo2(y,) temp4
STR y temp4
CALL alo(False,3 * y,)
RET
