
.TEXT

  .GLOBL main
.TYPE main, @function

pruMult:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $12%ebp
  MOVL $5, %eax
  MOVL %eax, -4(%ebp)
  MOVL -4(%ebp), %eax
  IMUL $7, %eax
  MOVL  %eax, -12(%ebp)
  MOVL temp1, %eax
  leave
  ret

main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $12%ebp
  CALL printf
  LEAVE
  RET
