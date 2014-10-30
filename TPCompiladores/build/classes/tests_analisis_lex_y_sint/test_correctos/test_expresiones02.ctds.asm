
.TEXT

  .GLOBL prueba
  TYPE prueba, @function
prueba:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $40%ebp
  MOVL $4, %eax
  MOVL %eax, -12(%ebp)
  MOVL $5, %eax
  MOVL %eax, -16(%ebp)
  MOVL -12(%ebp), %eax
  MOVL -16(%ebp), %edx
  IMUL %edx, %eax
  MOVL  %eax, -24(%ebp)
  MOVL -24(%ebp), %eax
  MOVL %eax, -4(%ebp)
  MOVL -4(%ebp), %eax
  MOVL -0(%ebp), %edx
  ADDL %edx, %eax
  MOVL  %eax, -28(%ebp)
  MOVL -28(%ebp), %eax
  MOVL %eax, -0(%ebp)
  MOVL $3.1, %eax
  MOVL %eax, -20(%ebp)
  MOVL -20(%ebp), %eax
  IMUL $2.0, %eax
  MOVL  %eax, -32(%ebp)
  MOVL -32(%ebp), %eax
  MOVL %eax, -8(%ebp)
  MOVL -4(%ebp), %edx
  MOVL -8(%ebp), %ecx
  IDIV %ecx
  MOVL  %eax, -36(%ebp)
  MOVL -36(%ebp), %eax
  CMP $5, %eax
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -40(%ebp)
  JG LIF1
  MOVL 1, %eax
  LEAVE
  RET

LIF1:
  MOVL 0, %eax
  LEAVE
  RET

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $40%ebp
  CALL printf
  LEAVE
  RET
