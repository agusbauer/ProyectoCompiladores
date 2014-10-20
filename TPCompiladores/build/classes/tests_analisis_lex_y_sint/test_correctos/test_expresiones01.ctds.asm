
prueba:
MOV $50, %eax
MOV %eax, -12(%ebp)
MOV -12(%ebp), %eax
CMP $0, %eax
JG SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -16(%ebp)
JG LIF1
MOV $4, %eax
MOV %eax, -4(%ebp)
MOV -4(%ebp), %eax
CMP $4, %eax
JE SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -20(%ebp)
JE LIF2
BI3:
MOV -4(%ebp), %eax
CMP $4, %eax
JL SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -24(%ebp)
JL EI4
BI5:
MOV -12(%ebp), %eax
CMP $4, %eax
JG SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -28(%ebp)
JG EI6
MOV -12(%ebp), %eax
SUB $1, %eax
MOV  %eax, -32(%ebp)
MOV -32(%ebp), %eax
MOV %eax, -32(%ebp)
MOV -4(%ebp), %eax
IMUL $2, %eax
MOV  %eax, -36(%ebp)
MOV -36(%ebp), %eax
MOV %eax, -36(%ebp)
JMP BI5
EI6:
MOV -4(%ebp), %eax
ADD $1, %eax
MOV  %eax, -40(%ebp)
MOV -40(%ebp), %eax
MOV %eax, -40(%ebp)
MOV -8(%ebp), %edx
IDIV $2
MOV  %eax, -44(%ebp)
MOV -44(%ebp), %eax
MOV %eax, -44(%ebp)
JMP BI5
EI6:
LIF6:
LIF6:
leave
ret
main:
CALL printf

