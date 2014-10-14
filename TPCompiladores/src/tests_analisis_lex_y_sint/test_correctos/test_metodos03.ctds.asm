leave
ret
MOV $2, %rax
IMUL $3, %rax
MOV  %rax, -4(%rbp)
MOV -0(%ebp), %eax
MOV -4(%ebp), %ebx
CMP  %ebx, %eax
JG SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -8(%ebp)
JG, LIF1
MOV -0(%rbp), %rdx
IDIV $3
MOV  %rax, -12(%rbp)
MOV $temp3, %rax
MOV %rax, -0(%rbp)
LIF1:
MOV -0(%rbp), %rdx
IDIV $2
MOV  %rdx, -16(%rbp)
MOV $temp4, %rax
MOV %rax, -0(%rbp)
leave
ret
MOV $False, %rax
MOV %rax, -0(%rbp)
CALL resto
MOV  %eax, -20(%ebp)
MOV $temp5, %rax
MOV %rax, -0(%rbp)
