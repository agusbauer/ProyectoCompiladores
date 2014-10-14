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
MOV $b, %rax
MOV %rax, -0(%rbp)
LIF1:
MOV $c, %rax
MOV %rax, -0(%rbp)
leave
ret
CALL printf
