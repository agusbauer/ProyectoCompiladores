MOV $0, %rax
MOV %rax, -0(%rbp)
BI1:
MOV -0(%ebp), %eax
CMP $10, %eax
JL SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -4(%ebp)
JL, EI2
MOV -0(%rbp), %rax
ADD $1, %rax
MOV  %rax, -8(%rbp)
MOV $temp2, %rax
MOV %rax, -0(%rbp)
MOV -0(%ebp), %eax
CMP $0, %eax
JL SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -12(%ebp)
JL, LIF3
JMP, BI2
LIF3:
JMP, BI1
JMP, BI1
EI2:
leave
ret
CALL printf
leave
ret
