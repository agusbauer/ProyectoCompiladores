
.TEXT

  .GLOBL sumatoria
  TYPE sumatoria, @function
sumatoria:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-48%ebp
  MOVL .LC0, %eax
  MOVL %eax, -4(%ebp)
  MOVL 8(%ebp), %eax
  MOVL %eax, -8(%ebp)
BI1:
  FLDS -8(%ebp)
  FLDS .LC1
  FUCOMPP
  FNSTSW %ax
  ANDB $69,%ah
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -28(%ebp)
  FLDS -8(%ebp)
  FLDS .LC2
  FUCOMPP
  FNSTSW %ax
  ANDB $69,%ah
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -32(%ebp)
  MOVL -28(%ebp), %eax
  MOVL -32(%ebp), %edx
  OR %edx, %eax
  MOVL  %eax, -36(%ebp)
  MOVL -36(%ebp), %eax
  CMP %eax, $1
  JE EI2
  FLDS -8(%ebp)
  FLDS .LC3
  FUCOMPP
  FNSTSW %ax
  ANDB $69,%ah
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -40(%ebp)
  JG LIF3
  FLDS -4(%ebp)
  FLDS -8(%ebp)
  FADDP %st, %st(1)
  FSTPS -44(%ebp)
  MOVL -44(%ebp), %eax
  MOVL %eax, -4(%ebp)
LIF3:
  FLDS -8(%ebp)
  FLDS .LC4
  FSUBP %st, %st(1)
  FSTPS -8(%ebp)
  JMP BI1
EI2:
  MOVL -4(%ebp), %eax
  MOVL %eax, -12(%ebp)
  MOVL res, %eax
  LEAVE
  RET

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-48%ebp
  MOVL .LC5, %eax
  MOVL %eax, -8(%ebp)
  MOVL --8(%ebp), %eax
  MOVL %eax, 0(%esp)
  CALL sumatoria
  MOVL  %eax, -48(%ebp)
  MOVL -48(%ebp), %eax
  MOVL %eax, -4(%ebp)
  CALL printf
  LEAVE
  RET

  LEAVE
  RET
.LC1:
  .float 0.0
.LC2:
  .float 0.0
.LC3:
  .float 0.0
.LC4:
  .float 0.0
.LC5:
  .float 1.0
.LC6:
  .float 8.0
