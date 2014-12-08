
.TEXT

  .GLOBL suma
  TYPE suma, @function
suma:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-24%ebp
  MOVL 8(%ebp), %eax
  CMP $0, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -16(%ebp)
  JE LIF1
  MOVL 12(%ebp), %eax
  LEAVE
  RET

LIF1:
  MOVL 12(%ebp), %eax
  CMP $0, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -20(%ebp)
  JE LIF2
  MOVL 8(%ebp), %eax
  LEAVE
  RET

LIF2:
  MOVL 8(%ebp), %eax
  MOVL 12(%ebp), %edx
  ADDL %edx, %eax
  MOVL  %eax, -24(%ebp)
  MOVL -24(%ebp), %eax
  LEAVE
  RET

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-24%ebp
  CALL printf
  LEAVE
  RET
