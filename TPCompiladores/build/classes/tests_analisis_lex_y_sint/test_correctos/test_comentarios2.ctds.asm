
.TEXT

  .GLOBL pruAritmetica
  TYPE pruAritmetica, @function
pruAritmetica:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-8%ebp
  MOVL 8(%ebp), %eax
  MOVL 12(%ebp), %ebx
  CMP  %ebx, %eax
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -8(%ebp)
  JG LIF1
  MOVL 8(%ebp), %eax
  MOVL %eax, -4(%ebp)
LIF1:
  MOVL 12(%ebp), %eax
  MOVL %eax, -4(%ebp)
  MOVL -4(%ebp), %eax
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
