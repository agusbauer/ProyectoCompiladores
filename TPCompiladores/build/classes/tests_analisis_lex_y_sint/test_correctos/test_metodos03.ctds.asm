COMM res, 4, 4

.TEXT

  .GLOBL inc
  TYPE inc, @function
inc:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-48%ebp
  MOVL 8(%ebp), %eax
  ADDL $1, %eax
  MOVL  %eax, -28(%ebp)
  MOVL -28(%ebp), %eax
  LEAVE
  RET

  .GLOBL resto
  TYPE resto, @function
resto:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-48%ebp
  MOVL $2, %eax
  IMUL $3, %eax
  MOVL  %eax, -32(%ebp)
  MOVL 8(%ebp), %eax
  MOVL -32(%ebp), %ebx
  CMP  %ebx, %eax
  ANDB $69,%ah
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -36(%ebp)
  JG LIF1
  MOVL 8(%ebp), %edx
  IDIV $3
  MOVL  %eax, -40(%ebp)
  MOVL --40(%ebp), %eax
  MOVL %eax, -50(%ebp)
LIF1:
  MOVL 8(%ebp), %edx
  IDIV $2
  MOVL  %edx, -44(%ebp)
  MOVL --44(%ebp), %eax
  MOVL %eax, -50(%ebp)
  MOVL 50(%ebp), %eax
  LEAVE
  RET

  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-48%ebp
  MOVL $False, %eax
  MOVL %eax, res
  CALL resto
  MOVL  %eax, -48(%ebp)
  MOVL --48(%ebp), %eax
  MOVL %eax, -50(%ebp)
  LEAVE
  RET
