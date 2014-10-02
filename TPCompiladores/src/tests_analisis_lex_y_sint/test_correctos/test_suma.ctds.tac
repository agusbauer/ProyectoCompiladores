LMEM num1 temp1
LCON 0 temp2
CMP temp1 temp2 temp3
JE LIF1
RET
LBL LIF1
LMEM num2 temp4
LCON 0 temp5
CMP temp4 temp5 temp6
JE LIF2
RET
LBL LIF2
RET
EXCALL null
