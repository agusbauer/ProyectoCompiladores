STR aux 0.0
STR i 0
LBL BI1
CMP i n temp1
JL EI2
ADD aux x temp2
STR aux temp2
ADD i 1 temp3
STR i temp3
JMP BI1
LBL EI2
RET aux
EXCALL printf
