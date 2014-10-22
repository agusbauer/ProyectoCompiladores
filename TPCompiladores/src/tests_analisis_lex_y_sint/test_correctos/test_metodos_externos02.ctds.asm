SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

maxcomdiv:
  PUSH %ebp
  MOV %ebp, %esp
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %ebx
  CMP  %ebx, %eax
  JG SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -32(%ebp)
  JG LIF1
  MOV -0(%ebp), %eax
  MOV %eax, -4(%ebp)
  MOV -0(%ebp), %eax
  MOV %eax, -8(%ebp)
LIF1:
  MOV -0(%ebp), %eax
  MOV %eax, -4(%ebp)
  MOV -0(%ebp), %eax
  MOV %eax, -8(%ebp)
  MOV $1, %eax
  MOV %eax, -12(%ebp)
BI2:
  MOV -12(%ebp), %eax
  CMP $0, %eax
  JNE SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -36(%ebp)
  JNE EI3
  MOV -4(%ebp), %edx
  MOV -8(%ebp), %ecx
  IDIV %ecx
  MOV  %edx, -40(%ebp)
  MOV -40(%ebp), %eax
  MOV %eax, -12(%ebp)
  MOV -8(%ebp), %eax
  MOV %eax, -4(%ebp)
  MOV -12(%ebp), %eax
  MOV %eax, -8(%ebp)
  JMP BI2
EI3:
  MOV dividendo, %eax
  leave
  ret

main:
  PUSH %ebp
  MOV %ebp, %esp
  MOV $3, %eax
  MOV %eax, -16(%ebp)
  CALL printf
  LEAVE
  RET
