SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

pruebaLogica:
  PUSH %ebp
  MOV %ebp, %esp
  MOV $True, %eax
  MOV %eax, -4(%ebp)
  MOV -4(%ebp), %eax
  OR $False, %eax
  MOV  %eax, -28(%ebp)
  MOV True, %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOV $1, %eax
isTrue:
  MOV $0, %eax
  MOV  %eax, -32(%ebp)
  MOV -28(%ebp), %eax
  MOV -32(%ebp), %edx
  AND %edx, %eax
  MOV  %eax, -36(%ebp)
  MOV -0(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOV $1, %eax
isTrue:
  MOV $0, %eax
  MOV  %eax, -40(%ebp)
  MOV -36(%ebp), %eax
  MOV -40(%ebp), %edx
  AND %edx, %eax
  MOV  %eax, -44(%ebp)
  MOV temp5, %eax
  leave
  ret

main:
  PUSH %ebp
  MOV %ebp, %esp
  CALL printf
  LEAVE
  RET
