MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JNE SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -4(%ebp)
JNE, LIF1
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JG SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -8(%ebp)
JG, LIF2
MOV -0(%rbp), %rax
MOV -0(%rbp), %rdx
SUB %rdx, %rax
MOV  %rax, -12(%rbp)
MOV $temp3, %rax
MOV %rax, -0(%rbp)
LIF2:
MOV -0(%rbp), %rax
MOV -0(%rbp), %rdx
SUB %rdx, %rax
MOV  %rax, -16(%rbp)
MOV $temp4, %rax
MOV %rax, -0(%rbp)
LIF2:
MOV -0(%rbp), %rax
IMUL $5, %rax
MOV  %rax, -20(%rbp)
MOV $temp5, %rax
MOV %rax, -0(%rbp)
leave
ret
CALL printf
CALL printf
CALL printf
CALL printf
