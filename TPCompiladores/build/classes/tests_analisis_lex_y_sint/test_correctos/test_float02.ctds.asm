
sumatoria:
MOV $0.0, %eax
MOV %eax, -4(%ebp)
MOV -0(%ebp), %eax
MOV %eax, -0(%ebp)
BI1:
MOV -8(%ebp), %eax
CMP $0.0, %eax
JG SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -24(%ebp)
MOV -8(%ebp), %eax
CMP $0.0, %eax
JG SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -28(%ebp)
MOV -24(%ebp), %eax
MOV -28(%ebp), %edx
OR %edx, %eax
MOV  %eax, -32(%ebp)
MOV -32(%ebp), %eax
CMP %eax, $1
JE EI2
MOV -8(%ebp), %eax
CMP $0.0, %eax
JG SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -36(%ebp)
JG LIF3
MOV -4(%ebp), %eax
MOV -8(%ebp), %edx
ADD %edx, %eax
MOV  %eax, -40(%ebp)
MOV -40(%ebp), %eax
MOV %eax, -40(%ebp)
LIF3:
MOV -8(%ebp), %eax
SUB $1.0, %eax
MOV  %eax, -8(%ebp)
JMP BI1
EI2:
MOV -4(%ebp), %eax
MOV %eax, -4(%ebp)
leave
ret
main:
MOV $8.0, %eax
MOV %eax, -20(%ebp)
CALL sumatoria
MOV  %eax, -44(%ebp)
MOV -44(%ebp), %eax
MOV %eax, -44(%ebp)
CALL printf
leave
ret

