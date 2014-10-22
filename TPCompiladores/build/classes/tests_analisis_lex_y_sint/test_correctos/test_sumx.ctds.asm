SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

sumx:
  PUSH %ebp
  MOV %ebp, %esp
  MOV $0.0, %eax
  MOV %eax, -4(%ebp)
  MOV $0, %eax
  MOV %eax, -8(%ebp)
BI1:
  MOV -8(%ebp), %eax
  MOV -0(%ebp), %ebx
  CMP  %ebx, %eax
  JL SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -24(%ebp)
  JL EI2
  MOV -4(%ebp), %eax
  MOV -0(%ebp), %edx
  ADD %edx, %eax
  MOV  %eax, -28(%ebp)
  MOV -28(%ebp), %eax
  MOV %eax, -4(%ebp)
  MOV -8(%ebp), %eax
  ADD $1, %eax
  MOV  %eax, -32(%ebp)
  MOV -32(%ebp), %eax
  MOV %eax, -8(%ebp)
  JMP BI1
EI2:
  MOV aux, %eax
  leave
  ret

main:
  PUSH %ebp
  MOV %ebp, %esp
  CALL printf
  LEAVE
  RET
