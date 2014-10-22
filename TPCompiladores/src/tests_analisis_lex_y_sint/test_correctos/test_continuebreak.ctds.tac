MNAME pruContinue
OPP 1.0 temp1
STR total temp1
STR n 23
STR i 23.0
LBL BI1
CMP i 0.0 temp2
JGE EI2
SUB i 1 temp3
STR i temp3
CMP x b temp4
JL LIF3
CMP i 0.0 temp5
JNE LIF4
MUL total x temp6
MUL temp6 b temp7
STR total temp7
LBL LIF4
JMP BI1
LBL LIF4
OPP 1000.234 temp8
ADD temp8 6752 temp9
STR total temp9
JMP BI2
JMP BI1
LBL EI2
MUL 2 total temp11
OPP temp11 temp10
RET temp10
MNAME main
EXCALL printf
