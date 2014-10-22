MNAME suma
CMP num1 0 temp1
JE LIF1
RET num2
LBL LIF1
CMP num2 0 temp2
JE LIF2
RET num1
LBL LIF2
ADD num1 num2 temp3
RET temp3
MNAME main
EXCALL printf
