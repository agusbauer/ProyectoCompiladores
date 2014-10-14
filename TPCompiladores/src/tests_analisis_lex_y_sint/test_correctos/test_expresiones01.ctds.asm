MOV $50, %rax
MOV %rax, -0(%rbp)
MOV -0(%ebp), %eax
CMP $0, %eax
JG SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -4(%ebp)
JG, LIF1
MOV $4, %rax
MOV %rax, -0(%rbp)
MOV -0(%ebp), %eax
CMP $4, %eax
JE SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -8(%ebp)
JE, LIF2
BI3:
MOV -0(%ebp), %eax
CMP $4, %eax
JL SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -12(%ebp)
JL, EI4
BI5:
MOV -0(%ebp), %eax
CMP $4, %eax
JG SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -16(%ebp)
JG, EI6
MOV -0(%rbp), %rax
SUB $1, %rax
MOV  %rax, -20(%rbp)
MOV $temp5, %rax
MOV %rax, -0(%rbp)
MOV -0(%rbp), %rax
IMUL $2, %rax
MOV  %rax, -24(%rbp)
MOV $temp6, %rax
MOV %rax, -0(%rbp)
JMP, BI5
EI6:
MOV -0(%rbp), %rax
ADD $1, %rax
MOV  %rax, -28(%rbp)
MOV $temp7, %rax
MOV %rax, -0(%rbp)
MOV -0(%rbp), %rdx
IDIV $2
MOV  %rax, -32(%rbp)
MOV $temp8, %rax
MOV %rax, -0(%rbp)
JMP, BI5
EI6:
LIF6:
LIF6:
leave
ret
CALL printf
