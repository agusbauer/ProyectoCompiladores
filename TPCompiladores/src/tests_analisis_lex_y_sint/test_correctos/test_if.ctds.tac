CMP b c temp1
JG LIF1
SUB b c temp2
STR res temp2
LBL LIF1
CMP b c temp3
JE LIF2
MUL b 5 temp4
STR res temp4
LBL LIF2
SUB c b temp5
STR res temp5
RET res
EXCALL printf
EXCALL printf
EXCALL printf
EXCALL printf
