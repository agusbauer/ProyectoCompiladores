
.TEXT

  .GLOBL suma
  TYPE suma, @function
suma:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $24%ebp
  MOVL -0(%ebp), %eax
  CMP $0, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -16(%ebp)
  JE LIF1
  MOVL num2, %eax
  LEAVE
  RET

LIF1:
  MOVL -0(%ebp), %eax
  CMP $0, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -20(%ebp)
  JE LIF2
  MOVL num1, %eax
  LEAVE
  RET

LIF2:
  MOVL -0(%ebp), %eax
  MOVL -0(%ebp), %edx
  ADDL %edx, %eax
  MOVL  %eax, -24(%ebp)
  MOVL temp3, %eax
  LEAVE
  RET

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $24%ebp
  CALL printf
  LEAVE
  RET
