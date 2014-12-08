  .file  "testCTDS1.asm"
  .comm global, 4, 4

  .text

  .globl ochoparametrosInt
  .type ochoparametrosInt, @function
ochoparametrosInt:
  pushl %ebp
  movl %esp, %ebp
  subl $36,%esp
  movl 8(%ebp), %eax
  movl 12(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -8(%ebp)
  movl -8(%ebp), %eax
  movl 16(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -12(%ebp)
  movl -12(%ebp), %eax
  movl 20(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -16(%ebp)
  movl -16(%ebp), %eax
  movl 24(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -20(%ebp)
  movl -20(%ebp), %eax
  movl 28(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -24(%ebp)
  movl -24(%ebp), %eax
  movl 32(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -28(%ebp)
  movl -28(%ebp), %eax
  movl 36(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -32(%ebp)
  movl -32(%ebp), %eax
  movl global, %edx
  addl %edx, %eax
  movl  %eax, -36(%ebp)
  movl -36(%ebp), %eax
  movl %eax, -4(%ebp)
  movl $1000,global
  call print_int
  leave
  ret

  .globl ochoparametrosFloat
  .type ochoparametrosFloat, @function
ochoparametrosFloat:
  pushl %ebp
  movl %esp, %ebp
  subl $32,%esp
  flds 8(%ebp)
  flds 12(%ebp)
  faddp %st, %st(1)
  fstps -8(%ebp)
  movl -8(%ebp), %eax
  movl 16(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -12(%ebp)
  movl -12(%ebp), %eax
  movl 20(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -16(%ebp)
  movl -16(%ebp), %eax
  movl 24(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -20(%ebp)
  movl -20(%ebp), %eax
  movl 28(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -24(%ebp)
  movl -24(%ebp), %eax
  movl 32(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -28(%ebp)
  movl -28(%ebp), %eax
  movl 36(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -32(%ebp)
  movl -32(%ebp), %eax
  movl %eax, -4(%ebp)
  call print_float
  leave
  ret

  .globl ochoparametrosMixtos
  .type ochoparametrosMixtos, @function
ochoparametrosMixtos:
  pushl %ebp
  movl %esp, %ebp
  subl $36,%esp
  movl 8(%ebp), %eax
  movl 16(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -12(%ebp)
  movl -12(%ebp), %eax
  movl 24(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -16(%ebp)
  movl -16(%ebp), %eax
  movl 32(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -20(%ebp)
  movl -20(%ebp), %eax
  movl global, %edx
  addl %edx, %eax
  movl  %eax, -24(%ebp)
  movl -24(%ebp), %eax
  movl %eax, -4(%ebp)
  flds 12(%ebp)
  flds 20(%ebp)
  faddp %st, %st(1)
  fstps -28(%ebp)
  movl -28(%ebp), %eax
  movl 28(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -32(%ebp)
  movl -32(%ebp), %eax
  movl 36(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -36(%ebp)
  movl -36(%ebp), %eax
  movl %eax, -8(%ebp)
  movl $10000,global
  call print_int
  call print_float
  leave
  ret

  .globl main
  .type main, @function
main:
  pushl %ebp
  movl %esp, %ebp
  subl $84,%esp
  call init_input
  movl $100,global
  movl $0,-8(%ebp)
  movl $11,-4(%ebp)
.BI1:
  movl $1,-12(%ebp)
  movl -12(%ebp), %eax
  cmp -4(%ebp), %eax
  jle short .ok
  movl $0, %eax
.ok:
  movl $1, %eax
  movl  %eax, -88(%ebp)
  jg .EI2
.BI3:
  movl $1,-16(%ebp)
  movl -16(%ebp), %eax
  cmp -4(%ebp), %eax
  jle short .ok
  movl $0, %eax
.ok:
  movl $1, %eax
  movl  %eax, -92(%ebp)
  jg .EI4
.BI5:
  movl $1,-20(%ebp)
  movl -20(%ebp), %eax
  cmp -4(%ebp), %eax
  jle short .ok
  movl $0, %eax
.ok:
  movl $1, %eax
  movl  %eax, -96(%ebp)
  jg .EI6
  movl -8(%ebp), %eax
  addl $1, %eax
  movl  %eax, -100(%ebp)
  movl -100(%ebp), %eax
  movl %eax, -8(%ebp)
  movl -20(%ebp), %eax
  addl $1, %eax
  movl  %eax, -20(%ebp)
  jmp .BI5
.EI6:
  movl -16(%ebp), %eax
  addl $1, %eax
  movl  %eax, -16(%ebp)
  jmp .BI5
.EI6:
  movl -12(%ebp), %eax
  addl $1, %eax
  movl  %eax, -12(%ebp)
  jmp .BI5
.EI6:
  call print_int
  movl $0,-24(%ebp)
  movl $0,-28(%ebp)
  movl $0,-32(%ebp)
.BI7:
  movl $1,-12(%ebp)
  movl -12(%ebp), %eax
  cmp -4(%ebp), %eax
  jle short .ok
  movl $0, %eax
.ok:
  movl $1, %eax
  movl  %eax, -104(%ebp)
  jg .EI8
.BI9:
  movl $1,-16(%ebp)
  movl -16(%ebp), %eax
  cmp -4(%ebp), %eax
  jle short .ok
  movl $0, %eax
.ok:
  movl $1, %eax
  movl  %eax, -108(%ebp)
  jg .EI10
  jmp .BI10
.BI11:
  movl $1,-20(%ebp)
  movl -20(%ebp), %eax
  cmp -4(%ebp), %eax
  jle short .ok
  movl $0, %eax
.ok:
  movl $1, %eax
  movl  %eax, -112(%ebp)
  jg .EI12
  movl -32(%ebp), %eax
  addl $1, %eax
  movl  %eax, -116(%ebp)
  movl -116(%ebp), %eax
  movl %eax, -32(%ebp)
  movl -20(%ebp), %eax
  addl $1, %eax
  movl  %eax, -20(%ebp)
  jmp .BI11
.EI12:
  movl -28(%ebp), %eax
  addl $1, %eax
  movl  %eax, -120(%ebp)
  movl -120(%ebp), %eax
  movl %eax, -28(%ebp)
  movl -16(%ebp), %eax
  addl $1, %eax
  movl  %eax, -16(%ebp)
  jmp .BI11
.EI12:
  movl -24(%ebp), %eax
  addl $1, %eax
  movl  %eax, -124(%ebp)
  movl -124(%ebp), %eax
  movl %eax, -24(%ebp)
  movl -12(%ebp), %eax
  addl $1, %eax
  movl  %eax, -12(%ebp)
  jmp .BI11
.EI12:
  call print_int
  call print_int
  call print_int
  movl $1,-36(%ebp)
  movl $1,-40(%ebp)
  movl $1,-44(%ebp)
  movl -36(%ebp), %eax
  movl %eax, -48(%ebp)
  movl -40(%ebp), %eax
  movl %eax, -52(%ebp)
  movl -44(%ebp), %eax
  movl %eax, -56(%ebp)
  movl $10,-4(%ebp)
.BI13:
  movl -48(%ebp), %eax
  cmp -4(%ebp), %eax
  jl short .ok
  movl $0, %eax
.ok:
  movl $1, %eax
  movl  %eax, -128(%ebp)
  jge .EI14
.BI15:
  movl -52(%ebp), %eax
  cmp -4(%ebp), %eax
  jl short .ok
  movl $0, %eax
.ok:
  movl $1, %eax
  movl  %eax, -132(%ebp)
  jge .EI16
.BI17:
  movl -56(%ebp), %eax
  cmp -4(%ebp), %eax
  jl short .ok
  movl $0, %eax
.ok:
  movl $1, %eax
  movl  %eax, -136(%ebp)
  jge .EI18
  movl -44(%ebp), %eax
  addl $1, %eax
  movl  %eax, -140(%ebp)
  movl -140(%ebp), %eax
  movl %eax, -44(%ebp)
  movl -56(%ebp), %eax
  addl $1, %eax
  movl  %eax, -144(%ebp)
  movl -144(%ebp), %eax
  movl %eax, -56(%ebp)
  jmp .BI17
.EI18:
  movl -40(%ebp), %eax
  addl $1, %eax
  movl  %eax, -148(%ebp)
  movl -148(%ebp), %eax
  movl %eax, -40(%ebp)
  movl -52(%ebp), %eax
  addl $1, %eax
  movl  %eax, -152(%ebp)
  movl -152(%ebp), %eax
  movl %eax, -52(%ebp)
  jmp .BI17
.EI18:
  movl -36(%ebp), %eax
  addl $1, %eax
  movl  %eax, -156(%ebp)
  movl -156(%ebp), %eax
  movl %eax, -36(%ebp)
  movl -48(%ebp), %eax
  addl $1, %eax
  movl  %eax, -160(%ebp)
  movl -160(%ebp), %eax
  movl %eax, -48(%ebp)
  movl $100,-60(%ebp)
  movl $100,-64(%ebp)
  movl $100,-68(%ebp)
  movl -60(%ebp), %eax
  movl %eax, -72(%ebp)
  movl -64(%ebp), %eax
  movl %eax, -76(%ebp)
  movl -68(%ebp), %eax
  movl %eax, -80(%ebp)
  movl $1000,-84(%ebp)
.BI19:
  movl -72(%ebp), %eax
  cmp -84(%ebp), %eax
  jl short .ok
  movl $0, %eax
.ok:
  movl $1, %eax
  movl  %eax, -164(%ebp)
  jge .EI20
.BI21:
  movl -76(%ebp), %eax
  cmp -84(%ebp), %eax
  jl short .ok
  movl $0, %eax
.ok:
  movl $1, %eax
  movl  %eax, -168(%ebp)
  jge .EI22
  jmp .BI22
.BI23:
  movl -80(%ebp), %eax
  cmp -84(%ebp), %eax
  jl short .ok
  movl $0, %eax
.ok:
  movl $1, %eax
  movl  %eax, -172(%ebp)
  jge .EI24
  movl -68(%ebp), %eax
  addl $1, %eax
  movl  %eax, -176(%ebp)
  movl -176(%ebp), %eax
  movl %eax, -68(%ebp)
  movl -80(%ebp), %eax
  addl $1, %eax
  movl  %eax, -180(%ebp)
  movl -180(%ebp), %eax
  movl %eax, -80(%ebp)
  jmp .BI23
.EI24:
  movl -64(%ebp), %eax
  addl $1, %eax
  movl  %eax, -184(%ebp)
  movl -184(%ebp), %eax
  movl %eax, -64(%ebp)
  movl -76(%ebp), %eax
  addl $1, %eax
  movl  %eax, -188(%ebp)
  movl -188(%ebp), %eax
  movl %eax, -76(%ebp)
  jmp .BI23
.EI24:
  movl -60(%ebp), %eax
  addl $100, %eax
  movl  %eax, -192(%ebp)
  movl -192(%ebp), %eax
  movl %eax, -60(%ebp)
  movl -72(%ebp), %eax
  addl $100, %eax
  movl  %eax, -196(%ebp)
  movl -196(%ebp), %eax
  movl %eax, -72(%ebp)
  jmp .BI23
  jmp .BI23
.EI24:
  call print_int
  call print_int
  call print_int
  jmp .BI23
.EI24:
  call print_int
  call print_int
  call print_int
  CALL ochoparametrosInt
  movl  %eax, -200(%ebp)
  CALL ochoparametrosFloat
  movl  %eax, -204(%ebp)
  CALL ochoparametrosMixtos
  movl  %eax, -208(%ebp)
  leave
  ret
