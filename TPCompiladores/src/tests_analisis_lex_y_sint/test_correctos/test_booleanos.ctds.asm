leave
ret
leave
ret
leave
ret
MOV $True, %rax
MOV %rax, -0(%rbp)
MOV $False, %rax
MOV %rax, -0(%rbp)
CALL neg
MOV  %eax, -4(%ebp)
MOV $temp1, %rax
MOV %rax, -0(%rbp)
CALL or
MOV  %eax, -8(%ebp)
MOV $temp2, %rax
MOV %rax, -0(%rbp)
CALL printf
