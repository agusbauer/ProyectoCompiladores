SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

pruAritmetica:
  PUSH %ebp
  MOV %ebp, %esp
  MOV $90, %eax
  MOV %eax, -4(%ebp)
  MOV -4(%ebp), %edx
  IDIV $7
  MOV  %edx, -12(%ebp)
  MOV temp1, %eax
  leave
  ret

main:
  PUSH %ebp
  MOV %ebp, %esp
  CALL printf
  LEAVE
  RET
