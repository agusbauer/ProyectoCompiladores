
suma:
MOV -0(%ebp), %eax
CMP $0, %eax
JE SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -4(%ebp)
JE LIF1
leave
ret
LIF1:
MOV -0(%ebp), %eax
CMP $0, %eax
JE SHORT ok
MOV $0, %eax
ok:
MOV $1, %eax
MOV  %eax, -8(%ebp)
JE LIF2
leave
ret
LIF2:
leave
ret
main:
CALL printf

