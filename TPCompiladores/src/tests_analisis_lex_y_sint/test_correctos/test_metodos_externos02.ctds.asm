
.TEXT

  .GLOBL maxcomdiv
  TYPE maxcomdiv, @function
maxcomdiv:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-24%ebp
  MOVL 8(%ebp), %eax
  MOVL 12(%ebp), %ebx
  CMP  %ebx, %eax
  ANDB $69,%ah
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -16(%ebp)
  JG LIF1
  MOVL 8(%ebp), %eax
  MOVL %eax, -4(%ebp)
  MOVL 12(%ebp), %eax
  MOVL %eax, -8(%ebp)
LIF1:
  MOVL 12(%ebp), %eax
  MOVL %eax, -4(%ebp)
  MOVL 8(%ebp), %eax
  MOVL %eax, -8(%ebp)
  MOVL $1, %eax
  MOVL %eax, -12(%ebp)
BI2:
  MOVL -12(%ebp), %eax
  CMP $0, %eax
  ANDB $68,%ah
  XORB $64,%ah
  JNE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -20(%ebp)
  JNE EI3
  MOVL -4(%ebp), %edx
  MOVL -8(%ebp), %ecx
  IDIV %ecx
  MOVL  %edx, -24(%ebp)
  MOVL -24(%ebp), %eax
  MOVL %eax, -12(%ebp)
  MOVL -8(%ebp), %eax
  MOVL %eax, -4(%ebp)
  MOVL -12(%ebp), %eax
  MOVL %eax, -8(%ebp)
  JMP BI2
EI3:
  MOVL dividendo, %eax
  LEAVE
  RET

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-24%ebp
  MOVL $3, %eax
  MOVL %eax, -4(%ebp)
  CALL printf
  LEAVE
  RET
