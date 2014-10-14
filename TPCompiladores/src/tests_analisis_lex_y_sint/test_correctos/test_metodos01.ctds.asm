MOV -0(%rbp), %rax
ADD $1, %rax
MOV  %rax, -4(%rbp)
MOV $temp1, %rax
MOV %rax, -0(%rbp)
leave
ret
CALL alo
MOV -0(%rbp), %rax
ADD $1, %rax
MOV  %rax, -8(%rbp)
MOV $temp2, %rax
MOV %rax, -0(%rbp)
leave
ret
MOV $7, %rax
MOV %rax, -0(%rbp)
MOV $8.0, %rax
MOV %rax, -0(%rbp)
CALL alo2
MOV  %eax, -12(%ebp)
MOV $temp3, %rax
MOV %rax, -0(%rbp)
CALL alo2
MOV  %eax, -16(%ebp)
MOV $temp4, %rax
MOV %rax, -0(%rbp)
leave
ret
