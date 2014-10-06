STR g 50
CMP g 0 temp1
JG LIF1
STR a 4
CMP a 4 temp2
JE LIF2
LBL BI3
CMP a 4 temp3
JL EI4
LBL BI5
CMP g 4 temp4
JG EI6
SUB g 1 temp5
STR g temp5
MUL a 2 temp6
STR c temp6
JMP BI5
LBL EI6
ADD a 1 temp7
STR a temp7
DIV c 2 temp8
STR c temp8
JMP BI5
LBL EI6
LBL LIF6
LBL LIF6
RET c
EXCALL printf
