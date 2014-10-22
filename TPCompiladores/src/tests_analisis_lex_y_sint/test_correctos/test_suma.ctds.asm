SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

suma:
  PUSH %ebp
  MOV %ebp, %esp
  MOV -0(%ebp), %eax
  CMP $0, %eax
  JE SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -16(%ebp)
  JE LIF1
  MOV num2, %eax
  leave
  ret

LIF1:
  MOV -0(%ebp), %eax
  CMP $0, %eax
  JE SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -20(%ebp)
  JE LIF2
  MOV num1, %eax
  leave
  ret

LIF2:
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %edx
  ADD %edx, %eax
  MOV  %eax, -24(%ebp)
  MOV temp3, %eax
  leave
  ret

main:
  PUSH %ebp
  MOV %ebp, %esp
  CALL printf
  LEAVE
  RET
