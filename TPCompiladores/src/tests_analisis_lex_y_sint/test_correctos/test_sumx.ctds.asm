MOV $0.0, %rax
MOV %rax, -0(%rbp)
MOV $0, %rax
MOV %rax, -0(%rbp)
BI1:
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JL SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -4(%ebp)
JL, EI2
MOV -0(%rbp), %rax
MOV -0(%rbp), %rdx
ADD %rdx, %rax
MOV  %rax, -8(%rbp)
MOV $temp2, %rax
MOV %rax, -0(%rbp)
MOV -0(%rbp), %rax
ADD $1, %rax
MOV  %rax, -12(%rbp)
MOV $temp3, %rax
MOV %rax, -0(%rbp)
JMP, BI1
EI2:
leave
ret
CALL printf
