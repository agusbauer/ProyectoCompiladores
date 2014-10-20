
main:
MOV $True, %eax
MOV %eax, -4(%ebp)
MOV -4(%ebp), %eax
CMP %eax, $1
JE SHORT isTrue
MOV $1, %eax
isTrue:
MOV $0, %eax
MOV  %eax, -24(%ebp)
MOV -24(%ebp), %eax
MOV %eax, -8(%ebp)
MOV -4(%ebp), %eax
MOV -8(%ebp), %edx
AND %edx, %eax
MOV  %eax, -28(%ebp)
MOV -8(%ebp), %eax
CMP %eax, $1
JE SHORT isTrue
MOV $1, %eax
isTrue:
MOV $0, %eax
MOV  %eax, -32(%ebp)
MOV -28(%ebp), %eax
MOV -32(%ebp), %edx
OR %edx, %eax
MOV  %eax, -36(%ebp)
MOV -36(%ebp), %eax
MOV %eax, -12(%ebp)
CALL printf

