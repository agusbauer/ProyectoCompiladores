
.TEXT

  .GLOBL main
.TYPE main, @function

sumx:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $32%ebp
  MOVL $0.0, %eax
  MOVL %eax, -4(%ebp)
  MOVL $0, %eax
  MOVL %eax, -8(%ebp)
BI1:
  MOVL -8(%ebp), %eax
  MOVL -0(%ebp), %ebx
  CMP  %ebx, %eax
  JL SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -24(%ebp)
  JL EI2
  MOVL -4(%ebp), %eax
  MOVL -0(%ebp), %edx
  ADDL %edx, %eax
  MOVL  %eax, -28(%ebp)
  MOVL -28(%ebp), %eax
  MOVL %eax, -4(%ebp)
  MOVL -8(%ebp), %eax
  ADDL $1, %eax
  MOVL  %eax, -32(%ebp)
  MOVL -32(%ebp), %eax
  MOVL %eax, -8(%ebp)
  JMP BI1
EI2:
  MOVL aux, %eax
  leave
  ret

main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $32%ebp
  CALL printf
  LEAVE
  RET
