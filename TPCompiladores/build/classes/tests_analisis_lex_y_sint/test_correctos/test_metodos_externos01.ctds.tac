MNAME alo
ADD x 1 temp1
STR x temp1
RET x
MNAME alo_2
CALL alo(x,) temp2
ADD temp2 1 temp3
STR x temp3
RET
MNAME main
EXCALL printf
EXCALL printf
EXCALL /home/programas/primer_primo_par
