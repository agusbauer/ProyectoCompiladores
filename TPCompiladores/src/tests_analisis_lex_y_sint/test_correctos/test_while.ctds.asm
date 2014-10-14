MOV $1, %rax
MOV %rax, -0(%rbp)
BI1:
MOV -0(%ebp), %eax
CMP $0, %eax
JNE SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -4(%ebp)
JNE, EI2
MOV -0(%rbp), %rdx
MOV -0(%rbp), %rcx
IDIV %rcx
MOV  %rdx, -8(%rbp)
MOV -0(%rbp), %rax
MOV -8(%rbp), %rdx
ADD %rdx, %rax
MOV  %rax, -0(%rbp)
MOV -0(%rbp), %rax
MOV -0(%rbp), %rdx
SUB %rdx, %rax
MOV  %rax, -0(%rbp)
JMP, BI1
JMP, BI1
EI2:
BI3:
MOV -0(%ebp), %eax
CMP $0, %eax
JNE SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -12(%ebp)
JNE, EI4
JMP, BI4
JMP, BI3
EI4:
BI5:
MOV -0(%ebp), %eax
CMP $0, %eax
JNE SHORT ok
JNE SHORT ok:
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -16(%ebp)
JNE, EI6
JMP, BI5
EI6:
leave
ret
CALL printf
