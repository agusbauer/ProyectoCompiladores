
id:
MOV $100, %eax
MOV %eax, -4(%ebp)
MOV $0, %eax
MOV %eax, -8(%ebp)
MOV -0(%ebp), %eax
MOV %eax, -0(%ebp)
BI1:
MOV -8(%ebp), %eax
MOV -4(%ebp), %ebx
CMP  %ebx, %eax
JL SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -20(%ebp)
JL EI2
MOV -0(%ebp), %eax
MOV %eax, -0(%ebp)
BI3:
MOV -0(%ebp), %eax
CMP $0, %eax
JG SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -24(%ebp)
MOV -0(%ebp), %eax
CMP $0, %eax
JL SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -28(%ebp)
MOV -24(%ebp), %eax
MOV -28(%ebp), %edx
OR %edx, %eax
MOV  %eax, -32(%ebp)
MOV -32(%ebp), %eax
CMP %eax, $1
JE EI4
MOV -0(%ebp), %eax
CMP $0, %eax
JG SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -36(%ebp)
JG LIF5
MOV -0(%ebp), %eax
SUB $1, %eax
MOV  %eax, -40(%ebp)
MOV -40(%ebp), %eax
MOV %eax, -40(%ebp)
LIF5:
MOV -0(%ebp), %eax
ADD $1, %eax
MOV  %eax, -44(%ebp)
MOV -44(%ebp), %eax
MOV %eax, -44(%ebp)
JMP BI3
EI4:
BI6:
MOV -0(%ebp), %eax
MOV -16(%ebp), %ebx
CMP  %ebx, %eax
JL SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -48(%ebp)
MOV -0(%ebp), %eax
MOV -16(%ebp), %ebx
CMP  %ebx, %eax
JG SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -52(%ebp)
MOV -48(%ebp), %eax
MOV -52(%ebp), %edx
OR %edx, %eax
MOV  %eax, -56(%ebp)
MOV -56(%ebp), %eax
CMP %eax, $1
JE EI7
MOV -0(%ebp), %eax
MOV -16(%ebp), %ebx
CMP  %ebx, %eax
JL SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -60(%ebp)
JL LIF8
MOV -0(%ebp), %eax
ADD $1, %eax
MOV  %eax, -64(%ebp)
MOV -64(%ebp), %eax
MOV %eax, -64(%ebp)
LIF8:
MOV -0(%ebp), %eax
MOV -0(%ebp), %ebx
CMP  %ebx, %eax
JE SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -68(%ebp)
JE LIF9
MOV -0(%ebp), %eax
SUB $1, %eax
MOV  %eax, -72(%ebp)
MOV -8(%ebp), %eax
MOV -0(%ebp), %edx
IMUL %edx, %eax
MOV  %eax, -76(%ebp)
MOV -8(%ebp), %eax
MOV -0(%ebp), %edx
IMUL %edx, %eax
MOV  %eax, -80(%ebp)
MOV -76(%ebp), %eax
MOV -80(%ebp), %edx
SUB %edx, %eax
MOV  %eax, -84(%ebp)
MOV -72(%ebp), %eax
MOV -84(%ebp), %edx
ADD %edx, %eax
MOV  %eax, -88(%ebp)
MOV -88(%ebp), %eax
MOV %eax, -88(%ebp)
LIF9:
JMP BI6
EI7:
MOV -12(%ebp), %eax
MOV %eax, -12(%ebp)
MOV -8(%ebp), %eax
ADD $1, %eax
MOV  %eax, -92(%ebp)
MOV -92(%ebp), %eax
MOV %eax, -92(%ebp)
JMP BI6
EI7:
leave
ret
main:
CALL printf

