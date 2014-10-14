MOV $5, %rax
MOV %rax, -0(%rbp)
MOV $2000, %rax
MOV %rax, -0(%rbp)
leave
ret
CALL printf
