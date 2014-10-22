MNAME prueba
STR b 4
STR c 5
MUL b c temp1
STR a temp1
ADD a p temp2
STR p temp2
STR pi 3.1
MUL 2.0 pi temp3
STR f temp3
DIV a f temp4
CMP temp4 5 temp5
JG LIF1
RET 1
LBL LIF1
RET 0
MNAME main
EXCALL printf
