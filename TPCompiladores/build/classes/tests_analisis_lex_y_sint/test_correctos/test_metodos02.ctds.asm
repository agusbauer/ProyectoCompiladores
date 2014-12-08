COMM c, 4, 4

.TEXT

  .GLOBL alo
  TYPE alo, @function
alo:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-48%ebp
  CMP %eax, $1
  JE LIF1
  MOVL 12(%ebp), %eax
  ADDL $1, %eax
  MOVL  %eax, -28(%ebp)
  MOVL -28(%ebp), %eax
  MOVL %eax, 12(%ebp)
LIF1:
  MOVL 12(%ebp), %eax
  SUBL $1, %eax
  MOVL  %eax, -32(%ebp)
  MOVL -32(%ebp), %eax
  MOVL %eax, 12(%ebp)
  LEAVE
  RET

  .GLOBL Alo
  TYPE Alo, @function
Alo:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-48%ebp
  LEAVE
  RET

  .GLOBL alo2
  TYPE alo2, @function
alo2:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-48%ebp
  MOVL -8(%ebp), %eax
  MOVL %eax, 4(%esp)
  CALL alo
  MOVL  %eax, -36(%ebp)
  MOVL 8(%ebp), %eax
  ADDL $1, %eax
  MOVL  %eax, -40(%ebp)
  MOVL -40(%ebp), %eax
  MOVL %eax, 8(%ebp)
  MOVL 8(%ebp), %eax
  LEAVE
  RET

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-48%ebp
  MOVL $7, %eax
  MOVL %eax, -4(%ebp)
  MOVL .LC0, %eax
  MOVL %eax, c
  MOVL --4(%ebp), %eax
  MOVL %eax, 0(%esp)
  CALL alo2
  MOVL  %eax, -44(%ebp)
  MOVL -44(%ebp), %eax
  MOVL %eax, -4(%ebp)
  CALL alo
  MOVL  %eax, -48(%ebp)
  LEAVE
  RET

  LEAVE
  RET
.LC1:
  .float 8.0
