COMM A, 20, 4
COMM B, 224, 4
COMM C, 40, 4

.TEXT

  .GLOBL pruArreglos
  TYPE pruArreglos, @function
pruArreglos:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-32%ebp
  MOVL $2, %eax
  MOVL %eax, A
  MOVL A, %eax
  LEAVE
  RET

BI1:
  MOVL $5, %eax
  MOVL %eax, -20(%ebp)
  MOVL -20(%ebp), %eax
  IMUL $10, %eax
  MOVL  %eax, -24(%ebp)
  MOVL -24(%ebp), %eax
  CMP $5, %eax
  JLE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -28(%ebp)
  JLE EI2
  MOVL -20(%ebp), %eax
  ADDL $2, %eax
  MOVL  %eax, -32(%ebp)
  MOVL -32(%ebp), %eax
  MOVL %eax, A
  JMP BI1
EI2:
  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-32%ebp
  CALL printf
  MOVL 1, %eax
  LEAVE
  RET

  LEAVE
  RET
