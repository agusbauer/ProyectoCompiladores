
neg:
leave
ret
and:
leave
ret
or:
leave
ret
main:
MOV $True, %eax
MOV %eax, -4(%ebp)
MOV $False, %eax
MOV %eax, -8(%ebp)
CALL neg
MOV  %eax, -24(%ebp)
MOV -24(%ebp), %eax
MOV %eax, -24(%ebp)
CALL or
MOV  %eax, -28(%ebp)
MOV -28(%ebp), %eax
MOV %eax, -28(%ebp)
CALL printf

