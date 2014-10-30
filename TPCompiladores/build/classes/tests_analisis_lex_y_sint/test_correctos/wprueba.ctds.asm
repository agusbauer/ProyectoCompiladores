
.TEXT

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $0%ebp
  MOVL $2, %eax
  MOVL %eax, -4(%ebp)
  LEAVE
  RET
