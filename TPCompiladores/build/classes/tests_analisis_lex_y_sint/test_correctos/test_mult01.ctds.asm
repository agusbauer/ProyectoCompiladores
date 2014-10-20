
pruMult:
MOV $5, %eax
MOV %eax, -4(%ebp)
MOV $2000, %eax
MOV %eax, -8(%ebp)
leave
ret
main:
CALL printf

