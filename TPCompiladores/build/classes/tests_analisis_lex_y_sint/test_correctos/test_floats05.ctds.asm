
.TEXT

  .GLOBL div
  TYPE div, @function
div:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $32%ebp
  MOVL -0(%ebp), %edx
  MOVL -0(%ebp), %ecx
  IDIV %ecx
  MOVL  %eax, -20(%ebp)
  MOVL temp1, %eax
  LEAVE
  RET

  .GLOBL resta
  TYPE resta, @function
resta:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $32%ebp
  MOVL -0(%ebp), %eax
  MOVL -0(%ebp), %edx
  SUBL %edx, %eax
  MOVL  %eax, -24(%ebp)
  MOVL temp2, %eax
  LEAVE
  RET

  .GLOBL sum
  TYPE sum, @function
sum:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $32%ebp
  MOVL -0(%ebp), %eax
  MOVL -0(%ebp), %edx
  ADDL %edx, %eax
  MOVL  %eax, -28(%ebp)
  MOVL temp3, %eax
  LEAVE
  RET

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $32%ebp
  MOVL $6.98, %eax
  MOVL %eax, -4(%ebp)
  MOVL 2.0, %eax
  NOT  %eax
  MOVL  %eax, -32(%ebp)
  MOVL -32(%ebp), %eax
  MOVL %eax, -8(%ebp)
  MOVL $3.569, %eax
  MOVL %eax, -12(%ebp)
  CALL printf
  LEAVE
  RET
