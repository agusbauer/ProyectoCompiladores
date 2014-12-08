
.TEXT

  .GLOBL div
  TYPE div, @function
div:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-32%ebp
  FLDS 8(%ebp)
  FLDS 12(%ebp)
  FDIVP %st, %st(1)
  FSTPS -20(%ebp)
  MOVL -20(%ebp), %eax
  LEAVE
  RET

  .GLOBL resta
  TYPE resta, @function
resta:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-32%ebp
  FLDS 8(%ebp)
  FLDS 12(%ebp)
  FSUBP %st, %st(1)
  FSTPS -24(%ebp)
  MOVL -24(%ebp), %eax
  LEAVE
  RET

  .GLOBL sum
  TYPE sum, @function
sum:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-32%ebp
  FLDS 8(%ebp)
  FLDS 12(%ebp)
  FADDP %st, %st(1)
  FSTPS -28(%ebp)
  MOVL -28(%ebp), %eax
  LEAVE
  RET

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-32%ebp
  MOVL .LC0, %eax
  MOVL %eax, -4(%ebp)
  FLDS .LC1
  FCHS 
  FSTPS -32(%ebp)
  MOVL -32(%ebp), %eax
  MOVL %eax, -8(%ebp)
  MOVL .LC2, %eax
  MOVL %eax, -12(%ebp)
  CALL printf
  LEAVE
  RET
.LC1:
  .float 6.98
.LC2:
  .float 2.0
.LC3:
  .float 3.569
