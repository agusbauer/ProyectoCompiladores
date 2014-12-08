  .file  "constante.asm"

  .text

  .globl main
  .type main, @function
main:
  pushl %ebp
  movl %esp, %ebp
  subl $4,%esp
  movl $27,-4(%ebp)
  leave
  ret
