
.TEXT

  .GLOBL prueba
  TYPE prueba, @function
prueba:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-40%ebp
  MOVL $4, %eax
  MOVL %eax, -12(%ebp)
  MOVL $5, %eax
  MOVL %eax, -16(%ebp)
  MOVL -12(%ebp), %eax
  MOVL -16(%ebp), %edx
  IMUL %edx, %eax
  MOVL  %eax, -24(%ebp)
  MOVL --24(%ebp), %eax
  MOVL %eax, --4(%ebp)
  MOVL -4(%ebp), %eax
  MOVL 8(%ebp), %edx
  ADDL %edx, %eax
  MOVL  %eax, -28(%ebp)
  MOVL --28(%ebp), %eax
  MOVL %eax, -8(%ebp)
  MOVL .LC0, %eax
  MOVL %eax, -20(%ebp)
  FLDS -20(%ebp)
  FLDS .LC1
  FMULP %st, %st(1)
  FSTPS -32(%ebp)
  MOVL --32(%ebp), %eax
  MOVL %eax, --8(%ebp)
  MOVL -4(%ebp), %edx
  MOVL -8(%ebp), %ecx
  IDIV %ecx
  MOVL  %eax, -36(%ebp)
  MOVL -36(%ebp), %eax
  CMP $5, %eax
  ANDB $69,%ah
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -40(%ebp)
  JG LIF1
  MOVL 1, %eax
  LEAVE
  RET

LIF1:
  MOVL 0, %eax
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
.LC1:
  .float 3.1
.LC2:
  .float 2.0
