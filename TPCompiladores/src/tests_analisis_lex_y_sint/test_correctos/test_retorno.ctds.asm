MOV $100, %rax
MOV %rax, -0(%rbp)
MOV $0, %rax
MOV %rax, -0(%rbp)
MOV $x, %rax
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
MOV $x, %rax
MOV %rax, -0(%rbp)
BI3:
MOV -0(%ebp), %eax
CMP $0, %eax
JG SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -8(%ebp)
MOV -0(%ebp), %eax
CMP $0, %eax
JL SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -12(%ebp)
MOV -8(%rbp), %rax
MOV -12(%rbp), %rdx
OR %rdx, %rax
MOV  %rax, -16(%rbp)
MOV -16(%ebp), %eax
CMP %eax, $1
JE EI4
MOV -0(%ebp), %eax
CMP $0, %eax
JG SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -20(%ebp)
JG, LIF5
MOV -0(%rbp), %rax
SUB $1, %rax
MOV  %rax, -24(%rbp)
MOV $temp6, %rax
MOV %rax, -0(%rbp)
LIF5:
MOV -0(%rbp), %rax
ADD $1, %rax
MOV  %rax, -28(%rbp)
MOV $temp7, %rax
MOV %rax, -0(%rbp)
JMP, BI3
EI4:
BI6:
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JL SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -32(%ebp)
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JG SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -36(%ebp)
MOV -32(%rbp), %rax
MOV -36(%rbp), %rdx
OR %rdx, %rax
MOV  %rax, -40(%rbp)
MOV -40(%ebp), %eax
CMP %eax, $1
JE EI7
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JL SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -44(%ebp)
JL, LIF8
MOV -0(%rbp), %rax
ADD $1, %rax
MOV  %rax, -48(%rbp)
MOV $temp12, %rax
MOV %rax, -0(%rbp)
LIF8:
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JE SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -52(%ebp)
JE, LIF9
MOV -0(%rbp), %rax
SUB $1, %rax
MOV  %rax, -56(%rbp)
MOV -0(%rbp), %rax
MOV -0(%rbp), %rdx
IMUL %rdx, %rax
MOV  %rax, -60(%rbp)
MOV -0(%rbp), %rax
MOV -0(%rbp), %rdx
IMUL %rdx, %rax
MOV  %rax, -64(%rbp)
MOV -60(%rbp), %rax
MOV -64(%rbp), %rdx
SUB %rdx, %rax
MOV  %rax, -68(%rbp)
MOV -56(%rbp), %rax
MOV -68(%rbp), %rdx
ADD %rdx, %rax
MOV  %rax, -72(%rbp)
MOV $temp18, %rax
MOV %rax, -0(%rbp)
LIF9:
JMP, BI6
EI7:
MOV $z, %rax
MOV %rax, -0(%rbp)
MOV -0(%rbp), %rax
ADD $1, %rax
MOV  %rax, -76(%rbp)
MOV $temp19, %rax
MOV %rax, -0(%rbp)
JMP, BI6
EI7:
leave
ret
CALL printf
