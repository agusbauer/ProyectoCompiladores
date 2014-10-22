SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

neg:
  PUSH %ebp
  MOV %ebp, %esp
  MOV -0(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOV $1, %eax
isTrue:
  MOV $0, %eax
  MOV  %eax, -44(%ebp)
  MOV temp1, %eax
  leave
  ret

and:
  PUSH %ebp
  MOV %ebp, %esp
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %edx
  AND %edx, %eax
  MOV  %eax, -48(%ebp)
  MOV temp2, %eax
  leave
  ret

or:
  PUSH %ebp
  MOV %ebp, %esp
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %edx
  OR %edx, %eax
  MOV  %eax, -52(%ebp)
  MOV temp3, %eax
  leave
  ret

main:
  PUSH %ebp
  MOV %ebp, %esp
  MOV $True, %eax
  MOV %eax, -4(%ebp)
  MOV $False, %eax
  MOV %eax, -8(%ebp)
  CALL neg
  MOV  %eax, -56(%ebp)
  MOV -56(%ebp), %eax
  MOV %eax, -8(%ebp)
  CALL or
  MOV  %eax, -60(%ebp)
  MOV -60(%ebp), %eax
  MOV %eax, -12(%ebp)
  CALL printf
  LEAVE
  RET
