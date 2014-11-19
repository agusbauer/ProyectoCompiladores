MNAME alo
ADD x 1 temp1
STR x temp1
RET
MNAME alo2
CALL alo(x,) temp2
ADD x 1 temp3
STR x temp3
RET x
MNAME main
STR y 7
STR c 8.0
CALL alo2(y,) temp4
STR y temp4
CALL alo2(3 * y,) temp5
STR y temp5
RET
