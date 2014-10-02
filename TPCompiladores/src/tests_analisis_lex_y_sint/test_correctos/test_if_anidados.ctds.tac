LMEM b temp1
LMEM c temp2
CMP temp1 temp2 temp3
JNE LIF1
LMEM b temp4
LMEM c temp5
CMP temp4 temp5 temp6
JG LIF2
LMEM res temp7
LMEM b temp8
LMEM c temp9
SUB temp8 temp9 temp10
STR temp7 temp10
LBL LIF2
LMEM res temp11
LMEM c temp12
LMEM b temp13
SUB temp12 temp13 temp14
STR temp11 temp14
LBL LIF2
LMEM res temp15
LMEM b temp16
LCON 5 temp17
MUL temp16 temp17 temp18
STR temp15 temp18
RET
EXCALL null
EXCALL null
EXCALL null
EXCALL null
