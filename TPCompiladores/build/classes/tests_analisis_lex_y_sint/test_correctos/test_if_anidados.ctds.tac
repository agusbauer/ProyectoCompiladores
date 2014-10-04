CMP b c temp1
JNE LIF1
CMP b c temp2
JG LIF2
SUB b c temp3
STR res temp3
LBL LIF2
SUB c b temp4
STR res temp4
LBL LIF2
MUL b 5 temp5
STR res temp5
RET
EXCALL null
EXCALL null
EXCALL null
EXCALL null
