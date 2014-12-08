  .file  "testCTDS.asm"

  .text

  .globl factorial
  .type factorial, @function
factorial:
  pushl %ebp
  movl %esp, %ebp
  subl $28,%esp
  movl $15,-4(%ebp)
  movl 8(%ebp), %eax
  cmp -4(%ebp), %eax
  jg short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -16(%ebp)
  jle .LIF1
  movl -1, %eax
  leave
  ret

.LIF1:
  movl $0,-8(%ebp)
  movl $1,-12(%ebp)
.BI2:
  movl -8(%ebp), %eax
  cmp 8(%ebp), %eax
  jl short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -20(%ebp)
  jge .EI2
  movl -8(%ebp), %eax
  addl $1, %eax
  movl  %eax, -24(%ebp)
  movl -24(%ebp), %eax
  movl %eax, -8(%ebp)
  movl -12(%ebp), %eax
  movl -8(%ebp), %edx
  imull %edx, %eax
  movl  %eax, -28(%ebp)
  movl -28(%ebp), %eax
  movl %eax, -12(%ebp)
  jmp .BI2
.EI2:
  movl -12(%ebp), %eax
  leave
  ret

  .globl factorialFor
  .type factorialFor, @function
factorialFor:
  pushl %ebp
  movl %esp, %ebp
  subl $24,%esp
  movl $15,-4(%ebp)
  movl 8(%ebp), %eax
  cmp -4(%ebp), %eax
  jg short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -16(%ebp)
  jle .LIF3
  movl -1, %eax
  leave
  ret

.LIF3:
  movl $1,-8(%ebp)
  movl $1,-12(%ebp)
.BI4:
  movl $1,-8(%ebp)
  movl -8(%ebp), %eax
  cmp 8(%ebp), %eax
  jle short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -20(%ebp)
  jg .EI4
  movl -12(%ebp), %eax
  movl -8(%ebp), %edx
  imull %edx, %eax
  movl  %eax, -24(%ebp)
  movl -24(%ebp), %eax
  movl %eax, -12(%ebp)
  movl -8(%ebp), %eax
  addl $1, %eax
  movl  %eax, -8(%ebp)
  jmp .BI4
.EI4:
  movl -12(%ebp), %eax
  leave
  ret

  .globl factorialF
  .type factorialF, @function
factorialF:
  pushl %ebp
  movl %esp, %ebp
  subl $28,%esp
  movl .LC0, %eax
  movl %eax, -4(%ebp)
  flds 8(%ebp)
  flds -4(%ebp)
  fucompp
  fnstsw %ax
  andb $69,%ah
  jg short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -16(%ebp)
  jle .LIF5
  movl .LC1, %eax
  leave
  ret

.LIF5:
  movl .LC2, %eax
  movl %eax, -8(%ebp)
  movl .LC3, %eax
  movl %eax, -12(%ebp)
.BI6:
  flds -8(%ebp)
  flds 8(%ebp)
  fucompp
  fnstsw %ax
  andb $69,%ah
  cmpb $1,%ah
  jl short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -20(%ebp)
  jge .EI6
  flds -8(%ebp)
  flds .LC4
  faddp %st, %st(1)
  fstps -24(%ebp)
  movl -24(%ebp), %eax
  movl %eax, -8(%ebp)
  flds -12(%ebp)
  flds -8(%ebp)
  fmulp %st, %st(1)
  fstps -28(%ebp)
  movl -28(%ebp), %eax
  movl %eax, -12(%ebp)
  jmp .BI6
.EI6:
  movl -12(%ebp), %eax
  leave
  ret

  .globl factorialArray
  .type factorialArray, @function
factorialArray:
  pushl %ebp
  movl %esp, %ebp
  subl $104,%esp
  movl $15,-4(%ebp)
  movl $0,-8(%ebp)
.BI7:
  movl -8(%ebp), %eax
  cmp -4(%ebp), %eax
  jl short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -80(%ebp)
  jge .EI7
  movl $0,-72(%ebp)
  movl $1,-76(%ebp)
.BI8:
  movl -72(%ebp), %eax
  cmp -8(%ebp), %eax
  jl short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -84(%ebp)
  jge .EI8
  movl -72(%ebp), %eax
  addl $1, %eax
  movl  %eax, -88(%ebp)
  movl -88(%ebp), %eax
  movl %eax, -72(%ebp)
  movl -76(%ebp), %eax
  movl -72(%ebp), %edx
  imull %edx, %eax
  movl  %eax, -92(%ebp)
  movl -92(%ebp), %eax
  movl %eax, -76(%ebp)
  jmp .BI8
.EI8:
  movl -8(%ebp), %edx
  movl -76(%ebp), %eax
  movl %eax, -68(%ebp,%edx,4)
  movl -8(%ebp), %eax
  addl $1, %eax
  movl  %eax, -96(%ebp)
  movl -96(%ebp), %eax
  movl %eax, -8(%ebp)
  jmp .BI7
.EI7:
  movl -4(%ebp), %eax
  subl $1, %eax
  movl  %eax, -100(%ebp)
  movl 8(%ebp), %eax
  cmp -100(%ebp), %eax
  jg short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -104(%ebp)
  jle .LIF9
  movl -1, %eax
  leave
  ret

.LIF9:
  movl 8(%ebp), %edx
  movl -68(%ebp,%edx,4), %eax
  leave
  ret

  .globl nthprime
  .type nthprime, @function
nthprime:
  pushl %ebp
  movl %esp, %ebp
  subl $56,%esp
  movl $0,-4(%ebp)
  movl $2,-8(%ebp)
  movl 8(%ebp), %eax
  addl $1, %eax
  movl  %eax, -16(%ebp)
  movl -16(%ebp), %eax
  movl %eax, 8(%ebp)
.BI10:
  movl 8(%ebp), %eax
  cmp $0, %eax
  jg short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -20(%ebp)
  jle .EI10
  movl $False,-12(%ebp)
  movl -4(%ebp), %eax
  addl $1, %eax
  movl  %eax, -24(%ebp)
  movl -24(%ebp), %eax
  movl %eax, -4(%ebp)
.BI11:
  movl -8(%ebp), %eax
  cmp -4(%ebp), %eax
  jl short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -32(%ebp)
  movl -12(%ebp), %eax
  movl -32(%ebp), %edx
  and %edx, %eax
  movl  %eax, -36(%ebp)
  movl -36(%ebp), %eax
  cmp %eax, $1
  je short isTrue
  movl $1, %eax
isTrue:
  movl $0, %eax
  movl  %eax, -28(%ebp)
  cmp %eax, $1
  je .EI11
  movl -4(%ebp), %edx
  movl -8(%ebp), %ecx
  idiv %ecx
  movl  %edx, -40(%ebp)
  movl -40(%ebp), %eax
  cmp $0, %eax
  je short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -44(%ebp)
  jne .LIF12
  movl $True,-12(%ebp)
.LIF12:
  movl -8(%ebp), %eax
  addl $1, %eax
  movl  %eax, -48(%ebp)
  movl -48(%ebp), %eax
  movl %eax, -8(%ebp)
  jmp .BI11
.EI11:
  movl $2,-8(%ebp)
  movl -12(%ebp), %eax
  cmp %eax, $1
  je short isTrue
  movl $1, %eax
isTrue:
  movl $0, %eax
  movl  %eax, -52(%ebp)
  cmp %eax, $1
  je .LIF13
  movl 8(%ebp), %eax
  subl $1, %eax
  movl  %eax, -56(%ebp)
  movl -56(%ebp), %eax
  movl %eax, 8(%ebp)
.LIF13:
  jmp .BI10
.EI10:
  movl -4(%ebp), %eax
  leave
  ret

  .globl nthprimeArray
  .type nthprimeArray, @function
nthprimeArray:
  pushl %ebp
  movl %esp, %ebp
  subl $420,%esp
  movl $0,-4(%ebp)
.BI14:
  movl -4(%ebp), %eax
  cmp $100, %eax
  jl short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -408(%ebp)
  jge .EI14
  movl --4(%ebp), %eax
  movl %eax, 0(%esp)
  CALL nthprime
  movl  %eax, -412(%ebp)
  movl -4(%ebp), %edx
  movl -412(%ebp), %eax
  movl %eax, -404(%ebp,%edx,4)
  movl -4(%ebp), %eax
  addl $1, %eax
  movl  %eax, -416(%ebp)
  movl -416(%ebp), %eax
  movl %eax, -4(%ebp)
  jmp .BI14
.EI14:
  movl 8(%ebp), %eax
  subl $1, %eax
  movl  %eax, -420(%ebp)
  movl -420(%ebp), %edx
  movl -404(%ebp,%edx,4), %eax
  leave
  ret

  .globl int2bin
  .type int2bin, @function
int2bin:
  pushl %ebp
  movl %esp, %ebp
  subl $68,%esp
  movl $0,-4(%ebp)
  movl $0,-12(%ebp)
.BI15:
  movl 8(%ebp), %eax
  cmp $1, %eax
  jg short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -24(%ebp)
  jle .LIF16
  movl 8(%ebp), %edx
  idiv $2
  movl  %edx, -28(%ebp)
  movl -28(%ebp), %eax
  movl %eax, -8(%ebp)
  movl $0,-16(%ebp)
.BI17:
  movl -16(%ebp), %eax
  cmp -12(%ebp), %eax
  jl short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -32(%ebp)
  jge .LIF18
  movl -8(%ebp), %eax
  imull $10, %eax
  movl  %eax, -36(%ebp)
  movl -36(%ebp), %eax
  movl %eax, -8(%ebp)
  movl -16(%ebp), %eax
  addl $1, %eax
  movl  %eax, -40(%ebp)
  movl -40(%ebp), %eax
  movl %eax, -16(%ebp)
  jmp .BI17
.LIF18:
  jmp .BI17
  jmp .BI17
.EI17:
  movl -4(%ebp), %eax
  movl -8(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -44(%ebp)
  movl -44(%ebp), %eax
  movl %eax, -4(%ebp)
  movl -12(%ebp), %eax
  addl $1, %eax
  movl  %eax, -48(%ebp)
  movl -48(%ebp), %eax
  movl %eax, -12(%ebp)
  movl 8(%ebp), %edx
  idiv $2
  movl  %eax, -52(%ebp)
  movl -52(%ebp), %eax
  movl %eax, 8(%ebp)
  jmp .BI15
.LIF18:
  jmp .BI15
  movl $0,-20(%ebp)
.BI19:
  movl -20(%ebp), %eax
  cmp -12(%ebp), %eax
  jl short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -56(%ebp)
  jge .LIF20
  movl 8(%ebp), %eax
  imull $10, %eax
  movl  %eax, -60(%ebp)
  movl -60(%ebp), %eax
  movl %eax, 8(%ebp)
  movl -20(%ebp), %eax
  addl $1, %eax
  movl  %eax, -64(%ebp)
  movl -64(%ebp), %eax
  movl %eax, -20(%ebp)
  jmp .BI19
.LIF20:
  jmp .BI19
  jmp .BI19
.EI19:
  jmp .BI15
.EI15:
  movl -4(%ebp), %eax
  movl 8(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -68(%ebp)
  movl -68(%ebp), %eax
  leave
  ret

  .globl gcd
  .type gcd, @function
gcd:
  pushl %ebp
  movl %esp, %ebp
  subl $40,%esp
  movl $1,-4(%ebp)
  movl -4(%ebp), %eax
  movl %eax, -8(%ebp)
.BI21:
  movl 8(%ebp), %eax
  movl 12(%ebp), %edx
  addl %edx, %eax
  movl  %eax, -12(%ebp)
  movl -4(%ebp), %eax
  cmp -12(%ebp), %eax
  jl short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -16(%ebp)
  jge .EI21
  movl 8(%ebp), %edx
  movl -4(%ebp), %ecx
  idiv %ecx
  movl  %edx, -20(%ebp)
  movl -20(%ebp), %eax
  cmp $0, %eax
  je short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -24(%ebp)
  movl 12(%ebp), %edx
  movl -4(%ebp), %ecx
  idiv %ecx
  movl  %edx, -28(%ebp)
  movl -28(%ebp), %eax
  cmp $0, %eax
  je short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -32(%ebp)
  movl -24(%ebp), %eax
  movl -32(%ebp), %edx
  and %edx, %eax
  movl  %eax, -36(%ebp)
  movl -36(%ebp), %eax
  cmp %eax, $1
  je .LIF22
  movl -4(%ebp), %eax
  movl %eax, -8(%ebp)
.LIF22:
  movl -4(%ebp), %eax
  addl $1, %eax
  movl  %eax, -40(%ebp)
  movl -40(%ebp), %eax
  movl %eax, -4(%ebp)
  jmp .BI21
.EI21:
  movl -8(%ebp), %eax
  leave
  ret

  .globl potenciaR
  .type potenciaR, @function
potenciaR:
  pushl %ebp
  movl %esp, %ebp
  subl $28,%esp
  movl .LC5, %eax
  movl %eax, -8(%ebp)
  movl $1,-4(%ebp)
.BI23:
  movl -4(%ebp), %eax
  cmp 12(%ebp), %eax
  jl short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -12(%ebp)
  movl -4(%ebp), %eax
  cmp 12(%ebp), %eax
  je short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -16(%ebp)
  movl -12(%ebp), %eax
  movl -16(%ebp), %edx
  or %edx, %eax
  movl  %eax, -20(%ebp)
  movl -20(%ebp), %eax
  cmp %eax, $1
  je .LIF24
  flds -8(%ebp)
  flds 8(%ebp)
  fmulp %st, %st(1)
  fstps -24(%ebp)
  movl -24(%ebp), %eax
  movl %eax, -8(%ebp)
  movl -4(%ebp), %eax
  addl $1, %eax
  movl  %eax, -28(%ebp)
  movl -28(%ebp), %eax
  movl %eax, -4(%ebp)
.LIF24:
  jmp .BI23
  jmp .BI23
.EI23:
  movl -8(%ebp), %eax
  leave
  ret

  .globl test
  .type test, @function
test:
  pushl %ebp
  movl %esp, %ebp
  subl $8,%esp
  movl .LC6, %eax
  movl %eax, -4(%ebp)
  call print_int
  call print_int
  movl --4(%ebp), %eax
  movl %eax, 0(%esp)
  CALL potenciaR
  movl  %eax, -8(%ebp)
  movl -8(%ebp), %eax
  movl %eax, -4(%ebp)
  call print_float
  .globl test1
  .type test1, @function
test1:
  pushl %ebp
  movl %esp, %ebp
  subl $8,%esp
  movl .LC7, %eax
  movl %eax, -4(%ebp)
  CALL test
  movl  %eax, -8(%ebp)
  call print_float
  .globl main
  .type main, @function
main:
  pushl %ebp
  movl %esp, %ebp
  subl $36,%esp
  call init_input
  call print_string
  call get_int
  movl  %eax, -40(%ebp)
  movl -40(%ebp), %eax
  movl %eax, -4(%ebp)
  movl $0,-8(%ebp)
.BI25:
  movl -8(%ebp), %eax
  cmp -4(%ebp), %eax
  jl short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -44(%ebp)
  jge .EI25
  call get_int
  movl  %eax, -48(%ebp)
  movl -48(%ebp), %eax
  movl %eax, -12(%ebp)
  movl --12(%ebp), %eax
  movl %eax, 0(%esp)
  CALL factorial
  movl  %eax, -52(%ebp)
  movl -52(%ebp), %eax
  movl %eax, -12(%ebp)
  call print_int
  movl -8(%ebp), %eax
  addl $1, %eax
  movl  %eax, -8(%ebp)
  jmp .BI25
.EI25:
  call print_string
  call print_string
  call get_int
  movl  %eax, -56(%ebp)
  movl -56(%ebp), %eax
  movl %eax, -4(%ebp)
  movl $0,-8(%ebp)
.BI26:
  movl -8(%ebp), %eax
  cmp -4(%ebp), %eax
  jl short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -60(%ebp)
  jge .EI26
  call get_float
  movl  %eax, -64(%ebp)
  movl -64(%ebp), %eax
  movl %eax, -16(%ebp)
  movl --16(%ebp), %eax
  movl %eax, 0(%esp)
  CALL factorialF
  movl  %eax, -68(%ebp)
  movl -68(%ebp), %eax
  movl %eax, -16(%ebp)
  call print_float
  movl -8(%ebp), %eax
  addl $1, %eax
  movl  %eax, -8(%ebp)
  jmp .BI26
.EI26:
  call print_string
  call print_string
  call get_int
  movl  %eax, -72(%ebp)
  movl -72(%ebp), %eax
  movl %eax, -4(%ebp)
  movl $0,-8(%ebp)
.BI27:
  movl -8(%ebp), %eax
  cmp -4(%ebp), %eax
  jl short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -76(%ebp)
  jge .EI27
  call get_int
  movl  %eax, -80(%ebp)
  movl -80(%ebp), %eax
  movl %eax, -20(%ebp)
  movl --20(%ebp), %eax
  movl %eax, 0(%esp)
  CALL factorialArray
  movl  %eax, -84(%ebp)
  movl -84(%ebp), %eax
  movl %eax, -20(%ebp)
  call print_int
  movl -8(%ebp), %eax
  addl $1, %eax
  movl  %eax, -8(%ebp)
  jmp .BI27
.EI27:
  call print_string
  call print_string
  call get_int
  movl  %eax, -88(%ebp)
  movl -88(%ebp), %eax
  movl %eax, -4(%ebp)
  movl $0,-8(%ebp)
.BI28:
  movl -8(%ebp), %eax
  cmp -4(%ebp), %eax
  jl short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -92(%ebp)
  jge .EI28
  call get_int
  movl  %eax, -96(%ebp)
  movl -96(%ebp), %eax
  movl %eax, -24(%ebp)
  movl --24(%ebp), %eax
  movl %eax, 0(%esp)
  CALL nthprime
  movl  %eax, -100(%ebp)
  movl -100(%ebp), %eax
  movl %eax, -24(%ebp)
  call print_int
  movl -8(%ebp), %eax
  addl $1, %eax
  movl  %eax, -8(%ebp)
  jmp .BI28
.EI28:
  call print_string
  call print_string
  call get_int
  movl  %eax, -104(%ebp)
  movl -104(%ebp), %eax
  movl %eax, -4(%ebp)
  movl $0,-8(%ebp)
.BI29:
  movl -8(%ebp), %eax
  cmp -4(%ebp), %eax
  jl short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -108(%ebp)
  jge .EI29
  call get_int
  movl  %eax, -112(%ebp)
  movl -112(%ebp), %eax
  movl %eax, -28(%ebp)
  movl --28(%ebp), %eax
  movl %eax, 0(%esp)
  CALL nthprimeArray
  movl  %eax, -116(%ebp)
  movl -116(%ebp), %eax
  movl %eax, -28(%ebp)
  call print_int
  movl -8(%ebp), %eax
  addl $1, %eax
  movl  %eax, -8(%ebp)
  jmp .BI29
.EI29:
  call print_string
  call print_string
  call get_int
  movl  %eax, -120(%ebp)
  movl -120(%ebp), %eax
  movl %eax, -4(%ebp)
  movl $0,-8(%ebp)
.BI30:
  movl -8(%ebp), %eax
  cmp -4(%ebp), %eax
  jl short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -124(%ebp)
  jge .EI30
  call get_int
  movl  %eax, -128(%ebp)
  movl -128(%ebp), %eax
  movl %eax, -32(%ebp)
  movl --32(%ebp), %eax
  movl %eax, 0(%esp)
  CALL int2bin
  movl  %eax, -132(%ebp)
  movl -132(%ebp), %eax
  movl %eax, -32(%ebp)
  call print_int
  movl -8(%ebp), %eax
  addl $1, %eax
  movl  %eax, -8(%ebp)
  jmp .BI30
.EI30:
  call print_string
  call print_string
  call get_int
  movl  %eax, -136(%ebp)
  movl -136(%ebp), %eax
  movl %eax, -4(%ebp)
  movl $0,-8(%ebp)
.BI31:
  movl -8(%ebp), %eax
  cmp -4(%ebp), %eax
  jl short .true
  movl $0, %eax
  jmp short .endtrue
.true:
  movl $1, %eax
.endtrue:
  movl  %eax, -140(%ebp)
  jge .EI31
  CALL gcd
  movl  %eax, -144(%ebp)
  movl -144(%ebp), %eax
  movl %eax, -36(%ebp)
  call print_int
  movl -8(%ebp), %eax
  addl $1, %eax
  movl  %eax, -8(%ebp)
  jmp .BI31
.EI31:
  call print_string
  call print_string
  CALL test
  movl  %eax, -148(%ebp)
  call print_string
  call print_string
  CALL test1
  movl  %eax, -152(%ebp)
  call print_string
  call close_input
  leave
  ret
.LC0:
  .float 15.0
.LC1:
  .float -1.0
.LC2:
  .float 0.0
.LC3:
  .float 1.0
.LC4:
  .float 1.0
.LC5:
  .float 1.0
.LC6:
  .float 2.0
.LC7:
  .float 2.0
