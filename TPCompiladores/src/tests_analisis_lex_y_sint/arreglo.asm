  .file  "arreglo.asm"
  .comm a, 20, 4

  .text

  .globl main
  .type main, @function
main:
  pushl %ebp
  movl %esp, %ebp
  subl $4,%esp
  movl $2,-4(%ebp)
  movl -4(%ebp), %edx
  movl .LC0, %eax
  movl %eax, a(,%edx,4)
  leave
  ret
.LC0:
  .float 3.0
