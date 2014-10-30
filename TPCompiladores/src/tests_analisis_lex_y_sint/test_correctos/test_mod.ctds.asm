
.TEXT

  .GLOBL main
.TYPE main, @function

pruAritmetica:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $12%ebp
  MOVL $90, %eax
  MOVL %eax, -4(%ebp)
  MOVL -4(%ebp), %edx
  IDIV $7
  MOVL  %edx, -12(%ebp)
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
