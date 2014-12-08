
.TEXT

  .GLOBL prueba
  TYPE prueba, @function
prueba:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-64%ebp
  MOVL $50, %eax
  MOVL %eax, -12(%ebp)
  MOVL -12(%ebp), %eax
  CMP $0, %eax
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -36(%ebp)
  JG LIF1
  MOVL $4, %eax
  MOVL %eax, -4(%ebp)
  MOVL -4(%ebp), %eax
  CMP $4, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -40(%ebp)
  JE LIF2
BI3:
  MOVL -4(%ebp), %eax
  CMP $4, %eax
  JL SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -44(%ebp)
  JL EI4
BI5:
  MOVL -12(%ebp), %eax
  CMP $4, %eax
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -48(%ebp)
  JG EI6
  MOVL -12(%ebp), %eax
  SUBL $1, %eax
  MOVL  %eax, -52(%ebp)
  MOVL -52(%ebp), %eax
  MOVL %eax, -12(%ebp)
  MOVL -4(%ebp), %eax
  IMUL $2, %eax
  MOVL  %eax, -56(%ebp)
  MOVL -56(%ebp), %eax
  MOVL %eax, -8(%ebp)
  JMP BI5
EI6:
  MOVL -4(%ebp), %eax
  ADDL $1, %eax
  MOVL  %eax, -60(%ebp)
  MOVL -60(%ebp), %eax
  MOVL %eax, -4(%ebp)
  MOVL -8(%ebp), %edx
  IDIV $2
  MOVL  %eax, -64(%ebp)
  MOVL -64(%ebp), %eax
  MOVL %eax, -8(%ebp)
  JMP BI5
EI6:
LIF6:
LIF6:
  MOVL -8(%ebp), %eax
  LEAVE
  RET

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-64%ebp
  CALL printf
  LEAVE
  RET
