SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

promedio:
  PUSH %ebp
  MOV %ebp, %esp
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %ebx
  CMP  %ebx, %eax
  JG SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -84(%ebp)
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %ebx
  CMP  %ebx, %eax
  JG SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -88(%ebp)
  MOV -84(%ebp), %eax
  MOV -88(%ebp), %edx
  AND %edx, %eax
  MOV  %eax, -92(%ebp)
  MOV -92(%ebp), %eax
  CMP %eax, $1
  JE LIF1
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %edx
  ADD %edx, %eax
  MOV  %eax, -96(%ebp)
  MOV -96(%ebp), %edx
  IDIV $2.0
  MOV  %eax, -100(%ebp)
  MOV temp5, %eax
  leave
  ret

LIF1:
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %ebx
  CMP  %ebx, %eax
  JG SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -104(%ebp)
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %ebx
  CMP  %ebx, %eax
  JG SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -108(%ebp)
  MOV -104(%ebp), %eax
  MOV -108(%ebp), %edx
  AND %edx, %eax
  MOV  %eax, -112(%ebp)
  MOV -112(%ebp), %eax
  CMP %eax, $1
  JE LIF2
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %edx
  ADD %edx, %eax
  MOV  %eax, -116(%ebp)
  MOV -116(%ebp), %edx
  IDIV $2.0
  MOV  %eax, -120(%ebp)
  MOV temp10, %eax
  leave
  ret

LIF2:
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %ebx
  CMP  %ebx, %eax
  JG SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -124(%ebp)
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %ebx
  CMP  %ebx, %eax
  JG SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -128(%ebp)
  MOV -124(%ebp), %eax
  MOV -128(%ebp), %edx
  AND %edx, %eax
  MOV  %eax, -132(%ebp)
  MOV -132(%ebp), %eax
  CMP %eax, $1
  JE LIF3
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %edx
  ADD %edx, %eax
  MOV  %eax, -136(%ebp)
  MOV -136(%ebp), %edx
  IDIV $2.0
  MOV  %eax, -140(%ebp)
  MOV temp15, %eax
  leave
  ret

LIF3:
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %ebx
  CMP  %ebx, %eax
  JE SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -144(%ebp)
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %ebx
  CMP  %ebx, %eax
  JE SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -148(%ebp)
  MOV -144(%ebp), %eax
  MOV -148(%ebp), %edx
  AND %edx, %eax
  MOV  %eax, -152(%ebp)
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %ebx
  CMP  %ebx, %eax
  JE SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -156(%ebp)
  MOV -152(%ebp), %eax
  MOV -156(%ebp), %edx
  AND %edx, %eax
  MOV  %eax, -160(%ebp)
  MOV -160(%ebp), %eax
  CMP %eax, $1
  JE LIF4
  MOV nota1, %eax
  leave
  ret

LIF4:
main:
  PUSH %ebp
  MOV %ebp, %esp
  CALL printf
  MOV 1, %eax
  leave
  ret

  LEAVE
  RET
