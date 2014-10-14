MOV $0.0, %rax
MOV %rax, -0(%rbp)
MOV $b, %rax
MOV %rax, -0(%rbp)
BI1:
MOV -0(%ebp), %eax
CMP $0.0, %eax
JG SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -4(%ebp)
MOV -0(%ebp), %eax
CMP $0.0, %eax
JG SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -8(%ebp)
MOV -4(%rbp), %rax
MOV -8(%rbp), %rdx
OR %rdx, %rax
MOV  %rax, -12(%rbp)
MOV -12(%ebp), %eax
CMP %eax, $1
JE EI2
MOV -0(%ebp), %eax
CMP $0.0, %eax
JG SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -16(%ebp)
JG, LIF3
MOV -0(%rbp), %rax
MOV -0(%rbp), %rdx
ADD %rdx, %rax
MOV  %rax, -20(%rbp)
MOV $temp5, %rax
MOV %rax, -0(%rbp)
LIF3:
MOV -0(%rbp), %rax
SUB $1.0, %rax
MOV  %rax, -0(%rbp)
JMP, BI1
EI2:
MOV $total, %rax
MOV %rax, -0(%rbp)
leave
ret
MOV $8.0, %rax
MOV %rax, -0(%rbp)
CALL sumatoria
MOV  %eax, -24(%ebp)
MOV $temp6, %rax
MOV %rax, -0(%rbp)
CALL printf
leave
ret
