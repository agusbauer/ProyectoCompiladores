
.TEXT

  .GLOBL breaks
  TYPE breaks, @function
breaks:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-24%ebp
  MOVL $0, %eax
  MOVL %eax, -4(%ebp)
BI1:
  MOVL -4(%ebp), %eax
  CMP $10, %eax
  JL SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -16(%ebp)
  JL EI2
  MOVL -4(%ebp), %eax
  ADDL $1, %eax
  MOVL  %eax, -20(%ebp)
  MOVL -20(%ebp), %eax
  MOVL %eax, -4(%ebp)
  MOVL 8(%ebp), %eax
  CMP $0, %eax
  JL SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -24(%ebp)
  JL LIF3
  JMP BI2
LIF3:
  JMP BI1
  JMP BI1
EI2:
  MOVL -4(%ebp), %eax
  LEAVE
  RET

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
