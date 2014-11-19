MNAME potencia
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
JOR EI3 temp5
MUL prod x temp6
MUL temp6 2.0 temp7
STR prod temp7
ADD i 1 temp8
STR i temp8
JMP BI2
LBL EI3
NOT neg temp10
NOT temp10 temp9
JNOT LIF4
DIV 1.0 prod temp11
RET temp11
LBL LIF4
RET prod
OPP 100.0 temp12
RET temp12
MNAME multRepeat
MUL a a temp13
MUL temp13 b temp14
MUL temp14 b temp15
MUL temp15 b temp16
MUL temp16 a temp17
STR c temp17
RET c
MNAME main
OPP 15.0 temp18
STR res temp18
STR w 4.0
OPP 7.0 temp19
STR m temp19
STR a 80.0
CALL potencia(a,2,) temp20
STR f temp20
EXCALL printf
RET
