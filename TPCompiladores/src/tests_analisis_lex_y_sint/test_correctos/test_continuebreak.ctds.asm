MOV 1.0, %eax
NOT  %eax
MOV  %eax, -4(%ebp)
MOV $temp1, %rax
MOV %rax, -0(%rbp)
MOV $23, %rax
MOV %rax, -0(%rbp)
MOV $23.0, %rax
MOV %rax, -0(%rbp)
BI1:
MOV -0(%ebp), %eax
CMP $0.0, %eax
JGE SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -8(%ebp)
JGE, EI2
MOV -0(%rbp), %rax
SUB $1, %rax
MOV  %rax, -12(%rbp)
MOV $temp3, %rax
MOV %rax, -0(%rbp)
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JL SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -16(%ebp)
JL, LIF3
MOV -0(%ebp), %eax
CMP $0.0, %eax
JNE SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -20(%ebp)
JNE, LIF4
MOV -0(%rbp), %rax
MOV -0(%rbp), %rdx
IMUL %rdx, %rax
MOV  %rax, -24(%rbp)
MOV -24(%rbp), %rax
MOV -0(%rbp), %rdx
IMUL %rdx, %rax
MOV  %rax, -28(%rbp)
MOV $temp7, %rax
MOV %rax, -0(%rbp)
LIF4:
JMP, BI1
LIF4:
MOV 1000.234, %eax
NOT  %eax
MOV  %eax, -32(%ebp)
MOV -32(%rbp), %rax
ADD $6752, %rax
MOV  %rax, -36(%rbp)
MOV $temp9, %rax
MOV %rax, -0(%rbp)
JMP, BI2
JMP, BI1
EI2:
leave
ret
CALL printf
