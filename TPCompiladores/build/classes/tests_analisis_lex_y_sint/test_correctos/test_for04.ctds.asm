COMM A, 20, 4
COMM B, 224, 4
COMM C, 40, 4

.TEXT

  .GLOBL pruArreglos
  TYPE pruArreglos, @function
pruArreglos:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-48%ebp
  MOVL $2, %eax
  MOVL %eax, A
  MOVL A, %eax
  LEAVE
  RET

BI1:
  MOVL $0, %eax
  MOVL %eax, -28(%ebp)
  MOVL 10, %eax
  NOT  %eax
  MOVL  %eax, -32(%ebp)
  MOVL $2, %eax
  IMUL $11, %eax
  MOVL  %eax, -36(%ebp)
  MOVL -32(%ebp), %eax
  MOVL -36(%ebp), %edx
  ADDL %edx, %eax
  MOVL  %eax, -40(%ebp)
  MOVL -40(%ebp), %eax
  CMP $0, %eax
  JLE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -44(%ebp)
  JLE EI2
  MOVL -28(%ebp), %eax
  ADDL $2, %eax
  MOVL  %eax, -48(%ebp)
  MOVL -48(%ebp), %eax
  MOVL %eax, A
  JMP BI1
EI2:
  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-48%ebp
  CALL printf
  MOVL 1, %eax
  LEAVE
  RET

  LEAVE
  RET
