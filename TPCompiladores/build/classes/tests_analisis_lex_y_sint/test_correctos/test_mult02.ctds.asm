
pruMult:
MOV $5, %eax
MOV %eax, -4(%ebp)
leave
ret
main:
CALL printf

