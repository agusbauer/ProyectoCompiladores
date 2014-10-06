STR neg False
STR i 1
STR prod 1.0
CMP n 0 temp1
JL LIF1
OPP n temp2
STR n temp2
STR neg True
LBL LIF1
LBL BI2
CMP i n temp3
CMP i n temp4
OR temp3 temp4 temp5
JOR EI3
MUL prod x temp6
MUL temp6 2.0 temp7
STR prod temp7
ADD i 1 temp8
STR i temp8
JMP BI2
LBL EI3
OPP neg temp10
OPP temp10 temp9
JNOT LIF4
RET 1.0 / prod
LBL LIF4
RET prod
RET - 100.0
MUL a a temp11
MUL temp11 b temp12
MUL temp12 b temp13
MUL temp13 b temp14
MUL temp14 a temp15
STR c temp15
RET c
OPP 15.0 temp16
STR res temp16
STR w 4.0
OPP 7.0 temp17
STR m temp17
STR a 80.0
CALL potencia(a,2,) temp18
STR f temp18
EXCALL printf
RET
