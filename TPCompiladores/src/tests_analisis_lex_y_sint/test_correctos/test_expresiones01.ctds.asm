SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

prueba:
  PUSH %ebp
  MOV %ebp, %esp
  MOV $50, %eax
  MOV %eax, -12(%ebp)
  MOV -12(%ebp), %eax
  CMP $0, %eax
  JG SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -48(%ebp)
  JG LIF1
  MOV $4, %eax
  MOV %eax, -4(%ebp)
  MOV -4(%ebp), %eax
  CMP $4, %eax
  JE SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -52(%ebp)
  JE LIF2
BI3:
  MOV -4(%ebp), %eax
  CMP $4, %eax
  JL SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -56(%ebp)
  JL EI4
BI5:
  MOV -12(%ebp), %eax
  CMP $4, %eax
  JG SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -60(%ebp)
  JG EI6
  MOV -12(%ebp), %eax
  SUB $1, %eax
  MOV  %eax, -64(%ebp)
  MOV -64(%ebp), %eax
  MOV %eax, -12(%ebp)
  MOV -4(%ebp), %eax
  IMUL $2, %eax
  MOV  %eax, -68(%ebp)
  MOV -68(%ebp), %eax
  MOV %eax, -8(%ebp)
  JMP BI5
EI6:
  MOV -4(%ebp), %eax
  ADD $1, %eax
  MOV  %eax, -72(%ebp)
  MOV -72(%ebp), %eax
  MOV %eax, -4(%ebp)
  MOV -8(%ebp), %edx
  IDIV $2
  MOV  %eax, -76(%ebp)
  MOV -76(%ebp), %eax
  MOV %eax, -8(%ebp)
  JMP BI5
EI6:
LIF6:
LIF6:
  MOV c, %eax
  leave
  ret

main:
  PUSH %ebp
  MOV %ebp, %esp
  CALL printf
  LEAVE
  RET
