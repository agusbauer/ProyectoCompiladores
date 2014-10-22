MNAME pruMult
STR a 5
STR d 2000
MUL a 1000 temp1
MUL temp1 c temp2
MUL temp2 d temp3
RET temp3
MNAME main
EXCALL printf
