
div:
leave
ret
resta:
leave
ret
sum:
leave
ret
main:
MOV $6.98, %eax
MOV %eax, -4(%ebp)
MOV 2.0, %eax
NOT  %eax
MOV  %eax, -16(%ebp)
MOV -16(%ebp), %eax
MOV %eax, -8(%ebp)
MOV $3.569, %eax
MOV %eax, -12(%ebp)
CALL printf

