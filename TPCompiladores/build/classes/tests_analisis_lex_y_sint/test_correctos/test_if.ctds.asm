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
  MOV  %eax, -28(%ebp)
  JG LIF1
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %edx
  SUB %edx, %eax
  MOV  %eax, -32(%ebp)
  MOV -32(%ebp), %eax
  MOV %eax, -4(%ebp)
LIF1:
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %ebx
  CMP  %ebx, %eax
  JE SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -36(%ebp)
  JE LIF2
  MOV -0(%ebp), %eax
  IMUL $5, %eax
  MOV  %eax, -40(%ebp)
  MOV -40(%ebp), %eax
  MOV %eax, -4(%ebp)
LIF2:
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %edx
  SUB %edx, %eax
  MOV  %eax, -44(%ebp)
  MOV -44(%ebp), %eax
  MOV %eax, -4(%ebp)
  MOV res, %eax
  leave
  ret

main:
  PUSH %ebp
  MOV %ebp, %esp
  CALL printf
  CALL printf
  CALL printf
  CALL printf
  LEAVE
  RET
