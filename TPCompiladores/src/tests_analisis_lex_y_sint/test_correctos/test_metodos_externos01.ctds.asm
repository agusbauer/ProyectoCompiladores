COMM c, 4, 4

.TEXT

  .GLOBL alo
  TYPE alo, @function
alo:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-24%ebp
  MOVL 8(%ebp), %eax
  ADDL $1, %eax
  MOVL  %eax, -16(%ebp)
  MOVL -16(%ebp), %eax
  MOVL %eax, 8(%ebp)
  MOVL 8(%ebp), %eax
  LEAVE
  RET

  .GLOBL alo_2
  TYPE alo_2, @function
alo_2:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-24%ebp
  MOVL -8(%ebp), %eax
  MOVL %eax, 0(%esp)
  CALL alo
  MOVL  %eax, -20(%ebp)
  MOVL -20(%ebp), %eax
  ADDL $1, %eax
  MOVL  %eax, -24(%ebp)
  MOVL -24(%ebp), %eax
  MOVL %eax, 8(%ebp)
  LEAVE
  RET

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-24%ebp
  CALL printf
  CALL printf
  CALL /home/programas/primer_primo_par
  LEAVE
  RET
