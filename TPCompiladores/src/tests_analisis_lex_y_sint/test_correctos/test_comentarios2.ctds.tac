MNAME pruAritmetica
CMP b c temp1
JG LIF1
STR res b
LBL LIF1
STR res c
RET res
MNAME main
EXCALL printf
