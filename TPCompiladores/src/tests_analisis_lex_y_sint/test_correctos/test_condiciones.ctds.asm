
.TEXT

  .GLOBL dados
  TYPE dados, @function
dados:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-448%ebp
  MOVL 8(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -232(%ebp)
  MOVL 12(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -240(%ebp)
  MOVL 16(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -248(%ebp)
  MOVL -248(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOVL $1, %eax
isTrue:
  MOVL $0, %eax
  MOVL  %eax, -244(%ebp)
  MOVL -240(%ebp), %eax
  MOVL -244(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -252(%ebp)
  MOVL -252(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOVL $1, %eax
isTrue:
  MOVL $0, %eax
  MOVL  %eax, -236(%ebp)
  MOVL -232(%ebp), %eax
  MOVL -236(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -256(%ebp)
  MOVL -256(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOVL $1, %eax
isTrue:
  MOVL $0, %eax
  MOVL  %eax, -228(%ebp)
  CMP %eax, $1
  JE LIF1
  MOVL 1.0, %eax
  LEAVE
  RET

LIF1:
  MOVL 8(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -260(%ebp)
  MOVL 12(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -268(%ebp)
  MOVL 16(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -276(%ebp)
  MOVL -276(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOVL $1, %eax
isTrue:
  MOVL $0, %eax
  MOVL  %eax, -272(%ebp)
  MOVL -268(%ebp), %eax
  MOVL -272(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -280(%ebp)
  MOVL -280(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOVL $1, %eax
isTrue:
  MOVL $0, %eax
  MOVL  %eax, -264(%ebp)
  MOVL -260(%ebp), %eax
  MOVL -264(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -284(%ebp)
  MOVL 8(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -292(%ebp)
  MOVL 12(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -296(%ebp)
  MOVL -292(%ebp), %eax
  MOVL -296(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -300(%ebp)
  MOVL 16(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -308(%ebp)
  MOVL -308(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOVL $1, %eax
isTrue:
  MOVL $0, %eax
  MOVL  %eax, -304(%ebp)
  MOVL -300(%ebp), %eax
  MOVL -304(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -312(%ebp)
  MOVL -312(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOVL $1, %eax
isTrue:
  MOVL $0, %eax
  MOVL  %eax, -288(%ebp)
  MOVL -284(%ebp), %eax
  MOVL -288(%ebp), %edx
  OR %edx, %eax
  MOVL  %eax, -316(%ebp)
  MOVL 8(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -324(%ebp)
  MOVL 12(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -332(%ebp)
  MOVL 16(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -336(%ebp)
  MOVL -332(%ebp), %eax
  MOVL -336(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -340(%ebp)
  MOVL -340(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOVL $1, %eax
isTrue:
  MOVL $0, %eax
  MOVL  %eax, -328(%ebp)
  MOVL -324(%ebp), %eax
  MOVL -328(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -344(%ebp)
  MOVL -344(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOVL $1, %eax
isTrue:
  MOVL $0, %eax
  MOVL  %eax, -320(%ebp)
  MOVL -316(%ebp), %eax
  MOVL -320(%ebp), %edx
  OR %edx, %eax
  MOVL  %eax, -348(%ebp)
  MOVL -348(%ebp), %eax
  CMP %eax, $1
  JE LIF2
  MOVL 4.0, %eax
  LEAVE
  RET

LIF2:
  MOVL 8(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -352(%ebp)
  MOVL 12(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -356(%ebp)
  MOVL -352(%ebp), %eax
  MOVL -356(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -360(%ebp)
  MOVL 16(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -368(%ebp)
  MOVL -368(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOVL $1, %eax
isTrue:
  MOVL $0, %eax
  MOVL  %eax, -364(%ebp)
  MOVL -360(%ebp), %eax
  MOVL -364(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -372(%ebp)
  MOVL 8(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -376(%ebp)
  MOVL 12(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -384(%ebp)
  MOVL 16(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -388(%ebp)
  MOVL -384(%ebp), %eax
  MOVL -388(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -392(%ebp)
  MOVL -392(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOVL $1, %eax
isTrue:
  MOVL $0, %eax
  MOVL  %eax, -380(%ebp)
  MOVL -376(%ebp), %eax
  MOVL -380(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -396(%ebp)
  MOVL -372(%ebp), %eax
  MOVL -396(%ebp), %edx
  OR %edx, %eax
  MOVL  %eax, -400(%ebp)
  MOVL 8(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -408(%ebp)
  MOVL 12(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -412(%ebp)
  MOVL -408(%ebp), %eax
  MOVL -412(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -416(%ebp)
  MOVL 16(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -420(%ebp)
  MOVL -416(%ebp), %eax
  MOVL -420(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -424(%ebp)
  MOVL -424(%ebp), %eax
  CMP %eax, $1
  JE SHORT isTrue
  MOVL $1, %eax
isTrue:
  MOVL $0, %eax
  MOVL  %eax, -404(%ebp)
  MOVL -400(%ebp), %eax
  MOVL -404(%ebp), %edx
  OR %edx, %eax
  MOVL  %eax, -428(%ebp)
  MOVL -428(%ebp), %eax
  CMP %eax, $1
  JE LIF3
  MOVL 8.5, %eax
  LEAVE
  RET

LIF3:
  MOVL 8(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -432(%ebp)
  MOVL 12(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -436(%ebp)
  MOVL -432(%ebp), %eax
  MOVL -436(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -440(%ebp)
  MOVL 16(%ebp), %eax
  CMP $6, %eax
  JE SHORT ok
  MOVL $0, %eax
ok:
  MOVL $1, %eax
  MOVL  %eax, -444(%ebp)
  MOVL -440(%ebp), %eax
  MOVL -444(%ebp), %edx
  AND %edx, %eax
  MOVL  %eax, -448(%ebp)
  MOVL -448(%ebp), %eax
  CMP %eax, $1
  JE LIF4
  MOVL 10.0, %eax
  LEAVE
  RET

LIF4:
  .GLOBL main
  TYPE main, @function
main:
  PUSHL %ebp
  MOVL %ebp, %esp
  SUBL $-448%ebp
  CALL printf
  LEAVE
  RET
