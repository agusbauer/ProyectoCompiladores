CMP d1 6 temp2
CMP d2 6 temp4
CMP d3 6 temp6
OPP temp6 temp5
AND temp4 temp5 temp7
OPP temp7 temp3
AND temp2 temp3 temp8
OPP temp8 temp1
JNOT LIF1
RET 1.0
LBL LIF1
CMP d1 6 temp9
CMP d2 6 temp11
CMP d3 6 temp13
OPP temp13 temp12
AND temp11 temp12 temp14
OPP temp14 temp10
AND temp9 temp10 temp15
CMP d1 6 temp17
CMP d2 6 temp18
AND temp17 temp18 temp19
CMP d3 6 temp21
OPP temp21 temp20
AND temp19 temp20 temp22
OPP temp22 temp16
OR temp15 temp16 temp23
CMP d1 6 temp25
CMP d2 6 temp27
CMP d3 6 temp28
AND temp27 temp28 temp29
OPP temp29 temp26
AND temp25 temp26 temp30
OPP temp30 temp24
OR temp23 temp24 temp31
JOR LIF2
RET 4.0
LBL LIF2
CMP d1 6 temp32
CMP d2 6 temp33
AND temp32 temp33 temp34
CMP d3 6 temp36
OPP temp36 temp35
AND temp34 temp35 temp37
CMP d1 6 temp38
CMP d2 6 temp40
CMP d3 6 temp41
AND temp40 temp41 temp42
OPP temp42 temp39
AND temp38 temp39 temp43
OR temp37 temp43 temp44
CMP d1 6 temp46
CMP d2 6 temp47
AND temp46 temp47 temp48
CMP d3 6 temp49
AND temp48 temp49 temp50
OPP temp50 temp45
OR temp44 temp45 temp51
JOR LIF3
RET 8.5
LBL LIF3
CMP d1 6 temp52
CMP d2 6 temp53
AND temp52 temp53 temp54
CMP d3 6 temp55
AND temp54 temp55 temp56
JAND LIF4
RET 10.0
LBL LIF4
EXCALL printf
