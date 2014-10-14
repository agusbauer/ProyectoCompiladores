MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JG SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -4(%ebp)
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JG SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -8(%ebp)
MOV -4(%rbp), %rax
MOV -8(%rbp), %rdx
AND %rdx, %rax
MOV  %rax, -12(%rbp)
MOV -12(%ebp), %eax
CMP %eax, $1
JE LIF1
leave
ret
LIF1:
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JG SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -16(%ebp)
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JG SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -20(%ebp)
MOV -16(%rbp), %rax
MOV -20(%rbp), %rdx
AND %rdx, %rax
MOV  %rax, -24(%rbp)
MOV -24(%ebp), %eax
CMP %eax, $1
JE LIF2
leave
ret
LIF2:
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JG SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -28(%ebp)
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JG SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -32(%ebp)
MOV -28(%rbp), %rax
MOV -32(%rbp), %rdx
AND %rdx, %rax
MOV  %rax, -36(%rbp)
MOV -36(%ebp), %eax
CMP %eax, $1
JE LIF3
leave
ret
LIF3:
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JE SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -40(%ebp)
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JE SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -44(%ebp)
MOV -40(%rbp), %rax
MOV -44(%rbp), %rdx
AND %rdx, %rax
MOV  %rax, -48(%rbp)
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JE SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -52(%ebp)
MOV -48(%rbp), %rax
MOV -52(%rbp), %rdx
AND %rdx, %rax
MOV  %rax, -56(%rbp)
MOV -56(%ebp), %eax
CMP %eax, $1
JE LIF4
leave
ret
LIF4:
CALL printf
leave
ret
