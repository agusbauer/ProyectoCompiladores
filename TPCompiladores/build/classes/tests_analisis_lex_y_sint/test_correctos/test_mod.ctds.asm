
.TEXT

  .GLOBL pruAritmetica
  TYPE pruAritmetica, @function
pruAritmetica:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-8%ebp
  MOVL $90, %eax
  MOVL %eax, -4(%ebp)
  MOVL -4(%ebp), %edx
  IDIV $7
  MOVL  %edx, -8(%ebp)
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
