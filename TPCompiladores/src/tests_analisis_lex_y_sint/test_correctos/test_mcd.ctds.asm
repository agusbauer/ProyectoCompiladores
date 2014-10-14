MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JG SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -4(%ebp)
JG, LIF1
MOV $a, %rax
MOV %rax, -0(%rbp)
MOV $b, %rax
MOV %rax, -0(%rbp)
LIF1:
MOV $b, %rax
MOV %rax, -0(%rbp)
MOV $a, %rax
MOV %rax, -0(%rbp)
MOV $1, %rax
MOV %rax, -0(%rbp)
BI2:
MOV -0(%ebp), %eax
CMP $0, %eax
JNE SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -8(%ebp)
JNE, EI3
MOV -0(%rbp), %rdx
MOV -0(%rbp), %rcx
IDIV %rcx
MOV  %rdx, -12(%rbp)
MOV $temp3, %rax
MOV %rax, -0(%rbp)
MOV $divisor, %rax
MOV %rax, -0(%rbp)
MOV $resto, %rax
MOV %rax, -0(%rbp)
JMP, BI2
EI3:
leave
ret
CALL printf
