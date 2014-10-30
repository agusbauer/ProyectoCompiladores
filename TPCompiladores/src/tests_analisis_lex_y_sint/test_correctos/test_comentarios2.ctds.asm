
.TEXT

  .GLOBL pruAritmetica
  TYPE pruAritmetica, @function
pruAritmetica:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $8%ebp
  MOVL -0(%ebp), %eax
  MOVL -0(%ebp), %ebx
  CMP  %ebx, %eax
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -8(%ebp)
  JG LIF1
  MOVL -0(%ebp), %eax
  MOVL %eax, -4(%ebp)
LIF1:
  MOVL -0(%ebp), %eax
  MOVL %eax, -4(%ebp)
  MOVL res, %eax
  LEAVE
  RET

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $8%ebp
  CALL printf
  LEAVE
  RET
