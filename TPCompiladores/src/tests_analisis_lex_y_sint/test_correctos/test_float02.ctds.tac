STR total 0.0
STR i b
LBL BI1
CMP i 0.0 temp1
CMP i 0.0 temp2
OR temp1 temp2 temp3
JOR EI2 temp3
CMP i 0.0 temp4
JG LIF3
ADD total i temp5
STR total temp5
LBL LIF3
SUB i 1.0 i
JMP BI1
LBL EI2
STR res total
RET res
STR a 8.0
CALL sumatoria(a,) temp6
STR f temp6
EXCALL printf
RET
