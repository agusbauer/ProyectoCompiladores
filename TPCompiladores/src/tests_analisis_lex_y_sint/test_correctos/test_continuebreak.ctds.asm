
pruContinue:
MOV 1.0, %eax
NOT  %eax
MOV  %eax, -16(%ebp)
MOV -16(%ebp), %eax
MOV %eax, -12(%ebp)
MOV $23, %eax
MOV %eax, -8(%ebp)
MOV $23.0, %eax
MOV %eax, -4(%ebp)
BI1:
MOV -4(%ebp), %eax
CMP $0.0, %eax
JGE SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -20(%ebp)
JGE EI2
MOV -4(%ebp), %eax
SUB $1, %eax
MOV  %eax, -24(%ebp)
MOV -24(%ebp), %eax
MOV %eax, -4(%ebp)
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JL SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -28(%ebp)
JL LIF3
MOV -4(%ebp), %eax
CMP $0.0, %eax
JNE SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -32(%ebp)
JNE LIF4
MOV -12(%ebp), %eax
MOV -0(%ebp), %edx
IMUL %edx, %eax
MOV  %eax, -36(%ebp)
MOV -36(%ebp), %eax
MOV -0(%ebp), %edx
IMUL %edx, %eax
MOV  %eax, -40(%ebp)
MOV -40(%ebp), %eax
MOV %eax, -12(%ebp)
LIF4:
JMP BI1
LIF4:
MOV 1000.234, %eax
NOT  %eax
MOV  %eax, -44(%ebp)
MOV -44(%ebp), %eax
ADD $6752, %eax
MOV  %eax, -48(%ebp)
MOV -48(%ebp), %eax
MOV %eax, -12(%ebp)
JMP BI2
JMP BI1
EI2:
leave
ret
main:
CALL printf

