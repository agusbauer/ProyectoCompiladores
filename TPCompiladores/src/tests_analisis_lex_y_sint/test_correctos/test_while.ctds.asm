SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

maxcomdiv:
  PUSH %ebp
  MOV %ebp, %esp
  MOV $1, %eax
  MOV %eax, -12(%ebp)
BI1:
  MOV -12(%ebp), %eax
  CMP $0, %eax
  JNE SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -32(%ebp)
  JNE EI2
  MOV -4(%ebp), %edx
  MOV -8(%ebp), %ecx
  IDIV %ecx
  MOV  %edx, -36(%ebp)
  MOV -12(%ebp), %eax
  MOV -36(%ebp), %edx
  ADD %edx, %eax
  MOV  %eax, -12(%ebp)
  MOV -4(%ebp), %eax
  MOV -8(%ebp), %edx
  SUB %edx, %eax
  MOV  %eax, -4(%ebp)
  JMP BI1
  JMP BI1
EI2:
BI3:
  MOV -12(%ebp), %eax
  CMP $0, %eax
  JNE SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -40(%ebp)
  JNE EI4
  JMP BI4
  JMP BI3
EI4:
BI5:
  MOV -12(%ebp), %eax
  CMP $0, %eax
  JNE SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -44(%ebp)
  JNE EI6
  JMP BI5
EI6:
  MOV dividendo, %eax
  leave
  ret

main:
  PUSH %ebp
  MOV %ebp, %esp
  CALL printf
  LEAVE
  RET
