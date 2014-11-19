COMM a, 4, 4

.TEXT

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-8%ebp
  MOVL $4, %eax
  CMP $3, %eax
  ANDB $69,%ah
  CMPB $1,%ah
  JL SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -8(%ebp)
  JL LIF1
  MOVL $2, %eax
  MOVL %eax, a
LIF1:
  LEAVE
  RET
