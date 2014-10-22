SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

pruMult:
  PUSH %ebp
  MOV %ebp, %esp
  MOV $5, %eax
  MOV %eax, -4(%ebp)
  MOV -4(%ebp), %eax
  IMUL $7, %eax
  MOV  %eax, -12(%ebp)
  MOV temp1, %eax
  leave
  ret

main:
  PUSH %ebp
  MOV %ebp, %esp
  CALL printf
  LEAVE
  RET
