
pruebaLogica:
MOV $True, %eax
MOV %eax, -4(%ebp)
leave
ret
main:
CALL printf

