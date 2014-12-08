COMM w, 4, 4
COMM res, 4, 4
COMM m, 4, 4

.TEXT

  .GLOBL potencia
  TYPE potencia, @function
potencia:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-160%ebp
  MOVL $False, %eax
  MOVL %eax, -8(%ebp)
  MOVL $1, %eax
  MOVL %eax, -4(%ebp)
  MOVL .LC0, %eax
  MOVL %eax, -12(%ebp)
  MOVL 12(%ebp), %eax
  CMP $0, %eax
  JL SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -84(%ebp)
  JL LIF1
  MOVL 12(%ebp), %eax
  NOT  %eax
  MOVL  %eax, -88(%ebp)
  MOVL -88(%ebp), %eax
  MOVL %eax, 12(%ebp)
  MOVL $True, %eax
  MOVL %eax, -8(%ebp)
LIF1:
BI2:
  MOVL -4(%ebp), %eax
  MOVL 12(%ebp), %ebx
  CMP  %ebx, %eax
  JL SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -92(%ebp)
  MOVL -4(%ebp), %eax
  MOVL 12(%ebp), %ebx
  CMP  %ebx, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -96(%ebp)
  MOVL -92(%ebp), %eax
  MOVL -96(%ebp), %edx
  OR %edx, %eax
  MOVL  %eax, -100(%ebp)
  MOVL -100(%ebp), %eax
  CMP %eax, $1
  JE EI3
  FLDS -12(%ebp)
  FLDS 8(%ebp)
  FMULP %st, %st(1)
  FSTPS -104(%ebp)
  FLDS -104(%ebp)
  FLDS .LC1
  FMULP %st, %st(1)
  FSTPS -108(%ebp)
  MOVL -108(%ebp), %eax
  MOVL %eax, -12(%ebp)
  MOVL -4(%ebp), %eax
  ADDL $1, %eax
  MOVL  %eax, -112(%ebp)
  MOVL -112(%ebp), %eax
  MOVL %eax, -4(%ebp)
  JMP BI2
EI3:
  MOVL -8(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOVL $1, %eax
isTrue:
  MOVL $0, %eax
  MOVL  %eax, -120(%ebp)
  MOVL -120(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOVL $1, %eax
isTrue:
  MOVL $0, %eax
  MOVL  %eax, -116(%ebp)
  CMP %eax, $1
  JE LIF4
  FLDS -12(%ebp)
  FLDS .LC2
  FDIVP %st, %st(1)
  FSTPS -124(%ebp)
  MOVL -124(%ebp), %eax
  LEAVE
  RET

LIF4:
  MOVL -12(%ebp), %eax
  LEAVE
  RET

  FLDS .LC3
  FCHS 
  FSTPS -128(%ebp)
  MOVL -128(%ebp), %eax
  LEAVE
  RET

  .GLOBL multRepeat
  TYPE multRepeat, @function
multRepeat:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-160%ebp
  FLDS 12(%ebp)
  FLDS 12(%ebp)
  FMULP %st, %st(1)
  FSTPS -132(%ebp)
  MOVL -132(%ebp), %eax
  MOVL 8(%ebp), %edx
  IMUL %edx, %eax
  MOVL  %eax, -136(%ebp)
  MOVL -136(%ebp), %eax
  MOVL 8(%ebp), %edx
  IMUL %edx, %eax
  MOVL  %eax, -140(%ebp)
  MOVL -140(%ebp), %eax
  MOVL 8(%ebp), %edx
  IMUL %edx, %eax
  MOVL  %eax, -144(%ebp)
  MOVL -144(%ebp), %eax
  MOVL 12(%ebp), %edx
  IMUL %edx, %eax
  MOVL  %eax, -148(%ebp)
  MOVL -148(%ebp), %eax
  MOVL %eax, -4(%ebp)
  MOVL -4(%ebp), %eax
  LEAVE
  RET

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-160%ebp
  FLDS .LC4
  FCHS 
  FSTPS -152(%ebp)
  MOVL -152(%ebp), %eax
  MOVL %eax, res
  MOVL .LC5, %eax
  MOVL %eax, w
  FLDS .LC6
  FCHS 
  FSTPS -156(%ebp)
  MOVL -156(%ebp), %eax
  MOVL %eax, m
  MOVL .LC7, %eax
  MOVL %eax, -8(%ebp)
  MOVL --8(%ebp), %eax
  MOVL %eax, 0(%esp)
  CALL potencia
  MOVL  %eax, -160(%ebp)
  MOVL -160(%ebp), %eax
  MOVL %eax, -4(%ebp)
  CALL printf
  LEAVE
  RET

  LEAVE
  RET
.LC1:
  .float 1.0
.LC2:
  .float 2.0
.LC3:
  .float 1.0
.LC4:
  .float 100.0
.LC5:
  .float 15.0
.LC6:
  .float 4.0
.LC7:
  .float 7.0
.LC8:
  .float 80.0
