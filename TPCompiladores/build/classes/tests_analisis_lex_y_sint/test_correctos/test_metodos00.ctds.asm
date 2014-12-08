COMM c, 4, 4

.TEXT

  .GLOBL alo
  TYPE alo, @function
alo:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-16%ebp
  MOVL 8(%ebp), %eax
  ADDL $1, %eax
  MOVL  %eax, -12(%ebp)
  MOVL -12(%ebp), %eax
  MOVL %eax, 8(%ebp)
  .GLOBL alo2
  TYPE alo2, @function
alo2:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-16%ebp
  MOVL -8(%ebp), %eax
  MOVL %eax, 0(%esp)
  CALL alo
  MOVL  %eax, -16(%ebp)
  LEAVE
  RET
