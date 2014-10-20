
inc:
leave
ret
resto:
MOV $2, %eax
IMUL $3, %eax
MOV  %eax, -16(%ebp)
MOV -0(%ebp), %eax
MOV -16(%ebp), %ebx
CMP  %ebx, %eax
JG SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -20(%ebp)
JG LIF1
MOV -0(%ebp), %edx
IDIV $3
MOV  %eax, -24(%ebp)
MOV -24(%ebp), %eax
MOV %eax, -24(%ebp)
LIF1:
MOV -0(%ebp), %edx
IDIV $2
MOV  %edx, -28(%ebp)
MOV -28(%ebp), %eax
MOV %eax, -28(%ebp)
leave
ret
main:
MOV $False, %eax
MOV %eax, -4(%ebp)
CALL resto
MOV  %eax, -32(%ebp)
MOV -32(%ebp), %eax
MOV %eax, -32(%ebp)

