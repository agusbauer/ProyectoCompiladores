COMM A, 20, 4
COMM B, 224, 4
COMM C, 40, 4

.TEXT

  .GLOBL pruArreglos
  TYPE pruArreglos, @function
pruArreglos:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-24%ebp
  MOVL $2, %eax
  MOVL %eax, A
  MOVL A, %eax
  LEAVE
  RET

BI1:
  MOVL $5, %eax
  MOVL %eax, -16(%ebp)
  MOVL $10, %eax
  CMP $5, %eax
  JLE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -20(%ebp)
  JLE EI2
  MOVL -16(%ebp), %eax
  ADDL $2, %eax
  MOVL  %eax, -24(%ebp)
  MOVL -24(%ebp), %eax
  MOVL %eax, A
  JMP BI1
EI2:
  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-24%ebp
  CALL printf
  MOVL 1, %eax
  LEAVE
  RET

  LEAVE
  RET
