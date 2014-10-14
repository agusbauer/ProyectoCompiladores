MOV $True, %rax
MOV %rax, -0(%rbp)
MOV -0(%ebp), %eax
CMP %eax, $1
JE SHORT isTrue
MOV $1, %eax
isTrue:
MOV $0, %eax
MOV  %eax, -4(%ebp)
MOV $temp1, %rax
MOV %rax, -0(%rbp)
MOV -0(%rbp), %rax
MOV -0(%rbp), %rdx
AND %rdx, %rax
MOV  %rax, -8(%rbp)
MOV -0(%ebp), %eax
CMP %eax, $1
JE SHORT isTrue
MOV $1, %eax
isTrue:
MOV $0, %eax
MOV  %eax, -12(%ebp)
MOV -8(%rbp), %rax
MOV -12(%rbp), %rdx
OR %rdx, %rax
MOV  %rax, -16(%rbp)
MOV $temp4, %rax
MOV %rax, -0(%rbp)
CALL printf
