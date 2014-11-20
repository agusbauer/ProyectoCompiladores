
.TEXT

  .GLOBL pruebaLogica
  TYPE pruebaLogica, @function
pruebaLogica:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-40%ebp
  MOVL $True, %eax
  MOVL %eax, -4(%ebp)
  MOVL -4(%ebp), %eax
  OR $False, %eax
  MOVL  %eax, -24(%ebp)
  MOVL True, %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOVL $1, %eax
isTrue:
  MOVL $0, %eax
  MOVL  %eax, -28(%ebp)
  MOVL -24(%ebp), %eax
  MOVL -28(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -32(%ebp)
  MOVL 8(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOVL $1, %eax
isTrue:
  MOVL $0, %eax
  MOVL  %eax, -36(%ebp)
  MOVL -32(%ebp), %eax
  MOVL -36(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -40(%ebp)
  MOVL -40(%ebp), %eax
  LEAVE
  RET

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-40%ebp
  CALL printf
  LEAVE
  RET
