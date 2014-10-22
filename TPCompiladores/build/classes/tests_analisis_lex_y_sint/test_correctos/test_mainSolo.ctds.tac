MNAME main
STR a True
NOT a temp1
STR b temp1
AND a b temp2
NOT b temp3
OR temp2 temp3 temp4
STR c temp4
EXCALL printf
