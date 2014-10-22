SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

pruMult:
  PUSH %ebp
  MOV %ebp, %esp
  MOV $5, %eax
  MOV %eax, -4(%ebp)
  MOV $2000, %eax
  MOV %eax, -8(%ebp)
  MOV -4(%ebp), %eax
  IMUL $1000, %eax
  MOV  %eax, -24(%ebp)
  MOV -24(%ebp), %eax
  MOV -0(%ebp), %edx
  IMUL %edx, %eax
  MOV  %eax, -28(%ebp)
  MOV -28(%ebp), %eax
  MOV -8(%ebp), %edx
  IMUL %edx, %eax
  MOV  %eax, -32(%ebp)
  MOV temp3, %eax
  leave
  ret

main:
  PUSH %ebp
  MOV %ebp, %esp
  CALL printf
  LEAVE
  RET
