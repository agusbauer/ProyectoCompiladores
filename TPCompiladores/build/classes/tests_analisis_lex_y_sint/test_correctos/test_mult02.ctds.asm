
.TEXT

  .GLOBL pruMult
  TYPE pruMult, @function
pruMult:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-8%ebp
  MOVL $5, %eax
  MOVL %eax, -4(%ebp)
  MOVL -4(%ebp), %eax
  IMUL $7, %eax
  MOVL  %eax, -8(%ebp)
  MOVL temp1, %eax
  LEAVE
  RET

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-8%ebp
  CALL printf
  LEAVE
  RET
