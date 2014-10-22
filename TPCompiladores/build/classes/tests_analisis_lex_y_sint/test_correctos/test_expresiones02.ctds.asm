SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

prueba:
  PUSH %ebp
  MOV %ebp, %esp
  MOV $4, %eax
  MOV %eax, -12(%ebp)
  MOV $5, %eax
  MOV %eax, -16(%ebp)
  MOV -12(%ebp), %eax
  MOV -16(%ebp), %edx
  IMUL %edx, %eax
  MOV  %eax, -44(%ebp)
  MOV -44(%ebp), %eax
  MOV %eax, -4(%ebp)
  MOV -4(%ebp), %eax
  MOV -0(%ebp), %edx
  ADD %edx, %eax
  MOV  %eax, -48(%ebp)
  MOV -48(%ebp), %eax
  MOV %eax, -0(%ebp)
  MOV $3.1, %eax
  MOV %eax, -20(%ebp)
  MOV -20(%ebp), %eax
  IMUL $2.0, %eax
  MOV  %eax, -52(%ebp)
  MOV -52(%ebp), %eax
  MOV %eax, -8(%ebp)
  MOV -4(%ebp), %edx
  MOV -8(%ebp), %ecx
  IDIV %ecx
  MOV  %eax, -56(%ebp)
  MOV -56(%ebp), %eax
  CMP $5, %eax
  JG SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -60(%ebp)
  JG LIF1
  MOV 1, %eax
  leave
  ret

LIF1:
  MOV 0, %eax
  leave
  ret

main:
  PUSH %ebp
  MOV %ebp, %esp
  CALL printf
  LEAVE
  RET
