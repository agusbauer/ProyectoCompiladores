  .file  "testCTDS.s"

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
      jg  .true0
      movl $0, %eax
      jmp  .endtrue0
.true0:
      movl $1, %eax
.endtrue0:
      movl  %eax, -16(%ebp)
      jle .LIF0
      movl -1, %eax
      leave
      ret

.LIF0:
      movl $0,-8(%ebp)
      movl $1,-12(%ebp)
.BI2:
      movl -8(%ebp), %eax
      cmp 8(%ebp), %eax
      jl  .true1
      movl $0, %eax
      jmp  .endtrue1
.true1:
      movl $1, %eax
.endtrue1:
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
      jg  .true2
      movl $0, %eax
      jmp  .endtrue2
.true2:
      movl $1, %eax
.endtrue2:
      movl  %eax, -16(%ebp)
      jle .LIF2
      movl -1, %eax
      leave
      ret

.LIF2:
      movl $1,-8(%ebp)
      movl $1,-12(%ebp)
.BI4:
      movl $1,-8(%ebp)
      movl -8(%ebp), %eax
      cmp 8(%ebp), %eax
      jle  .true3
      movl $0, %eax
      jmp  .endtrue3
.true3:
      movl $1, %eax
.endtrue3:
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

      leave
      ret

      .globl factorialF
      .type factorialF, @function
factorialF:
      pushl %ebp
      movl %esp, %ebp
      subl $28,%esp
      movl .LF0, %eax
      movl %eax, -4(%ebp)
      flds 8(%ebp)
      flds -4(%ebp)
      fucompp
      fnstsw %ax
      andb $69,%ah
      jg  .true4
      movl $0, %eax
      jmp  .endtrue4
.true4:
      movl $1, %eax
.endtrue4:
      movl  %eax, -16(%ebp)
      jle .LIF4
      movl .LF1, %eax
      leave
      ret

.LIF4:
      movl .LF2, %eax
      movl %eax, -8(%ebp)
      movl .LF3, %eax
      movl %eax, -12(%ebp)
.BI6:
      flds -8(%ebp)
      flds 8(%ebp)
      fucompp
      fnstsw %ax
      andb $69,%ah
      cmpb $1,%ah
      jl  .true5
      movl $0, %eax
      jmp  .endtrue5
.true5:
      movl $1, %eax
.endtrue5:
      movl  %eax, -20(%ebp)
      jge .EI6
      flds -8(%ebp)
      flds .LF4
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
      jl  .true6
      movl $0, %eax
      jmp  .endtrue6
.true6:
      movl $1, %eax
.endtrue6:
      movl  %eax, -80(%ebp)
      jge .EI7
      movl $0,-72(%ebp)
      movl $1,-76(%ebp)
.BI8:
      movl -72(%ebp), %eax
      cmp -8(%ebp), %eax
      jl  .true7
      movl $0, %eax
      jmp  .endtrue7
.true7:
      movl $1, %eax
.endtrue7:
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
      jg  .true8
      movl $0, %eax
      jmp  .endtrue8
.true8:
      movl $1, %eax
.endtrue8:
      movl  %eax, -104(%ebp)
      jle .LIF8
      movl -1, %eax
      leave
      ret

      jmp .LEIF8
.LIF8:
  movl 8(%ebp), %edx
      movl -68(%ebp,%edx,4), %eax
      leave
      ret

.LEIF8:
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
      jg  .true9
      movl $0, %eax
      jmp  .endtrue9
.true9:
      movl $1, %eax
.endtrue9:
      movl  %eax, -20(%ebp)
      jle .EI10
      movl $0,-12(%ebp)
      movl -4(%ebp), %eax
      addl $1, %eax
      movl  %eax, -24(%ebp)
      movl -24(%ebp), %eax
      movl %eax, -4(%ebp)
.BI11:
      movl -12(%ebp), %eax
      cmp $1, %eax
      je  .true10
      movl $1, %eax
      jmp  .endtrue10
.true10:
      movl $0, %eax
.endtrue10:
      movl  %eax, -28(%ebp)
      movl -8(%ebp), %eax
      cmp -4(%ebp), %eax
      jl  .true11
      movl $0, %eax
      jmp  .endtrue11
.true11:
      movl $1, %eax
.endtrue11:
      movl  %eax, -32(%ebp)
      movl -28(%ebp), %eax
      movl -32(%ebp), %edx
      and %edx, %eax
      movl  %eax, -36(%ebp)
      movl -36(%ebp), %eax
      cmp $1, %eax
      jne .EI11
      movl -4(%ebp), %edx
      movl -8(%ebp), %ecx
      cltd
      idivl %ecx
      movl  %edx, -40(%ebp)
      movl -40(%ebp), %eax
      cmp $0, %eax
      je  .true12
      movl $0, %eax
      jmp  .endtrue12
.true12:
      movl $1, %eax
.endtrue12:
      movl  %eax, -44(%ebp)
      jne .LIF11
      movl $1,-12(%ebp)
      jmp .LEIF11
.LIF11:
      movl -8(%ebp), %eax
      addl $1, %eax
      movl  %eax, -48(%ebp)
      movl -48(%ebp), %eax
      movl %eax, -8(%ebp)
.LEIF11:
      jmp .BI11
.EI11:
      movl $2,-8(%ebp)
      movl -12(%ebp), %eax
      cmp $1, %eax
      je  .true13
      movl $1, %eax
      jmp  .endtrue13
.true13:
      movl $0, %eax
.endtrue13:
      movl  %eax, -52(%ebp)
      movl -52(%ebp), %eax
      cmp $1, %eax
      jne .LIF12
      movl 8(%ebp), %eax
      subl $1, %eax
      movl  %eax, -56(%ebp)
      movl -56(%ebp), %eax
      movl %eax, 8(%ebp)
.LIF12:
      jmp .BI10
.EI10:
      movl -4(%ebp), %eax
      leave
      ret

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
      jl  .true14
      movl $0, %eax
      jmp  .endtrue14
.true14:
      movl $1, %eax
.endtrue14:
      movl  %eax, -408(%ebp)
      jge .EI14
      movl -4(%ebp), %eax
      movl %eax, 0(%esp)
      call nthprime
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
      cmp $0, %eax
      jg  .true15
      movl $0, %eax
      jmp  .endtrue15
.true15:
      movl $1, %eax
.endtrue15:
      movl  %eax, -24(%ebp)
      jle .LIF15
      movl 8(%ebp), %edx
      movl $2, %ecx
      cltd
      idivl %ecx
      movl  %edx, -28(%ebp)
      movl -28(%ebp), %eax
      movl %eax, -8(%ebp)
      movl $0,-16(%ebp)
.BI17:
      movl -16(%ebp), %eax
      cmp -12(%ebp), %eax
      jl  .true16
      movl $0, %eax
      jmp  .endtrue16
.true16:
      movl $1, %eax
.endtrue16:
      movl  %eax, -32(%ebp)
      jge .LIF17
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
      jmp .LEIF17
.LIF17:
      jmp .EI17
.LEIF17:
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
      movl $2, %ecx
      cltd
      idivl %ecx
      movl  %eax, -52(%ebp)
      movl -52(%ebp), %eax
      movl %eax, 8(%ebp)
      jmp .BI15
      jmp .LEIF15
.LIF15:
      jmp .EI15
.LEIF15:
      movl $0,-20(%ebp)
.BI19:
      movl -20(%ebp), %eax
      cmp -12(%ebp), %eax
      jl  .true17
      movl $0, %eax
      jmp  .endtrue17
.true17:
      movl $1, %eax
.endtrue17:
      movl  %eax, -56(%ebp)
      jge .LIF19
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
      jmp .LEIF19
.LIF19:
      jmp .EI19
.LEIF19:
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
      jl  .true18
      movl $0, %eax
      jmp  .endtrue18
.true18:
      movl $1, %eax
.endtrue18:
      movl  %eax, -16(%ebp)
      jge .EI21
      movl 8(%ebp), %edx
      movl -4(%ebp), %ecx
      cltd
      idivl %ecx
      movl  %edx, -20(%ebp)
      movl -20(%ebp), %eax
      cmp $0, %eax
      je  .true19
      movl $0, %eax
      jmp  .endtrue19
.true19:
      movl $1, %eax
.endtrue19:
      movl  %eax, -24(%ebp)
      movl 12(%ebp), %edx
      movl -4(%ebp), %ecx
      cltd
      idivl %ecx
      movl  %edx, -28(%ebp)
      movl -28(%ebp), %eax
      cmp $0, %eax
      je  .true20
      movl $0, %eax
      jmp  .endtrue20
.true20:
      movl $1, %eax
.endtrue20:
      movl  %eax, -32(%ebp)
      movl -24(%ebp), %eax
      movl -32(%ebp), %edx
      and %edx, %eax
      movl  %eax, -36(%ebp)
      movl -36(%ebp), %eax
      cmp $1, %eax
      jne .LIF21
      movl -4(%ebp), %eax
      movl %eax, -8(%ebp)
.LIF21:
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

      leave
      ret

      .globl potenciaR
      .type potenciaR, @function
potenciaR:
      pushl %ebp
      movl %esp, %ebp
      subl $28,%esp
      movl .LF5, %eax
      movl %eax, -8(%ebp)
      movl $1,-4(%ebp)
.BI23:
      movl -4(%ebp), %eax
      cmp 12(%ebp), %eax
      jl  .true21
      movl $0, %eax
      jmp  .endtrue21
.true21:
      movl $1, %eax
.endtrue21:
      movl  %eax, -12(%ebp)
      movl -4(%ebp), %eax
      cmp 12(%ebp), %eax
      je  .true22
      movl $0, %eax
      jmp  .endtrue22
.true22:
      movl $1, %eax
.endtrue22:
      movl  %eax, -16(%ebp)
      movl -12(%ebp), %eax
      movl -16(%ebp), %edx
      or %edx, %eax
      movl  %eax, -20(%ebp)
      movl -20(%ebp), %eax
      cmp $1, %eax
      jne .LIF23
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
      jmp .LEIF23
.LIF23:
      jmp .EI23
.LEIF23:
      jmp .BI23
.EI23:
      movl -8(%ebp), %eax
      leave
      ret

      leave
      ret

      .globl test
      .type test, @function
test:
      pushl %ebp
      movl %esp, %ebp
      subl $64,%esp
      movl .LF6, %eax
      movl %eax, -4(%ebp)
      movl $3, %eax
      movl %eax, 0(%esp)
      call factorial
      movl  %eax, -8(%ebp)
      movl $4, %eax
      movl %eax, 0(%esp)
      call factorial
      movl  %eax, -12(%ebp)
      movl -8(%ebp), %eax
      movl %eax, 0(%esp)
      movl -12(%ebp), %eax
      movl %eax, 4(%esp)
      call gcd
      movl  %eax, -16(%ebp)
      movl -16(%ebp), %eax
      movl %eax, 0(%esp)
      call print_int
      movl  %eax, -20(%ebp)
      movl $3, %eax
      movl %eax, 0(%esp)
      call factorial
      movl  %eax, -24(%ebp)
      movl $4, %eax
      movl %eax, 0(%esp)
      call factorial
      movl  %eax, -28(%ebp)
      movl -24(%ebp), %eax
      movl %eax, 0(%esp)
      movl -28(%ebp), %eax
      movl %eax, 4(%esp)
      call gcd
      movl  %eax, -32(%ebp)
      movl -32(%ebp), %eax
      movl %eax, 0(%esp)
      call nthprimeArray
      movl  %eax, -36(%ebp)
      movl -36(%ebp), %eax
      movl %eax, 0(%esp)
      call print_int
      movl  %eax, -40(%ebp)
      movl $3, %eax
      movl %eax, 0(%esp)
      call factorial
      movl  %eax, -44(%ebp)
      movl $4, %eax
      movl %eax, 0(%esp)
      call factorial
      movl  %eax, -48(%ebp)
      movl -44(%ebp), %eax
      movl %eax, 0(%esp)
      movl -48(%ebp), %eax
      movl %eax, 4(%esp)
      call gcd
      movl  %eax, -52(%ebp)
      movl -52(%ebp), %eax
      movl %eax, 0(%esp)
      call nthprimeArray
      movl  %eax, -56(%ebp)
      movl -4(%ebp), %eax
      movl %eax, 0(%esp)
      movl -56(%ebp), %eax
      movl %eax, 4(%esp)
      call potenciaR
      movl  %eax, -60(%ebp)
      movl -60(%ebp), %eax
      movl %eax, -4(%ebp)
      movl -4(%ebp), %eax
      movl %eax, 0(%esp)
      call print_float
      movl  %eax, -64(%ebp)
      leave
      ret

      .globl test1
      .type test1, @function
test1:
      pushl %ebp
      movl %esp, %ebp
      subl $12,%esp
      movl .LF7, %eax
      movl %eax, -4(%ebp)
      call test
      movl  %eax, -8(%ebp)
      movl -4(%ebp), %eax
      movl %eax, 0(%esp)
      call print_float
      movl  %eax, -12(%ebp)
      leave
      ret

      .globl main
      .type main, @function
main:
      pushl %ebp
      movl %esp, %ebp
      subl $268,%esp
      movl $.LS0, (%esp)
      call init_input
      movl  %eax, -40(%ebp)
      movl $.LS1, (%esp)
      call print_string
      movl  %eax, -44(%ebp)
      call get_int
      movl  %eax, -48(%ebp)
      movl -48(%ebp), %eax
      movl %eax, -4(%ebp)
      movl $0,-8(%ebp)
.BI25:
      movl -8(%ebp), %eax
      cmp -4(%ebp), %eax
      jl  .true23
      movl $0, %eax
      jmp  .endtrue23
.true23:
      movl $1, %eax
.endtrue23:
      movl  %eax, -52(%ebp)
      jge .EI25
      call get_int
      movl  %eax, -56(%ebp)
      movl -56(%ebp), %eax
      movl %eax, -12(%ebp)
      movl -12(%ebp), %eax
      movl %eax, 0(%esp)
      call factorial
      movl  %eax, -60(%ebp)
      movl -60(%ebp), %eax
      movl %eax, -12(%ebp)
      movl -12(%ebp), %eax
      movl %eax, 0(%esp)
      call print_int
      movl  %eax, -64(%ebp)
      movl -8(%ebp), %eax
      addl $1, %eax
      movl  %eax, -8(%ebp)
      jmp .BI25
.EI25:
      movl $.LS2, (%esp)
      call print_string
      movl  %eax, -68(%ebp)
      movl $.LS3, (%esp)
      call print_string
      movl  %eax, -72(%ebp)
      call get_int
      movl  %eax, -76(%ebp)
      movl -76(%ebp), %eax
      movl %eax, -4(%ebp)
      movl $0,-8(%ebp)
.BI26:
      movl -8(%ebp), %eax
      cmp -4(%ebp), %eax
      jl  .true24
      movl $0, %eax
      jmp  .endtrue24
.true24:
      movl $1, %eax
.endtrue24:
      movl  %eax, -80(%ebp)
      jge .EI26
      call get_float
      movl  %eax, -84(%ebp)
      movl -84(%ebp), %eax
      movl %eax, -16(%ebp)
      movl -16(%ebp), %eax
      movl %eax, 0(%esp)
      call factorialF
      movl  %eax, -88(%ebp)
      movl -88(%ebp), %eax
      movl %eax, -16(%ebp)
      movl -16(%ebp), %eax
      movl %eax, 0(%esp)
      call print_float
      movl  %eax, -92(%ebp)
      movl -8(%ebp), %eax
      addl $1, %eax
      movl  %eax, -8(%ebp)
      jmp .BI26
.EI26:
      movl $.LS4, (%esp)
      call print_string
      movl  %eax, -96(%ebp)
      movl $.LS5, (%esp)
      call print_string
      movl  %eax, -100(%ebp)
      call get_int
      movl  %eax, -104(%ebp)
      movl -104(%ebp), %eax
      movl %eax, -4(%ebp)
      movl $0,-8(%ebp)
.BI27:
      movl -8(%ebp), %eax
      cmp -4(%ebp), %eax
      jl  .true25
      movl $0, %eax
      jmp  .endtrue25
.true25:
      movl $1, %eax
.endtrue25:
      movl  %eax, -108(%ebp)
      jge .EI27
      call get_int
      movl  %eax, -112(%ebp)
      movl -112(%ebp), %eax
      movl %eax, -20(%ebp)
      movl -20(%ebp), %eax
      movl %eax, 0(%esp)
      call factorialArray
      movl  %eax, -116(%ebp)
      movl -116(%ebp), %eax
      movl %eax, -20(%ebp)
      movl -20(%ebp), %eax
      movl %eax, 0(%esp)
      call print_int
      movl  %eax, -120(%ebp)
      movl -8(%ebp), %eax
      addl $1, %eax
      movl  %eax, -8(%ebp)
      jmp .BI27
.EI27:
      movl $.LS6, (%esp)
      call print_string
      movl  %eax, -124(%ebp)
      movl $.LS7, (%esp)
      call print_string
      movl  %eax, -128(%ebp)
      call get_int
      movl  %eax, -132(%ebp)
      movl -132(%ebp), %eax
      movl %eax, -4(%ebp)
      movl $0,-8(%ebp)
.BI28:
      movl -8(%ebp), %eax
      cmp -4(%ebp), %eax
      jl  .true26
      movl $0, %eax
      jmp  .endtrue26
.true26:
      movl $1, %eax
.endtrue26:
      movl  %eax, -136(%ebp)
      jge .EI28
      call get_int
      movl  %eax, -140(%ebp)
      movl -140(%ebp), %eax
      movl %eax, -24(%ebp)
      movl -24(%ebp), %eax
      movl %eax, 0(%esp)
      call nthprime
      movl  %eax, -144(%ebp)
      movl -144(%ebp), %eax
      movl %eax, -24(%ebp)
      movl -24(%ebp), %eax
      movl %eax, 0(%esp)
      call print_int
      movl  %eax, -148(%ebp)
      movl -8(%ebp), %eax
      addl $1, %eax
      movl  %eax, -8(%ebp)
      jmp .BI28
.EI28:
      movl $.LS8, (%esp)
      call print_string
      movl  %eax, -152(%ebp)
      movl $.LS9, (%esp)
      call print_string
      movl  %eax, -156(%ebp)
      call get_int
      movl  %eax, -160(%ebp)
      movl -160(%ebp), %eax
      movl %eax, -4(%ebp)
      movl $0,-8(%ebp)
.BI29:
      movl -8(%ebp), %eax
      cmp -4(%ebp), %eax
      jl  .true27
      movl $0, %eax
      jmp  .endtrue27
.true27:
      movl $1, %eax
.endtrue27:
      movl  %eax, -164(%ebp)
      jge .EI29
      call get_int
      movl  %eax, -168(%ebp)
      movl -168(%ebp), %eax
      movl %eax, -28(%ebp)
      movl -28(%ebp), %eax
      movl %eax, 0(%esp)
      call nthprimeArray
      movl  %eax, -172(%ebp)
      movl -172(%ebp), %eax
      movl %eax, -28(%ebp)
      movl -28(%ebp), %eax
      movl %eax, 0(%esp)
      call print_int
      movl  %eax, -176(%ebp)
      movl -8(%ebp), %eax
      addl $1, %eax
      movl  %eax, -8(%ebp)
      jmp .BI29
.EI29:
      movl $.LS10, (%esp)
      call print_string
      movl  %eax, -180(%ebp)
      movl $.LS11, (%esp)
      call print_string
      movl  %eax, -184(%ebp)
      call get_int
      movl  %eax, -188(%ebp)
      movl -188(%ebp), %eax
      movl %eax, -4(%ebp)
      movl $0,-8(%ebp)
.BI30:
      movl -8(%ebp), %eax
      cmp -4(%ebp), %eax
      jl  .true28
      movl $0, %eax
      jmp  .endtrue28
.true28:
      movl $1, %eax
.endtrue28:
      movl  %eax, -192(%ebp)
      jge .EI30
      call get_int
      movl  %eax, -196(%ebp)
      movl -196(%ebp), %eax
      movl %eax, -32(%ebp)
      movl -32(%ebp), %eax
      movl %eax, 0(%esp)
      call int2bin
      movl  %eax, -200(%ebp)
      movl -200(%ebp), %eax
      movl %eax, -32(%ebp)
      movl -32(%ebp), %eax
      movl %eax, 0(%esp)
      call print_int
      movl  %eax, -204(%ebp)
      movl -8(%ebp), %eax
      addl $1, %eax
      movl  %eax, -8(%ebp)
      jmp .BI30
.EI30:
      movl $.LS12, (%esp)
      call print_string
      movl  %eax, -208(%ebp)
      movl $.LS13, (%esp)
      call print_string
      movl  %eax, -212(%ebp)
      call get_int
      movl  %eax, -216(%ebp)
      movl -216(%ebp), %eax
      movl %eax, -4(%ebp)
      movl $0,-8(%ebp)
.BI31:
      movl -8(%ebp), %eax
      cmp -4(%ebp), %eax
      jl  .true29
      movl $0, %eax
      jmp  .endtrue29
.true29:
      movl $1, %eax
.endtrue29:
      movl  %eax, -220(%ebp)
      jge .EI31
      call get_int
      movl  %eax, -224(%ebp)
      call get_int
      movl  %eax, -228(%ebp)
      movl -224(%ebp), %eax
      movl %eax, 0(%esp)
      movl -228(%ebp), %eax
      movl %eax, 4(%esp)
      call gcd
      movl  %eax, -232(%ebp)
      movl -232(%ebp), %eax
      movl %eax, -36(%ebp)
      movl -36(%ebp), %eax
      movl %eax, 0(%esp)
      call print_int
      movl  %eax, -236(%ebp)
      movl -8(%ebp), %eax
      addl $1, %eax
      movl  %eax, -8(%ebp)
      jmp .BI31
.EI31:
      movl $.LS14, (%esp)
      call print_string
      movl  %eax, -240(%ebp)
      movl $.LS15, (%esp)
      call print_string
      movl  %eax, -244(%ebp)
      call test
      movl  %eax, -248(%ebp)
      movl $.LS16, (%esp)
      call print_string
      movl  %eax, -252(%ebp)
      movl $.LS17, (%esp)
      call print_string
      movl  %eax, -256(%ebp)
      call test1
      movl  %eax, -260(%ebp)
      movl $.LS18, (%esp)
      call print_string
      movl  %eax, -264(%ebp)
      call close_input
      movl  %eax, -268(%ebp)
      leave
      ret

.LF0:
      .float 15.0
.LF1:
      .float -1.0
.LF2:
      .float 0.0
.LF3:
      .float 1.0
.LF4:
      .float 1.0
.LF5:
      .float 1.0
.LF6:
      .float 2.0
.LF7:
      .float 2.0
.LS0:
      .string "input"
.LS1:
      .string "Factorial Enteros----------------------------------"
.LS2:
      .string "---------------------------------------------------------"
.LS3:
      .string "Factorial Reales----------------------------------"
.LS4:
      .string "---------------------------------------------------------"
.LS5:
      .string "Factorial Array Enteros----------------------------------"
.LS6:
      .string "---------------------------------------------------------"
.LS7:
      .string "Nthprime Enteros----------------------------------"
.LS8:
      .string "---------------------------------------------------------"
.LS9:
      .string "Nthprime Array Enteros----------------------------------"
.LS10:
      .string "---------------------------------------------------------"
.LS11:
      .string "Int2Bin Enteros----------------------------------"
.LS12:
      .string "---------------------------------------------------------"
.LS13:
      .string "GCD Enteros----------------------------------"
.LS14:
      .string "---------------------------------------------------------"
.LS15:
      .string "test----------------------------------"
.LS16:
      .string "---------------------------------------------------------"
.LS17:
      .string "test1----------------------------------"
.LS18:
      .string "---------------------------------------------------------"
