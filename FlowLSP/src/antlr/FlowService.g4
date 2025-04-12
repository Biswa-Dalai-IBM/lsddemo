grammar FlowService;

@header{
	package antlr;
}


flowService : 'service' ID '{' step* '}' ;

step
    : invokeStep
    | mapStep
    | loopStep 
    | sequenceStep
    | branchStep
    | repeatStep
    | tryStep
    | exitStep
    ;
    

stepProperty
    : 'comment' ':' STRING_LITERAL
    | 'scope' ':' ID
    | 'timeout' ':' INT
    | 'label' ':' STRING_LITERAL
    ;
    
qualifiedServiceName : ID ('.' ID)* ':' ID ;    
// MAP step

mapStep
	: 'MAP' ('{' (stepProperty|mappingSetEntry|mappingCopyEntry|transformStep|dropStep)*?'}')? ';'
	;
	
transformStep
    : 'TRANSFORM' qualifiedServiceName ('{' mappingBlock*? '}')? ';'
    ;
dropStep
    : 'drop' ID ('/' ID)*  ';'
    ;

// INVOKE Step
invokeStep
    : 'INVOKE' qualifiedServiceName ('{' stepProperty*? invokeProperty*? mappingBlock*? '}')? ';'
    ;

mappingBlock
    : 'input'  '{' (mappingCopyEntry|mappingSetEntry)*? '}'
    | 'output' '{' (mappingCopyEntry|mappingSetEntry)*? '}'
    ;

mappingCopyEntry
    : 'copy' ID ('/' ID)*  '->' ID ('/' ID)*  ';'
    ;
    
mappingSetEntry
    : 'set' ID ('/' ID)*  '=' value ';'
    ;
value
    : INT
    | STRING_LITERAL
    ;
invokeProperty
    : 'validateInput' ':' BOOL
    | 'validateOutput' ':' BOOL
    ;

//LOOP Step

loopStep
    : 'LOOP' ('{' stepProperty*? loopProperty*? step*? '}')? 
    ;
    
loopProperty
    : 'inputArray' ':' STRING_LITERAL
    | 'outputArray' ':' STRING_LITERAL
    ;

//SEQUENCE Step

sequenceStep
    : 'SEQUENCE' ('{' stepProperty*? sequenceProperty*? step*? '}')? 
    ;
    
sequenceProperty
    : 'exitOn' ':' STRING_LITERAL
    ;

//TRY Step

tryStep
    : 'TRY' '{'(stepProperty| tryProperty)*?  step*'}' catchStep* finallyStep?
    ;
    
tryProperty
    : 'exitOn' ':' STRING_LITERAL
    ;
    
//CATCH Step

catchStep
    : 'CATCH' ('{' stepProperty*? catchProperty*? step*? '}')? 
    ;
    
catchProperty
    : 'exitOn' ':' STRING_LITERAL
    | 'failures' ':' STRING_LITERAL
    | 'selection' ':' STRING_LITERAL 
    ;

//FINALLY Step

finallyStep
    : 'FINALLY' ('{' stepProperty*? finallyProperty*? step*? '}')? 
    ;
    
finallyProperty
    : 'exitOn' ':' STRING_LITERAL
    ;    
    
//BRANCH Step

branchStep
    : 'BRANCH' ('{' stepProperty*? branchProperty*? step*? '}')? 
    ;
    
branchProperty
    : 'switch' ':' STRING_LITERAL
    | 'evaluateLabels' ':' BOOL
    ;

//REPEAT Step

repeatStep
    : 'REPEAT' ('{' stepProperty*? repeatProperty*? step*? '}')? 
    ;
    
repeatProperty
    : 'count' ':' INT
    | 'repeatInterval' ':' INT
    | 'repeatOn' ':' STRING_LITERAL
    ;

// EXIT Step

exitStep
    : 'EXIT' ('{' exitProperty*? '}')? ';'
    ;
    
exitProperty
    : 'comment' ':' STRING_LITERAL
    | 'label' ':' STRING_LITERAL
    | 'signal' ':' STRING_LITERAL
    | 'failureName' ':' STRING_LITERAL
    | 'failureInstance' ':' STRING_LITERAL
    | 'exitForm' ':' STRING_LITERAL
    | 'failureMessage' ':' STRING_LITERAL
    ;
    
    


BOOL : 'true' | 'false' ;
ID    : [a-zA-Z_][a-zA-Z0-9_]* ;
INT   : [0-9]+ ;
STRING_LITERAL : '"' (~["\\] | '\\' .)* '"' ;
WS    : [ \t\r\n]+ -> skip ;

