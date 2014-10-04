ADD x 1 temp1
STR x temp1
RET
CALL alo(x,)
ADD x 1 temp2
STR x temp2
RET
STR y 7
STR c 8.0
CALL alo2(y,) temp3
STR y temp3
CALL alo2(3 * y,) temp4
STR y temp4
RET
