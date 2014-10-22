SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

breaks:
  PUSH %ebp
  MOV %ebp, %esp
  MOV $0, %eax
  MOV %eax, -4(%ebp)
BI1:
  MOV -4(%ebp), %eax
  CMP $10, %eax
  JL SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -20(%ebp)
  JL EI2
  MOV -4(%ebp), %eax
  ADD $1, %eax
  MOV  %eax, -24(%ebp)
  MOV -24(%ebp), %eax
  MOV %eax, -4(%ebp)
  MOV -0(%ebp), %eax
  CMP $0, %eax
  JL SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -28(%ebp)
  JL LIF3
  JMP BI2
LIF3:
  JMP BI1
  JMP BI1
EI2:
  MOV i, %eax
  leave
  ret

main:
  PUSH %ebp
  MOV %ebp, %esp
  CALL printf
  MOV 1, %eax
  leave
  ret

  LEAVE
  RET
