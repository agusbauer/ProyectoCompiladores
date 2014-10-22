MNAME maxcomdiv
CMP a b temp1
JG LIF1
STR dividendo a
STR divisor b
LBL LIF1
STR dividendo b
STR divisor a
STR resto 1
LBL BI2
CMP resto 0 temp2
JNE EI3
MOD dividendo divisor temp3
STR resto temp3
STR dividendo divisor
STR divisor resto
JMP BI2
LBL EI3
RET dividendo
MNAME main
STR a 3
EXCALL printf
