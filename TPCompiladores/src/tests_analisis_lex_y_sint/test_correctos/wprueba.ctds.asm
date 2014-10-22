SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

main:
  PUSH %ebp
  MOV %ebp, %esp
  MOV $1, %eax
  MOV %eax, -4(%ebp)
  LEAVE
  RET
