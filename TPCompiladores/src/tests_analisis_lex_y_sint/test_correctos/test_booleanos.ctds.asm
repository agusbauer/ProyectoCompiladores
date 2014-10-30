
.TEXT

  .GLOBL main
.TYPE main, @function

neg:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $60%ebp
  MOVL -0(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOVL $1, %eax
isTrue:
  MOVL $0, %eax
  MOVL  %eax, -44(%ebp)
  MOVL temp1, %eax
  leave
  ret

and:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $60%ebp
  MOVL -0(%ebp), %eax
  MOVL -0(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -48(%ebp)
  MOVL temp2, %eax
  leave
  ret

or:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $60%ebp
  MOVL -0(%ebp), %eax
  MOVL -0(%ebp), %edx
  OR %edx, %eax
  MOVL  %eax, -52(%ebp)
  MOVL temp3, %eax
  leave
  ret

main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $60%ebp
  MOVL $True, %eax
  MOVL %eax, -4(%ebp)
  MOVL $False, %eax
  MOVL %eax, -8(%ebp)
  CALL neg
  MOVL  %eax, -56(%ebp)
  MOVL -56(%ebp), %eax
  MOVL %eax, -8(%ebp)
  CALL or
  MOVL  %eax, -60(%ebp)
  MOVL -60(%ebp), %eax
  MOVL %eax, -12(%ebp)
  CALL printf
  LEAVE
  RET
