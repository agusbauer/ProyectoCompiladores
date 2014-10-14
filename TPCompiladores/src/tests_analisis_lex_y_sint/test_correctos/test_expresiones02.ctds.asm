MOV $4, %rax
MOV %rax, -0(%rbp)
MOV $5, %rax
MOV %rax, -0(%rbp)
MOV -0(%rbp), %rax
MOV -0(%rbp), %rdx
IMUL %rdx, %rax
MOV  %rax, -4(%rbp)
MOV $temp1, %rax
MOV %rax, -0(%rbp)
MOV -0(%rbp), %rax
MOV -0(%rbp), %rdx
ADD %rdx, %rax
MOV  %rax, -8(%rbp)
MOV $temp2, %rax
MOV %rax, -0(%rbp)
MOV $3.1, %rax
MOV %rax, -0(%rbp)
MOV -0(%rbp), %rax
IMUL $2.0, %rax
MOV  %rax, -12(%rbp)
MOV $temp3, %rax
MOV %rax, -0(%rbp)
MOV -0(%rbp), %rdx
MOV -0(%rbp), %rcx
IDIV %rcx
MOV  %rax, -16(%rbp)
MOV -16(%ebp), %eax
CMP $5, %eax
JG SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -20(%ebp)
JG, LIF1
leave
ret
LIF1:
leave
ret
CALL printf
