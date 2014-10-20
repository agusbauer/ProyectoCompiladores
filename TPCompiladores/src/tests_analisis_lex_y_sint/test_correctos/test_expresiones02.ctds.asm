
prueba:
MOV $4, %eax
MOV %eax, -12(%ebp)
MOV $5, %eax
MOV %eax, -16(%ebp)
MOV -12(%ebp), %eax
MOV -16(%ebp), %edx
IMUL %edx, %eax
MOV  %eax, -24(%ebp)
MOV -24(%ebp), %eax
MOV %eax, -4(%ebp)
MOV -4(%ebp), %eax
MOV -0(%ebp), %edx
ADD %edx, %eax
MOV  %eax, -28(%ebp)
MOV -28(%ebp), %eax
MOV %eax, -0(%ebp)
MOV $3.1, %eax
MOV %eax, -20(%ebp)
MOV -20(%ebp), %eax
IMUL $2.0, %eax
MOV  %eax, -32(%ebp)
MOV -32(%ebp), %eax
MOV %eax, -8(%ebp)
MOV -4(%ebp), %edx
MOV -8(%ebp), %ecx
IDIV %ecx
MOV  %eax, -36(%ebp)
MOV -36(%ebp), %eax
CMP $5, %eax
JG SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -40(%ebp)
JG LIF1
leave
ret
LIF1:
leave
ret
main:
CALL printf

