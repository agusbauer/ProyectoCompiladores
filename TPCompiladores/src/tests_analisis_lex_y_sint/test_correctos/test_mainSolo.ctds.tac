LMEM a temp1
LCON True temp2
STR temp1 temp2
LMEM b temp3
LMEM a temp5
OPP temp5 temp4
STR temp3 temp4
LMEM c temp6
LMEM a temp7
LMEM b temp8
AND temp7 temp8 temp9
LMEM b temp11
OPP temp11 temp10
OR temp9 temp10 temp12
STR temp6 temp12
EXCALL null
