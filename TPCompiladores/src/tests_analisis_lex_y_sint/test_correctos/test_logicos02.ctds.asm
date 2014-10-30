
.TEXT

  .GLOBL promedio
  TYPE promedio, @function
promedio:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $160%ebp
  MOVL -0(%ebp), %eax
  MOVL -0(%ebp), %ebx
  CMP  %ebx, %eax
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -84(%ebp)
  MOVL -0(%ebp), %eax
  MOVL -0(%ebp), %ebx
  CMP  %ebx, %eax
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
  MOVL -0(%ebp), %eax
  MOVL -0(%ebp), %edx
  ADDL %edx, %eax
  MOVL  %eax, -96(%ebp)
  MOVL -96(%ebp), %edx
  IDIV $2.0
  MOVL  %eax, -100(%ebp)
  MOVL temp5, %eax
  LEAVE
  RET

LIF1:
  MOVL -0(%ebp), %eax
  MOVL -0(%ebp), %ebx
  CMP  %ebx, %eax
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -104(%ebp)
  MOVL -0(%ebp), %eax
  MOVL -0(%ebp), %ebx
  CMP  %ebx, %eax
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
  MOVL -0(%ebp), %eax
  MOVL -0(%ebp), %edx
  ADDL %edx, %eax
  MOVL  %eax, -116(%ebp)
  MOVL -116(%ebp), %edx
  IDIV $2.0
  MOVL  %eax, -120(%ebp)
  MOVL temp10, %eax
  LEAVE
  RET

LIF2:
  MOVL -0(%ebp), %eax
  MOVL -0(%ebp), %ebx
  CMP  %ebx, %eax
  JG SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -124(%ebp)
  MOVL -0(%ebp), %eax
  MOVL -0(%ebp), %ebx
  CMP  %ebx, %eax
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
  MOVL -0(%ebp), %eax
  MOVL -0(%ebp), %edx
  ADDL %edx, %eax
  MOVL  %eax, -136(%ebp)
  MOVL -136(%ebp), %edx
  IDIV $2.0
  MOVL  %eax, -140(%ebp)
  MOVL temp15, %eax
  LEAVE
  RET

LIF3:
  MOVL -0(%ebp), %eax
  MOVL -0(%ebp), %ebx
  CMP  %ebx, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -144(%ebp)
  MOVL -0(%ebp), %eax
  MOVL -0(%ebp), %ebx
  CMP  %ebx, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -148(%ebp)
  MOVL -144(%ebp), %eax
  MOVL -148(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -152(%ebp)
  MOVL -0(%ebp), %eax
  MOVL -0(%ebp), %ebx
  CMP  %ebx, %eax
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
  SUBL $160%ebp
  CALL printf
  MOVL 1, %eax
  LEAVE
  RET

  LEAVE
  RET
