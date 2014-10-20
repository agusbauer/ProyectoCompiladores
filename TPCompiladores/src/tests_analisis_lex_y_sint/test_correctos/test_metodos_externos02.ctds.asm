
maxcomdiv:
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JG SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -20(%ebp)
JG LIF1
MOV -0(%ebp), %eax
MOV %eax, -4(%ebp)
MOV -0(%ebp), %eax
MOV %eax, -8(%ebp)
LIF1:
MOV -0(%ebp), %eax
MOV %eax, -4(%ebp)
MOV -0(%ebp), %eax
MOV %eax, -8(%ebp)
MOV $1, %eax
MOV %eax, -12(%ebp)
BI2:
MOV -12(%ebp), %eax
CMP $0, %eax
JNE SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -24(%ebp)
JNE EI3
MOV -4(%ebp), %edx
MOV -8(%ebp), %ecx
IDIV %ecx
MOV  %edx, -28(%ebp)
MOV -28(%ebp), %eax
MOV %eax, -12(%ebp)
MOV -8(%ebp), %eax
MOV %eax, -4(%ebp)
MOV -12(%ebp), %eax
MOV %eax, -8(%ebp)
JMP BI2
EI3:
leave
ret
main:
MOV $3, %eax
MOV %eax, -16(%ebp)
CALL printf

