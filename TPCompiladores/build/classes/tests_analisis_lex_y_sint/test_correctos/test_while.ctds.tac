STR resto 1
LBL BI1
CMP resto 0 temp1
JNE EI2
MOD dividendo divisor temp2
ADD resto temp2 resto
SUB dividendo divisor dividendo
JMP BI1
JMP BI1
LBL EI2
LBL BI3
CMP resto 0 temp3
JNE EI4
JMP BI4
JMP BI3
LBL EI4
LBL BI5
CMP resto 0 temp4
JNE EI6
JMP BI5
LBL EI6
RET
EXCALL null
