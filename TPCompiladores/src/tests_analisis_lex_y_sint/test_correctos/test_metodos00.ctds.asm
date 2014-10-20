
alo:
MOV -0(%ebp), %eax
ADD $1, %eax
MOV  %eax, -8(%ebp)
MOV -8(%ebp), %eax
MOV %eax, -0(%ebp)
alo2:
CALL alo

