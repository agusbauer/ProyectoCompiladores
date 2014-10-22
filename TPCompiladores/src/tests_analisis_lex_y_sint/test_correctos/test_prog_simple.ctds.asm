SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

alo:
  PUSH %ebp
  MOV %ebp, %esp
  MOV -0(%ebp), %eax
  ADD $1, %eax
  MOV  %eax, -12(%ebp)
  MOV -12(%ebp), %eax
  MOV %eax, -0(%ebp)
  LEAVE
  RET
