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
MUL temp6 2 temp7
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
OPP 2.0 temp11
STR a temp11
OPP 2 temp12
STR b temp12
OPP 3.0 temp13
STR w temp13
OPP 3.0 temp14
STR z temp14
MUL a z temp15
SUB temp15 w temp16
STR m temp16
STR j 0
STR i 0
STR k 0
STR n 5
CMP x y temp17
JG LIF5
CMP m a temp18
JL LIF6
STR res x
LBL LIF6
STR res y
LBL LIF6
LBL BI7
CMP j n temp19
JLE EI8
LBL BI9
CMP i n temp20
JLE EI10
LBL BI11
CMP k n temp21
CMP k n temp22
OR temp21 temp22 temp23
JOR EI12
CMP b 3 temp24
JE LIF13
ADD res 2.0 temp25
STR res temp25
LBL LIF13
DIV 10.0 2.0 temp26
SUB res temp26 temp27
STR res temp27
ADD k 1 k
JMP BI11
LBL EI12
CMP a x temp28
CMP 0.0 x temp29
AND temp28 temp29 temp30
JAND LIF14
MUL 4.0 res temp31
ADD 35.0 temp31 temp32
SUB temp32 498.0 temp33
STR res temp33
LBL LIF14
SUB 3.0 res temp34
SUB temp34 12345.35 temp35
STR res temp35
ADD i 1 temp36
STR i temp36
JMP BI11
LBL EI12
OPP x temp37
MUL res temp37 temp38
MUL 23.0 y temp39
ADD temp38 temp39 temp40
DIV 2.0 4.0 temp41
ADD temp40 temp41 temp42
STR res temp42
ADD j 1 temp43
STR j temp43
JMP BI11
LBL EI12
RET - res
STR a 80.0
OPP 15.0 temp44
STR res temp44
STR w 4.0
OPP 7.0 temp45
STR m temp45
CALL potencia(a,2,) temp46
STR f temp46
EXCALL printf
RET
