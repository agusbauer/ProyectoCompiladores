SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

pruAritmetica:
  PUSH %ebp
  MOV %ebp, %esp
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %ebx
  CMP  %ebx, %eax
  JG SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -12(%ebp)
  JG LIF1
  MOV -0(%ebp), %eax
  MOV %eax, -4(%ebp)
LIF1:
  MOV -0(%ebp), %eax
  MOV %eax, -4(%ebp)
  MOV res, %eax
  leave
  ret

main:
  PUSH %ebp
  MOV %ebp, %esp
  CALL printf
  LEAVE
  RET
