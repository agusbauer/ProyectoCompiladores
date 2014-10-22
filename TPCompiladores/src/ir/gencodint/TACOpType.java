/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * 
 */
package ir.gencodint;

public enum TACOpType {
    STR,
    ADD,
    SUB,
    MUL,
    DIV,
    MOD,
    CMP,
    JMP,
    JG,
    JL,
    JGE,
    JLE,
    JE,
    JNE,
    JAND,
    JOR,
    JNOT,
    LCON,
    LMEM,
    LBL,
    MNAME, //LO AGREGUE PORQUE NECESITO DIFERENCIAR LOS LABELS DE LOS METODOS DE LOS DEMAS.
    OPP,
    AND,
    OR,
    EXCALL,
    CALL, 
    RET, 
    NOT;
}
