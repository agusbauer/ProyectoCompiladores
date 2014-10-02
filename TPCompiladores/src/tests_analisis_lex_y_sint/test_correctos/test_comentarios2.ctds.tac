LMEM b temp1
LMEM c temp2
CMP temp1 temp2 temp3
JG LIF1
LMEM res temp4
LMEM b temp5
STR temp4 temp5
LBL LIF1
LMEM res temp6
LMEM c temp7
STR temp6 temp7
RET
EXCALL null
