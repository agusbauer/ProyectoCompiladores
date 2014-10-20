
alo:
MOV -0(%ebp), %eax
ADD $1, %eax
MOV  %eax, -8(%ebp)
MOV -8(%ebp), %eax
MOV %eax, -0(%ebp)
leave
ret
alo_2:
CALL alo
MOV  %eax, -12(%ebp)
MOV -12(%ebp), %eax
ADD $1, %eax
MOV  %eax, -16(%ebp)
MOV -16(%ebp), %eax
MOV %eax, -0(%ebp)
leave
ret
main:
CALL printf
CALL printf
CALL /home/programas/primer_primo_par

