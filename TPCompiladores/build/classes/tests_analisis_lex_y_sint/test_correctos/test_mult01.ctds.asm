
.TEXT

  .GLOBL pruMult
  TYPE pruMult, @function
pruMult:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-24%ebp
  MOVL $5, %eax
  MOVL %eax, -4(%ebp)
  MOVL $2000, %eax
  MOVL %eax, -8(%ebp)
  MOVL -4(%ebp), %eax
  IMUL $1000, %eax
  MOVL  %eax, -16(%ebp)
  MOVL -16(%ebp), %eax
  MOVL 8(%ebp), %edx
  IMUL %edx, %eax
  MOVL  %eax, -20(%ebp)
  MOVL -20(%ebp), %eax
  MOVL -8(%ebp), %edx
  IMUL %edx, %eax
  MOVL  %eax, -24(%ebp)
  MOVL -24(%ebp), %eax
  LEAVE
  RET

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-24%ebp
  CALL printf
  LEAVE
  RET
