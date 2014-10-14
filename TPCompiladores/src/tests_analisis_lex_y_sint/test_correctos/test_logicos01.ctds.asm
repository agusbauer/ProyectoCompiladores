MOV $True, %rax
MOV %rax, -0(%rbp)
leave
ret
CALL printf
