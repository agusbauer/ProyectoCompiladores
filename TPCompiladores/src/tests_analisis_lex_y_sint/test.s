	.file	"test.c"
	.text
	.globl	factorial
	.type	factorial, @function
factorial:
.LFB0:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$16, %esp
	movl	$15, -4(%ebp)
	movl	8(%ebp), %eax
	cmpl	-4(%ebp), %eax
	jle	.L2
	movl	$-1, %eax
	jmp	.L3
.L2:
	movl	$0, -12(%ebp)
	movl	$1, -8(%ebp)
	jmp	.L4
.L5:
	addl	$1, -12(%ebp)
	movl	-8(%ebp), %eax
	imull	-12(%ebp), %eax
	movl	%eax, -8(%ebp)
.L4:
	movl	-12(%ebp), %eax
	cmpl	8(%ebp), %eax
	jl	.L5
	movl	-8(%ebp), %eax
.L3:
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE0:
	.size	factorial, .-factorial
	.globl	factorialFor
	.type	factorialFor, @function
factorialFor:
.LFB1:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$16, %esp
	movl	$15, -4(%ebp)
	movl	8(%ebp), %eax
	cmpl	-4(%ebp), %eax
	jle	.L7
	movl	$-1, %eax
	jmp	.L8
.L7:
	movl	$0, -12(%ebp)
	movl	$1, -8(%ebp)
	jmp	.L9
.L10:
	addl	$1, -12(%ebp)
	movl	-8(%ebp), %eax
	imull	-12(%ebp), %eax
	movl	%eax, -8(%ebp)
.L9:
	movl	-12(%ebp), %eax
	cmpl	8(%ebp), %eax
	jl	.L10
	movl	-8(%ebp), %eax
.L8:
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE1:
	.size	factorialFor, .-factorialFor
	.globl	factorialF
	.type	factorialF, @function
factorialF:
.LFB2:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$20, %esp
	movl	.LC0, %eax
	movl	%eax, -4(%ebp)
	flds	8(%ebp)
	flds	-4(%ebp)
	fxch	%st(1)
	fucomip	%st(1), %st
	fstp	%st(0)
	jbe	.L18
	movl	.LC1, %eax
	jmp	.L14
.L18:
	movl	.LC2, %eax
	movl	%eax, -12(%ebp)
	movl	.LC3, %eax
	movl	%eax, -8(%ebp)
	jmp	.L15
.L16:
	flds	-12(%ebp)
	fld1
	faddp	%st, %st(1)
	fstps	-12(%ebp)
	flds	-8(%ebp)
	fmuls	-12(%ebp)
	fstps	-8(%ebp)
.L15:
	flds	8(%ebp)
	flds	-12(%ebp)
	fxch	%st(1)
	fucomip	%st(1), %st
	fstp	%st(0)
	ja	.L16
	movl	-8(%ebp), %eax
.L14:
	movl	%eax, -20(%ebp)
	flds	-20(%ebp)
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE2:
	.size	factorialF, .-factorialF
	.globl	factorialArray
	.type	factorialArray, @function
factorialArray:
.LFB3:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$80, %esp
	movl	$15, -64(%ebp)
	movl	$0, -76(%ebp)
	jmp	.L20
.L23:
	movl	$0, -72(%ebp)
	movl	$1, -68(%ebp)
	jmp	.L21
.L22:
	addl	$1, -72(%ebp)
	movl	-68(%ebp), %eax
	imull	-72(%ebp), %eax
	movl	%eax, -68(%ebp)
.L21:
	movl	-72(%ebp), %eax
	cmpl	-76(%ebp), %eax
	jl	.L22
	movl	-76(%ebp), %eax
	movl	-68(%ebp), %edx
	movl	%edx, -60(%ebp,%eax,4)
	addl	$1, -76(%ebp)
.L20:
	movl	-76(%ebp), %eax
	cmpl	-64(%ebp), %eax
	jl	.L23
	movl	-64(%ebp), %eax
	subl	$1, %eax
	cmpl	8(%ebp), %eax
	jge	.L24
	movl	$-1, %eax
	jmp	.L26
.L24:
	movl	8(%ebp), %eax
	movl	-60(%ebp,%eax,4), %eax
.L26:
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE3:
	.size	factorialArray, .-factorialArray
	.globl	nthprime
	.type	nthprime, @function
nthprime:
.LFB4:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$16, %esp
	movl	$0, -12(%ebp)
	movl	$2, -8(%ebp)
	addl	$1, 8(%ebp)
	jmp	.L28
.L33:
	movl	$0, -4(%ebp)
	addl	$1, -12(%ebp)
	jmp	.L29
.L32:
	movl	-12(%ebp), %eax
	cltd
	idivl	-8(%ebp)
	movl	%edx, %eax
	testl	%eax, %eax
	jne	.L30
	movl	$1, -4(%ebp)
	jmp	.L29
.L30:
	addl	$1, -8(%ebp)
.L29:
	cmpl	$0, -4(%ebp)
	jne	.L31
	movl	-8(%ebp), %eax
	cmpl	-12(%ebp), %eax
	jl	.L32
.L31:
	movl	$2, -8(%ebp)
	cmpl	$0, -4(%ebp)
	jne	.L28
	subl	$1, 8(%ebp)
.L28:
	cmpl	$0, 8(%ebp)
	jg	.L33
	movl	-12(%ebp), %eax
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE4:
	.size	nthprime, .-nthprime
	.globl	nthprimeArray
	.type	nthprimeArray, @function
nthprimeArray:
.LFB5:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$420, %esp
	movl	$0, -404(%ebp)
	jmp	.L36
.L37:
	movl	-404(%ebp), %eax
	movl	%eax, (%esp)
	call	nthprime
	movl	-404(%ebp), %edx
	movl	%eax, -400(%ebp,%edx,4)
	addl	$1, -404(%ebp)
.L36:
	cmpl	$99, -404(%ebp)
	jle	.L37
	movl	8(%ebp), %eax
	subl	$1, %eax
	movl	-400(%ebp,%eax,4), %eax
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE5:
	.size	nthprimeArray, .-nthprimeArray
	.globl	int2bin
	.type	int2bin, @function
int2bin:
.LFB6:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$32, %esp
	movl	$0, -20(%ebp)
	movl	$0, -12(%ebp)
.L43:
	cmpl	$1, 8(%ebp)
	jle	.L40
	movl	8(%ebp), %eax
	cltd
	shrl	$31, %edx
	addl	%edx, %eax
	andl	$1, %eax
	subl	%edx, %eax
	movl	%eax, -16(%ebp)
	movl	$0, -8(%ebp)
.L42:
	movl	-8(%ebp), %eax
	cmpl	-12(%ebp), %eax
	jge	.L41
	movl	-16(%ebp), %edx
	movl	%edx, %eax
	sall	$2, %eax
	addl	%edx, %eax
	addl	%eax, %eax
	movl	%eax, -16(%ebp)
	addl	$1, -8(%ebp)
	jmp	.L42
.L41:
	nop
	movl	-16(%ebp), %eax
	addl	%eax, -20(%ebp)
	addl	$1, -12(%ebp)
	movl	8(%ebp), %eax
	movl	%eax, %edx
	shrl	$31, %edx
	addl	%edx, %eax
	sarl	%eax
	movl	%eax, 8(%ebp)
	jmp	.L43
.L40:
	nop
	movl	$0, -4(%ebp)
.L45:
	movl	-4(%ebp), %eax
	cmpl	-12(%ebp), %eax
	jge	.L44
	movl	8(%ebp), %edx
	movl	%edx, %eax
	sall	$2, %eax
	addl	%edx, %eax
	addl	%eax, %eax
	movl	%eax, 8(%ebp)
	addl	$1, -4(%ebp)
	jmp	.L45
.L44:
	nop
	movl	8(%ebp), %eax
	movl	-20(%ebp), %edx
	addl	%edx, %eax
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE6:
	.size	int2bin, .-int2bin
	.globl	gcd
	.type	gcd, @function
gcd:
.LFB7:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$16, %esp
	movl	$1, -8(%ebp)
	movl	-8(%ebp), %eax
	movl	%eax, -4(%ebp)
	jmp	.L48
.L50:
	movl	8(%ebp), %eax
	cltd
	idivl	-8(%ebp)
	movl	%edx, %eax
	testl	%eax, %eax
	jne	.L49
	movl	12(%ebp), %eax
	cltd
	idivl	-8(%ebp)
	movl	%edx, %eax
	testl	%eax, %eax
	jne	.L49
	movl	-8(%ebp), %eax
	movl	%eax, -4(%ebp)
.L49:
	addl	$1, -8(%ebp)
.L48:
	movl	12(%ebp), %eax
	movl	8(%ebp), %edx
	addl	%edx, %eax
	cmpl	-8(%ebp), %eax
	jg	.L50
	movl	-4(%ebp), %eax
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE7:
	.size	gcd, .-gcd
	.globl	potenciaR
	.type	potenciaR, @function
potenciaR:
.LFB8:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$20, %esp
	movl	.LC3, %eax
	movl	%eax, -4(%ebp)
	movl	$1, -8(%ebp)
.L55:
	movl	-8(%ebp), %eax
	cmpl	12(%ebp), %eax
	jl	.L53
	movl	-8(%ebp), %eax
	cmpl	12(%ebp), %eax
	jne	.L54
.L53:
	flds	-4(%ebp)
	fmuls	8(%ebp)
	fstps	-4(%ebp)
	addl	$1, -8(%ebp)
	jmp	.L55
.L54:
	movl	-4(%ebp), %eax
	movl	%eax, -20(%ebp)
	flds	-20(%ebp)
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE8:
	.size	potenciaR, .-potenciaR
	.globl	test
	.type	test, @function
test:
.LFB9:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	pushl	%ebx
	subl	$36, %esp
	.cfi_offset 3, -12
	movl	.LC5, %eax
	movl	%eax, -12(%ebp)
	movl	$4, (%esp)
	call	factorial
	movl	%eax, %ebx
	movl	$3, (%esp)
	call	factorial
	movl	%ebx, 4(%esp)
	movl	%eax, (%esp)
	call	gcd
	movl	%eax, (%esp)
	call	print_int
	movl	$4, (%esp)
	call	factorial
	movl	%eax, %ebx
	movl	$3, (%esp)
	call	factorial
	movl	%ebx, 4(%esp)
	movl	%eax, (%esp)
	call	gcd
	movl	%eax, (%esp)
	call	nthprimeArray
	movl	%eax, (%esp)
	call	print_int
	movl	$4, (%esp)
	call	factorial
	movl	%eax, %ebx
	movl	$3, (%esp)
	call	factorial
	movl	%ebx, 4(%esp)
	movl	%eax, (%esp)
	call	gcd
	movl	%eax, (%esp)
	call	nthprimeArray
	movl	%eax, 4(%esp)
	movl	-12(%ebp), %eax
	movl	%eax, (%esp)
	call	potenciaR
	fstps	-12(%ebp)
	movl	-12(%ebp), %eax
	movl	%eax, (%esp)
	call	print_float
	addl	$36, %esp
	popl	%ebx
	.cfi_restore 3
	popl	%ebp
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE9:
	.size	test, .-test
	.globl	test1
	.type	test1, @function
test1:
.LFB10:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$40, %esp
	movl	.LC5, %eax
	movl	%eax, -12(%ebp)
	call	test
	movl	-12(%ebp), %eax
	movl	%eax, (%esp)
	call	print_float
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE10:
	.size	test1, .-test1
	.section	.rodata
.LC6:
	.string	"input"
	.align 4
.LC7:
	.string	"Factorial Enteros----------------------------------"
	.align 4
.LC8:
	.string	"---------------------------------------------------------"
	.align 4
.LC9:
	.string	"Factorial Reales----------------------------------"
	.align 4
.LC10:
	.string	"Factorial Array Enteros----------------------------------"
	.align 4
.LC11:
	.string	"Nthprime Enteros----------------------------------"
	.align 4
.LC12:
	.string	"Nthprime Array Enteros----------------------------------"
	.align 4
.LC13:
	.string	"Int2Bin Enteros----------------------------------"
	.align 4
.LC14:
	.string	"GCD Enteros----------------------------------"
	.align 4
.LC15:
	.string	"test----------------------------------"
	.align 4
.LC16:
	.string	"test1----------------------------------"
	.text
	.globl	main
	.type	main, @function
main:
.LFB11:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	pushl	%ebx
	andl	$-16, %esp
	subl	$64, %esp
	.cfi_offset 3, -12
	movl	$.LC6, (%esp)
	call	init_input
	movl	$.LC7, (%esp)
	call	print_string
	call	get_int
	movl	%eax, 32(%esp)
	movl	$0, 28(%esp)
	jmp	.L60
.L61:
	call	get_int
	movl	%eax, 36(%esp)
	movl	36(%esp), %eax
	movl	%eax, (%esp)
	call	factorial
	movl	%eax, 36(%esp)
	movl	36(%esp), %eax
	movl	%eax, (%esp)
	call	print_int
	addl	$1, 28(%esp)
.L60:
	movl	28(%esp), %eax
	cmpl	32(%esp), %eax
	jl	.L61
	movl	$.LC8, (%esp)
	call	print_string
	movl	$.LC9, (%esp)
	call	print_string
	call	get_int
	movl	%eax, 32(%esp)
	movl	$0, 28(%esp)
	jmp	.L62
.L63:
	call	get_float
	fstps	40(%esp)
	movl	40(%esp), %eax
	movl	%eax, (%esp)
	call	factorialF
	fstps	40(%esp)
	movl	40(%esp), %eax
	movl	%eax, (%esp)
	call	print_float
	addl	$1, 28(%esp)
.L62:
	movl	28(%esp), %eax
	cmpl	32(%esp), %eax
	jl	.L63
	movl	$.LC8, (%esp)
	call	print_string
	movl	$.LC10, (%esp)
	call	print_string
	call	get_int
	movl	%eax, 32(%esp)
	movl	$0, 28(%esp)
	jmp	.L64
.L65:
	call	get_int
	movl	%eax, 44(%esp)
	movl	44(%esp), %eax
	movl	%eax, (%esp)
	call	factorialArray
	movl	%eax, 44(%esp)
	movl	44(%esp), %eax
	movl	%eax, (%esp)
	call	print_int
	addl	$1, 28(%esp)
.L64:
	movl	28(%esp), %eax
	cmpl	32(%esp), %eax
	jl	.L65
	movl	$.LC8, (%esp)
	call	print_string
	movl	$.LC11, (%esp)
	call	print_string
	call	get_int
	movl	%eax, 32(%esp)
	movl	$0, 28(%esp)
	jmp	.L66
.L67:
	call	get_int
	movl	%eax, 48(%esp)
	movl	48(%esp), %eax
	movl	%eax, (%esp)
	call	nthprime
	movl	%eax, 48(%esp)
	movl	48(%esp), %eax
	movl	%eax, (%esp)
	call	print_int
	addl	$1, 28(%esp)
.L66:
	movl	28(%esp), %eax
	cmpl	32(%esp), %eax
	jl	.L67
	movl	$.LC8, (%esp)
	call	print_string
	movl	$.LC12, (%esp)
	call	print_string
	call	get_int
	movl	%eax, 32(%esp)
	movl	$0, 28(%esp)
	jmp	.L68
.L69:
	call	get_int
	movl	%eax, 52(%esp)
	movl	52(%esp), %eax
	movl	%eax, (%esp)
	call	nthprimeArray
	movl	%eax, 52(%esp)
	movl	52(%esp), %eax
	movl	%eax, (%esp)
	call	print_int
	addl	$1, 28(%esp)
.L68:
	movl	28(%esp), %eax
	cmpl	32(%esp), %eax
	jl	.L69
	movl	$.LC8, (%esp)
	call	print_string
	movl	$.LC13, (%esp)
	call	print_string
	call	get_int
	movl	%eax, 32(%esp)
	movl	$0, 28(%esp)
	jmp	.L70
.L71:
	call	get_int
	movl	%eax, 56(%esp)
	movl	56(%esp), %eax
	movl	%eax, (%esp)
	call	int2bin
	movl	%eax, 56(%esp)
	movl	56(%esp), %eax
	movl	%eax, (%esp)
	call	print_int
	addl	$1, 28(%esp)
.L70:
	movl	28(%esp), %eax
	cmpl	32(%esp), %eax
	jl	.L71
	movl	$.LC8, (%esp)
	call	print_string
	movl	$.LC14, (%esp)
	call	print_string
	call	get_int
	movl	%eax, 32(%esp)
	movl	$0, 28(%esp)
	jmp	.L72
.L73:
	call	get_int
	movl	%eax, %ebx
	call	get_int
	movl	%ebx, 4(%esp)
	movl	%eax, (%esp)
	call	gcd
	movl	%eax, 60(%esp)
	movl	60(%esp), %eax
	movl	%eax, (%esp)
	call	print_int
	addl	$1, 28(%esp)
.L72:
	movl	28(%esp), %eax
	cmpl	32(%esp), %eax
	jl	.L73
	movl	$.LC8, (%esp)
	call	print_string
	movl	$.LC15, (%esp)
	call	print_string
	call	test
	movl	$.LC8, (%esp)
	call	print_string
	movl	$.LC16, (%esp)
	call	print_string
	call	test1
	movl	$.LC8, (%esp)
	call	print_string
	call	close_input
	movl	$1, %eax
	movl	-4(%ebp), %ebx
	leave
	.cfi_restore 5
	.cfi_restore 3
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE11:
	.size	main, .-main
	.section	.rodata
	.align 4
.LC0:
	.long	1097859072
	.align 4
.LC1:
	.long	-1082130432
	.align 4
.LC2:
	.long	0
	.align 4
.LC3:
	.long	1065353216
	.align 4
.LC5:
	.long	1073741824
	.ident	"GCC: (Ubuntu 4.8.2-19ubuntu1) 4.8.2"
	.section	.note.GNU-stack,"",@progbits
