SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

div:
  PUSH %ebp
  MOV %ebp, %esp
  MOV -0(%ebp), %edx
  MOV -0(%ebp), %ecx
  IDIV %ecx
  MOV  %eax, -32(%ebp)
  MOV temp1, %eax
  leave
  ret

resta:
  PUSH %ebp
  MOV %ebp, %esp
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %edx
  SUB %edx, %eax
  MOV  %eax, -36(%ebp)
  MOV temp2, %eax
  leave
  ret

sum:
  PUSH %ebp
  MOV %ebp, %esp
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %edx
  ADD %edx, %eax
  MOV  %eax, -40(%ebp)
  MOV temp3, %eax
  leave
  ret

main:
  PUSH %ebp
  MOV %ebp, %esp
  MOV $6.98, %eax
  MOV %eax, -4(%ebp)
  MOV 2.0, %eax
  NOT  %eax
  MOV  %eax, -44(%ebp)
  MOV -44(%ebp), %eax
  MOV %eax, -8(%ebp)
  MOV $3.569, %eax
  MOV %eax, -12(%ebp)
  CALL printf
  LEAVE
  RET
