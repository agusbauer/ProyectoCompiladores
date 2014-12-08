
.TEXT

  .GLOBL pruAritmetica
  TYPE pruAritmetica, @function
pruAritmetica:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-40%ebp
  MOVL 8(%ebp), %eax
  MOVL 12(%ebp), %ebx
  CMP  %ebx, %eax
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -24(%ebp)
  JG LIF1
  MOVL 8(%ebp), %eax
  MOVL 12(%ebp), %edx
  SUBL %edx, %eax
  MOVL  %eax, -28(%ebp)
  MOVL -28(%ebp), %eax
  MOVL %eax, -4(%ebp)
LIF1:
  MOVL 8(%ebp), %eax
  MOVL 12(%ebp), %ebx
  CMP  %ebx, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -32(%ebp)
  JE LIF2
  MOVL 8(%ebp), %eax
  IMUL $5, %eax
  MOVL  %eax, -36(%ebp)
  MOVL -36(%ebp), %eax
  MOVL %eax, -4(%ebp)
LIF2:
  MOVL 12(%ebp), %eax
  MOVL 8(%ebp), %edx
  SUBL %edx, %eax
  MOVL  %eax, -40(%ebp)
  MOVL -40(%ebp), %eax
  MOVL %eax, -4(%ebp)
  MOVL -4(%ebp), %eax
  LEAVE
  RET

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-40%ebp
  CALL printf
  CALL printf
  CALL printf
  CALL printf
  LEAVE
  RET
