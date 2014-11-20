COMM a, 4, 4

.TEXT

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $0%ebp
  MOVL $3, %eax
  MOVL %eax, -8(%ebp)
  MOVL $2, %eax
  MOVL %eax, 50(%ebp)
  LEAVE
  RET
