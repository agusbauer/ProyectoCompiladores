COMM c, 4, 4

.TEXT

  .GLOBL alo
  TYPE alo, @function
alo:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $8%ebp
  MOVL -0(%ebp), %eax
  ADDL $1, %eax
  MOVL  %eax, -8(%ebp)
  MOVL -8(%ebp), %eax
  MOVL %eax, -0(%ebp)
  LEAVE
  RET
