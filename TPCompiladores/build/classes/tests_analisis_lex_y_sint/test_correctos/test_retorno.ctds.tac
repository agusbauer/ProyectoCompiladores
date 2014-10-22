MNAME id
STR i 100
STR j 0
STR z x
LBL BI1
CMP j i temp1
JL EI2
STR i x
LBL BI3
CMP x 0 temp2
CMP x 0 temp3
OR temp2 temp3 temp4
JOR EI4 temp4
CMP x 0 temp5
JG LIF5
SUB x 1 temp6
STR x temp6
LBL LIF5
ADD x 1 temp7
STR x temp7
JMP BI3
LBL EI4
LBL BI6
CMP x i temp8
CMP x i temp9
OR temp8 temp9 temp10
JOR EI7 temp10
CMP x i temp11
JL LIF8
ADD x 1 temp12
STR x temp12
LBL LIF8
CMP x x temp13
JE LIF9
SUB x 1 temp14
MUL j x temp15
MUL j x temp16
SUB temp15 temp16 temp17
ADD temp14 temp17 temp18
STR x temp18
LBL LIF9
JMP BI6
LBL EI7
STR x z
ADD j 1 temp19
STR j temp19
JMP BI6
LBL EI7
RET x
MNAME main
EXCALL printf
