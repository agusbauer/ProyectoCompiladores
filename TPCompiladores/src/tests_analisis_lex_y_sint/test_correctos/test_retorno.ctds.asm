SEGMENT .DATA

SEGMENT .BSS

SEGMENT .TEXT

  GLOBAL main

id:
  PUSH %ebp
  MOV %ebp, %esp
  MOV $100, %eax
  MOV %eax, -4(%ebp)
  MOV $0, %eax
  MOV %eax, -8(%ebp)
  MOV -0(%ebp), %eax
  MOV %eax, -12(%ebp)
BI1:
  MOV -8(%ebp), %eax
  MOV -4(%ebp), %ebx
  CMP  %ebx, %eax
  JL SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -96(%ebp)
  JL EI2
  MOV -0(%ebp), %eax
  MOV %eax, -16(%ebp)
BI3:
  MOV -0(%ebp), %eax
  CMP $0, %eax
  JG SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -100(%ebp)
  MOV -0(%ebp), %eax
  CMP $0, %eax
  JL SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -104(%ebp)
  MOV -100(%ebp), %eax
  MOV -104(%ebp), %edx
  OR %edx, %eax
  MOV  %eax, -108(%ebp)
  MOV -108(%ebp), %eax
  CMP %eax, $1
  JE EI4
  MOV -0(%ebp), %eax
  CMP $0, %eax
  JG SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -112(%ebp)
  JG LIF5
  MOV -0(%ebp), %eax
  SUB $1, %eax
  MOV  %eax, -116(%ebp)
  MOV -116(%ebp), %eax
  MOV %eax, -0(%ebp)
LIF5:
  MOV -0(%ebp), %eax
  ADD $1, %eax
  MOV  %eax, -120(%ebp)
  MOV -120(%ebp), %eax
  MOV %eax, -0(%ebp)
  JMP BI3
EI4:
BI6:
  MOV -0(%ebp), %eax
  MOV -16(%ebp), %ebx
  CMP  %ebx, %eax
  JL SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -124(%ebp)
  MOV -0(%ebp), %eax
  MOV -16(%ebp), %ebx
  CMP  %ebx, %eax
  JG SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -128(%ebp)
  MOV -124(%ebp), %eax
  MOV -128(%ebp), %edx
  OR %edx, %eax
  MOV  %eax, -132(%ebp)
  MOV -132(%ebp), %eax
  CMP %eax, $1
  JE EI7
  MOV -0(%ebp), %eax
  MOV -16(%ebp), %ebx
  CMP  %ebx, %eax
  JL SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -136(%ebp)
  JL LIF8
  MOV -0(%ebp), %eax
  ADD $1, %eax
  MOV  %eax, -140(%ebp)
  MOV -140(%ebp), %eax
  MOV %eax, -0(%ebp)
LIF8:
  MOV -0(%ebp), %eax
  MOV -0(%ebp), %ebx
  CMP  %ebx, %eax
  JE SHORT ok
  MOV $0, %eax
ok:
  MOV $1, %eax
  MOV  %eax, -144(%ebp)
  JE LIF9
  MOV -0(%ebp), %eax
  SUB $1, %eax
  MOV  %eax, -148(%ebp)
  MOV -8(%ebp), %eax
  MOV -0(%ebp), %edx
  IMUL %edx, %eax
  MOV  %eax, -152(%ebp)
  MOV -8(%ebp), %eax
  MOV -0(%ebp), %edx
  IMUL %edx, %eax
  MOV  %eax, -156(%ebp)
  MOV -152(%ebp), %eax
  MOV -156(%ebp), %edx
  SUB %edx, %eax
  MOV  %eax, -160(%ebp)
  MOV -148(%ebp), %eax
  MOV -160(%ebp), %edx
  ADD %edx, %eax
  MOV  %eax, -164(%ebp)
  MOV -164(%ebp), %eax
  MOV %eax, -0(%ebp)
LIF9:
  JMP BI6
EI7:
  MOV -12(%ebp), %eax
  MOV %eax, -0(%ebp)
  MOV -8(%ebp), %eax
  ADD $1, %eax
  MOV  %eax, -168(%ebp)
  MOV -168(%ebp), %eax
  MOV %eax, -8(%ebp)
  JMP BI6
EI7:
  MOV x, %eax
  leave
  ret

main:
  PUSH %ebp
  MOV %ebp, %esp
  CALL printf
  LEAVE
  RET
