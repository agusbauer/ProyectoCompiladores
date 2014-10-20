
alo:
MOV -0(%ebp), %eax
ADD $1, %eax
MOV  %eax, -12(%ebp)
MOV -12(%ebp), %eax
MOV %eax, -0(%ebp)
leave
ret
alo2:
CALL alo
MOV -0(%ebp), %eax
ADD $1, %eax
MOV  %eax, -16(%ebp)
MOV -16(%ebp), %eax
MOV %eax, -0(%ebp)
leave
ret
main:
MOV $7, %eax
MOV %eax, -8(%ebp)
MOV $8.0, %eax
MOV %eax, -4(%ebp)
CALL alo2
MOV  %eax, -20(%ebp)
MOV -20(%ebp), %eax
MOV %eax, -8(%ebp)
CALL alo2
MOV  %eax, -24(%ebp)
MOV -24(%ebp), %eax
MOV %eax, -8(%ebp)
leave
ret

