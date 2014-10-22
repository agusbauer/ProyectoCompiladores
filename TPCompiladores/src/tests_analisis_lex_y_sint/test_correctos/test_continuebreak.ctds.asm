SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

pruContinue:
  PUSH %ebp
  MOV %ebp, %esp
  MOV 1.0, %eax
  NOT  %eax
  MOV  %eax, -60(%ebp)
  MOV -60(%ebp), %eax
  MOV %eax, -12(%ebp)
  MOV $23, %eax
  MOV %eax, -8(%ebp)
  MOV $23.0, %eax
  MOV %eax, -4(%ebp)
BI1:
  MOV -4(%ebp), %eax
  CMP $0.0, %eax
  JGE SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -64(%ebp)
  JGE EI2
  MOV -4(%ebp), %eax
  SUB $1, %eax
  MOV  %eax, -68(%ebp)
  MOV -68(%ebp), %eax
  MOV %eax, -4(%ebp)
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %ebx
  CMP  %ebx, %eax
  JL SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -72(%ebp)
  JL LIF3
  MOV -4(%ebp), %eax
  CMP $0.0, %eax
  JNE SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -76(%ebp)
  JNE LIF4
  MOV -12(%ebp), %eax
  MOV -0(%ebp), %edx
  IMUL %edx, %eax
  MOV  %eax, -80(%ebp)
  MOV -80(%ebp), %eax
  MOV -0(%ebp), %edx
  IMUL %edx, %eax
  MOV  %eax, -84(%ebp)
  MOV -84(%ebp), %eax
  MOV %eax, -12(%ebp)
LIF4:
  JMP BI1
LIF4:
  MOV 1000.234, %eax
  NOT  %eax
  MOV  %eax, -88(%ebp)
  MOV -88(%ebp), %eax
  ADD $6752, %eax
  MOV  %eax, -92(%ebp)
  MOV -92(%ebp), %eax
  MOV %eax, -12(%ebp)
  JMP BI2
  JMP BI1
EI2:
  MOV -12(%ebp), %eax
  IMUL $2, %eax
  MOV  %eax, -100(%ebp)
  MOV -100(%ebp), %eax
  NOT  %eax
  MOV  %eax, -96(%ebp)
  MOV temp10, %eax
  leave
  ret

main:
  PUSH %ebp
  MOV %ebp, %esp
  CALL printf
  LEAVE
  RET
