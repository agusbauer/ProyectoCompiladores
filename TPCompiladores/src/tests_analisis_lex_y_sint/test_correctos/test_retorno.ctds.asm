
.TEXT

  .GLOBL id
  TYPE id, @function
id:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-152%ebp
  MOVL $100, %eax
  MOVL %eax, -4(%ebp)
  MOVL $0, %eax
  MOVL %eax, -8(%ebp)
  MOVL 8(%ebp), %eax
  MOVL %eax, -12(%ebp)
BI1:
  MOVL -8(%ebp), %eax
  MOVL -4(%ebp), %ebx
  CMP  %ebx, %eax
  ANDB $69,%ah
  CMPB $1,%ah
  JL SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -80(%ebp)
  JL EI2
  MOVL 8(%ebp), %eax
  MOVL %eax, -4(%ebp)
BI3:
  MOVL 8(%ebp), %eax
  CMP $0, %eax
  ANDB $69,%ah
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -84(%ebp)
  MOVL 8(%ebp), %eax
  CMP $0, %eax
  ANDB $69,%ah
  CMPB $1,%ah
  JL SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -88(%ebp)
  MOVL -84(%ebp), %eax
  MOVL -88(%ebp), %edx
  OR %edx, %eax
  MOVL  %eax, -92(%ebp)
  MOVL -92(%ebp), %eax
  CMP %eax, $1
  JE EI4
  MOVL 8(%ebp), %eax
  CMP $0, %eax
  ANDB $69,%ah
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -96(%ebp)
  JG LIF5
  MOVL 8(%ebp), %eax
  SUBL $1, %eax
  MOVL  %eax, -100(%ebp)
  MOVL -100(%ebp), %eax
  MOVL %eax, 8(%ebp)
LIF5:
  MOVL 8(%ebp), %eax
  ADDL $1, %eax
  MOVL  %eax, -104(%ebp)
  MOVL -104(%ebp), %eax
  MOVL %eax, 8(%ebp)
  JMP BI3
EI4:
BI6:
  MOVL 8(%ebp), %eax
  MOVL -4(%ebp), %ebx
  CMP  %ebx, %eax
  ANDB $69,%ah
  CMPB $1,%ah
  JL SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -108(%ebp)
  MOVL 8(%ebp), %eax
  MOVL -4(%ebp), %ebx
  CMP  %ebx, %eax
  ANDB $69,%ah
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -112(%ebp)
  MOVL -108(%ebp), %eax
  MOVL -112(%ebp), %edx
  OR %edx, %eax
  MOVL  %eax, -116(%ebp)
  MOVL -116(%ebp), %eax
  CMP %eax, $1
  JE EI7
  MOVL 8(%ebp), %eax
  MOVL -4(%ebp), %ebx
  CMP  %ebx, %eax
  ANDB $69,%ah
  CMPB $1,%ah
  JL SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -120(%ebp)
  JL LIF8
  MOVL 8(%ebp), %eax
  ADDL $1, %eax
  MOVL  %eax, -124(%ebp)
  MOVL -124(%ebp), %eax
  MOVL %eax, 8(%ebp)
LIF8:
  MOVL 8(%ebp), %eax
  MOVL 8(%ebp), %ebx
  CMP  %ebx, %eax
  ANDB $69,%ah
  CMPB $64,%ah
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -128(%ebp)
  JE LIF9
  MOVL 8(%ebp), %eax
  SUBL $1, %eax
  MOVL  %eax, -132(%ebp)
  MOVL -8(%ebp), %eax
  MOVL 8(%ebp), %edx
  IMUL %edx, %eax
  MOVL  %eax, -136(%ebp)
  MOVL -8(%ebp), %eax
  MOVL 8(%ebp), %edx
  IMUL %edx, %eax
  MOVL  %eax, -140(%ebp)
  MOVL -136(%ebp), %eax
  MOVL -140(%ebp), %edx
  SUBL %edx, %eax
  MOVL  %eax, -144(%ebp)
  MOVL -132(%ebp), %eax
  MOVL -144(%ebp), %edx
  ADDL %edx, %eax
  MOVL  %eax, -148(%ebp)
  MOVL -148(%ebp), %eax
  MOVL %eax, 8(%ebp)
LIF9:
  JMP BI6
EI7:
  MOVL -12(%ebp), %eax
  MOVL %eax, 8(%ebp)
  MOVL -8(%ebp), %eax
  ADDL $1, %eax
  MOVL  %eax, -152(%ebp)
  MOVL -152(%ebp), %eax
  MOVL %eax, -8(%ebp)
  JMP BI6
EI7:
  MOVL x, %eax
  LEAVE
  RET

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-152%ebp
  CALL printf
  LEAVE
  RET
