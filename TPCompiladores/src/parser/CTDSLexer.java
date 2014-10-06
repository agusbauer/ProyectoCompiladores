/* The following code was generated by JFlex 1.6.0 */

/* --------------------------Usercode Section------------------------ */
package parser;
import java_cup.runtime.*;

      

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.0
 * from the specification file <tt>CTDS.flex</tt>
 */
public class CTDSLexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;
  public static final int CHARLITERAL = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\2\1\71\1\72\1\1\22\0\1\3\1\32\1\12"+
    "\2\0\1\27\1\31\1\13\1\40\1\41\1\11\1\26\1\37\1\16"+
    "\1\7\1\10\1\6\1\20\1\17\1\24\1\21\1\15\1\25\1\22"+
    "\1\23\1\5\1\0\1\36\1\34\1\33\1\35\2\0\32\4\1\44"+
    "\1\14\1\45\1\0\1\4\1\0\1\52\1\46\1\56\1\65\1\51"+
    "\1\63\1\4\1\67\1\61\1\4\1\55\1\50\1\4\1\53\1\47"+
    "\2\4\1\54\1\57\1\60\1\62\1\64\1\66\1\70\2\4\1\42"+
    "\1\30\1\43\7\0\1\71\u1fa2\0\1\71\1\71\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\2\2\1\3\2\4\1\1\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\2\1\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\11\3\1\30\2\31\1\32\2\1\2\33"+
    "\1\1\2\34\1\2\2\0\1\35\1\36\1\37\1\40"+
    "\1\41\1\42\1\43\1\44\11\3\1\45\5\3\1\46"+
    "\1\47\1\50\1\51\1\52\1\47\1\53\1\54\1\55"+
    "\1\56\1\57\1\60\12\46\3\0\10\3\1\61\1\62"+
    "\4\3\1\47\1\0\1\63\1\64\1\65\1\66\1\0"+
    "\1\67\1\70\1\71\1\72\1\73\2\0\2\3\1\74"+
    "\4\3\1\75\2\3\1\76\1\3\1\0\1\3\1\77"+
    "\3\3\1\100\1\101\1\102\1\103\1\0\2\3\1\104"+
    "\1\3\1\0\1\105\2\3\1\0\1\3\1\106\1\0"+
    "\1\3\1\0\1\107\1\110";

  private static int [] zzUnpackAction() {
    int [] result = new int[169];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\73\0\166\0\261\0\354\0\261\0\u0127\0\u0162"+
    "\0\u019d\0\u01d8\0\u0213\0\261\0\261\0\261\0\u024e\0\u0289"+
    "\0\261\0\u02c4\0\u02ff\0\u033a\0\u0375\0\u03b0\0\u03eb\0\261"+
    "\0\261\0\261\0\261\0\261\0\261\0\261\0\261\0\u0426"+
    "\0\u0461\0\u049c\0\u04d7\0\u0512\0\u054d\0\u0588\0\u05c3\0\u05fe"+
    "\0\u0639\0\u0674\0\261\0\261\0\u06af\0\u06ea\0\u0725\0\261"+
    "\0\u0760\0\u01d8\0\u019d\0\u079b\0\u07d6\0\u0811\0\261\0\261"+
    "\0\261\0\261\0\261\0\261\0\261\0\261\0\u084c\0\u0887"+
    "\0\u08c2\0\u08fd\0\u0938\0\u0973\0\u09ae\0\u09e9\0\u0a24\0\u0127"+
    "\0\u0a5f\0\u0a9a\0\u0ad5\0\u0b10\0\u0b4b\0\261\0\u0b86\0\261"+
    "\0\261\0\261\0\u0bc1\0\261\0\261\0\261\0\261\0\261"+
    "\0\261\0\u0bfc\0\u0c37\0\u0c72\0\u0cad\0\u0ce8\0\u0d23\0\u0d5e"+
    "\0\u0d99\0\u0dd4\0\u0e0f\0\u0e4a\0\u0e85\0\u0ec0\0\u0efb\0\u0f36"+
    "\0\u0f71\0\u0fac\0\u0fe7\0\u1022\0\u105d\0\u1098\0\u0127\0\u0127"+
    "\0\u10d3\0\u110e\0\u1149\0\u1184\0\261\0\u0ce8\0\261\0\261"+
    "\0\261\0\261\0\u11bf\0\261\0\261\0\261\0\261\0\261"+
    "\0\u11fa\0\u1235\0\u1270\0\u12ab\0\u0127\0\u12e6\0\u1321\0\u135c"+
    "\0\u1397\0\u0127\0\u13d2\0\u140d\0\u0127\0\u1448\0\u1483\0\u14be"+
    "\0\u0127\0\u14f9\0\u1534\0\u156f\0\u0127\0\u0127\0\u0127\0\u0127"+
    "\0\u15aa\0\u15e5\0\u1620\0\u0127\0\u165b\0\u1696\0\u0127\0\u16d1"+
    "\0\u170c\0\u1747\0\u1782\0\u0127\0\u17bd\0\u17f8\0\u1833\0\u0127"+
    "\0\261";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[169];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\1\5\2\6\1\7\1\10\1\11\1\12\1\13"+
    "\1\14\1\15\1\16\1\4\1\10\1\17\7\10\1\20"+
    "\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40"+
    "\2\7\1\41\2\7\1\42\1\7\1\43\1\7\1\44"+
    "\1\45\1\7\1\46\1\47\1\7\1\50\2\7\1\4"+
    "\1\6\1\51\1\52\1\53\7\51\1\54\1\51\1\55"+
    "\56\51\1\56\1\57\1\60\10\56\1\4\1\61\56\56"+
    "\75\0\1\6\74\0\3\7\6\0\1\7\1\0\7\7"+
    "\20\0\23\7\7\0\2\10\1\62\5\0\1\10\1\0"+
    "\7\10\52\0\2\63\1\62\5\0\1\63\1\0\7\63"+
    "\52\0\2\62\6\0\1\62\1\0\7\62\55\0\1\64"+
    "\1\65\100\0\1\66\13\0\1\67\72\0\1\70\67\0"+
    "\1\71\73\0\1\72\74\0\1\73\72\0\1\74\72\0"+
    "\1\75\72\0\1\76\43\0\3\7\6\0\1\7\1\0"+
    "\7\7\20\0\1\7\1\77\4\7\1\100\14\7\6\0"+
    "\3\7\6\0\1\7\1\0\7\7\20\0\2\7\1\101"+
    "\17\7\1\102\6\0\3\7\6\0\1\7\1\0\7\7"+
    "\20\0\3\7\1\103\17\7\6\0\3\7\6\0\1\7"+
    "\1\0\7\7\20\0\1\7\1\104\1\105\20\7\6\0"+
    "\3\7\6\0\1\7\1\0\7\7\20\0\6\7\1\106"+
    "\14\7\6\0\3\7\6\0\1\7\1\0\7\7\20\0"+
    "\5\7\1\107\7\7\1\110\5\7\6\0\3\7\6\0"+
    "\1\7\1\0\7\7\20\0\1\7\1\111\1\112\1\7"+
    "\1\113\16\7\6\0\3\7\6\0\1\7\1\0\7\7"+
    "\20\0\1\7\1\114\21\7\6\0\3\7\6\0\1\7"+
    "\1\0\7\7\20\0\21\7\1\115\1\7\2\0\1\51"+
    "\2\0\7\51\1\0\1\51\1\0\56\51\2\0\1\53"+
    "\70\0\1\116\2\0\3\116\1\117\3\116\1\120\1\121"+
    "\1\122\1\123\1\116\2\117\2\123\1\116\1\117\1\123"+
    "\20\116\1\124\4\116\1\125\1\126\3\116\1\127\2\116"+
    "\1\130\5\116\15\0\1\131\61\0\1\60\70\0\1\116"+
    "\2\0\3\116\1\132\3\116\1\133\1\134\1\135\1\136"+
    "\1\116\2\132\2\136\1\116\1\132\1\136\20\116\1\137"+
    "\4\116\1\140\1\141\3\116\1\142\2\116\1\143\5\116"+
    "\2\0\1\64\1\5\1\6\70\64\11\144\1\145\61\144"+
    "\20\0\1\146\56\0\3\7\6\0\1\7\1\0\7\7"+
    "\20\0\1\7\1\147\21\7\6\0\3\7\6\0\1\7"+
    "\1\0\7\7\20\0\3\7\1\150\17\7\6\0\3\7"+
    "\6\0\1\7\1\0\7\7\20\0\11\7\1\151\11\7"+
    "\6\0\3\7\6\0\1\7\1\0\7\7\20\0\12\7"+
    "\1\152\10\7\6\0\3\7\6\0\1\7\1\0\7\7"+
    "\20\0\12\7\1\153\10\7\6\0\3\7\6\0\1\7"+
    "\1\0\7\7\20\0\5\7\1\154\15\7\6\0\3\7"+
    "\6\0\1\7\1\0\7\7\20\0\4\7\1\155\16\7"+
    "\6\0\3\7\6\0\1\7\1\0\7\7\20\0\14\7"+
    "\1\156\6\7\6\0\3\7\6\0\1\7\1\0\7\7"+
    "\20\0\12\7\1\157\10\7\6\0\3\7\6\0\1\7"+
    "\1\0\7\7\20\0\6\7\1\160\14\7\6\0\3\7"+
    "\6\0\1\7\1\0\7\7\20\0\1\7\1\161\21\7"+
    "\6\0\3\7\6\0\1\7\1\0\7\7\20\0\2\7"+
    "\1\162\20\7\6\0\3\7\6\0\1\7\1\0\7\7"+
    "\20\0\13\7\1\163\7\7\6\0\3\7\6\0\1\7"+
    "\1\0\7\7\20\0\13\7\1\164\7\7\10\0\1\123"+
    "\6\0\1\123\1\0\4\123\1\0\2\123\53\0\1\165"+
    "\6\0\1\165\1\0\4\165\1\0\2\165\53\0\1\166"+
    "\4\0\1\167\1\0\1\166\1\0\4\166\1\0\2\166"+
    "\60\0\1\170\72\0\1\171\72\0\1\172\65\0\1\173"+
    "\4\0\1\167\1\0\1\173\1\0\4\173\1\0\2\173"+
    "\60\0\1\174\72\0\1\175\72\0\1\176\72\0\1\177"+
    "\72\0\1\200\57\0\11\144\1\201\61\144\10\0\1\6"+
    "\1\145\102\0\1\202\55\0\3\7\6\0\1\7\1\0"+
    "\7\7\20\0\2\7\1\203\20\7\6\0\3\7\6\0"+
    "\1\7\1\0\7\7\20\0\4\7\1\204\16\7\6\0"+
    "\3\7\6\0\1\7\1\0\7\7\20\0\3\7\1\205"+
    "\17\7\6\0\3\7\6\0\1\7\1\0\7\7\20\0"+
    "\3\7\1\206\17\7\6\0\3\7\6\0\1\7\1\0"+
    "\7\7\20\0\14\7\1\207\6\7\6\0\3\7\6\0"+
    "\1\7\1\0\7\7\20\0\12\7\1\210\10\7\6\0"+
    "\3\7\6\0\1\7\1\0\7\7\20\0\11\7\1\211"+
    "\11\7\6\0\3\7\6\0\1\7\1\0\7\7\20\0"+
    "\3\7\1\212\17\7\6\0\3\7\6\0\1\7\1\0"+
    "\7\7\20\0\4\7\1\213\16\7\6\0\3\7\6\0"+
    "\1\7\1\0\7\7\20\0\11\7\1\214\11\7\6\0"+
    "\3\7\6\0\1\7\1\0\7\7\20\0\17\7\1\215"+
    "\3\7\6\0\3\7\6\0\1\7\1\0\7\7\20\0"+
    "\2\7\1\216\20\7\15\0\1\167\57\0\10\144\1\6"+
    "\1\201\61\144\22\0\1\217\54\0\3\7\6\0\1\7"+
    "\1\0\7\7\20\0\3\7\1\220\17\7\6\0\3\7"+
    "\6\0\1\7\1\0\7\7\20\0\7\7\1\221\13\7"+
    "\6\0\3\7\6\0\1\7\1\0\7\7\20\0\6\7"+
    "\1\222\14\7\6\0\3\7\6\0\1\7\1\0\7\7"+
    "\20\0\6\7\1\223\14\7\6\0\3\7\6\0\1\7"+
    "\1\0\7\7\20\0\13\7\1\224\7\7\6\0\3\7"+
    "\6\0\1\7\1\0\7\7\20\0\11\7\1\225\11\7"+
    "\6\0\3\7\6\0\1\7\1\0\7\7\20\0\12\7"+
    "\1\226\10\7\6\0\3\7\6\0\1\7\1\0\7\7"+
    "\20\0\3\7\1\227\17\7\6\0\3\7\6\0\1\7"+
    "\1\0\7\7\20\0\3\7\1\230\17\7\23\0\1\231"+
    "\55\0\3\7\6\0\1\7\1\0\7\7\20\0\4\7"+
    "\1\232\16\7\6\0\3\7\6\0\1\7\1\0\7\7"+
    "\20\0\5\7\1\233\15\7\6\0\3\7\6\0\1\7"+
    "\1\0\7\7\20\0\5\7\1\234\15\7\6\0\3\7"+
    "\6\0\1\7\1\0\7\7\20\0\5\7\1\235\15\7"+
    "\25\0\1\236\53\0\3\7\6\0\1\7\1\0\7\7"+
    "\20\0\5\7\1\237\15\7\6\0\3\7\6\0\1\7"+
    "\1\0\7\7\20\0\13\7\1\240\7\7\6\0\3\7"+
    "\6\0\1\7\1\0\7\7\20\0\14\7\1\241\6\7"+
    "\26\0\1\242\52\0\3\7\6\0\1\7\1\0\7\7"+
    "\20\0\5\7\1\243\15\7\6\0\3\7\6\0\1\7"+
    "\1\0\7\7\20\0\3\7\1\244\17\7\27\0\1\245"+
    "\51\0\3\7\6\0\1\7\1\0\7\7\20\0\16\7"+
    "\1\246\4\7\23\0\1\247\55\0\3\7\6\0\1\7"+
    "\1\0\7\7\20\0\7\7\1\250\13\7\25\0\1\251"+
    "\47\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6254];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\11\1\1\1\11\5\1\3\11\2\1\1\11"+
    "\6\1\10\11\13\1\2\11\3\1\1\11\4\1\2\0"+
    "\10\11\17\1\1\11\1\1\3\11\1\1\6\11\12\1"+
    "\3\0\16\1\1\11\1\0\4\11\1\0\5\11\2\0"+
    "\14\1\1\0\11\1\1\0\4\1\1\0\3\1\1\0"+
    "\2\1\1\0\1\1\1\0\1\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[169];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
	StringBuilder string = new StringBuilder();  
    /* To create a new java_cup.runtime.Symbol with information about
       the current token, the token will have no value in this
       case. */
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    /* Also creates a new java_cup.runtime.Symbol with information
       about the current token, but this object has a value. */
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public CTDSLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 188) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;           
    int totalRead = 0;
    while (totalRead < requested) {
      int numRead = zzReader.read(zzBuffer, zzEndRead + totalRead, requested - totalRead);
      if (numRead == -1) {
        break;
      }
      totalRead += numRead;
    }

    if (totalRead > 0) {
      zzEndRead += totalRead;
      if (totalRead == requested) { /* possibly more input available */
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      return false;
    }

    // totalRead = 0: End of stream
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 1: 
          { throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+yyline+1+", column "+yycolumn+1);
          }
        case 73: break;
        case 2: 
          { /*skip*/
          }
        case 74: break;
        case 3: 
          { return symbol(sym.IDENTIFIER, yytext());
          }
        case 75: break;
        case 4: 
          { return symbol(sym.INT_LITERAL, new Integer(yytext()));
          }
        case 76: break;
        case 5: 
          { return symbol(sym.DIVIDE);
          }
        case 77: break;
        case 6: 
          { return symbol(sym.TIMES);
          }
        case 78: break;
        case 7: 
          { yybegin(STRING); string.setLength(0);
          }
        case 79: break;
        case 8: 
          { yybegin(CHARLITERAL);
          }
        case 80: break;
        case 9: 
          { return symbol(sym.MINUS);
          }
        case 81: break;
        case 10: 
          { return symbol(sym.PLUS);
          }
        case 82: break;
        case 11: 
          { return symbol(sym.MOD);
          }
        case 83: break;
        case 12: 
          { return symbol(sym.NOT);
          }
        case 84: break;
        case 13: 
          { return symbol(sym.EQ);
          }
        case 85: break;
        case 14: 
          { return symbol(sym.LT);
          }
        case 86: break;
        case 15: 
          { return symbol(sym.GT);
          }
        case 87: break;
        case 16: 
          { return symbol(sym.SEMI);
          }
        case 88: break;
        case 17: 
          { return symbol(sym.COMMA);
          }
        case 89: break;
        case 18: 
          { return symbol(sym.LPAREN);
          }
        case 90: break;
        case 19: 
          { return symbol(sym.RPAREN);
          }
        case 91: break;
        case 20: 
          { return symbol(sym.LKEY);
          }
        case 92: break;
        case 21: 
          { return symbol(sym.RKEY);
          }
        case 93: break;
        case 22: 
          { return symbol(sym.LBRACKET);
          }
        case 94: break;
        case 23: 
          { return symbol(sym.RBRACKET);
          }
        case 95: break;
        case 24: 
          { string.append( yytext() );
          }
        case 96: break;
        case 25: 
          { throw new RuntimeException("Unterminated string at end of line");
          }
        case 97: break;
        case 26: 
          { yybegin(YYINITIAL); return symbol(sym.STRING_LITERAL, new String(string));
          }
        case 98: break;
        case 27: 
          { throw new RuntimeException("Unterminated character literal at end of line");
          }
        case 99: break;
        case 28: 
          { return symbol(sym.FLOAT_LITERAL, new Float(yytext().substring(0,yylength()-1)));
          }
        case 100: break;
        case 29: 
          { return symbol(sym.MINUSEQ);
          }
        case 101: break;
        case 30: 
          { return symbol(sym.PLUSEQ);
          }
        case 102: break;
        case 31: 
          { return symbol(sym.OR);
          }
        case 103: break;
        case 32: 
          { return symbol(sym.AND);
          }
        case 104: break;
        case 33: 
          { return symbol(sym.NOTEQ);
          }
        case 105: break;
        case 34: 
          { return symbol(sym.EQEQ);
          }
        case 106: break;
        case 35: 
          { return symbol(sym.LTEQ);
          }
        case 107: break;
        case 36: 
          { return symbol(sym.GTEQ);
          }
        case 108: break;
        case 37: 
          { return symbol(sym.IF);
          }
        case 109: break;
        case 38: 
          { throw new RuntimeException("Illegal escape sequence \""+yytext()+"\"");
          }
        case 110: break;
        case 39: 
          { char val = (char) Integer.parseInt(yytext().substring(1),8);
                        				   string.append( val );
          }
        case 111: break;
        case 40: 
          { string.append( '\"' );
          }
        case 112: break;
        case 41: 
          { string.append( '\'' );
          }
        case 113: break;
        case 42: 
          { string.append( '\\' );
          }
        case 114: break;
        case 43: 
          { string.append( '\b' );
          }
        case 115: break;
        case 44: 
          { string.append( '\n' );
          }
        case 116: break;
        case 45: 
          { string.append( '\r' );
          }
        case 117: break;
        case 46: 
          { string.append( '\t' );
          }
        case 118: break;
        case 47: 
          { string.append( '\f' );
          }
        case 119: break;
        case 48: 
          { yybegin(YYINITIAL); return symbol(sym.CHAR_LITERAL, yytext().charAt(0));
          }
        case 120: break;
        case 49: 
          { return symbol(sym.INT);
          }
        case 121: break;
        case 50: 
          { return symbol(sym.FOR);
          }
        case 122: break;
        case 51: 
          { yybegin(YYINITIAL); 
			                              int val = Integer.parseInt(yytext().substring(1,yylength()-1),8);
			                            return symbol(sym.CHAR_LITERAL, (char)val);
          }
        case 123: break;
        case 52: 
          { yybegin(YYINITIAL); return symbol(sym.CHAR_LITERAL, '\"');
          }
        case 124: break;
        case 53: 
          { yybegin(YYINITIAL); return symbol(sym.CHAR_LITERAL, '\'');
          }
        case 125: break;
        case 54: 
          { yybegin(YYINITIAL); return symbol(sym.CHAR_LITERAL, '\\');
          }
        case 126: break;
        case 55: 
          { yybegin(YYINITIAL); return symbol(sym.CHAR_LITERAL, '\b');
          }
        case 127: break;
        case 56: 
          { yybegin(YYINITIAL); return symbol(sym.CHAR_LITERAL, '\n');
          }
        case 128: break;
        case 57: 
          { yybegin(YYINITIAL); return symbol(sym.CHAR_LITERAL, '\r');
          }
        case 129: break;
        case 58: 
          { yybegin(YYINITIAL); return symbol(sym.CHAR_LITERAL, '\t');
          }
        case 130: break;
        case 59: 
          { yybegin(YYINITIAL); return symbol(sym.CHAR_LITERAL, '\f');
          }
        case 131: break;
        case 60: 
          { return symbol(sym.ELSE);
          }
        case 132: break;
        case 61: 
          { return symbol(sym.TRUE, true);
          }
        case 133: break;
        case 62: 
          { return symbol(sym.VOID);
          }
        case 134: break;
        case 63: 
          { return symbol(sym.BREAK);
          }
        case 135: break;
        case 64: 
          { return symbol(sym.CLASS);
          }
        case 136: break;
        case 65: 
          { return symbol(sym.FLOAT);
          }
        case 137: break;
        case 66: 
          { return symbol(sym.FALSE, false);
          }
        case 138: break;
        case 67: 
          { return symbol(sym.WHILE);
          }
        case 139: break;
        case 68: 
          { return symbol(sym.RETURN);
          }
        case 140: break;
        case 69: 
          { return symbol(sym.BOOLEAN);
          }
        case 141: break;
        case 70: 
          { return symbol(sym.CONTINUE);
          }
        case 142: break;
        case 71: 
          { return symbol(sym.EXTERNINVK);
          }
        case 143: break;
        case 72: 
          { return symbol(sym.INT_LITERAL, new Integer(Integer.MIN_VALUE));
          }
        case 144: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {
                return symbol(sym.EOF);
              }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
