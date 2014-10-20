
pruAritmetica:
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JG SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -8(%ebp)
JG LIF1
MOV -0(%ebp), %eax
MOV -0(%ebp), %edx
SUB %edx, %eax
MOV  %eax, -12(%ebp)
MOV -12(%ebp), %eax
MOV %eax, -12(%ebp)
LIF1:
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JE SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -16(%ebp)
JE LIF2
MOV -0(%ebp), %eax
IMUL $5, %eax
MOV  %eax, -20(%ebp)
MOV -20(%ebp), %eax
MOV %eax, -20(%ebp)
LIF2:
MOV -0(%ebp), %eax
MOV -0(%ebp), %edx
SUB %edx, %eax
MOV  %eax, -24(%ebp)
MOV -24(%ebp), %eax
MOV %eax, -24(%ebp)
leave
ret
main:
CALL printf
CALL printf
CALL printf
CALL printf

