
.TEXT

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-32%ebp
  MOVL $True, %eax
  MOVL %eax, -4(%ebp)
  MOVL -4(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOVL $1, %eax
isTrue:
  MOVL $0, %eax
  MOVL  %eax, -20(%ebp)
  MOVL --20(%ebp), %eax
  MOVL %eax, --8(%ebp)
  MOVL -4(%ebp), %eax
  MOVL -8(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -24(%ebp)
  MOVL -8(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOVL $1, %eax
isTrue:
  MOVL $0, %eax
  MOVL  %eax, -28(%ebp)
  MOVL -24(%ebp), %eax
  MOVL -28(%ebp), %edx
  OR %edx, %eax
  MOVL  %eax, -32(%ebp)
  MOVL --32(%ebp), %eax
  MOVL %eax, --12(%ebp)
  CALL printf
  LEAVE
  RET
