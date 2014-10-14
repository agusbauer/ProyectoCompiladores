MOV -0(%rbp), %rax
ADD $1, %rax
MOV  %rax, -4(%rbp)
MOV $temp1, %rax
MOV %rax, -0(%rbp)
leave
ret
CALL alo
MOV  %eax, -8(%ebp)
MOV -8(%rbp), %rax
ADD $1, %rax
MOV  %rax, -12(%rbp)
MOV $temp3, %rax
MOV %rax, -0(%rbp)
leave
ret
CALL printf
CALL printf
CALL /home/programas/primer_primo_par
