SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

main:
  PUSH %ebp
  MOV %ebp, %esp
  MOV $True, %eax
  MOV %eax, -4(%ebp)
  MOV -4(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOV $1, %eax
isTrue:
  MOV $0, %eax
  MOV  %eax, -40(%ebp)
  MOV -40(%ebp), %eax
  MOV %eax, -8(%ebp)
  MOV -4(%ebp), %eax
  MOV -8(%ebp), %edx
  AND %edx, %eax
  MOV  %eax, -44(%ebp)
  MOV -8(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOV $1, %eax
isTrue:
  MOV $0, %eax
  MOV  %eax, -48(%ebp)
  MOV -44(%ebp), %eax
  MOV -48(%ebp), %edx
  OR %edx, %eax
  MOV  %eax, -52(%ebp)
  MOV -52(%ebp), %eax
  MOV %eax, -12(%ebp)
  CALL printf
  LEAVE
  RET
