grammar pedro;

goal
 : mainClass classDeclaration* EOF
 ;

mainClass
 : 'class' identifier '{' 'public' 'static' 'void' 'main' '(' 'String' '[' ']' identifier ')' '{' statement '}' '}'
 ;

classDeclaration
 : 'class' identifier ( 'extends' identifier )? '{' varDeclaration* methodDeclaration* '}'
 ;

varDeclaration
 : type identifier ';'
 ;

methodDeclaration
 : 'public' type identifier '(' (type identifier ( ',' type identifier)* )? ')' '{' (varDeclaration)* (statement)* 'return' expression ';' '}'
 ;

type
 : 'int' '[' ']'
 | 'boolean'
 | 'int'
 | identifier
 ;

statement
 : '{' (statement)* '}' #cochetes
 | 'if' '(' expression ')' statement 'else' statement #if
 | 'while' '(' expression ')' statement #while
 | 'System.out.println' '(' expression ')' ';' #print
 | identifier '=' expression ';' #atribuicao
 | identifier '[' expression ']' '=' expression ';' #atribuicaoArray
 ;

 expression
 : expression ( OPERATOR ) expression #expressaoBinaria
 | expression '[' expression ']' #arrayLookup
 | expression '.' 'length' #length
 | expression '.' identifier '(' ( expression ( ',' expression )* )? ')' #call
 | integerLiteral #literal
 | 'true' #true
 | 'false' #false
 | identifier #id
 | 'this' #this
 | 'new' 'int' '[' expression ']' #newArray
 | 'new' identifier '(' ')' #newObj
 | '(' expression ')' #addParenthesis
 | '!' expression #negation
 ;


identifier : IDENTIFIER;
integerLiteral: INTEGER_LITERAL;

COMMENT: '/*' .*? '*/' -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;
OPERATOR: '&&' | '<' | '+' | '-' | '*';
IDENTIFIER: [_a-zA-Z][_a-zA-Z0-9]*;
INTEGER_LITERAL: [1-9][0-9]* | '0';
WS: [ \t\f\r\n]+ -> skip;