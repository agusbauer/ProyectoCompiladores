
.TEXT

  .GLOBL maxcomdiv
  TYPE maxcomdiv, @function
maxcomdiv:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-32%ebp
  MOVL $1, %eax
  MOVL %eax, -12(%ebp)
BI1:
  MOVL -12(%ebp), %eax
  CMP $0, %eax
  ANDB $68,%ah
  XORB $64,%ah
  JNE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -20(%ebp)
  JNE EI2
  MOVL -4(%ebp), %edx
  MOVL -8(%ebp), %ecx
  IDIV %ecx
  MOVL  %edx, -24(%ebp)
  MOVL -12(%ebp), %eax
  MOVL -24(%ebp), %edx
  ADDL %edx, %eax
  MOVL  %eax, -12(%ebp)
  MOVL -4(%ebp), %eax
  MOVL -8(%ebp), %edx
  SUBL %edx, %eax
  MOVL  %eax, -4(%ebp)
  JMP BI1
  JMP BI1
EI2:
BI3:
  MOVL -12(%ebp), %eax
  CMP $0, %eax
  ANDB $68,%ah
  XORB $64,%ah
  JNE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -28(%ebp)
  JNE EI4
  JMP BI4
  JMP BI3
EI4:
BI5:
  MOVL -12(%ebp), %eax
  CMP $0, %eax
  ANDB $68,%ah
  XORB $64,%ah
  JNE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -32(%ebp)
  JNE EI6
  JMP BI5
EI6:
  MOVL dividendo, %eax
  LEAVE
  RET

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-32%ebp
  CALL printf
  LEAVE
  RET
