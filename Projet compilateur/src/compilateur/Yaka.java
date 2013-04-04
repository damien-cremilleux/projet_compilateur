/* Generated By:JavaCC: Do not edit this line. Yaka.java */
package compilateur;

public class Yaka implements YakaConstants {

        public static TabIdent tabIdent = new TabIdent();
        public static Declaration declaration = new Declaration();
        public static Expression expression = new Expression();
        public static Erreur erreur = new Erreur();
        public static YVM yVM= new YVMasm();
        public static ControleType controleT = new ControleType();
        public static Iteration iteration = new Iteration();
        public static Conditionnelle cond = new Conditionnelle();
        public static Fonction fonc = new Fonction();
        public static boolean dansFonct = false;

        static boolean appelFonct = false;
        public static int cptBoucles = 0;
        public static int cptCond = 0;


        public static void main(String args[]) {
                Yaka analyseur;
                java.io.InputStream input;
                String output;

                if (args.length==1) {
                  System.out.print(args[args.length-1] + ": ");
                  try {
                        input = new java.io.FileInputStream(args[args.length-1]+".yaka");
                        output = args[args.length-1];
                  } catch (java.io.FileNotFoundException e) {
                        System.out.println("Fichier introuvable.");
                        return;
                  }
                } else if (args.length==0) {
                  System.out.println("Lecture sur l'entree standard...");
                  input = System.in;
                  output = "sortie";
                } else {
                  System.out.println("Usage: java Gram [fichier]");
                  return;
                }
                try {
                  analyseur = new Yaka(input);
                  yVM.setFichierSortie(output);
                  analyseur.analyse();

                  System.out.println("analyse syntaxique reussie!");
                } catch (ParseException e) {
                  String msg = e.getMessage();
                  msg = msg.substring(0,msg.indexOf("\u005cn"));
                  System.out.println("Erreur de syntaxe : "+msg);
                } catch (java.io.FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
    }

/**************************************/
/********debut de la grammaire ********/
/**************************************/
  static final public void analyse() throws ParseException {
    jj_consume_token(PROGRAMME);
    jj_consume_token(ident);
     yVM.entete();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BOOLEEN:
      case ENTIER:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      declFonction();
    }
    jj_consume_token(PRINCIPAL);
     fonc.ouvreMain();
    bloc();
    jj_consume_token(FPRINCIPAL);
    jj_consume_token(FPROGRAMME);
                yVM.queue();
  }

  static final public void declFonction() throws ParseException {
    dansFonct = true;
    type();
    jj_consume_token(FONCTION);
    jj_consume_token(ident);
                fonc.majNom(YakaTokenManager.identLu);
                fonc.initFonc();
    paramForms();
      fonc.majParam();
    bloc();
    jj_consume_token(FFONCTION);
    fonc.finFonction();
    dansFonct = false;
  }

  static final public void paramForms() throws ParseException {
    jj_consume_token(40);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BOOLEEN:
    case ENTIER:
      paramForm();
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 41:
          ;
          break;
        default:
          jj_la1[1] = jj_gen;
          break label_2;
        }
        jj_consume_token(41);
        paramForm();
      }
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
    jj_consume_token(42);
  }

  static final public void paramForm() throws ParseException {
    type();
    jj_consume_token(ident);
     fonc.majNom(YakaTokenManager.identLu);
     fonc.ajouterParam();
  }

  static final public void bloc() throws ParseException {
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONST:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
      declConst();
    }
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VAR:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_4;
      }
      declVar();
    }
          if(!dansFonct)
                declaration.ouvrePrinc();
          else
                fonc.ouvreFonction();
    suiteInstr();
  }

  static final public void declConst() throws ParseException {
    jj_consume_token(CONST);
    defConst();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 41:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_5;
      }
      jj_consume_token(41);
      defConst();
    }
    jj_consume_token(43);
  }

  static final public void defConst() throws ParseException {
    jj_consume_token(ident);
          declaration.setNomIdent(YakaTokenManager.identLu);
    jj_consume_token(44);
    valConst();
  }

  static final public void valConst() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case entier:
      jj_consume_token(entier);
          declaration.affectationConst(YakaTokenManager.entierLu, Constante.T_ENTIER);
      break;
    case ident:
      jj_consume_token(ident);
          declaration.affectationConstCopie(YakaTokenManager.identLu);
      break;
    case VRAI:
      jj_consume_token(VRAI);
          declaration.affectationConst(Constante.V_VRAI, Constante.T_BOOLEEN);
      break;
    case FAUX:
      jj_consume_token(FAUX);
          declaration.affectationConst(Constante.V_FAUX, Constante.T_BOOLEEN);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void declVar() throws ParseException {
    jj_consume_token(VAR);
    type();
    jj_consume_token(ident);
          declaration.affectationVal(YakaTokenManager.identLu);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 41:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_6;
      }
      jj_consume_token(41);
      jj_consume_token(ident);
          declaration.affectationVal(YakaTokenManager.identLu);
    }
    jj_consume_token(43);
  }

  static final public void type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ENTIER:
      jj_consume_token(ENTIER);
          declaration.setTypeVar(Constante.T_ENTIER);
          fonc.majType(Constante.T_ENTIER);
      break;
    case BOOLEEN:
      jj_consume_token(BOOLEEN);
          declaration.setTypeVar(Constante.T_BOOLEEN);
          fonc.majType(Constante.T_BOOLEEN);
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
 * Syntaxe des instructions.
 */
  static final public void suiteInstr() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SI:
    case RETOURNE:
    case TANTQUE:
    case ECRIRE:
    case LIRE:
    case ALALIGNE:
    case ident:
      instruction();
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 43:
          ;
          break;
        default:
          jj_la1[9] = jj_gen;
          break label_7;
        }
        jj_consume_token(43);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SI:
        case RETOURNE:
        case TANTQUE:
        case ECRIRE:
        case LIRE:
        case ALALIGNE:
        case ident:
          instruction();
          break;
        default:
          jj_la1[10] = jj_gen;
          ;
        }
      }
      break;
    default:
      jj_la1[11] = jj_gen;
      ;
    }
  }

  static final public void instruction() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ident:
      affectation();
      break;
    case LIRE:
      lecture();
      break;
    case ECRIRE:
    case ALALIGNE:
      ecriture();
      break;
    case TANTQUE:
      iteration();
      break;
    case SI:
      conditionnelle();
      break;
    case RETOURNE:
      retourne();
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void affectation() throws ParseException {
    jj_consume_token(ident);
                  expression.setNomAffec(YakaTokenManager.identLu);
    jj_consume_token(44);
    expression();
                  expression.affectation();
  }

  static final public void lecture() throws ParseException {
    jj_consume_token(LIRE);
    jj_consume_token(40);
    jj_consume_token(ident);
    jj_consume_token(42);
         expression.lire(YakaTokenManager.identLu);
  }

  static final public void ecriture() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ECRIRE:
      jj_consume_token(ECRIRE);
      jj_consume_token(40);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VRAI:
      case FAUX:
      case NON:
      case entier:
      case ident:
      case 40:
      case 51:
        expression();
          expression.ecrireExpr();
        break;
      case chaine:
        jj_consume_token(chaine);
          expression.ecrireChaine(YakaTokenManager.chaineLue);
        break;
      default:
        jj_la1[13] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(42);
      break;
    case ALALIGNE:
      jj_consume_token(ALALIGNE);
           expression.aLaLigne();
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
 * Iteration
 */
  static final public void iteration() throws ParseException {
    jj_consume_token(TANTQUE);
          iteration.entreeIteration();
    expression();
    jj_consume_token(FAIRE);
          iteration.conditionIteration();
    suiteInstr();
    jj_consume_token(FAIT);
          iteration.sortieIteration();
  }

/*
 * Conditionnelle
 */
  static final public void conditionnelle() throws ParseException {
    jj_consume_token(SI);
               cond.entreeCond();
    expression();
    jj_consume_token(ALORS);
                 cond.conditionCond();
    suiteInstr();
          cond.sinonCond();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SINON:
      jj_consume_token(SINON);
      suiteInstr();
      break;
    default:
      jj_la1[15] = jj_gen;
      ;
    }
    jj_consume_token(FSI);
          cond.sortieCond();
  }

/*
 * Retourne
 */
  static final public void retourne() throws ParseException {
    jj_consume_token(RETOURNE);
    expression();
        fonc.retour();
  }

/*
 * Expression .
 */
  static final public void expression() throws ParseException {
    simpleExpr();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 44:
    case 45:
    case 46:
    case 47:
    case 48:
    case 49:
      opRel();
      simpleExpr();
          expression.operation();
      break;
    default:
      jj_la1[16] = jj_gen;
      ;
    }
  }

  static final public void simpleExpr() throws ParseException {
    terme();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OU:
      case 50:
      case 51:
        ;
        break;
      default:
        jj_la1[17] = jj_gen;
        break label_8;
      }
      opAdd();
      terme();
                  expression.operation();
    }
  }

  static final public void terme() throws ParseException {
    facteur();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ET:
      case 52:
      case 53:
        ;
        break;
      default:
        jj_la1[18] = jj_gen;
        break label_9;
      }
      opMul();
      facteur();
                  expression.operation();
    }
  }

  static final public void facteur() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VRAI:
    case FAUX:
    case entier:
    case ident:
    case 40:
      primaire();
      break;
    case NON:
    case 51:
      opNeg();
      primaire();
                  expression.operation();
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void primaire() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VRAI:
    case FAUX:
    case entier:
    case ident:
      valeur();
      break;
    case 40:
      jj_consume_token(40);
      expression();
      jj_consume_token(42);
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void valeur() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case entier:
      jj_consume_token(entier);
          expression.ajouteType(Constante.T_ENTIER);expression.ajouteVal(YakaTokenManager.entierLu);
      break;
    case ident:
      jj_consume_token(ident);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 40:
    if(fonc.existe(YakaTokenManager.identLu))
    {
        fonc.reserver();
                Yaka.controleT.ajoutePile();
    }
        argumentsFonction();
          appelFonct = true;
        break;
      default:
        jj_la1[21] = jj_gen;
        ;
      }
          if(appelFonct)
          {
            fonc.appelFonc();
          }else
          {
            expression.ajoute(YakaTokenManager.identLu);
          }
          appelFonct = false;
      break;
    case VRAI:
      jj_consume_token(VRAI);
          expression.ajouteType(Constante.T_BOOLEEN);expression.ajouteVal(true);
      break;
    case FAUX:
      jj_consume_token(FAUX);
          expression.ajouteType(Constante.T_BOOLEEN);expression.ajouteVal(false);
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void argumentsFonction() throws ParseException {
    jj_consume_token(40);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VRAI:
    case FAUX:
    case NON:
    case entier:
    case ident:
    case 40:
    case 51:
      expression();
        controleT.transfertTypeParam();
      label_10:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 41:
          ;
          break;
        default:
          jj_la1[23] = jj_gen;
          break label_10;
        }
        jj_consume_token(41);
        expression();
                        controleT.transfertTypeParam();
      }
      break;
    default:
      jj_la1[24] = jj_gen;
      ;
    }
    jj_consume_token(42);
  }

  static final public void opRel() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 44:
      jj_consume_token(44);
          expression.ajouteOp(Constante.OP_EQ);
      break;
    case 45:
      jj_consume_token(45);
          expression.ajouteOp(Constante.OP_DIF);
      break;
    case 46:
      jj_consume_token(46);
           expression.ajouteOp(Constante.OP_INF);
      break;
    case 47:
      jj_consume_token(47);
           expression.ajouteOp(Constante.OP_INFEQ);
      break;
    case 48:
      jj_consume_token(48);
          expression.ajouteOp(Constante.OP_SUP);
      break;
    case 49:
      jj_consume_token(49);
           expression.ajouteOp(Constante.OP_SUPEQ);
      break;
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opAdd() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 50:
      jj_consume_token(50);
      expression.ajouteOp(Constante.OP_PLUS);
      break;
    case 51:
      jj_consume_token(51);
           expression.ajouteOp(Constante.OP_MOINS);
      break;
    case OU:
      jj_consume_token(OU);
          expression.ajouteOp(Constante.OP_OU);
      break;
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opMul() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 52:
      jj_consume_token(52);
                 expression.ajouteOp(Constante.OP_FOIS);
      break;
    case 53:
      jj_consume_token(53);
                  expression.ajouteOp(Constante.OP_DIV);
      break;
    case ET:
      jj_consume_token(ET);
          expression.ajouteOp(Constante.OP_ET);
      break;
    default:
      jj_la1[27] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opNeg() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 51:
      jj_consume_token(51);
         expression.ajouteOp(Constante.OP_NEG);
      break;
    case NON:
      jj_consume_token(NON);
           expression.ajouteOp(Constante.OP_NON);
      break;
    default:
      jj_la1[28] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public YakaTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[29];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x8100,0x0,0x8100,0x80000,0x200,0x0,0x120000,0x0,0x8100,0x0,0x52000,0x52000,0x52000,0x1120000,0x0,0x800,0x0,0x400000,0x800000,0x1120000,0x120000,0x0,0x120000,0x0,0x1120000,0x0,0x400000,0x800000,0x1000000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x200,0x0,0x0,0x0,0x200,0x50,0x200,0x0,0x800,0x47,0x47,0x47,0x801d0,0x5,0x0,0x3f000,0xc0000,0x300000,0x80150,0x150,0x100,0x50,0x200,0x80150,0x3f000,0xc0000,0x300000,0x80000,};
   }

  /** Constructor with InputStream. */
  public Yaka(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Yaka(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new YakaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 29; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 29; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Yaka(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new YakaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 29; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 29; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Yaka(YakaTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 29; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(YakaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 29; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[54];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 29; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 54; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
