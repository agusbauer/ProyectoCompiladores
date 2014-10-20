
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
MOV %eax, -4(%ebp)
LIF1:
MOV -0(%ebp), %eax
MOV %eax, -4(%ebp)
leave
ret
main:
CALL printf

