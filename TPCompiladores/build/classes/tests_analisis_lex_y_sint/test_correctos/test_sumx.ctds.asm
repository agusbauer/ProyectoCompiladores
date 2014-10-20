
sumx:
MOV $0.0, %eax
MOV %eax, -4(%ebp)
MOV $0, %eax
MOV %eax, -8(%ebp)
BI1:
MOV -8(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JL SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -12(%ebp)
JL EI2
MOV -4(%ebp), %eax
MOV -0(%ebp), %edx
ADD %edx, %eax
MOV  %eax, -16(%ebp)
MOV -16(%ebp), %eax
MOV %eax, -16(%ebp)
MOV -8(%ebp), %eax
ADD $1, %eax
MOV  %eax, -20(%ebp)
MOV -20(%ebp), %eax
MOV %eax, -20(%ebp)
JMP BI1
EI2:
leave
ret
main:
CALL printf

