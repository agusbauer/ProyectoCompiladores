MOV -0(%rbp), %rax
ADD $1, %rax
MOV  %rax, -4(%rbp)
MOV $temp1, %rax
MOV %rax, -0(%rbp)
CALL alo
