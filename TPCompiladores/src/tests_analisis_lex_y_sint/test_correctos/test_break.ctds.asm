
breaks:
MOV $0, %eax
MOV %eax, -4(%ebp)
BI1:
MOV -4(%ebp), %eax
CMP $10, %eax
JL SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -8(%ebp)
JL EI2
MOV -4(%ebp), %eax
ADD $1, %eax
MOV  %eax, -12(%ebp)
MOV -12(%ebp), %eax
MOV %eax, -4(%ebp)
MOV -0(%ebp), %eax
CMP $0, %eax
JL SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -16(%ebp)
JL LIF3
JMP BI2
LIF3:
JMP BI1
JMP BI1
EI2:
leave
ret
main:
CALL printf
leave
ret

