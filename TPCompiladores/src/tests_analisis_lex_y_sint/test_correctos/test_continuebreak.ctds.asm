
.TEXT

  .GLOBL main
.TYPE main, @function

pruContinue:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $100%ebp
  MOVL 1.0, %eax
  NOT  %eax
  MOVL  %eax, -60(%ebp)
  MOVL -60(%ebp), %eax
  MOVL %eax, -12(%ebp)
  MOVL $23, %eax
  MOVL %eax, -8(%ebp)
  MOVL $23.0, %eax
  MOVL %eax, -4(%ebp)
BI1:
  MOVL -4(%ebp), %eax
  CMP $0.0, %eax
  JGE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -64(%ebp)
  JGE EI2
  MOVL -4(%ebp), %eax
  SUBL $1, %eax
  MOVL  %eax, -68(%ebp)
  MOVL -68(%ebp), %eax
  MOVL %eax, -4(%ebp)
  MOVL -0(%ebp), %eax
  MOVL -0(%ebp), %ebx
  CMP  %ebx, %eax
  JL SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -72(%ebp)
  JL LIF3
  MOVL -4(%ebp), %eax
  CMP $0.0, %eax
  JNE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -76(%ebp)
  JNE LIF4
  MOVL -12(%ebp), %eax
  MOVL -0(%ebp), %edx
  IMUL %edx, %eax
  MOVL  %eax, -80(%ebp)
  MOVL -80(%ebp), %eax
  MOVL -0(%ebp), %edx
  IMUL %edx, %eax
  MOVL  %eax, -84(%ebp)
  MOVL -84(%ebp), %eax
  MOVL %eax, -12(%ebp)
LIF4:
  JMP BI1
LIF4:
  MOVL 1000.234, %eax
  NOT  %eax
  MOVL  %eax, -88(%ebp)
  MOVL -88(%ebp), %eax
  ADDL $6752, %eax
  MOVL  %eax, -92(%ebp)
  MOVL -92(%ebp), %eax
  MOVL %eax, -12(%ebp)
  JMP BI2
  JMP BI1
EI2:
  MOVL -12(%ebp), %eax
  IMUL $2, %eax
  MOVL  %eax, -100(%ebp)
  MOVL -100(%ebp), %eax
  NOT  %eax
  MOVL  %eax, -96(%ebp)
  MOVL temp10, %eax
  leave
  ret

main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $100%ebp
  CALL printf
  LEAVE
  RET
