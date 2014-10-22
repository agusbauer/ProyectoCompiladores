SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

inc:
  PUSH %ebp
  MOV %ebp, %esp
  MOV -0(%ebp), %eax
  ADD $1, %eax
  MOV  %eax, -40(%ebp)
  MOV temp1, %eax
  leave
  ret

resto:
  PUSH %ebp
  MOV %ebp, %esp
  MOV $2, %eax
  IMUL $3, %eax
  MOV  %eax, -44(%ebp)
  MOV -0(%ebp), %eax
  MOV -44(%ebp), %ebx
  CMP  %ebx, %eax
  JG SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -48(%ebp)
  JG LIF1
  MOV -0(%ebp), %edx
  IDIV $3
  MOV  %eax, -52(%ebp)
  MOV -52(%ebp), %eax
  MOV %eax, -8(%ebp)
LIF1:
  MOV -0(%ebp), %edx
  IDIV $2
  MOV  %edx, -56(%ebp)
  MOV -56(%ebp), %eax
  MOV %eax, -8(%ebp)
  MOV res, %eax
  leave
  ret

main:
  PUSH %ebp
  MOV %ebp, %esp
  MOV $False, %eax
  MOV %eax, -4(%ebp)
  CALL resto
  MOV  %eax, -60(%ebp)
  MOV -60(%ebp), %eax
  MOV %eax, -12(%ebp)
  LEAVE
  RET
