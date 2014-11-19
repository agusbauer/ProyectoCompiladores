
.TEXT

  .GLOBL promedio
  TYPE promedio, @function
promedio:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-160%ebp
  FLDS 8(%ebp)
  FLDS 16(%ebp)
  FUCOMPP
  FNSTSW %ax
  ANDB $69,%ah
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -84(%ebp)
  FLDS 12(%ebp)
  FLDS 16(%ebp)
  FUCOMPP
  FNSTSW %ax
  ANDB $69,%ah
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -88(%ebp)
  MOVL -84(%ebp), %eax
  MOVL -88(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -92(%ebp)
  MOVL -92(%ebp), %eax
  CMP %eax, $1
  JE LIF1
  FLDS 8(%ebp)
  FLDS 12(%ebp)
  FADDP %st, %st(1)
  FSTPS -96(%ebp)
  FLDS -96(%ebp)
  FLDS .LC0
  FDIVP %st, %st(1)
  FSTPS -100(%ebp)
  MOVL temp5, %eax
  LEAVE
  RET

LIF1:
  FLDS 8(%ebp)
  FLDS 12(%ebp)
  FUCOMPP
  FNSTSW %ax
  ANDB $69,%ah
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -104(%ebp)
  FLDS 16(%ebp)
  FLDS 12(%ebp)
  FUCOMPP
  FNSTSW %ax
  ANDB $69,%ah
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -108(%ebp)
  MOVL -104(%ebp), %eax
  MOVL -108(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -112(%ebp)
  MOVL -112(%ebp), %eax
  CMP %eax, $1
  JE LIF2
  FLDS 8(%ebp)
  FLDS 16(%ebp)
  FADDP %st, %st(1)
  FSTPS -116(%ebp)
  FLDS -116(%ebp)
  FLDS .LC1
  FDIVP %st, %st(1)
  FSTPS -120(%ebp)
  MOVL temp10, %eax
  LEAVE
  RET

LIF2:
  FLDS 12(%ebp)
  FLDS 8(%ebp)
  FUCOMPP
  FNSTSW %ax
  ANDB $69,%ah
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -124(%ebp)
  FLDS 16(%ebp)
  FLDS 8(%ebp)
  FUCOMPP
  FNSTSW %ax
  ANDB $69,%ah
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -128(%ebp)
  MOVL -124(%ebp), %eax
  MOVL -128(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -132(%ebp)
  MOVL -132(%ebp), %eax
  CMP %eax, $1
  JE LIF3
  FLDS 16(%ebp)
  FLDS 12(%ebp)
  FADDP %st, %st(1)
  FSTPS -136(%ebp)
  FLDS -136(%ebp)
  FLDS .LC2
  FDIVP %st, %st(1)
  FSTPS -140(%ebp)
  MOVL temp15, %eax
  LEAVE
  RET

LIF3:
  FLDS 8(%ebp)
  FLDS 12(%ebp)
  FUCOMPP
  FNSTSW %ax
  ANDB $69,%ah
  CMPB $64,%ah
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -144(%ebp)
  FLDS 8(%ebp)
  FLDS 16(%ebp)
  FUCOMPP
  FNSTSW %ax
  ANDB $69,%ah
  CMPB $64,%ah
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -148(%ebp)
  MOVL -144(%ebp), %eax
  MOVL -148(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -152(%ebp)
  FLDS 12(%ebp)
  FLDS 16(%ebp)
  FUCOMPP
  FNSTSW %ax
  ANDB $69,%ah
  CMPB $64,%ah
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -156(%ebp)
  MOVL -152(%ebp), %eax
  MOVL -156(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -160(%ebp)
  MOVL -160(%ebp), %eax
  CMP %eax, $1
  JE LIF4
  MOVL nota1, %eax
  LEAVE
  RET

LIF4:
  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-160%ebp
  CALL printf
  MOVL 1, %eax
  LEAVE
  RET

  LEAVE
  RET
.LC1:
  .float 2.0
.LC2:
  .float 2.0
.LC3:
  .float 2.0
