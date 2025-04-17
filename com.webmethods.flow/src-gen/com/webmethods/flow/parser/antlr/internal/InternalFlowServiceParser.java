package com.webmethods.flow.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.webmethods.flow.services.FlowServiceGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFlowServiceParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_BOOL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'service'", "'{'", "'}'", "'comment'", "':'", "'scope'", "'timeout'", "'label'", "'.'", "'MAP'", "';'", "'TRANSFORM'", "'drop'", "'/'", "'INVOKE'", "'input'", "'output'", "'copy'", "'->'", "'set'", "'='", "'validateInput'", "'validateOutput'", "'LOOP'", "'inputArray'", "'outputArray'", "'SEQUENCE'", "'exitOn'", "'TRY'", "'CATCH'", "'failures'", "'selection'", "'FINALLY'", "'BRANCH'", "'switch'", "'evaluateLabels'", "'REPEAT'", "'count'", "'repeatInterval'", "'repeatOn'", "'EXIT'", "'signal'", "'failureName'", "'failureInstance'", "'exitForm'", "'failureMessage'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_BOOL=7;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalFlowServiceParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFlowServiceParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFlowServiceParser.tokenNames; }
    public String getGrammarFileName() { return "InternalFlowService.g"; }



     	private FlowServiceGrammarAccess grammarAccess;

        public InternalFlowServiceParser(TokenStream input, FlowServiceGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected FlowServiceGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalFlowService.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalFlowService.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalFlowService.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalFlowService.g:71:1: ruleModel returns [EObject current=null] : ( (lv_services_0_0= ruleFlowService ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_services_0_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:77:2: ( ( (lv_services_0_0= ruleFlowService ) )* )
            // InternalFlowService.g:78:2: ( (lv_services_0_0= ruleFlowService ) )*
            {
            // InternalFlowService.g:78:2: ( (lv_services_0_0= ruleFlowService ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalFlowService.g:79:3: (lv_services_0_0= ruleFlowService )
            	    {
            	    // InternalFlowService.g:79:3: (lv_services_0_0= ruleFlowService )
            	    // InternalFlowService.g:80:4: lv_services_0_0= ruleFlowService
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getServicesFlowServiceParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_services_0_0=ruleFlowService();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"services",
            	    					lv_services_0_0,
            	    					"com.webmethods.flow.FlowService.FlowService");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleFlowService"
    // InternalFlowService.g:100:1: entryRuleFlowService returns [EObject current=null] : iv_ruleFlowService= ruleFlowService EOF ;
    public final EObject entryRuleFlowService() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowService = null;


        try {
            // InternalFlowService.g:100:52: (iv_ruleFlowService= ruleFlowService EOF )
            // InternalFlowService.g:101:2: iv_ruleFlowService= ruleFlowService EOF
            {
             newCompositeNode(grammarAccess.getFlowServiceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFlowService=ruleFlowService();

            state._fsp--;

             current =iv_ruleFlowService; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlowService"


    // $ANTLR start "ruleFlowService"
    // InternalFlowService.g:107:1: ruleFlowService returns [EObject current=null] : (otherlv_0= 'service' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_steps_3_0= ruleStep ) )* otherlv_4= '}' ) ;
    public final EObject ruleFlowService() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_steps_3_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:113:2: ( (otherlv_0= 'service' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_steps_3_0= ruleStep ) )* otherlv_4= '}' ) )
            // InternalFlowService.g:114:2: (otherlv_0= 'service' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_steps_3_0= ruleStep ) )* otherlv_4= '}' )
            {
            // InternalFlowService.g:114:2: (otherlv_0= 'service' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_steps_3_0= ruleStep ) )* otherlv_4= '}' )
            // InternalFlowService.g:115:3: otherlv_0= 'service' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_steps_3_0= ruleStep ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getFlowServiceAccess().getServiceKeyword_0());
            		
            // InternalFlowService.g:119:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFlowService.g:120:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFlowService.g:120:4: (lv_name_1_0= RULE_ID )
            // InternalFlowService.g:121:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFlowServiceAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFlowServiceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getFlowServiceAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalFlowService.g:141:3: ( (lv_steps_3_0= ruleStep ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==21||LA2_0==26||LA2_0==35||LA2_0==38||LA2_0==40||LA2_0==45||LA2_0==48||LA2_0==52) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalFlowService.g:142:4: (lv_steps_3_0= ruleStep )
            	    {
            	    // InternalFlowService.g:142:4: (lv_steps_3_0= ruleStep )
            	    // InternalFlowService.g:143:5: lv_steps_3_0= ruleStep
            	    {

            	    					newCompositeNode(grammarAccess.getFlowServiceAccess().getStepsStepParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_steps_3_0=ruleStep();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFlowServiceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"steps",
            	    						lv_steps_3_0,
            	    						"com.webmethods.flow.FlowService.Step");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getFlowServiceAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFlowService"


    // $ANTLR start "entryRuleStep"
    // InternalFlowService.g:168:1: entryRuleStep returns [EObject current=null] : iv_ruleStep= ruleStep EOF ;
    public final EObject entryRuleStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStep = null;


        try {
            // InternalFlowService.g:168:45: (iv_ruleStep= ruleStep EOF )
            // InternalFlowService.g:169:2: iv_ruleStep= ruleStep EOF
            {
             newCompositeNode(grammarAccess.getStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStep=ruleStep();

            state._fsp--;

             current =iv_ruleStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStep"


    // $ANTLR start "ruleStep"
    // InternalFlowService.g:175:1: ruleStep returns [EObject current=null] : (this_InvokeStep_0= ruleInvokeStep | this_MapStep_1= ruleMapStep | this_LoopStep_2= ruleLoopStep | this_SequenceStep_3= ruleSequenceStep | this_BranchStep_4= ruleBranchStep | this_RepeatStep_5= ruleRepeatStep | this_TryStep_6= ruleTryStep | this_ExitStep_7= ruleExitStep ) ;
    public final EObject ruleStep() throws RecognitionException {
        EObject current = null;

        EObject this_InvokeStep_0 = null;

        EObject this_MapStep_1 = null;

        EObject this_LoopStep_2 = null;

        EObject this_SequenceStep_3 = null;

        EObject this_BranchStep_4 = null;

        EObject this_RepeatStep_5 = null;

        EObject this_TryStep_6 = null;

        EObject this_ExitStep_7 = null;



        	enterRule();

        try {
            // InternalFlowService.g:181:2: ( (this_InvokeStep_0= ruleInvokeStep | this_MapStep_1= ruleMapStep | this_LoopStep_2= ruleLoopStep | this_SequenceStep_3= ruleSequenceStep | this_BranchStep_4= ruleBranchStep | this_RepeatStep_5= ruleRepeatStep | this_TryStep_6= ruleTryStep | this_ExitStep_7= ruleExitStep ) )
            // InternalFlowService.g:182:2: (this_InvokeStep_0= ruleInvokeStep | this_MapStep_1= ruleMapStep | this_LoopStep_2= ruleLoopStep | this_SequenceStep_3= ruleSequenceStep | this_BranchStep_4= ruleBranchStep | this_RepeatStep_5= ruleRepeatStep | this_TryStep_6= ruleTryStep | this_ExitStep_7= ruleExitStep )
            {
            // InternalFlowService.g:182:2: (this_InvokeStep_0= ruleInvokeStep | this_MapStep_1= ruleMapStep | this_LoopStep_2= ruleLoopStep | this_SequenceStep_3= ruleSequenceStep | this_BranchStep_4= ruleBranchStep | this_RepeatStep_5= ruleRepeatStep | this_TryStep_6= ruleTryStep | this_ExitStep_7= ruleExitStep )
            int alt3=8;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt3=1;
                }
                break;
            case 21:
                {
                alt3=2;
                }
                break;
            case 35:
                {
                alt3=3;
                }
                break;
            case 38:
                {
                alt3=4;
                }
                break;
            case 45:
                {
                alt3=5;
                }
                break;
            case 48:
                {
                alt3=6;
                }
                break;
            case 40:
                {
                alt3=7;
                }
                break;
            case 52:
                {
                alt3=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalFlowService.g:183:3: this_InvokeStep_0= ruleInvokeStep
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getInvokeStepParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_InvokeStep_0=ruleInvokeStep();

                    state._fsp--;


                    			current = this_InvokeStep_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFlowService.g:192:3: this_MapStep_1= ruleMapStep
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getMapStepParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_MapStep_1=ruleMapStep();

                    state._fsp--;


                    			current = this_MapStep_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFlowService.g:201:3: this_LoopStep_2= ruleLoopStep
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getLoopStepParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_LoopStep_2=ruleLoopStep();

                    state._fsp--;


                    			current = this_LoopStep_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalFlowService.g:210:3: this_SequenceStep_3= ruleSequenceStep
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getSequenceStepParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_SequenceStep_3=ruleSequenceStep();

                    state._fsp--;


                    			current = this_SequenceStep_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalFlowService.g:219:3: this_BranchStep_4= ruleBranchStep
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getBranchStepParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_BranchStep_4=ruleBranchStep();

                    state._fsp--;


                    			current = this_BranchStep_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalFlowService.g:228:3: this_RepeatStep_5= ruleRepeatStep
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getRepeatStepParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_RepeatStep_5=ruleRepeatStep();

                    state._fsp--;


                    			current = this_RepeatStep_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalFlowService.g:237:3: this_TryStep_6= ruleTryStep
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getTryStepParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_TryStep_6=ruleTryStep();

                    state._fsp--;


                    			current = this_TryStep_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalFlowService.g:246:3: this_ExitStep_7= ruleExitStep
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getExitStepParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExitStep_7=ruleExitStep();

                    state._fsp--;


                    			current = this_ExitStep_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStep"


    // $ANTLR start "entryRuleStepProperty"
    // InternalFlowService.g:258:1: entryRuleStepProperty returns [EObject current=null] : iv_ruleStepProperty= ruleStepProperty EOF ;
    public final EObject entryRuleStepProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStepProperty = null;


        try {
            // InternalFlowService.g:258:53: (iv_ruleStepProperty= ruleStepProperty EOF )
            // InternalFlowService.g:259:2: iv_ruleStepProperty= ruleStepProperty EOF
            {
             newCompositeNode(grammarAccess.getStepPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStepProperty=ruleStepProperty();

            state._fsp--;

             current =iv_ruleStepProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStepProperty"


    // $ANTLR start "ruleStepProperty"
    // InternalFlowService.g:265:1: ruleStepProperty returns [EObject current=null] : (this_CommentProperty_0= ruleCommentProperty | this_ScopeProperty_1= ruleScopeProperty | this_TimeoutProperty_2= ruleTimeoutProperty | this_LabelProperty_3= ruleLabelProperty ) ;
    public final EObject ruleStepProperty() throws RecognitionException {
        EObject current = null;

        EObject this_CommentProperty_0 = null;

        EObject this_ScopeProperty_1 = null;

        EObject this_TimeoutProperty_2 = null;

        EObject this_LabelProperty_3 = null;



        	enterRule();

        try {
            // InternalFlowService.g:271:2: ( (this_CommentProperty_0= ruleCommentProperty | this_ScopeProperty_1= ruleScopeProperty | this_TimeoutProperty_2= ruleTimeoutProperty | this_LabelProperty_3= ruleLabelProperty ) )
            // InternalFlowService.g:272:2: (this_CommentProperty_0= ruleCommentProperty | this_ScopeProperty_1= ruleScopeProperty | this_TimeoutProperty_2= ruleTimeoutProperty | this_LabelProperty_3= ruleLabelProperty )
            {
            // InternalFlowService.g:272:2: (this_CommentProperty_0= ruleCommentProperty | this_ScopeProperty_1= ruleScopeProperty | this_TimeoutProperty_2= ruleTimeoutProperty | this_LabelProperty_3= ruleLabelProperty )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt4=1;
                }
                break;
            case 17:
                {
                alt4=2;
                }
                break;
            case 18:
                {
                alt4=3;
                }
                break;
            case 19:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalFlowService.g:273:3: this_CommentProperty_0= ruleCommentProperty
                    {

                    			newCompositeNode(grammarAccess.getStepPropertyAccess().getCommentPropertyParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_CommentProperty_0=ruleCommentProperty();

                    state._fsp--;


                    			current = this_CommentProperty_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFlowService.g:282:3: this_ScopeProperty_1= ruleScopeProperty
                    {

                    			newCompositeNode(grammarAccess.getStepPropertyAccess().getScopePropertyParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ScopeProperty_1=ruleScopeProperty();

                    state._fsp--;


                    			current = this_ScopeProperty_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFlowService.g:291:3: this_TimeoutProperty_2= ruleTimeoutProperty
                    {

                    			newCompositeNode(grammarAccess.getStepPropertyAccess().getTimeoutPropertyParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_TimeoutProperty_2=ruleTimeoutProperty();

                    state._fsp--;


                    			current = this_TimeoutProperty_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalFlowService.g:300:3: this_LabelProperty_3= ruleLabelProperty
                    {

                    			newCompositeNode(grammarAccess.getStepPropertyAccess().getLabelPropertyParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_LabelProperty_3=ruleLabelProperty();

                    state._fsp--;


                    			current = this_LabelProperty_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStepProperty"


    // $ANTLR start "entryRuleCommentProperty"
    // InternalFlowService.g:312:1: entryRuleCommentProperty returns [EObject current=null] : iv_ruleCommentProperty= ruleCommentProperty EOF ;
    public final EObject entryRuleCommentProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommentProperty = null;


        try {
            // InternalFlowService.g:312:56: (iv_ruleCommentProperty= ruleCommentProperty EOF )
            // InternalFlowService.g:313:2: iv_ruleCommentProperty= ruleCommentProperty EOF
            {
             newCompositeNode(grammarAccess.getCommentPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCommentProperty=ruleCommentProperty();

            state._fsp--;

             current =iv_ruleCommentProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommentProperty"


    // $ANTLR start "ruleCommentProperty"
    // InternalFlowService.g:319:1: ruleCommentProperty returns [EObject current=null] : (otherlv_0= 'comment' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleCommentProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalFlowService.g:325:2: ( (otherlv_0= 'comment' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // InternalFlowService.g:326:2: (otherlv_0= 'comment' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // InternalFlowService.g:326:2: (otherlv_0= 'comment' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            // InternalFlowService.g:327:3: otherlv_0= 'comment' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getCommentPropertyAccess().getCommentKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getCommentPropertyAccess().getColonKeyword_1());
            		
            // InternalFlowService.g:335:3: ( (lv_value_2_0= RULE_STRING ) )
            // InternalFlowService.g:336:4: (lv_value_2_0= RULE_STRING )
            {
            // InternalFlowService.g:336:4: (lv_value_2_0= RULE_STRING )
            // InternalFlowService.g:337:5: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_2_0, grammarAccess.getCommentPropertyAccess().getValueSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCommentPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommentProperty"


    // $ANTLR start "entryRuleScopeProperty"
    // InternalFlowService.g:357:1: entryRuleScopeProperty returns [EObject current=null] : iv_ruleScopeProperty= ruleScopeProperty EOF ;
    public final EObject entryRuleScopeProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScopeProperty = null;


        try {
            // InternalFlowService.g:357:54: (iv_ruleScopeProperty= ruleScopeProperty EOF )
            // InternalFlowService.g:358:2: iv_ruleScopeProperty= ruleScopeProperty EOF
            {
             newCompositeNode(grammarAccess.getScopePropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScopeProperty=ruleScopeProperty();

            state._fsp--;

             current =iv_ruleScopeProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScopeProperty"


    // $ANTLR start "ruleScopeProperty"
    // InternalFlowService.g:364:1: ruleScopeProperty returns [EObject current=null] : (otherlv_0= 'scope' otherlv_1= ':' ( (lv_value_2_0= RULE_ID ) ) ) ;
    public final EObject ruleScopeProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalFlowService.g:370:2: ( (otherlv_0= 'scope' otherlv_1= ':' ( (lv_value_2_0= RULE_ID ) ) ) )
            // InternalFlowService.g:371:2: (otherlv_0= 'scope' otherlv_1= ':' ( (lv_value_2_0= RULE_ID ) ) )
            {
            // InternalFlowService.g:371:2: (otherlv_0= 'scope' otherlv_1= ':' ( (lv_value_2_0= RULE_ID ) ) )
            // InternalFlowService.g:372:3: otherlv_0= 'scope' otherlv_1= ':' ( (lv_value_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getScopePropertyAccess().getScopeKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getScopePropertyAccess().getColonKeyword_1());
            		
            // InternalFlowService.g:380:3: ( (lv_value_2_0= RULE_ID ) )
            // InternalFlowService.g:381:4: (lv_value_2_0= RULE_ID )
            {
            // InternalFlowService.g:381:4: (lv_value_2_0= RULE_ID )
            // InternalFlowService.g:382:5: lv_value_2_0= RULE_ID
            {
            lv_value_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_value_2_0, grammarAccess.getScopePropertyAccess().getValueIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScopePropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScopeProperty"


    // $ANTLR start "entryRuleTimeoutProperty"
    // InternalFlowService.g:402:1: entryRuleTimeoutProperty returns [EObject current=null] : iv_ruleTimeoutProperty= ruleTimeoutProperty EOF ;
    public final EObject entryRuleTimeoutProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeoutProperty = null;


        try {
            // InternalFlowService.g:402:56: (iv_ruleTimeoutProperty= ruleTimeoutProperty EOF )
            // InternalFlowService.g:403:2: iv_ruleTimeoutProperty= ruleTimeoutProperty EOF
            {
             newCompositeNode(grammarAccess.getTimeoutPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeoutProperty=ruleTimeoutProperty();

            state._fsp--;

             current =iv_ruleTimeoutProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeoutProperty"


    // $ANTLR start "ruleTimeoutProperty"
    // InternalFlowService.g:409:1: ruleTimeoutProperty returns [EObject current=null] : (otherlv_0= 'timeout' otherlv_1= ':' ( (lv_value_2_0= RULE_INT ) ) ) ;
    public final EObject ruleTimeoutProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalFlowService.g:415:2: ( (otherlv_0= 'timeout' otherlv_1= ':' ( (lv_value_2_0= RULE_INT ) ) ) )
            // InternalFlowService.g:416:2: (otherlv_0= 'timeout' otherlv_1= ':' ( (lv_value_2_0= RULE_INT ) ) )
            {
            // InternalFlowService.g:416:2: (otherlv_0= 'timeout' otherlv_1= ':' ( (lv_value_2_0= RULE_INT ) ) )
            // InternalFlowService.g:417:3: otherlv_0= 'timeout' otherlv_1= ':' ( (lv_value_2_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getTimeoutPropertyAccess().getTimeoutKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getTimeoutPropertyAccess().getColonKeyword_1());
            		
            // InternalFlowService.g:425:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalFlowService.g:426:4: (lv_value_2_0= RULE_INT )
            {
            // InternalFlowService.g:426:4: (lv_value_2_0= RULE_INT )
            // InternalFlowService.g:427:5: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_value_2_0, grammarAccess.getTimeoutPropertyAccess().getValueINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeoutPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeoutProperty"


    // $ANTLR start "entryRuleLabelProperty"
    // InternalFlowService.g:447:1: entryRuleLabelProperty returns [EObject current=null] : iv_ruleLabelProperty= ruleLabelProperty EOF ;
    public final EObject entryRuleLabelProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLabelProperty = null;


        try {
            // InternalFlowService.g:447:54: (iv_ruleLabelProperty= ruleLabelProperty EOF )
            // InternalFlowService.g:448:2: iv_ruleLabelProperty= ruleLabelProperty EOF
            {
             newCompositeNode(grammarAccess.getLabelPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLabelProperty=ruleLabelProperty();

            state._fsp--;

             current =iv_ruleLabelProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLabelProperty"


    // $ANTLR start "ruleLabelProperty"
    // InternalFlowService.g:454:1: ruleLabelProperty returns [EObject current=null] : (otherlv_0= 'label' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleLabelProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalFlowService.g:460:2: ( (otherlv_0= 'label' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // InternalFlowService.g:461:2: (otherlv_0= 'label' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // InternalFlowService.g:461:2: (otherlv_0= 'label' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            // InternalFlowService.g:462:3: otherlv_0= 'label' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,19,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getLabelPropertyAccess().getLabelKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getLabelPropertyAccess().getColonKeyword_1());
            		
            // InternalFlowService.g:470:3: ( (lv_value_2_0= RULE_STRING ) )
            // InternalFlowService.g:471:4: (lv_value_2_0= RULE_STRING )
            {
            // InternalFlowService.g:471:4: (lv_value_2_0= RULE_STRING )
            // InternalFlowService.g:472:5: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_2_0, grammarAccess.getLabelPropertyAccess().getValueSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLabelPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLabelProperty"


    // $ANTLR start "entryRuleQualifiedServiceName"
    // InternalFlowService.g:492:1: entryRuleQualifiedServiceName returns [EObject current=null] : iv_ruleQualifiedServiceName= ruleQualifiedServiceName EOF ;
    public final EObject entryRuleQualifiedServiceName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedServiceName = null;


        try {
            // InternalFlowService.g:492:61: (iv_ruleQualifiedServiceName= ruleQualifiedServiceName EOF )
            // InternalFlowService.g:493:2: iv_ruleQualifiedServiceName= ruleQualifiedServiceName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedServiceNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedServiceName=ruleQualifiedServiceName();

            state._fsp--;

             current =iv_ruleQualifiedServiceName; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedServiceName"


    // $ANTLR start "ruleQualifiedServiceName"
    // InternalFlowService.g:499:1: ruleQualifiedServiceName returns [EObject current=null] : ( ( (lv_namespace_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_namespace_2_0= RULE_ID ) ) )* otherlv_3= ':' ( (lv_name_4_0= RULE_ID ) ) ) ;
    public final EObject ruleQualifiedServiceName() throws RecognitionException {
        EObject current = null;

        Token lv_namespace_0_0=null;
        Token otherlv_1=null;
        Token lv_namespace_2_0=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;


        	enterRule();

        try {
            // InternalFlowService.g:505:2: ( ( ( (lv_namespace_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_namespace_2_0= RULE_ID ) ) )* otherlv_3= ':' ( (lv_name_4_0= RULE_ID ) ) ) )
            // InternalFlowService.g:506:2: ( ( (lv_namespace_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_namespace_2_0= RULE_ID ) ) )* otherlv_3= ':' ( (lv_name_4_0= RULE_ID ) ) )
            {
            // InternalFlowService.g:506:2: ( ( (lv_namespace_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_namespace_2_0= RULE_ID ) ) )* otherlv_3= ':' ( (lv_name_4_0= RULE_ID ) ) )
            // InternalFlowService.g:507:3: ( (lv_namespace_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_namespace_2_0= RULE_ID ) ) )* otherlv_3= ':' ( (lv_name_4_0= RULE_ID ) )
            {
            // InternalFlowService.g:507:3: ( (lv_namespace_0_0= RULE_ID ) )
            // InternalFlowService.g:508:4: (lv_namespace_0_0= RULE_ID )
            {
            // InternalFlowService.g:508:4: (lv_namespace_0_0= RULE_ID )
            // InternalFlowService.g:509:5: lv_namespace_0_0= RULE_ID
            {
            lv_namespace_0_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_namespace_0_0, grammarAccess.getQualifiedServiceNameAccess().getNamespaceIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQualifiedServiceNameRule());
            					}
            					addWithLastConsumed(
            						current,
            						"namespace",
            						lv_namespace_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalFlowService.g:525:3: (otherlv_1= '.' ( (lv_namespace_2_0= RULE_ID ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==20) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalFlowService.g:526:4: otherlv_1= '.' ( (lv_namespace_2_0= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,20,FOLLOW_4); 

            	    				newLeafNode(otherlv_1, grammarAccess.getQualifiedServiceNameAccess().getFullStopKeyword_1_0());
            	    			
            	    // InternalFlowService.g:530:4: ( (lv_namespace_2_0= RULE_ID ) )
            	    // InternalFlowService.g:531:5: (lv_namespace_2_0= RULE_ID )
            	    {
            	    // InternalFlowService.g:531:5: (lv_namespace_2_0= RULE_ID )
            	    // InternalFlowService.g:532:6: lv_namespace_2_0= RULE_ID
            	    {
            	    lv_namespace_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            	    						newLeafNode(lv_namespace_2_0, grammarAccess.getQualifiedServiceNameAccess().getNamespaceIDTerminalRuleCall_1_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getQualifiedServiceNameRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"namespace",
            	    							lv_namespace_2_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_3=(Token)match(input,16,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getQualifiedServiceNameAccess().getColonKeyword_2());
            		
            // InternalFlowService.g:553:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalFlowService.g:554:4: (lv_name_4_0= RULE_ID )
            {
            // InternalFlowService.g:554:4: (lv_name_4_0= RULE_ID )
            // InternalFlowService.g:555:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_4_0, grammarAccess.getQualifiedServiceNameAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQualifiedServiceNameRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedServiceName"


    // $ANTLR start "entryRuleMapStep"
    // InternalFlowService.g:575:1: entryRuleMapStep returns [EObject current=null] : iv_ruleMapStep= ruleMapStep EOF ;
    public final EObject entryRuleMapStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapStep = null;


        try {
            // InternalFlowService.g:575:48: (iv_ruleMapStep= ruleMapStep EOF )
            // InternalFlowService.g:576:2: iv_ruleMapStep= ruleMapStep EOF
            {
             newCompositeNode(grammarAccess.getMapStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMapStep=ruleMapStep();

            state._fsp--;

             current =iv_ruleMapStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapStep"


    // $ANTLR start "ruleMapStep"
    // InternalFlowService.g:582:1: ruleMapStep returns [EObject current=null] : (otherlv_0= 'MAP' (otherlv_1= '{' ( (lv_mapElements_2_0= ruleMapElement ) )* otherlv_3= '}' )? otherlv_4= ';' ) ;
    public final EObject ruleMapStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_mapElements_2_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:588:2: ( (otherlv_0= 'MAP' (otherlv_1= '{' ( (lv_mapElements_2_0= ruleMapElement ) )* otherlv_3= '}' )? otherlv_4= ';' ) )
            // InternalFlowService.g:589:2: (otherlv_0= 'MAP' (otherlv_1= '{' ( (lv_mapElements_2_0= ruleMapElement ) )* otherlv_3= '}' )? otherlv_4= ';' )
            {
            // InternalFlowService.g:589:2: (otherlv_0= 'MAP' (otherlv_1= '{' ( (lv_mapElements_2_0= ruleMapElement ) )* otherlv_3= '}' )? otherlv_4= ';' )
            // InternalFlowService.g:590:3: otherlv_0= 'MAP' (otherlv_1= '{' ( (lv_mapElements_2_0= ruleMapElement ) )* otherlv_3= '}' )? otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getMapStepAccess().getMAPKeyword_0());
            		
            // InternalFlowService.g:594:3: (otherlv_1= '{' ( (lv_mapElements_2_0= ruleMapElement ) )* otherlv_3= '}' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==13) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalFlowService.g:595:4: otherlv_1= '{' ( (lv_mapElements_2_0= ruleMapElement ) )* otherlv_3= '}'
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_12); 

                    				newLeafNode(otherlv_1, grammarAccess.getMapStepAccess().getLeftCurlyBracketKeyword_1_0());
                    			
                    // InternalFlowService.g:599:4: ( (lv_mapElements_2_0= ruleMapElement ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==15||(LA6_0>=17 && LA6_0<=19)||(LA6_0>=23 && LA6_0<=24)||LA6_0==29||LA6_0==31) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalFlowService.g:600:5: (lv_mapElements_2_0= ruleMapElement )
                    	    {
                    	    // InternalFlowService.g:600:5: (lv_mapElements_2_0= ruleMapElement )
                    	    // InternalFlowService.g:601:6: lv_mapElements_2_0= ruleMapElement
                    	    {

                    	    						newCompositeNode(grammarAccess.getMapStepAccess().getMapElementsMapElementParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_12);
                    	    lv_mapElements_2_0=ruleMapElement();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getMapStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"mapElements",
                    	    							lv_mapElements_2_0,
                    	    							"com.webmethods.flow.FlowService.MapElement");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,14,FOLLOW_13); 

                    				newLeafNode(otherlv_3, grammarAccess.getMapStepAccess().getRightCurlyBracketKeyword_1_2());
                    			

                    }
                    break;

            }

            otherlv_4=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getMapStepAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapStep"


    // $ANTLR start "entryRuleMapElement"
    // InternalFlowService.g:631:1: entryRuleMapElement returns [EObject current=null] : iv_ruleMapElement= ruleMapElement EOF ;
    public final EObject entryRuleMapElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapElement = null;


        try {
            // InternalFlowService.g:631:51: (iv_ruleMapElement= ruleMapElement EOF )
            // InternalFlowService.g:632:2: iv_ruleMapElement= ruleMapElement EOF
            {
             newCompositeNode(grammarAccess.getMapElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMapElement=ruleMapElement();

            state._fsp--;

             current =iv_ruleMapElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapElement"


    // $ANTLR start "ruleMapElement"
    // InternalFlowService.g:638:1: ruleMapElement returns [EObject current=null] : (this_StepProperty_0= ruleStepProperty | this_MappingSetEntry_1= ruleMappingSetEntry | this_MappingCopyEntry_2= ruleMappingCopyEntry | this_TransformStep_3= ruleTransformStep | this_DropStep_4= ruleDropStep ) ;
    public final EObject ruleMapElement() throws RecognitionException {
        EObject current = null;

        EObject this_StepProperty_0 = null;

        EObject this_MappingSetEntry_1 = null;

        EObject this_MappingCopyEntry_2 = null;

        EObject this_TransformStep_3 = null;

        EObject this_DropStep_4 = null;



        	enterRule();

        try {
            // InternalFlowService.g:644:2: ( (this_StepProperty_0= ruleStepProperty | this_MappingSetEntry_1= ruleMappingSetEntry | this_MappingCopyEntry_2= ruleMappingCopyEntry | this_TransformStep_3= ruleTransformStep | this_DropStep_4= ruleDropStep ) )
            // InternalFlowService.g:645:2: (this_StepProperty_0= ruleStepProperty | this_MappingSetEntry_1= ruleMappingSetEntry | this_MappingCopyEntry_2= ruleMappingCopyEntry | this_TransformStep_3= ruleTransformStep | this_DropStep_4= ruleDropStep )
            {
            // InternalFlowService.g:645:2: (this_StepProperty_0= ruleStepProperty | this_MappingSetEntry_1= ruleMappingSetEntry | this_MappingCopyEntry_2= ruleMappingCopyEntry | this_TransformStep_3= ruleTransformStep | this_DropStep_4= ruleDropStep )
            int alt8=5;
            switch ( input.LA(1) ) {
            case 15:
            case 17:
            case 18:
            case 19:
                {
                alt8=1;
                }
                break;
            case 31:
                {
                alt8=2;
                }
                break;
            case 29:
                {
                alt8=3;
                }
                break;
            case 23:
                {
                alt8=4;
                }
                break;
            case 24:
                {
                alt8=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalFlowService.g:646:3: this_StepProperty_0= ruleStepProperty
                    {

                    			newCompositeNode(grammarAccess.getMapElementAccess().getStepPropertyParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_StepProperty_0=ruleStepProperty();

                    state._fsp--;


                    			current = this_StepProperty_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFlowService.g:655:3: this_MappingSetEntry_1= ruleMappingSetEntry
                    {

                    			newCompositeNode(grammarAccess.getMapElementAccess().getMappingSetEntryParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_MappingSetEntry_1=ruleMappingSetEntry();

                    state._fsp--;


                    			current = this_MappingSetEntry_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFlowService.g:664:3: this_MappingCopyEntry_2= ruleMappingCopyEntry
                    {

                    			newCompositeNode(grammarAccess.getMapElementAccess().getMappingCopyEntryParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_MappingCopyEntry_2=ruleMappingCopyEntry();

                    state._fsp--;


                    			current = this_MappingCopyEntry_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalFlowService.g:673:3: this_TransformStep_3= ruleTransformStep
                    {

                    			newCompositeNode(grammarAccess.getMapElementAccess().getTransformStepParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_TransformStep_3=ruleTransformStep();

                    state._fsp--;


                    			current = this_TransformStep_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalFlowService.g:682:3: this_DropStep_4= ruleDropStep
                    {

                    			newCompositeNode(grammarAccess.getMapElementAccess().getDropStepParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_DropStep_4=ruleDropStep();

                    state._fsp--;


                    			current = this_DropStep_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapElement"


    // $ANTLR start "entryRuleTransformStep"
    // InternalFlowService.g:694:1: entryRuleTransformStep returns [EObject current=null] : iv_ruleTransformStep= ruleTransformStep EOF ;
    public final EObject entryRuleTransformStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformStep = null;


        try {
            // InternalFlowService.g:694:54: (iv_ruleTransformStep= ruleTransformStep EOF )
            // InternalFlowService.g:695:2: iv_ruleTransformStep= ruleTransformStep EOF
            {
             newCompositeNode(grammarAccess.getTransformStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransformStep=ruleTransformStep();

            state._fsp--;

             current =iv_ruleTransformStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransformStep"


    // $ANTLR start "ruleTransformStep"
    // InternalFlowService.g:701:1: ruleTransformStep returns [EObject current=null] : (otherlv_0= 'TRANSFORM' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_mappings_3_0= ruleMappingBlock ) )* otherlv_4= '}' )? otherlv_5= ';' ) ;
    public final EObject ruleTransformStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_service_1_0 = null;

        EObject lv_mappings_3_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:707:2: ( (otherlv_0= 'TRANSFORM' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_mappings_3_0= ruleMappingBlock ) )* otherlv_4= '}' )? otherlv_5= ';' ) )
            // InternalFlowService.g:708:2: (otherlv_0= 'TRANSFORM' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_mappings_3_0= ruleMappingBlock ) )* otherlv_4= '}' )? otherlv_5= ';' )
            {
            // InternalFlowService.g:708:2: (otherlv_0= 'TRANSFORM' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_mappings_3_0= ruleMappingBlock ) )* otherlv_4= '}' )? otherlv_5= ';' )
            // InternalFlowService.g:709:3: otherlv_0= 'TRANSFORM' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_mappings_3_0= ruleMappingBlock ) )* otherlv_4= '}' )? otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTransformStepAccess().getTRANSFORMKeyword_0());
            		
            // InternalFlowService.g:713:3: ( (lv_service_1_0= ruleQualifiedServiceName ) )
            // InternalFlowService.g:714:4: (lv_service_1_0= ruleQualifiedServiceName )
            {
            // InternalFlowService.g:714:4: (lv_service_1_0= ruleQualifiedServiceName )
            // InternalFlowService.g:715:5: lv_service_1_0= ruleQualifiedServiceName
            {

            					newCompositeNode(grammarAccess.getTransformStepAccess().getServiceQualifiedServiceNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_11);
            lv_service_1_0=ruleQualifiedServiceName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTransformStepRule());
            					}
            					set(
            						current,
            						"service",
            						lv_service_1_0,
            						"com.webmethods.flow.FlowService.QualifiedServiceName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalFlowService.g:732:3: (otherlv_2= '{' ( (lv_mappings_3_0= ruleMappingBlock ) )* otherlv_4= '}' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==13) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalFlowService.g:733:4: otherlv_2= '{' ( (lv_mappings_3_0= ruleMappingBlock ) )* otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_14); 

                    				newLeafNode(otherlv_2, grammarAccess.getTransformStepAccess().getLeftCurlyBracketKeyword_2_0());
                    			
                    // InternalFlowService.g:737:4: ( (lv_mappings_3_0= ruleMappingBlock ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>=27 && LA9_0<=28)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalFlowService.g:738:5: (lv_mappings_3_0= ruleMappingBlock )
                    	    {
                    	    // InternalFlowService.g:738:5: (lv_mappings_3_0= ruleMappingBlock )
                    	    // InternalFlowService.g:739:6: lv_mappings_3_0= ruleMappingBlock
                    	    {

                    	    						newCompositeNode(grammarAccess.getTransformStepAccess().getMappingsMappingBlockParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_14);
                    	    lv_mappings_3_0=ruleMappingBlock();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getTransformStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"mappings",
                    	    							lv_mappings_3_0,
                    	    							"com.webmethods.flow.FlowService.MappingBlock");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,14,FOLLOW_13); 

                    				newLeafNode(otherlv_4, grammarAccess.getTransformStepAccess().getRightCurlyBracketKeyword_2_2());
                    			

                    }
                    break;

            }

            otherlv_5=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getTransformStepAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransformStep"


    // $ANTLR start "entryRuleDropStep"
    // InternalFlowService.g:769:1: entryRuleDropStep returns [EObject current=null] : iv_ruleDropStep= ruleDropStep EOF ;
    public final EObject entryRuleDropStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDropStep = null;


        try {
            // InternalFlowService.g:769:49: (iv_ruleDropStep= ruleDropStep EOF )
            // InternalFlowService.g:770:2: iv_ruleDropStep= ruleDropStep EOF
            {
             newCompositeNode(grammarAccess.getDropStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDropStep=ruleDropStep();

            state._fsp--;

             current =iv_ruleDropStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDropStep"


    // $ANTLR start "ruleDropStep"
    // InternalFlowService.g:776:1: ruleDropStep returns [EObject current=null] : (otherlv_0= 'drop' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleDropStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_path_1_0=null;
        Token otherlv_2=null;
        Token lv_path_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalFlowService.g:782:2: ( (otherlv_0= 'drop' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= ';' ) )
            // InternalFlowService.g:783:2: (otherlv_0= 'drop' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= ';' )
            {
            // InternalFlowService.g:783:2: (otherlv_0= 'drop' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= ';' )
            // InternalFlowService.g:784:3: otherlv_0= 'drop' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDropStepAccess().getDropKeyword_0());
            		
            // InternalFlowService.g:788:3: ( (lv_path_1_0= RULE_ID ) )
            // InternalFlowService.g:789:4: (lv_path_1_0= RULE_ID )
            {
            // InternalFlowService.g:789:4: (lv_path_1_0= RULE_ID )
            // InternalFlowService.g:790:5: lv_path_1_0= RULE_ID
            {
            lv_path_1_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(lv_path_1_0, grammarAccess.getDropStepAccess().getPathIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDropStepRule());
            					}
            					addWithLastConsumed(
            						current,
            						"path",
            						lv_path_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalFlowService.g:806:3: (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==25) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalFlowService.g:807:4: otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getDropStepAccess().getSolidusKeyword_2_0());
            	    			
            	    // InternalFlowService.g:811:4: ( (lv_path_3_0= RULE_ID ) )
            	    // InternalFlowService.g:812:5: (lv_path_3_0= RULE_ID )
            	    {
            	    // InternalFlowService.g:812:5: (lv_path_3_0= RULE_ID )
            	    // InternalFlowService.g:813:6: lv_path_3_0= RULE_ID
            	    {
            	    lv_path_3_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            	    						newLeafNode(lv_path_3_0, grammarAccess.getDropStepAccess().getPathIDTerminalRuleCall_2_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getDropStepRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"path",
            	    							lv_path_3_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_4=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getDropStepAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDropStep"


    // $ANTLR start "entryRuleInvokeStep"
    // InternalFlowService.g:838:1: entryRuleInvokeStep returns [EObject current=null] : iv_ruleInvokeStep= ruleInvokeStep EOF ;
    public final EObject entryRuleInvokeStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvokeStep = null;


        try {
            // InternalFlowService.g:838:51: (iv_ruleInvokeStep= ruleInvokeStep EOF )
            // InternalFlowService.g:839:2: iv_ruleInvokeStep= ruleInvokeStep EOF
            {
             newCompositeNode(grammarAccess.getInvokeStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInvokeStep=ruleInvokeStep();

            state._fsp--;

             current =iv_ruleInvokeStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInvokeStep"


    // $ANTLR start "ruleInvokeStep"
    // InternalFlowService.g:845:1: ruleInvokeStep returns [EObject current=null] : (otherlv_0= 'INVOKE' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_invokeProps_4_0= ruleInvokeProperty ) )* ( (lv_mappings_5_0= ruleMappingBlock ) )* otherlv_6= '}' )? otherlv_7= ';' ) ;
    public final EObject ruleInvokeStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_service_1_0 = null;

        EObject lv_properties_3_0 = null;

        EObject lv_invokeProps_4_0 = null;

        EObject lv_mappings_5_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:851:2: ( (otherlv_0= 'INVOKE' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_invokeProps_4_0= ruleInvokeProperty ) )* ( (lv_mappings_5_0= ruleMappingBlock ) )* otherlv_6= '}' )? otherlv_7= ';' ) )
            // InternalFlowService.g:852:2: (otherlv_0= 'INVOKE' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_invokeProps_4_0= ruleInvokeProperty ) )* ( (lv_mappings_5_0= ruleMappingBlock ) )* otherlv_6= '}' )? otherlv_7= ';' )
            {
            // InternalFlowService.g:852:2: (otherlv_0= 'INVOKE' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_invokeProps_4_0= ruleInvokeProperty ) )* ( (lv_mappings_5_0= ruleMappingBlock ) )* otherlv_6= '}' )? otherlv_7= ';' )
            // InternalFlowService.g:853:3: otherlv_0= 'INVOKE' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_invokeProps_4_0= ruleInvokeProperty ) )* ( (lv_mappings_5_0= ruleMappingBlock ) )* otherlv_6= '}' )? otherlv_7= ';'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getInvokeStepAccess().getINVOKEKeyword_0());
            		
            // InternalFlowService.g:857:3: ( (lv_service_1_0= ruleQualifiedServiceName ) )
            // InternalFlowService.g:858:4: (lv_service_1_0= ruleQualifiedServiceName )
            {
            // InternalFlowService.g:858:4: (lv_service_1_0= ruleQualifiedServiceName )
            // InternalFlowService.g:859:5: lv_service_1_0= ruleQualifiedServiceName
            {

            					newCompositeNode(grammarAccess.getInvokeStepAccess().getServiceQualifiedServiceNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_11);
            lv_service_1_0=ruleQualifiedServiceName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInvokeStepRule());
            					}
            					set(
            						current,
            						"service",
            						lv_service_1_0,
            						"com.webmethods.flow.FlowService.QualifiedServiceName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalFlowService.g:876:3: (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_invokeProps_4_0= ruleInvokeProperty ) )* ( (lv_mappings_5_0= ruleMappingBlock ) )* otherlv_6= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==13) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalFlowService.g:877:4: otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_invokeProps_4_0= ruleInvokeProperty ) )* ( (lv_mappings_5_0= ruleMappingBlock ) )* otherlv_6= '}'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_16); 

                    				newLeafNode(otherlv_2, grammarAccess.getInvokeStepAccess().getLeftCurlyBracketKeyword_2_0());
                    			
                    // InternalFlowService.g:881:4: ( (lv_properties_3_0= ruleStepProperty ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==15||(LA12_0>=17 && LA12_0<=19)) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalFlowService.g:882:5: (lv_properties_3_0= ruleStepProperty )
                    	    {
                    	    // InternalFlowService.g:882:5: (lv_properties_3_0= ruleStepProperty )
                    	    // InternalFlowService.g:883:6: lv_properties_3_0= ruleStepProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getInvokeStepAccess().getPropertiesStepPropertyParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_16);
                    	    lv_properties_3_0=ruleStepProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInvokeStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"properties",
                    	    							lv_properties_3_0,
                    	    							"com.webmethods.flow.FlowService.StepProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    // InternalFlowService.g:900:4: ( (lv_invokeProps_4_0= ruleInvokeProperty ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>=33 && LA13_0<=34)) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalFlowService.g:901:5: (lv_invokeProps_4_0= ruleInvokeProperty )
                    	    {
                    	    // InternalFlowService.g:901:5: (lv_invokeProps_4_0= ruleInvokeProperty )
                    	    // InternalFlowService.g:902:6: lv_invokeProps_4_0= ruleInvokeProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getInvokeStepAccess().getInvokePropsInvokePropertyParserRuleCall_2_2_0());
                    	    					
                    	    pushFollow(FOLLOW_17);
                    	    lv_invokeProps_4_0=ruleInvokeProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInvokeStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"invokeProps",
                    	    							lv_invokeProps_4_0,
                    	    							"com.webmethods.flow.FlowService.InvokeProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    // InternalFlowService.g:919:4: ( (lv_mappings_5_0= ruleMappingBlock ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>=27 && LA14_0<=28)) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalFlowService.g:920:5: (lv_mappings_5_0= ruleMappingBlock )
                    	    {
                    	    // InternalFlowService.g:920:5: (lv_mappings_5_0= ruleMappingBlock )
                    	    // InternalFlowService.g:921:6: lv_mappings_5_0= ruleMappingBlock
                    	    {

                    	    						newCompositeNode(grammarAccess.getInvokeStepAccess().getMappingsMappingBlockParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_14);
                    	    lv_mappings_5_0=ruleMappingBlock();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getInvokeStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"mappings",
                    	    							lv_mappings_5_0,
                    	    							"com.webmethods.flow.FlowService.MappingBlock");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,14,FOLLOW_13); 

                    				newLeafNode(otherlv_6, grammarAccess.getInvokeStepAccess().getRightCurlyBracketKeyword_2_4());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getInvokeStepAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInvokeStep"


    // $ANTLR start "entryRuleMappingBlock"
    // InternalFlowService.g:951:1: entryRuleMappingBlock returns [EObject current=null] : iv_ruleMappingBlock= ruleMappingBlock EOF ;
    public final EObject entryRuleMappingBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingBlock = null;


        try {
            // InternalFlowService.g:951:53: (iv_ruleMappingBlock= ruleMappingBlock EOF )
            // InternalFlowService.g:952:2: iv_ruleMappingBlock= ruleMappingBlock EOF
            {
             newCompositeNode(grammarAccess.getMappingBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMappingBlock=ruleMappingBlock();

            state._fsp--;

             current =iv_ruleMappingBlock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMappingBlock"


    // $ANTLR start "ruleMappingBlock"
    // InternalFlowService.g:958:1: ruleMappingBlock returns [EObject current=null] : ( (otherlv_0= 'input' otherlv_1= '{' ( (lv_entries_2_0= ruleMappingEntry ) )* otherlv_3= '}' ) | (otherlv_4= 'output' otherlv_5= '{' ( (lv_entries_6_0= ruleMappingEntry ) )* otherlv_7= '}' ) ) ;
    public final EObject ruleMappingBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_entries_2_0 = null;

        EObject lv_entries_6_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:964:2: ( ( (otherlv_0= 'input' otherlv_1= '{' ( (lv_entries_2_0= ruleMappingEntry ) )* otherlv_3= '}' ) | (otherlv_4= 'output' otherlv_5= '{' ( (lv_entries_6_0= ruleMappingEntry ) )* otherlv_7= '}' ) ) )
            // InternalFlowService.g:965:2: ( (otherlv_0= 'input' otherlv_1= '{' ( (lv_entries_2_0= ruleMappingEntry ) )* otherlv_3= '}' ) | (otherlv_4= 'output' otherlv_5= '{' ( (lv_entries_6_0= ruleMappingEntry ) )* otherlv_7= '}' ) )
            {
            // InternalFlowService.g:965:2: ( (otherlv_0= 'input' otherlv_1= '{' ( (lv_entries_2_0= ruleMappingEntry ) )* otherlv_3= '}' ) | (otherlv_4= 'output' otherlv_5= '{' ( (lv_entries_6_0= ruleMappingEntry ) )* otherlv_7= '}' ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            else if ( (LA18_0==28) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalFlowService.g:966:3: (otherlv_0= 'input' otherlv_1= '{' ( (lv_entries_2_0= ruleMappingEntry ) )* otherlv_3= '}' )
                    {
                    // InternalFlowService.g:966:3: (otherlv_0= 'input' otherlv_1= '{' ( (lv_entries_2_0= ruleMappingEntry ) )* otherlv_3= '}' )
                    // InternalFlowService.g:967:4: otherlv_0= 'input' otherlv_1= '{' ( (lv_entries_2_0= ruleMappingEntry ) )* otherlv_3= '}'
                    {
                    otherlv_0=(Token)match(input,27,FOLLOW_5); 

                    				newLeafNode(otherlv_0, grammarAccess.getMappingBlockAccess().getInputKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,13,FOLLOW_18); 

                    				newLeafNode(otherlv_1, grammarAccess.getMappingBlockAccess().getLeftCurlyBracketKeyword_0_1());
                    			
                    // InternalFlowService.g:975:4: ( (lv_entries_2_0= ruleMappingEntry ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==29||LA16_0==31) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalFlowService.g:976:5: (lv_entries_2_0= ruleMappingEntry )
                    	    {
                    	    // InternalFlowService.g:976:5: (lv_entries_2_0= ruleMappingEntry )
                    	    // InternalFlowService.g:977:6: lv_entries_2_0= ruleMappingEntry
                    	    {

                    	    						newCompositeNode(grammarAccess.getMappingBlockAccess().getEntriesMappingEntryParserRuleCall_0_2_0());
                    	    					
                    	    pushFollow(FOLLOW_18);
                    	    lv_entries_2_0=ruleMappingEntry();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getMappingBlockRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"entries",
                    	    							lv_entries_2_0,
                    	    							"com.webmethods.flow.FlowService.MappingEntry");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getMappingBlockAccess().getRightCurlyBracketKeyword_0_3());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalFlowService.g:1000:3: (otherlv_4= 'output' otherlv_5= '{' ( (lv_entries_6_0= ruleMappingEntry ) )* otherlv_7= '}' )
                    {
                    // InternalFlowService.g:1000:3: (otherlv_4= 'output' otherlv_5= '{' ( (lv_entries_6_0= ruleMappingEntry ) )* otherlv_7= '}' )
                    // InternalFlowService.g:1001:4: otherlv_4= 'output' otherlv_5= '{' ( (lv_entries_6_0= ruleMappingEntry ) )* otherlv_7= '}'
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_5); 

                    				newLeafNode(otherlv_4, grammarAccess.getMappingBlockAccess().getOutputKeyword_1_0());
                    			
                    otherlv_5=(Token)match(input,13,FOLLOW_18); 

                    				newLeafNode(otherlv_5, grammarAccess.getMappingBlockAccess().getLeftCurlyBracketKeyword_1_1());
                    			
                    // InternalFlowService.g:1009:4: ( (lv_entries_6_0= ruleMappingEntry ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==29||LA17_0==31) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalFlowService.g:1010:5: (lv_entries_6_0= ruleMappingEntry )
                    	    {
                    	    // InternalFlowService.g:1010:5: (lv_entries_6_0= ruleMappingEntry )
                    	    // InternalFlowService.g:1011:6: lv_entries_6_0= ruleMappingEntry
                    	    {

                    	    						newCompositeNode(grammarAccess.getMappingBlockAccess().getEntriesMappingEntryParserRuleCall_1_2_0());
                    	    					
                    	    pushFollow(FOLLOW_18);
                    	    lv_entries_6_0=ruleMappingEntry();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getMappingBlockRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"entries",
                    	    							lv_entries_6_0,
                    	    							"com.webmethods.flow.FlowService.MappingEntry");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getMappingBlockAccess().getRightCurlyBracketKeyword_1_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMappingBlock"


    // $ANTLR start "entryRuleMappingEntry"
    // InternalFlowService.g:1037:1: entryRuleMappingEntry returns [EObject current=null] : iv_ruleMappingEntry= ruleMappingEntry EOF ;
    public final EObject entryRuleMappingEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingEntry = null;


        try {
            // InternalFlowService.g:1037:53: (iv_ruleMappingEntry= ruleMappingEntry EOF )
            // InternalFlowService.g:1038:2: iv_ruleMappingEntry= ruleMappingEntry EOF
            {
             newCompositeNode(grammarAccess.getMappingEntryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMappingEntry=ruleMappingEntry();

            state._fsp--;

             current =iv_ruleMappingEntry; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMappingEntry"


    // $ANTLR start "ruleMappingEntry"
    // InternalFlowService.g:1044:1: ruleMappingEntry returns [EObject current=null] : (this_MappingCopyEntry_0= ruleMappingCopyEntry | this_MappingSetEntry_1= ruleMappingSetEntry ) ;
    public final EObject ruleMappingEntry() throws RecognitionException {
        EObject current = null;

        EObject this_MappingCopyEntry_0 = null;

        EObject this_MappingSetEntry_1 = null;



        	enterRule();

        try {
            // InternalFlowService.g:1050:2: ( (this_MappingCopyEntry_0= ruleMappingCopyEntry | this_MappingSetEntry_1= ruleMappingSetEntry ) )
            // InternalFlowService.g:1051:2: (this_MappingCopyEntry_0= ruleMappingCopyEntry | this_MappingSetEntry_1= ruleMappingSetEntry )
            {
            // InternalFlowService.g:1051:2: (this_MappingCopyEntry_0= ruleMappingCopyEntry | this_MappingSetEntry_1= ruleMappingSetEntry )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==29) ) {
                alt19=1;
            }
            else if ( (LA19_0==31) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalFlowService.g:1052:3: this_MappingCopyEntry_0= ruleMappingCopyEntry
                    {

                    			newCompositeNode(grammarAccess.getMappingEntryAccess().getMappingCopyEntryParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_MappingCopyEntry_0=ruleMappingCopyEntry();

                    state._fsp--;


                    			current = this_MappingCopyEntry_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFlowService.g:1061:3: this_MappingSetEntry_1= ruleMappingSetEntry
                    {

                    			newCompositeNode(grammarAccess.getMappingEntryAccess().getMappingSetEntryParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_MappingSetEntry_1=ruleMappingSetEntry();

                    state._fsp--;


                    			current = this_MappingSetEntry_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMappingEntry"


    // $ANTLR start "entryRuleMappingCopyEntry"
    // InternalFlowService.g:1073:1: entryRuleMappingCopyEntry returns [EObject current=null] : iv_ruleMappingCopyEntry= ruleMappingCopyEntry EOF ;
    public final EObject entryRuleMappingCopyEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingCopyEntry = null;


        try {
            // InternalFlowService.g:1073:57: (iv_ruleMappingCopyEntry= ruleMappingCopyEntry EOF )
            // InternalFlowService.g:1074:2: iv_ruleMappingCopyEntry= ruleMappingCopyEntry EOF
            {
             newCompositeNode(grammarAccess.getMappingCopyEntryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMappingCopyEntry=ruleMappingCopyEntry();

            state._fsp--;

             current =iv_ruleMappingCopyEntry; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMappingCopyEntry"


    // $ANTLR start "ruleMappingCopyEntry"
    // InternalFlowService.g:1080:1: ruleMappingCopyEntry returns [EObject current=null] : (otherlv_0= 'copy' ( (lv_fromPath_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_fromPath_3_0= RULE_ID ) ) )* otherlv_4= '->' ( (lv_toPath_5_0= RULE_ID ) ) (otherlv_6= '/' ( (lv_toPath_7_0= RULE_ID ) ) )* otherlv_8= ';' ) ;
    public final EObject ruleMappingCopyEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_fromPath_1_0=null;
        Token otherlv_2=null;
        Token lv_fromPath_3_0=null;
        Token otherlv_4=null;
        Token lv_toPath_5_0=null;
        Token otherlv_6=null;
        Token lv_toPath_7_0=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalFlowService.g:1086:2: ( (otherlv_0= 'copy' ( (lv_fromPath_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_fromPath_3_0= RULE_ID ) ) )* otherlv_4= '->' ( (lv_toPath_5_0= RULE_ID ) ) (otherlv_6= '/' ( (lv_toPath_7_0= RULE_ID ) ) )* otherlv_8= ';' ) )
            // InternalFlowService.g:1087:2: (otherlv_0= 'copy' ( (lv_fromPath_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_fromPath_3_0= RULE_ID ) ) )* otherlv_4= '->' ( (lv_toPath_5_0= RULE_ID ) ) (otherlv_6= '/' ( (lv_toPath_7_0= RULE_ID ) ) )* otherlv_8= ';' )
            {
            // InternalFlowService.g:1087:2: (otherlv_0= 'copy' ( (lv_fromPath_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_fromPath_3_0= RULE_ID ) ) )* otherlv_4= '->' ( (lv_toPath_5_0= RULE_ID ) ) (otherlv_6= '/' ( (lv_toPath_7_0= RULE_ID ) ) )* otherlv_8= ';' )
            // InternalFlowService.g:1088:3: otherlv_0= 'copy' ( (lv_fromPath_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_fromPath_3_0= RULE_ID ) ) )* otherlv_4= '->' ( (lv_toPath_5_0= RULE_ID ) ) (otherlv_6= '/' ( (lv_toPath_7_0= RULE_ID ) ) )* otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getMappingCopyEntryAccess().getCopyKeyword_0());
            		
            // InternalFlowService.g:1092:3: ( (lv_fromPath_1_0= RULE_ID ) )
            // InternalFlowService.g:1093:4: (lv_fromPath_1_0= RULE_ID )
            {
            // InternalFlowService.g:1093:4: (lv_fromPath_1_0= RULE_ID )
            // InternalFlowService.g:1094:5: lv_fromPath_1_0= RULE_ID
            {
            lv_fromPath_1_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(lv_fromPath_1_0, grammarAccess.getMappingCopyEntryAccess().getFromPathIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMappingCopyEntryRule());
            					}
            					addWithLastConsumed(
            						current,
            						"fromPath",
            						lv_fromPath_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalFlowService.g:1110:3: (otherlv_2= '/' ( (lv_fromPath_3_0= RULE_ID ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==25) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalFlowService.g:1111:4: otherlv_2= '/' ( (lv_fromPath_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getMappingCopyEntryAccess().getSolidusKeyword_2_0());
            	    			
            	    // InternalFlowService.g:1115:4: ( (lv_fromPath_3_0= RULE_ID ) )
            	    // InternalFlowService.g:1116:5: (lv_fromPath_3_0= RULE_ID )
            	    {
            	    // InternalFlowService.g:1116:5: (lv_fromPath_3_0= RULE_ID )
            	    // InternalFlowService.g:1117:6: lv_fromPath_3_0= RULE_ID
            	    {
            	    lv_fromPath_3_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            	    						newLeafNode(lv_fromPath_3_0, grammarAccess.getMappingCopyEntryAccess().getFromPathIDTerminalRuleCall_2_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getMappingCopyEntryRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"fromPath",
            	    							lv_fromPath_3_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_4=(Token)match(input,30,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getMappingCopyEntryAccess().getHyphenMinusGreaterThanSignKeyword_3());
            		
            // InternalFlowService.g:1138:3: ( (lv_toPath_5_0= RULE_ID ) )
            // InternalFlowService.g:1139:4: (lv_toPath_5_0= RULE_ID )
            {
            // InternalFlowService.g:1139:4: (lv_toPath_5_0= RULE_ID )
            // InternalFlowService.g:1140:5: lv_toPath_5_0= RULE_ID
            {
            lv_toPath_5_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(lv_toPath_5_0, grammarAccess.getMappingCopyEntryAccess().getToPathIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMappingCopyEntryRule());
            					}
            					addWithLastConsumed(
            						current,
            						"toPath",
            						lv_toPath_5_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalFlowService.g:1156:3: (otherlv_6= '/' ( (lv_toPath_7_0= RULE_ID ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==25) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalFlowService.g:1157:4: otherlv_6= '/' ( (lv_toPath_7_0= RULE_ID ) )
            	    {
            	    otherlv_6=(Token)match(input,25,FOLLOW_4); 

            	    				newLeafNode(otherlv_6, grammarAccess.getMappingCopyEntryAccess().getSolidusKeyword_5_0());
            	    			
            	    // InternalFlowService.g:1161:4: ( (lv_toPath_7_0= RULE_ID ) )
            	    // InternalFlowService.g:1162:5: (lv_toPath_7_0= RULE_ID )
            	    {
            	    // InternalFlowService.g:1162:5: (lv_toPath_7_0= RULE_ID )
            	    // InternalFlowService.g:1163:6: lv_toPath_7_0= RULE_ID
            	    {
            	    lv_toPath_7_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            	    						newLeafNode(lv_toPath_7_0, grammarAccess.getMappingCopyEntryAccess().getToPathIDTerminalRuleCall_5_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getMappingCopyEntryRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"toPath",
            	    							lv_toPath_7_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_8=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getMappingCopyEntryAccess().getSemicolonKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMappingCopyEntry"


    // $ANTLR start "entryRuleMappingSetEntry"
    // InternalFlowService.g:1188:1: entryRuleMappingSetEntry returns [EObject current=null] : iv_ruleMappingSetEntry= ruleMappingSetEntry EOF ;
    public final EObject entryRuleMappingSetEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingSetEntry = null;


        try {
            // InternalFlowService.g:1188:56: (iv_ruleMappingSetEntry= ruleMappingSetEntry EOF )
            // InternalFlowService.g:1189:2: iv_ruleMappingSetEntry= ruleMappingSetEntry EOF
            {
             newCompositeNode(grammarAccess.getMappingSetEntryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMappingSetEntry=ruleMappingSetEntry();

            state._fsp--;

             current =iv_ruleMappingSetEntry; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMappingSetEntry"


    // $ANTLR start "ruleMappingSetEntry"
    // InternalFlowService.g:1195:1: ruleMappingSetEntry returns [EObject current=null] : (otherlv_0= 'set' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= '=' ( (lv_value_5_0= ruleValue ) ) otherlv_6= ';' ) ;
    public final EObject ruleMappingSetEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_path_1_0=null;
        Token otherlv_2=null;
        Token lv_path_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_value_5_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:1201:2: ( (otherlv_0= 'set' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= '=' ( (lv_value_5_0= ruleValue ) ) otherlv_6= ';' ) )
            // InternalFlowService.g:1202:2: (otherlv_0= 'set' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= '=' ( (lv_value_5_0= ruleValue ) ) otherlv_6= ';' )
            {
            // InternalFlowService.g:1202:2: (otherlv_0= 'set' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= '=' ( (lv_value_5_0= ruleValue ) ) otherlv_6= ';' )
            // InternalFlowService.g:1203:3: otherlv_0= 'set' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= '=' ( (lv_value_5_0= ruleValue ) ) otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getMappingSetEntryAccess().getSetKeyword_0());
            		
            // InternalFlowService.g:1207:3: ( (lv_path_1_0= RULE_ID ) )
            // InternalFlowService.g:1208:4: (lv_path_1_0= RULE_ID )
            {
            // InternalFlowService.g:1208:4: (lv_path_1_0= RULE_ID )
            // InternalFlowService.g:1209:5: lv_path_1_0= RULE_ID
            {
            lv_path_1_0=(Token)match(input,RULE_ID,FOLLOW_20); 

            					newLeafNode(lv_path_1_0, grammarAccess.getMappingSetEntryAccess().getPathIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMappingSetEntryRule());
            					}
            					addWithLastConsumed(
            						current,
            						"path",
            						lv_path_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalFlowService.g:1225:3: (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==25) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalFlowService.g:1226:4: otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getMappingSetEntryAccess().getSolidusKeyword_2_0());
            	    			
            	    // InternalFlowService.g:1230:4: ( (lv_path_3_0= RULE_ID ) )
            	    // InternalFlowService.g:1231:5: (lv_path_3_0= RULE_ID )
            	    {
            	    // InternalFlowService.g:1231:5: (lv_path_3_0= RULE_ID )
            	    // InternalFlowService.g:1232:6: lv_path_3_0= RULE_ID
            	    {
            	    lv_path_3_0=(Token)match(input,RULE_ID,FOLLOW_20); 

            	    						newLeafNode(lv_path_3_0, grammarAccess.getMappingSetEntryAccess().getPathIDTerminalRuleCall_2_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getMappingSetEntryRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"path",
            	    							lv_path_3_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_4=(Token)match(input,32,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getMappingSetEntryAccess().getEqualsSignKeyword_3());
            		
            // InternalFlowService.g:1253:3: ( (lv_value_5_0= ruleValue ) )
            // InternalFlowService.g:1254:4: (lv_value_5_0= ruleValue )
            {
            // InternalFlowService.g:1254:4: (lv_value_5_0= ruleValue )
            // InternalFlowService.g:1255:5: lv_value_5_0= ruleValue
            {

            					newCompositeNode(grammarAccess.getMappingSetEntryAccess().getValueValueParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_13);
            lv_value_5_0=ruleValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMappingSetEntryRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_5_0,
            						"com.webmethods.flow.FlowService.Value");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getMappingSetEntryAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMappingSetEntry"


    // $ANTLR start "entryRuleValue"
    // InternalFlowService.g:1280:1: entryRuleValue returns [String current=null] : iv_ruleValue= ruleValue EOF ;
    public final String entryRuleValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValue = null;


        try {
            // InternalFlowService.g:1280:45: (iv_ruleValue= ruleValue EOF )
            // InternalFlowService.g:1281:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalFlowService.g:1287:1: ruleValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_STRING_1=null;


        	enterRule();

        try {
            // InternalFlowService.g:1293:2: ( (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING ) )
            // InternalFlowService.g:1294:2: (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING )
            {
            // InternalFlowService.g:1294:2: (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_INT) ) {
                alt23=1;
            }
            else if ( (LA23_0==RULE_STRING) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalFlowService.g:1295:3: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_0);
                    		

                    			newLeafNode(this_INT_0, grammarAccess.getValueAccess().getINTTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalFlowService.g:1303:3: this_STRING_1= RULE_STRING
                    {
                    this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_1);
                    		

                    			newLeafNode(this_STRING_1, grammarAccess.getValueAccess().getSTRINGTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleInvokeProperty"
    // InternalFlowService.g:1314:1: entryRuleInvokeProperty returns [EObject current=null] : iv_ruleInvokeProperty= ruleInvokeProperty EOF ;
    public final EObject entryRuleInvokeProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvokeProperty = null;


        try {
            // InternalFlowService.g:1314:55: (iv_ruleInvokeProperty= ruleInvokeProperty EOF )
            // InternalFlowService.g:1315:2: iv_ruleInvokeProperty= ruleInvokeProperty EOF
            {
             newCompositeNode(grammarAccess.getInvokePropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInvokeProperty=ruleInvokeProperty();

            state._fsp--;

             current =iv_ruleInvokeProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInvokeProperty"


    // $ANTLR start "ruleInvokeProperty"
    // InternalFlowService.g:1321:1: ruleInvokeProperty returns [EObject current=null] : (this_ValidateInput_0= ruleValidateInput | this_ValidateOutput_1= ruleValidateOutput ) ;
    public final EObject ruleInvokeProperty() throws RecognitionException {
        EObject current = null;

        EObject this_ValidateInput_0 = null;

        EObject this_ValidateOutput_1 = null;



        	enterRule();

        try {
            // InternalFlowService.g:1327:2: ( (this_ValidateInput_0= ruleValidateInput | this_ValidateOutput_1= ruleValidateOutput ) )
            // InternalFlowService.g:1328:2: (this_ValidateInput_0= ruleValidateInput | this_ValidateOutput_1= ruleValidateOutput )
            {
            // InternalFlowService.g:1328:2: (this_ValidateInput_0= ruleValidateInput | this_ValidateOutput_1= ruleValidateOutput )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==33) ) {
                alt24=1;
            }
            else if ( (LA24_0==34) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalFlowService.g:1329:3: this_ValidateInput_0= ruleValidateInput
                    {

                    			newCompositeNode(grammarAccess.getInvokePropertyAccess().getValidateInputParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ValidateInput_0=ruleValidateInput();

                    state._fsp--;


                    			current = this_ValidateInput_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFlowService.g:1338:3: this_ValidateOutput_1= ruleValidateOutput
                    {

                    			newCompositeNode(grammarAccess.getInvokePropertyAccess().getValidateOutputParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ValidateOutput_1=ruleValidateOutput();

                    state._fsp--;


                    			current = this_ValidateOutput_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInvokeProperty"


    // $ANTLR start "entryRuleValidateInput"
    // InternalFlowService.g:1350:1: entryRuleValidateInput returns [EObject current=null] : iv_ruleValidateInput= ruleValidateInput EOF ;
    public final EObject entryRuleValidateInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValidateInput = null;


        try {
            // InternalFlowService.g:1350:54: (iv_ruleValidateInput= ruleValidateInput EOF )
            // InternalFlowService.g:1351:2: iv_ruleValidateInput= ruleValidateInput EOF
            {
             newCompositeNode(grammarAccess.getValidateInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValidateInput=ruleValidateInput();

            state._fsp--;

             current =iv_ruleValidateInput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValidateInput"


    // $ANTLR start "ruleValidateInput"
    // InternalFlowService.g:1357:1: ruleValidateInput returns [EObject current=null] : (otherlv_0= 'validateInput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) ) ) ;
    public final EObject ruleValidateInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalFlowService.g:1363:2: ( (otherlv_0= 'validateInput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) ) ) )
            // InternalFlowService.g:1364:2: (otherlv_0= 'validateInput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) ) )
            {
            // InternalFlowService.g:1364:2: (otherlv_0= 'validateInput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) ) )
            // InternalFlowService.g:1365:3: otherlv_0= 'validateInput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getValidateInputAccess().getValidateInputKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getValidateInputAccess().getColonKeyword_1());
            		
            // InternalFlowService.g:1373:3: ( (lv_value_2_0= RULE_BOOL ) )
            // InternalFlowService.g:1374:4: (lv_value_2_0= RULE_BOOL )
            {
            // InternalFlowService.g:1374:4: (lv_value_2_0= RULE_BOOL )
            // InternalFlowService.g:1375:5: lv_value_2_0= RULE_BOOL
            {
            lv_value_2_0=(Token)match(input,RULE_BOOL,FOLLOW_2); 

            					newLeafNode(lv_value_2_0, grammarAccess.getValidateInputAccess().getValueBOOLTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getValidateInputRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"com.webmethods.flow.FlowService.BOOL");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValidateInput"


    // $ANTLR start "entryRuleValidateOutput"
    // InternalFlowService.g:1395:1: entryRuleValidateOutput returns [EObject current=null] : iv_ruleValidateOutput= ruleValidateOutput EOF ;
    public final EObject entryRuleValidateOutput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValidateOutput = null;


        try {
            // InternalFlowService.g:1395:55: (iv_ruleValidateOutput= ruleValidateOutput EOF )
            // InternalFlowService.g:1396:2: iv_ruleValidateOutput= ruleValidateOutput EOF
            {
             newCompositeNode(grammarAccess.getValidateOutputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValidateOutput=ruleValidateOutput();

            state._fsp--;

             current =iv_ruleValidateOutput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValidateOutput"


    // $ANTLR start "ruleValidateOutput"
    // InternalFlowService.g:1402:1: ruleValidateOutput returns [EObject current=null] : (otherlv_0= 'validateOutput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) ) ) ;
    public final EObject ruleValidateOutput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalFlowService.g:1408:2: ( (otherlv_0= 'validateOutput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) ) ) )
            // InternalFlowService.g:1409:2: (otherlv_0= 'validateOutput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) ) )
            {
            // InternalFlowService.g:1409:2: (otherlv_0= 'validateOutput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) ) )
            // InternalFlowService.g:1410:3: otherlv_0= 'validateOutput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getValidateOutputAccess().getValidateOutputKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getValidateOutputAccess().getColonKeyword_1());
            		
            // InternalFlowService.g:1418:3: ( (lv_value_2_0= RULE_BOOL ) )
            // InternalFlowService.g:1419:4: (lv_value_2_0= RULE_BOOL )
            {
            // InternalFlowService.g:1419:4: (lv_value_2_0= RULE_BOOL )
            // InternalFlowService.g:1420:5: lv_value_2_0= RULE_BOOL
            {
            lv_value_2_0=(Token)match(input,RULE_BOOL,FOLLOW_2); 

            					newLeafNode(lv_value_2_0, grammarAccess.getValidateOutputAccess().getValueBOOLTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getValidateOutputRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"com.webmethods.flow.FlowService.BOOL");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValidateOutput"


    // $ANTLR start "entryRuleLoopStep"
    // InternalFlowService.g:1440:1: entryRuleLoopStep returns [EObject current=null] : iv_ruleLoopStep= ruleLoopStep EOF ;
    public final EObject entryRuleLoopStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopStep = null;


        try {
            // InternalFlowService.g:1440:49: (iv_ruleLoopStep= ruleLoopStep EOF )
            // InternalFlowService.g:1441:2: iv_ruleLoopStep= ruleLoopStep EOF
            {
             newCompositeNode(grammarAccess.getLoopStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLoopStep=ruleLoopStep();

            state._fsp--;

             current =iv_ruleLoopStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoopStep"


    // $ANTLR start "ruleLoopStep"
    // InternalFlowService.g:1447:1: ruleLoopStep returns [EObject current=null] : (otherlv_0= 'LOOP' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_loopProps_3_0= ruleLoopProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? ) ;
    public final EObject ruleLoopStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_properties_2_0 = null;

        EObject lv_loopProps_3_0 = null;

        EObject lv_steps_4_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:1453:2: ( (otherlv_0= 'LOOP' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_loopProps_3_0= ruleLoopProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? ) )
            // InternalFlowService.g:1454:2: (otherlv_0= 'LOOP' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_loopProps_3_0= ruleLoopProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? )
            {
            // InternalFlowService.g:1454:2: (otherlv_0= 'LOOP' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_loopProps_3_0= ruleLoopProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? )
            // InternalFlowService.g:1455:3: otherlv_0= 'LOOP' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_loopProps_3_0= ruleLoopProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )?
            {
            otherlv_0=(Token)match(input,35,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getLoopStepAccess().getLOOPKeyword_0());
            		
            // InternalFlowService.g:1459:3: (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_loopProps_3_0= ruleLoopProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==13) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalFlowService.g:1460:4: otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_loopProps_3_0= ruleLoopProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}'
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_24); 

                    				newLeafNode(otherlv_1, grammarAccess.getLoopStepAccess().getLeftCurlyBracketKeyword_1_0());
                    			
                    // InternalFlowService.g:1464:4: ( (lv_properties_2_0= ruleStepProperty ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==15||(LA25_0>=17 && LA25_0<=19)) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalFlowService.g:1465:5: (lv_properties_2_0= ruleStepProperty )
                    	    {
                    	    // InternalFlowService.g:1465:5: (lv_properties_2_0= ruleStepProperty )
                    	    // InternalFlowService.g:1466:6: lv_properties_2_0= ruleStepProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getLoopStepAccess().getPropertiesStepPropertyParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_24);
                    	    lv_properties_2_0=ruleStepProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getLoopStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"properties",
                    	    							lv_properties_2_0,
                    	    							"com.webmethods.flow.FlowService.StepProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    // InternalFlowService.g:1483:4: ( (lv_loopProps_3_0= ruleLoopProperty ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( ((LA26_0>=36 && LA26_0<=37)) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalFlowService.g:1484:5: (lv_loopProps_3_0= ruleLoopProperty )
                    	    {
                    	    // InternalFlowService.g:1484:5: (lv_loopProps_3_0= ruleLoopProperty )
                    	    // InternalFlowService.g:1485:6: lv_loopProps_3_0= ruleLoopProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getLoopStepAccess().getLoopPropsLoopPropertyParserRuleCall_1_2_0());
                    	    					
                    	    pushFollow(FOLLOW_25);
                    	    lv_loopProps_3_0=ruleLoopProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getLoopStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"loopProps",
                    	    							lv_loopProps_3_0,
                    	    							"com.webmethods.flow.FlowService.LoopProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    // InternalFlowService.g:1502:4: ( (lv_steps_4_0= ruleStep ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==21||LA27_0==26||LA27_0==35||LA27_0==38||LA27_0==40||LA27_0==45||LA27_0==48||LA27_0==52) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalFlowService.g:1503:5: (lv_steps_4_0= ruleStep )
                    	    {
                    	    // InternalFlowService.g:1503:5: (lv_steps_4_0= ruleStep )
                    	    // InternalFlowService.g:1504:6: lv_steps_4_0= ruleStep
                    	    {

                    	    						newCompositeNode(grammarAccess.getLoopStepAccess().getStepsStepParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_steps_4_0=ruleStep();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getLoopStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"steps",
                    	    							lv_steps_4_0,
                    	    							"com.webmethods.flow.FlowService.Step");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getLoopStepAccess().getRightCurlyBracketKeyword_1_4());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoopStep"


    // $ANTLR start "entryRuleLoopProperty"
    // InternalFlowService.g:1530:1: entryRuleLoopProperty returns [EObject current=null] : iv_ruleLoopProperty= ruleLoopProperty EOF ;
    public final EObject entryRuleLoopProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopProperty = null;


        try {
            // InternalFlowService.g:1530:53: (iv_ruleLoopProperty= ruleLoopProperty EOF )
            // InternalFlowService.g:1531:2: iv_ruleLoopProperty= ruleLoopProperty EOF
            {
             newCompositeNode(grammarAccess.getLoopPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLoopProperty=ruleLoopProperty();

            state._fsp--;

             current =iv_ruleLoopProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoopProperty"


    // $ANTLR start "ruleLoopProperty"
    // InternalFlowService.g:1537:1: ruleLoopProperty returns [EObject current=null] : ( (otherlv_0= 'inputArray' otherlv_1= ':' ( (lv_input_2_0= RULE_STRING ) ) ) | (otherlv_3= 'outputArray' otherlv_4= ':' ( (lv_output_5_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleLoopProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_input_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_output_5_0=null;


        	enterRule();

        try {
            // InternalFlowService.g:1543:2: ( ( (otherlv_0= 'inputArray' otherlv_1= ':' ( (lv_input_2_0= RULE_STRING ) ) ) | (otherlv_3= 'outputArray' otherlv_4= ':' ( (lv_output_5_0= RULE_STRING ) ) ) ) )
            // InternalFlowService.g:1544:2: ( (otherlv_0= 'inputArray' otherlv_1= ':' ( (lv_input_2_0= RULE_STRING ) ) ) | (otherlv_3= 'outputArray' otherlv_4= ':' ( (lv_output_5_0= RULE_STRING ) ) ) )
            {
            // InternalFlowService.g:1544:2: ( (otherlv_0= 'inputArray' otherlv_1= ':' ( (lv_input_2_0= RULE_STRING ) ) ) | (otherlv_3= 'outputArray' otherlv_4= ':' ( (lv_output_5_0= RULE_STRING ) ) ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==36) ) {
                alt29=1;
            }
            else if ( (LA29_0==37) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalFlowService.g:1545:3: (otherlv_0= 'inputArray' otherlv_1= ':' ( (lv_input_2_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:1545:3: (otherlv_0= 'inputArray' otherlv_1= ':' ( (lv_input_2_0= RULE_STRING ) ) )
                    // InternalFlowService.g:1546:4: otherlv_0= 'inputArray' otherlv_1= ':' ( (lv_input_2_0= RULE_STRING ) )
                    {
                    otherlv_0=(Token)match(input,36,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getLoopPropertyAccess().getInputArrayKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getLoopPropertyAccess().getColonKeyword_0_1());
                    			
                    // InternalFlowService.g:1554:4: ( (lv_input_2_0= RULE_STRING ) )
                    // InternalFlowService.g:1555:5: (lv_input_2_0= RULE_STRING )
                    {
                    // InternalFlowService.g:1555:5: (lv_input_2_0= RULE_STRING )
                    // InternalFlowService.g:1556:6: lv_input_2_0= RULE_STRING
                    {
                    lv_input_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_input_2_0, grammarAccess.getLoopPropertyAccess().getInputSTRINGTerminalRuleCall_0_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLoopPropertyRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"input",
                    							lv_input_2_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFlowService.g:1574:3: (otherlv_3= 'outputArray' otherlv_4= ':' ( (lv_output_5_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:1574:3: (otherlv_3= 'outputArray' otherlv_4= ':' ( (lv_output_5_0= RULE_STRING ) ) )
                    // InternalFlowService.g:1575:4: otherlv_3= 'outputArray' otherlv_4= ':' ( (lv_output_5_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,37,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getLoopPropertyAccess().getOutputArrayKeyword_1_0());
                    			
                    otherlv_4=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_4, grammarAccess.getLoopPropertyAccess().getColonKeyword_1_1());
                    			
                    // InternalFlowService.g:1583:4: ( (lv_output_5_0= RULE_STRING ) )
                    // InternalFlowService.g:1584:5: (lv_output_5_0= RULE_STRING )
                    {
                    // InternalFlowService.g:1584:5: (lv_output_5_0= RULE_STRING )
                    // InternalFlowService.g:1585:6: lv_output_5_0= RULE_STRING
                    {
                    lv_output_5_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_output_5_0, grammarAccess.getLoopPropertyAccess().getOutputSTRINGTerminalRuleCall_1_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLoopPropertyRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"output",
                    							lv_output_5_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoopProperty"


    // $ANTLR start "entryRuleSequenceStep"
    // InternalFlowService.g:1606:1: entryRuleSequenceStep returns [EObject current=null] : iv_ruleSequenceStep= ruleSequenceStep EOF ;
    public final EObject entryRuleSequenceStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceStep = null;


        try {
            // InternalFlowService.g:1606:53: (iv_ruleSequenceStep= ruleSequenceStep EOF )
            // InternalFlowService.g:1607:2: iv_ruleSequenceStep= ruleSequenceStep EOF
            {
             newCompositeNode(grammarAccess.getSequenceStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSequenceStep=ruleSequenceStep();

            state._fsp--;

             current =iv_ruleSequenceStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSequenceStep"


    // $ANTLR start "ruleSequenceStep"
    // InternalFlowService.g:1613:1: ruleSequenceStep returns [EObject current=null] : (otherlv_0= 'SEQUENCE' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_seqProps_3_0= ruleSequenceProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? ) ;
    public final EObject ruleSequenceStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_properties_2_0 = null;

        EObject lv_seqProps_3_0 = null;

        EObject lv_steps_4_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:1619:2: ( (otherlv_0= 'SEQUENCE' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_seqProps_3_0= ruleSequenceProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? ) )
            // InternalFlowService.g:1620:2: (otherlv_0= 'SEQUENCE' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_seqProps_3_0= ruleSequenceProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? )
            {
            // InternalFlowService.g:1620:2: (otherlv_0= 'SEQUENCE' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_seqProps_3_0= ruleSequenceProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? )
            // InternalFlowService.g:1621:3: otherlv_0= 'SEQUENCE' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_seqProps_3_0= ruleSequenceProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )?
            {
            otherlv_0=(Token)match(input,38,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getSequenceStepAccess().getSEQUENCEKeyword_0());
            		
            // InternalFlowService.g:1625:3: (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_seqProps_3_0= ruleSequenceProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==13) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalFlowService.g:1626:4: otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_seqProps_3_0= ruleSequenceProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}'
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_26); 

                    				newLeafNode(otherlv_1, grammarAccess.getSequenceStepAccess().getLeftCurlyBracketKeyword_1_0());
                    			
                    // InternalFlowService.g:1630:4: ( (lv_properties_2_0= ruleStepProperty ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==15||(LA30_0>=17 && LA30_0<=19)) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalFlowService.g:1631:5: (lv_properties_2_0= ruleStepProperty )
                    	    {
                    	    // InternalFlowService.g:1631:5: (lv_properties_2_0= ruleStepProperty )
                    	    // InternalFlowService.g:1632:6: lv_properties_2_0= ruleStepProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getSequenceStepAccess().getPropertiesStepPropertyParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_26);
                    	    lv_properties_2_0=ruleStepProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getSequenceStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"properties",
                    	    							lv_properties_2_0,
                    	    							"com.webmethods.flow.FlowService.StepProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    // InternalFlowService.g:1649:4: ( (lv_seqProps_3_0= ruleSequenceProperty ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==39) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalFlowService.g:1650:5: (lv_seqProps_3_0= ruleSequenceProperty )
                    	    {
                    	    // InternalFlowService.g:1650:5: (lv_seqProps_3_0= ruleSequenceProperty )
                    	    // InternalFlowService.g:1651:6: lv_seqProps_3_0= ruleSequenceProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getSequenceStepAccess().getSeqPropsSequencePropertyParserRuleCall_1_2_0());
                    	    					
                    	    pushFollow(FOLLOW_27);
                    	    lv_seqProps_3_0=ruleSequenceProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getSequenceStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"seqProps",
                    	    							lv_seqProps_3_0,
                    	    							"com.webmethods.flow.FlowService.SequenceProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    // InternalFlowService.g:1668:4: ( (lv_steps_4_0= ruleStep ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==21||LA32_0==26||LA32_0==35||LA32_0==38||LA32_0==40||LA32_0==45||LA32_0==48||LA32_0==52) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalFlowService.g:1669:5: (lv_steps_4_0= ruleStep )
                    	    {
                    	    // InternalFlowService.g:1669:5: (lv_steps_4_0= ruleStep )
                    	    // InternalFlowService.g:1670:6: lv_steps_4_0= ruleStep
                    	    {

                    	    						newCompositeNode(grammarAccess.getSequenceStepAccess().getStepsStepParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_steps_4_0=ruleStep();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getSequenceStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"steps",
                    	    							lv_steps_4_0,
                    	    							"com.webmethods.flow.FlowService.Step");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getSequenceStepAccess().getRightCurlyBracketKeyword_1_4());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSequenceStep"


    // $ANTLR start "entryRuleSequenceProperty"
    // InternalFlowService.g:1696:1: entryRuleSequenceProperty returns [EObject current=null] : iv_ruleSequenceProperty= ruleSequenceProperty EOF ;
    public final EObject entryRuleSequenceProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceProperty = null;


        try {
            // InternalFlowService.g:1696:57: (iv_ruleSequenceProperty= ruleSequenceProperty EOF )
            // InternalFlowService.g:1697:2: iv_ruleSequenceProperty= ruleSequenceProperty EOF
            {
             newCompositeNode(grammarAccess.getSequencePropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSequenceProperty=ruleSequenceProperty();

            state._fsp--;

             current =iv_ruleSequenceProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSequenceProperty"


    // $ANTLR start "ruleSequenceProperty"
    // InternalFlowService.g:1703:1: ruleSequenceProperty returns [EObject current=null] : (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleSequenceProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalFlowService.g:1709:2: ( (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // InternalFlowService.g:1710:2: (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // InternalFlowService.g:1710:2: (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            // InternalFlowService.g:1711:3: otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,39,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getSequencePropertyAccess().getExitOnKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getSequencePropertyAccess().getColonKeyword_1());
            		
            // InternalFlowService.g:1719:3: ( (lv_value_2_0= RULE_STRING ) )
            // InternalFlowService.g:1720:4: (lv_value_2_0= RULE_STRING )
            {
            // InternalFlowService.g:1720:4: (lv_value_2_0= RULE_STRING )
            // InternalFlowService.g:1721:5: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_2_0, grammarAccess.getSequencePropertyAccess().getValueSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSequencePropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSequenceProperty"


    // $ANTLR start "entryRuleTryStep"
    // InternalFlowService.g:1741:1: entryRuleTryStep returns [EObject current=null] : iv_ruleTryStep= ruleTryStep EOF ;
    public final EObject entryRuleTryStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTryStep = null;


        try {
            // InternalFlowService.g:1741:48: (iv_ruleTryStep= ruleTryStep EOF )
            // InternalFlowService.g:1742:2: iv_ruleTryStep= ruleTryStep EOF
            {
             newCompositeNode(grammarAccess.getTryStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTryStep=ruleTryStep();

            state._fsp--;

             current =iv_ruleTryStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTryStep"


    // $ANTLR start "ruleTryStep"
    // InternalFlowService.g:1748:1: ruleTryStep returns [EObject current=null] : (otherlv_0= 'TRY' otherlv_1= '{' ( ( (lv_properties_2_0= ruleStepProperty ) ) | ( (lv_tryProps_3_0= ruleTryProperty ) ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' ( (lv_catches_6_0= ruleCatchStep ) )* ( (lv_finallyBlock_7_0= ruleFinallyStep ) )? ) ;
    public final EObject ruleTryStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_properties_2_0 = null;

        EObject lv_tryProps_3_0 = null;

        EObject lv_steps_4_0 = null;

        EObject lv_catches_6_0 = null;

        EObject lv_finallyBlock_7_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:1754:2: ( (otherlv_0= 'TRY' otherlv_1= '{' ( ( (lv_properties_2_0= ruleStepProperty ) ) | ( (lv_tryProps_3_0= ruleTryProperty ) ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' ( (lv_catches_6_0= ruleCatchStep ) )* ( (lv_finallyBlock_7_0= ruleFinallyStep ) )? ) )
            // InternalFlowService.g:1755:2: (otherlv_0= 'TRY' otherlv_1= '{' ( ( (lv_properties_2_0= ruleStepProperty ) ) | ( (lv_tryProps_3_0= ruleTryProperty ) ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' ( (lv_catches_6_0= ruleCatchStep ) )* ( (lv_finallyBlock_7_0= ruleFinallyStep ) )? )
            {
            // InternalFlowService.g:1755:2: (otherlv_0= 'TRY' otherlv_1= '{' ( ( (lv_properties_2_0= ruleStepProperty ) ) | ( (lv_tryProps_3_0= ruleTryProperty ) ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' ( (lv_catches_6_0= ruleCatchStep ) )* ( (lv_finallyBlock_7_0= ruleFinallyStep ) )? )
            // InternalFlowService.g:1756:3: otherlv_0= 'TRY' otherlv_1= '{' ( ( (lv_properties_2_0= ruleStepProperty ) ) | ( (lv_tryProps_3_0= ruleTryProperty ) ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' ( (lv_catches_6_0= ruleCatchStep ) )* ( (lv_finallyBlock_7_0= ruleFinallyStep ) )?
            {
            otherlv_0=(Token)match(input,40,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getTryStepAccess().getTRYKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_26); 

            			newLeafNode(otherlv_1, grammarAccess.getTryStepAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalFlowService.g:1764:3: ( ( (lv_properties_2_0= ruleStepProperty ) ) | ( (lv_tryProps_3_0= ruleTryProperty ) ) )*
            loop34:
            do {
                int alt34=3;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==15||(LA34_0>=17 && LA34_0<=19)) ) {
                    alt34=1;
                }
                else if ( (LA34_0==39) ) {
                    alt34=2;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalFlowService.g:1765:4: ( (lv_properties_2_0= ruleStepProperty ) )
            	    {
            	    // InternalFlowService.g:1765:4: ( (lv_properties_2_0= ruleStepProperty ) )
            	    // InternalFlowService.g:1766:5: (lv_properties_2_0= ruleStepProperty )
            	    {
            	    // InternalFlowService.g:1766:5: (lv_properties_2_0= ruleStepProperty )
            	    // InternalFlowService.g:1767:6: lv_properties_2_0= ruleStepProperty
            	    {

            	    						newCompositeNode(grammarAccess.getTryStepAccess().getPropertiesStepPropertyParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_26);
            	    lv_properties_2_0=ruleStepProperty();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTryStepRule());
            	    						}
            	    						add(
            	    							current,
            	    							"properties",
            	    							lv_properties_2_0,
            	    							"com.webmethods.flow.FlowService.StepProperty");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalFlowService.g:1785:4: ( (lv_tryProps_3_0= ruleTryProperty ) )
            	    {
            	    // InternalFlowService.g:1785:4: ( (lv_tryProps_3_0= ruleTryProperty ) )
            	    // InternalFlowService.g:1786:5: (lv_tryProps_3_0= ruleTryProperty )
            	    {
            	    // InternalFlowService.g:1786:5: (lv_tryProps_3_0= ruleTryProperty )
            	    // InternalFlowService.g:1787:6: lv_tryProps_3_0= ruleTryProperty
            	    {

            	    						newCompositeNode(grammarAccess.getTryStepAccess().getTryPropsTryPropertyParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_26);
            	    lv_tryProps_3_0=ruleTryProperty();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTryStepRule());
            	    						}
            	    						add(
            	    							current,
            	    							"tryProps",
            	    							lv_tryProps_3_0,
            	    							"com.webmethods.flow.FlowService.TryProperty");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            // InternalFlowService.g:1805:3: ( (lv_steps_4_0= ruleStep ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==21||LA35_0==26||LA35_0==35||LA35_0==38||LA35_0==40||LA35_0==45||LA35_0==48||LA35_0==52) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalFlowService.g:1806:4: (lv_steps_4_0= ruleStep )
            	    {
            	    // InternalFlowService.g:1806:4: (lv_steps_4_0= ruleStep )
            	    // InternalFlowService.g:1807:5: lv_steps_4_0= ruleStep
            	    {

            	    					newCompositeNode(grammarAccess.getTryStepAccess().getStepsStepParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_steps_4_0=ruleStep();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTryStepRule());
            	    					}
            	    					add(
            	    						current,
            	    						"steps",
            	    						lv_steps_4_0,
            	    						"com.webmethods.flow.FlowService.Step");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            otherlv_5=(Token)match(input,14,FOLLOW_28); 

            			newLeafNode(otherlv_5, grammarAccess.getTryStepAccess().getRightCurlyBracketKeyword_4());
            		
            // InternalFlowService.g:1828:3: ( (lv_catches_6_0= ruleCatchStep ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==41) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalFlowService.g:1829:4: (lv_catches_6_0= ruleCatchStep )
            	    {
            	    // InternalFlowService.g:1829:4: (lv_catches_6_0= ruleCatchStep )
            	    // InternalFlowService.g:1830:5: lv_catches_6_0= ruleCatchStep
            	    {

            	    					newCompositeNode(grammarAccess.getTryStepAccess().getCatchesCatchStepParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_28);
            	    lv_catches_6_0=ruleCatchStep();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTryStepRule());
            	    					}
            	    					add(
            	    						current,
            	    						"catches",
            	    						lv_catches_6_0,
            	    						"com.webmethods.flow.FlowService.CatchStep");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            // InternalFlowService.g:1847:3: ( (lv_finallyBlock_7_0= ruleFinallyStep ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==44) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalFlowService.g:1848:4: (lv_finallyBlock_7_0= ruleFinallyStep )
                    {
                    // InternalFlowService.g:1848:4: (lv_finallyBlock_7_0= ruleFinallyStep )
                    // InternalFlowService.g:1849:5: lv_finallyBlock_7_0= ruleFinallyStep
                    {

                    					newCompositeNode(grammarAccess.getTryStepAccess().getFinallyBlockFinallyStepParserRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_finallyBlock_7_0=ruleFinallyStep();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTryStepRule());
                    					}
                    					set(
                    						current,
                    						"finallyBlock",
                    						lv_finallyBlock_7_0,
                    						"com.webmethods.flow.FlowService.FinallyStep");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTryStep"


    // $ANTLR start "entryRuleTryProperty"
    // InternalFlowService.g:1870:1: entryRuleTryProperty returns [EObject current=null] : iv_ruleTryProperty= ruleTryProperty EOF ;
    public final EObject entryRuleTryProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTryProperty = null;


        try {
            // InternalFlowService.g:1870:52: (iv_ruleTryProperty= ruleTryProperty EOF )
            // InternalFlowService.g:1871:2: iv_ruleTryProperty= ruleTryProperty EOF
            {
             newCompositeNode(grammarAccess.getTryPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTryProperty=ruleTryProperty();

            state._fsp--;

             current =iv_ruleTryProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTryProperty"


    // $ANTLR start "ruleTryProperty"
    // InternalFlowService.g:1877:1: ruleTryProperty returns [EObject current=null] : (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleTryProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalFlowService.g:1883:2: ( (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // InternalFlowService.g:1884:2: (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // InternalFlowService.g:1884:2: (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            // InternalFlowService.g:1885:3: otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,39,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getTryPropertyAccess().getExitOnKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getTryPropertyAccess().getColonKeyword_1());
            		
            // InternalFlowService.g:1893:3: ( (lv_value_2_0= RULE_STRING ) )
            // InternalFlowService.g:1894:4: (lv_value_2_0= RULE_STRING )
            {
            // InternalFlowService.g:1894:4: (lv_value_2_0= RULE_STRING )
            // InternalFlowService.g:1895:5: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_2_0, grammarAccess.getTryPropertyAccess().getValueSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTryPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTryProperty"


    // $ANTLR start "entryRuleCatchStep"
    // InternalFlowService.g:1915:1: entryRuleCatchStep returns [EObject current=null] : iv_ruleCatchStep= ruleCatchStep EOF ;
    public final EObject entryRuleCatchStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCatchStep = null;


        try {
            // InternalFlowService.g:1915:50: (iv_ruleCatchStep= ruleCatchStep EOF )
            // InternalFlowService.g:1916:2: iv_ruleCatchStep= ruleCatchStep EOF
            {
             newCompositeNode(grammarAccess.getCatchStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCatchStep=ruleCatchStep();

            state._fsp--;

             current =iv_ruleCatchStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCatchStep"


    // $ANTLR start "ruleCatchStep"
    // InternalFlowService.g:1922:1: ruleCatchStep returns [EObject current=null] : (otherlv_0= 'CATCH' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_catchProps_3_0= ruleCatchProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? ) ;
    public final EObject ruleCatchStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_properties_2_0 = null;

        EObject lv_catchProps_3_0 = null;

        EObject lv_steps_4_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:1928:2: ( (otherlv_0= 'CATCH' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_catchProps_3_0= ruleCatchProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? ) )
            // InternalFlowService.g:1929:2: (otherlv_0= 'CATCH' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_catchProps_3_0= ruleCatchProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? )
            {
            // InternalFlowService.g:1929:2: (otherlv_0= 'CATCH' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_catchProps_3_0= ruleCatchProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? )
            // InternalFlowService.g:1930:3: otherlv_0= 'CATCH' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_catchProps_3_0= ruleCatchProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )?
            {
            otherlv_0=(Token)match(input,41,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getCatchStepAccess().getCATCHKeyword_0());
            		
            // InternalFlowService.g:1934:3: (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_catchProps_3_0= ruleCatchProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==13) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalFlowService.g:1935:4: otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_catchProps_3_0= ruleCatchProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}'
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_29); 

                    				newLeafNode(otherlv_1, grammarAccess.getCatchStepAccess().getLeftCurlyBracketKeyword_1_0());
                    			
                    // InternalFlowService.g:1939:4: ( (lv_properties_2_0= ruleStepProperty ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==15||(LA38_0>=17 && LA38_0<=19)) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalFlowService.g:1940:5: (lv_properties_2_0= ruleStepProperty )
                    	    {
                    	    // InternalFlowService.g:1940:5: (lv_properties_2_0= ruleStepProperty )
                    	    // InternalFlowService.g:1941:6: lv_properties_2_0= ruleStepProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getCatchStepAccess().getPropertiesStepPropertyParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_29);
                    	    lv_properties_2_0=ruleStepProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getCatchStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"properties",
                    	    							lv_properties_2_0,
                    	    							"com.webmethods.flow.FlowService.StepProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);

                    // InternalFlowService.g:1958:4: ( (lv_catchProps_3_0= ruleCatchProperty ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==39||(LA39_0>=42 && LA39_0<=43)) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalFlowService.g:1959:5: (lv_catchProps_3_0= ruleCatchProperty )
                    	    {
                    	    // InternalFlowService.g:1959:5: (lv_catchProps_3_0= ruleCatchProperty )
                    	    // InternalFlowService.g:1960:6: lv_catchProps_3_0= ruleCatchProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getCatchStepAccess().getCatchPropsCatchPropertyParserRuleCall_1_2_0());
                    	    					
                    	    pushFollow(FOLLOW_30);
                    	    lv_catchProps_3_0=ruleCatchProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getCatchStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"catchProps",
                    	    							lv_catchProps_3_0,
                    	    							"com.webmethods.flow.FlowService.CatchProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);

                    // InternalFlowService.g:1977:4: ( (lv_steps_4_0= ruleStep ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==21||LA40_0==26||LA40_0==35||LA40_0==38||LA40_0==40||LA40_0==45||LA40_0==48||LA40_0==52) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalFlowService.g:1978:5: (lv_steps_4_0= ruleStep )
                    	    {
                    	    // InternalFlowService.g:1978:5: (lv_steps_4_0= ruleStep )
                    	    // InternalFlowService.g:1979:6: lv_steps_4_0= ruleStep
                    	    {

                    	    						newCompositeNode(grammarAccess.getCatchStepAccess().getStepsStepParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_steps_4_0=ruleStep();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getCatchStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"steps",
                    	    							lv_steps_4_0,
                    	    							"com.webmethods.flow.FlowService.Step");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getCatchStepAccess().getRightCurlyBracketKeyword_1_4());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCatchStep"


    // $ANTLR start "entryRuleCatchProperty"
    // InternalFlowService.g:2005:1: entryRuleCatchProperty returns [EObject current=null] : iv_ruleCatchProperty= ruleCatchProperty EOF ;
    public final EObject entryRuleCatchProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCatchProperty = null;


        try {
            // InternalFlowService.g:2005:54: (iv_ruleCatchProperty= ruleCatchProperty EOF )
            // InternalFlowService.g:2006:2: iv_ruleCatchProperty= ruleCatchProperty EOF
            {
             newCompositeNode(grammarAccess.getCatchPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCatchProperty=ruleCatchProperty();

            state._fsp--;

             current =iv_ruleCatchProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCatchProperty"


    // $ANTLR start "ruleCatchProperty"
    // InternalFlowService.g:2012:1: ruleCatchProperty returns [EObject current=null] : ( (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_exit_2_0= RULE_STRING ) ) ) | (otherlv_3= 'failures' otherlv_4= ':' ( (lv_failures_5_0= RULE_STRING ) ) ) | (otherlv_6= 'selection' otherlv_7= ':' ( (lv_selection_8_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleCatchProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_exit_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_failures_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_selection_8_0=null;


        	enterRule();

        try {
            // InternalFlowService.g:2018:2: ( ( (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_exit_2_0= RULE_STRING ) ) ) | (otherlv_3= 'failures' otherlv_4= ':' ( (lv_failures_5_0= RULE_STRING ) ) ) | (otherlv_6= 'selection' otherlv_7= ':' ( (lv_selection_8_0= RULE_STRING ) ) ) ) )
            // InternalFlowService.g:2019:2: ( (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_exit_2_0= RULE_STRING ) ) ) | (otherlv_3= 'failures' otherlv_4= ':' ( (lv_failures_5_0= RULE_STRING ) ) ) | (otherlv_6= 'selection' otherlv_7= ':' ( (lv_selection_8_0= RULE_STRING ) ) ) )
            {
            // InternalFlowService.g:2019:2: ( (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_exit_2_0= RULE_STRING ) ) ) | (otherlv_3= 'failures' otherlv_4= ':' ( (lv_failures_5_0= RULE_STRING ) ) ) | (otherlv_6= 'selection' otherlv_7= ':' ( (lv_selection_8_0= RULE_STRING ) ) ) )
            int alt42=3;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt42=1;
                }
                break;
            case 42:
                {
                alt42=2;
                }
                break;
            case 43:
                {
                alt42=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalFlowService.g:2020:3: (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_exit_2_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2020:3: (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_exit_2_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2021:4: otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_exit_2_0= RULE_STRING ) )
                    {
                    otherlv_0=(Token)match(input,39,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getCatchPropertyAccess().getExitOnKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getCatchPropertyAccess().getColonKeyword_0_1());
                    			
                    // InternalFlowService.g:2029:4: ( (lv_exit_2_0= RULE_STRING ) )
                    // InternalFlowService.g:2030:5: (lv_exit_2_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2030:5: (lv_exit_2_0= RULE_STRING )
                    // InternalFlowService.g:2031:6: lv_exit_2_0= RULE_STRING
                    {
                    lv_exit_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_exit_2_0, grammarAccess.getCatchPropertyAccess().getExitSTRINGTerminalRuleCall_0_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCatchPropertyRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"exit",
                    							lv_exit_2_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFlowService.g:2049:3: (otherlv_3= 'failures' otherlv_4= ':' ( (lv_failures_5_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2049:3: (otherlv_3= 'failures' otherlv_4= ':' ( (lv_failures_5_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2050:4: otherlv_3= 'failures' otherlv_4= ':' ( (lv_failures_5_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,42,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getCatchPropertyAccess().getFailuresKeyword_1_0());
                    			
                    otherlv_4=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_4, grammarAccess.getCatchPropertyAccess().getColonKeyword_1_1());
                    			
                    // InternalFlowService.g:2058:4: ( (lv_failures_5_0= RULE_STRING ) )
                    // InternalFlowService.g:2059:5: (lv_failures_5_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2059:5: (lv_failures_5_0= RULE_STRING )
                    // InternalFlowService.g:2060:6: lv_failures_5_0= RULE_STRING
                    {
                    lv_failures_5_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_failures_5_0, grammarAccess.getCatchPropertyAccess().getFailuresSTRINGTerminalRuleCall_1_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCatchPropertyRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"failures",
                    							lv_failures_5_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalFlowService.g:2078:3: (otherlv_6= 'selection' otherlv_7= ':' ( (lv_selection_8_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2078:3: (otherlv_6= 'selection' otherlv_7= ':' ( (lv_selection_8_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2079:4: otherlv_6= 'selection' otherlv_7= ':' ( (lv_selection_8_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,43,FOLLOW_7); 

                    				newLeafNode(otherlv_6, grammarAccess.getCatchPropertyAccess().getSelectionKeyword_2_0());
                    			
                    otherlv_7=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_7, grammarAccess.getCatchPropertyAccess().getColonKeyword_2_1());
                    			
                    // InternalFlowService.g:2087:4: ( (lv_selection_8_0= RULE_STRING ) )
                    // InternalFlowService.g:2088:5: (lv_selection_8_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2088:5: (lv_selection_8_0= RULE_STRING )
                    // InternalFlowService.g:2089:6: lv_selection_8_0= RULE_STRING
                    {
                    lv_selection_8_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_selection_8_0, grammarAccess.getCatchPropertyAccess().getSelectionSTRINGTerminalRuleCall_2_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCatchPropertyRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"selection",
                    							lv_selection_8_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCatchProperty"


    // $ANTLR start "entryRuleFinallyStep"
    // InternalFlowService.g:2110:1: entryRuleFinallyStep returns [EObject current=null] : iv_ruleFinallyStep= ruleFinallyStep EOF ;
    public final EObject entryRuleFinallyStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFinallyStep = null;


        try {
            // InternalFlowService.g:2110:52: (iv_ruleFinallyStep= ruleFinallyStep EOF )
            // InternalFlowService.g:2111:2: iv_ruleFinallyStep= ruleFinallyStep EOF
            {
             newCompositeNode(grammarAccess.getFinallyStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFinallyStep=ruleFinallyStep();

            state._fsp--;

             current =iv_ruleFinallyStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFinallyStep"


    // $ANTLR start "ruleFinallyStep"
    // InternalFlowService.g:2117:1: ruleFinallyStep returns [EObject current=null] : (otherlv_0= 'FINALLY' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_finalProps_3_0= ruleFinallyProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? ) ;
    public final EObject ruleFinallyStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_properties_2_0 = null;

        EObject lv_finalProps_3_0 = null;

        EObject lv_steps_4_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:2123:2: ( (otherlv_0= 'FINALLY' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_finalProps_3_0= ruleFinallyProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? ) )
            // InternalFlowService.g:2124:2: (otherlv_0= 'FINALLY' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_finalProps_3_0= ruleFinallyProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? )
            {
            // InternalFlowService.g:2124:2: (otherlv_0= 'FINALLY' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_finalProps_3_0= ruleFinallyProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? )
            // InternalFlowService.g:2125:3: otherlv_0= 'FINALLY' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_finalProps_3_0= ruleFinallyProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )?
            {
            otherlv_0=(Token)match(input,44,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getFinallyStepAccess().getFINALLYKeyword_0());
            		
            // InternalFlowService.g:2129:3: (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_finalProps_3_0= ruleFinallyProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==13) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalFlowService.g:2130:4: otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_finalProps_3_0= ruleFinallyProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}'
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_26); 

                    				newLeafNode(otherlv_1, grammarAccess.getFinallyStepAccess().getLeftCurlyBracketKeyword_1_0());
                    			
                    // InternalFlowService.g:2134:4: ( (lv_properties_2_0= ruleStepProperty ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==15||(LA43_0>=17 && LA43_0<=19)) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // InternalFlowService.g:2135:5: (lv_properties_2_0= ruleStepProperty )
                    	    {
                    	    // InternalFlowService.g:2135:5: (lv_properties_2_0= ruleStepProperty )
                    	    // InternalFlowService.g:2136:6: lv_properties_2_0= ruleStepProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getFinallyStepAccess().getPropertiesStepPropertyParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_26);
                    	    lv_properties_2_0=ruleStepProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getFinallyStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"properties",
                    	    							lv_properties_2_0,
                    	    							"com.webmethods.flow.FlowService.StepProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);

                    // InternalFlowService.g:2153:4: ( (lv_finalProps_3_0= ruleFinallyProperty ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==39) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // InternalFlowService.g:2154:5: (lv_finalProps_3_0= ruleFinallyProperty )
                    	    {
                    	    // InternalFlowService.g:2154:5: (lv_finalProps_3_0= ruleFinallyProperty )
                    	    // InternalFlowService.g:2155:6: lv_finalProps_3_0= ruleFinallyProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getFinallyStepAccess().getFinalPropsFinallyPropertyParserRuleCall_1_2_0());
                    	    					
                    	    pushFollow(FOLLOW_27);
                    	    lv_finalProps_3_0=ruleFinallyProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getFinallyStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"finalProps",
                    	    							lv_finalProps_3_0,
                    	    							"com.webmethods.flow.FlowService.FinallyProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);

                    // InternalFlowService.g:2172:4: ( (lv_steps_4_0= ruleStep ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==21||LA45_0==26||LA45_0==35||LA45_0==38||LA45_0==40||LA45_0==45||LA45_0==48||LA45_0==52) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // InternalFlowService.g:2173:5: (lv_steps_4_0= ruleStep )
                    	    {
                    	    // InternalFlowService.g:2173:5: (lv_steps_4_0= ruleStep )
                    	    // InternalFlowService.g:2174:6: lv_steps_4_0= ruleStep
                    	    {

                    	    						newCompositeNode(grammarAccess.getFinallyStepAccess().getStepsStepParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_steps_4_0=ruleStep();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getFinallyStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"steps",
                    	    							lv_steps_4_0,
                    	    							"com.webmethods.flow.FlowService.Step");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getFinallyStepAccess().getRightCurlyBracketKeyword_1_4());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFinallyStep"


    // $ANTLR start "entryRuleFinallyProperty"
    // InternalFlowService.g:2200:1: entryRuleFinallyProperty returns [EObject current=null] : iv_ruleFinallyProperty= ruleFinallyProperty EOF ;
    public final EObject entryRuleFinallyProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFinallyProperty = null;


        try {
            // InternalFlowService.g:2200:56: (iv_ruleFinallyProperty= ruleFinallyProperty EOF )
            // InternalFlowService.g:2201:2: iv_ruleFinallyProperty= ruleFinallyProperty EOF
            {
             newCompositeNode(grammarAccess.getFinallyPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFinallyProperty=ruleFinallyProperty();

            state._fsp--;

             current =iv_ruleFinallyProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFinallyProperty"


    // $ANTLR start "ruleFinallyProperty"
    // InternalFlowService.g:2207:1: ruleFinallyProperty returns [EObject current=null] : (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleFinallyProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalFlowService.g:2213:2: ( (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // InternalFlowService.g:2214:2: (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // InternalFlowService.g:2214:2: (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            // InternalFlowService.g:2215:3: otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,39,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getFinallyPropertyAccess().getExitOnKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getFinallyPropertyAccess().getColonKeyword_1());
            		
            // InternalFlowService.g:2223:3: ( (lv_value_2_0= RULE_STRING ) )
            // InternalFlowService.g:2224:4: (lv_value_2_0= RULE_STRING )
            {
            // InternalFlowService.g:2224:4: (lv_value_2_0= RULE_STRING )
            // InternalFlowService.g:2225:5: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_2_0, grammarAccess.getFinallyPropertyAccess().getValueSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFinallyPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFinallyProperty"


    // $ANTLR start "entryRuleBranchStep"
    // InternalFlowService.g:2245:1: entryRuleBranchStep returns [EObject current=null] : iv_ruleBranchStep= ruleBranchStep EOF ;
    public final EObject entryRuleBranchStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBranchStep = null;


        try {
            // InternalFlowService.g:2245:51: (iv_ruleBranchStep= ruleBranchStep EOF )
            // InternalFlowService.g:2246:2: iv_ruleBranchStep= ruleBranchStep EOF
            {
             newCompositeNode(grammarAccess.getBranchStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBranchStep=ruleBranchStep();

            state._fsp--;

             current =iv_ruleBranchStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBranchStep"


    // $ANTLR start "ruleBranchStep"
    // InternalFlowService.g:2252:1: ruleBranchStep returns [EObject current=null] : (otherlv_0= 'BRANCH' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_branchProps_3_0= ruleBranchProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? ) ;
    public final EObject ruleBranchStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_properties_2_0 = null;

        EObject lv_branchProps_3_0 = null;

        EObject lv_steps_4_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:2258:2: ( (otherlv_0= 'BRANCH' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_branchProps_3_0= ruleBranchProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? ) )
            // InternalFlowService.g:2259:2: (otherlv_0= 'BRANCH' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_branchProps_3_0= ruleBranchProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? )
            {
            // InternalFlowService.g:2259:2: (otherlv_0= 'BRANCH' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_branchProps_3_0= ruleBranchProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? )
            // InternalFlowService.g:2260:3: otherlv_0= 'BRANCH' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_branchProps_3_0= ruleBranchProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )?
            {
            otherlv_0=(Token)match(input,45,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getBranchStepAccess().getBRANCHKeyword_0());
            		
            // InternalFlowService.g:2264:3: (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_branchProps_3_0= ruleBranchProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==13) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalFlowService.g:2265:4: otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_branchProps_3_0= ruleBranchProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}'
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_31); 

                    				newLeafNode(otherlv_1, grammarAccess.getBranchStepAccess().getLeftCurlyBracketKeyword_1_0());
                    			
                    // InternalFlowService.g:2269:4: ( (lv_properties_2_0= ruleStepProperty ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==15||(LA47_0>=17 && LA47_0<=19)) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalFlowService.g:2270:5: (lv_properties_2_0= ruleStepProperty )
                    	    {
                    	    // InternalFlowService.g:2270:5: (lv_properties_2_0= ruleStepProperty )
                    	    // InternalFlowService.g:2271:6: lv_properties_2_0= ruleStepProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getBranchStepAccess().getPropertiesStepPropertyParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_31);
                    	    lv_properties_2_0=ruleStepProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getBranchStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"properties",
                    	    							lv_properties_2_0,
                    	    							"com.webmethods.flow.FlowService.StepProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);

                    // InternalFlowService.g:2288:4: ( (lv_branchProps_3_0= ruleBranchProperty ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( ((LA48_0>=46 && LA48_0<=47)) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // InternalFlowService.g:2289:5: (lv_branchProps_3_0= ruleBranchProperty )
                    	    {
                    	    // InternalFlowService.g:2289:5: (lv_branchProps_3_0= ruleBranchProperty )
                    	    // InternalFlowService.g:2290:6: lv_branchProps_3_0= ruleBranchProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getBranchStepAccess().getBranchPropsBranchPropertyParserRuleCall_1_2_0());
                    	    					
                    	    pushFollow(FOLLOW_32);
                    	    lv_branchProps_3_0=ruleBranchProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getBranchStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"branchProps",
                    	    							lv_branchProps_3_0,
                    	    							"com.webmethods.flow.FlowService.BranchProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);

                    // InternalFlowService.g:2307:4: ( (lv_steps_4_0= ruleStep ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==21||LA49_0==26||LA49_0==35||LA49_0==38||LA49_0==40||LA49_0==45||LA49_0==48||LA49_0==52) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // InternalFlowService.g:2308:5: (lv_steps_4_0= ruleStep )
                    	    {
                    	    // InternalFlowService.g:2308:5: (lv_steps_4_0= ruleStep )
                    	    // InternalFlowService.g:2309:6: lv_steps_4_0= ruleStep
                    	    {

                    	    						newCompositeNode(grammarAccess.getBranchStepAccess().getStepsStepParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_steps_4_0=ruleStep();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getBranchStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"steps",
                    	    							lv_steps_4_0,
                    	    							"com.webmethods.flow.FlowService.Step");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop49;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getBranchStepAccess().getRightCurlyBracketKeyword_1_4());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBranchStep"


    // $ANTLR start "entryRuleBranchProperty"
    // InternalFlowService.g:2335:1: entryRuleBranchProperty returns [EObject current=null] : iv_ruleBranchProperty= ruleBranchProperty EOF ;
    public final EObject entryRuleBranchProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBranchProperty = null;


        try {
            // InternalFlowService.g:2335:55: (iv_ruleBranchProperty= ruleBranchProperty EOF )
            // InternalFlowService.g:2336:2: iv_ruleBranchProperty= ruleBranchProperty EOF
            {
             newCompositeNode(grammarAccess.getBranchPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBranchProperty=ruleBranchProperty();

            state._fsp--;

             current =iv_ruleBranchProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBranchProperty"


    // $ANTLR start "ruleBranchProperty"
    // InternalFlowService.g:2342:1: ruleBranchProperty returns [EObject current=null] : ( (otherlv_0= 'switch' otherlv_1= ':' ( (lv_switch_2_0= RULE_STRING ) ) ) | (otherlv_3= 'evaluateLabels' otherlv_4= ':' ( (lv_eval_5_0= RULE_BOOL ) ) ) ) ;
    public final EObject ruleBranchProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_switch_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_eval_5_0=null;


        	enterRule();

        try {
            // InternalFlowService.g:2348:2: ( ( (otherlv_0= 'switch' otherlv_1= ':' ( (lv_switch_2_0= RULE_STRING ) ) ) | (otherlv_3= 'evaluateLabels' otherlv_4= ':' ( (lv_eval_5_0= RULE_BOOL ) ) ) ) )
            // InternalFlowService.g:2349:2: ( (otherlv_0= 'switch' otherlv_1= ':' ( (lv_switch_2_0= RULE_STRING ) ) ) | (otherlv_3= 'evaluateLabels' otherlv_4= ':' ( (lv_eval_5_0= RULE_BOOL ) ) ) )
            {
            // InternalFlowService.g:2349:2: ( (otherlv_0= 'switch' otherlv_1= ':' ( (lv_switch_2_0= RULE_STRING ) ) ) | (otherlv_3= 'evaluateLabels' otherlv_4= ':' ( (lv_eval_5_0= RULE_BOOL ) ) ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==46) ) {
                alt51=1;
            }
            else if ( (LA51_0==47) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalFlowService.g:2350:3: (otherlv_0= 'switch' otherlv_1= ':' ( (lv_switch_2_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2350:3: (otherlv_0= 'switch' otherlv_1= ':' ( (lv_switch_2_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2351:4: otherlv_0= 'switch' otherlv_1= ':' ( (lv_switch_2_0= RULE_STRING ) )
                    {
                    otherlv_0=(Token)match(input,46,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getBranchPropertyAccess().getSwitchKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getBranchPropertyAccess().getColonKeyword_0_1());
                    			
                    // InternalFlowService.g:2359:4: ( (lv_switch_2_0= RULE_STRING ) )
                    // InternalFlowService.g:2360:5: (lv_switch_2_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2360:5: (lv_switch_2_0= RULE_STRING )
                    // InternalFlowService.g:2361:6: lv_switch_2_0= RULE_STRING
                    {
                    lv_switch_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_switch_2_0, grammarAccess.getBranchPropertyAccess().getSwitchSTRINGTerminalRuleCall_0_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBranchPropertyRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"switch",
                    							lv_switch_2_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFlowService.g:2379:3: (otherlv_3= 'evaluateLabels' otherlv_4= ':' ( (lv_eval_5_0= RULE_BOOL ) ) )
                    {
                    // InternalFlowService.g:2379:3: (otherlv_3= 'evaluateLabels' otherlv_4= ':' ( (lv_eval_5_0= RULE_BOOL ) ) )
                    // InternalFlowService.g:2380:4: otherlv_3= 'evaluateLabels' otherlv_4= ':' ( (lv_eval_5_0= RULE_BOOL ) )
                    {
                    otherlv_3=(Token)match(input,47,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getBranchPropertyAccess().getEvaluateLabelsKeyword_1_0());
                    			
                    otherlv_4=(Token)match(input,16,FOLLOW_22); 

                    				newLeafNode(otherlv_4, grammarAccess.getBranchPropertyAccess().getColonKeyword_1_1());
                    			
                    // InternalFlowService.g:2388:4: ( (lv_eval_5_0= RULE_BOOL ) )
                    // InternalFlowService.g:2389:5: (lv_eval_5_0= RULE_BOOL )
                    {
                    // InternalFlowService.g:2389:5: (lv_eval_5_0= RULE_BOOL )
                    // InternalFlowService.g:2390:6: lv_eval_5_0= RULE_BOOL
                    {
                    lv_eval_5_0=(Token)match(input,RULE_BOOL,FOLLOW_2); 

                    						newLeafNode(lv_eval_5_0, grammarAccess.getBranchPropertyAccess().getEvalBOOLTerminalRuleCall_1_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBranchPropertyRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"eval",
                    							lv_eval_5_0,
                    							"com.webmethods.flow.FlowService.BOOL");
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBranchProperty"


    // $ANTLR start "entryRuleRepeatStep"
    // InternalFlowService.g:2411:1: entryRuleRepeatStep returns [EObject current=null] : iv_ruleRepeatStep= ruleRepeatStep EOF ;
    public final EObject entryRuleRepeatStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRepeatStep = null;


        try {
            // InternalFlowService.g:2411:51: (iv_ruleRepeatStep= ruleRepeatStep EOF )
            // InternalFlowService.g:2412:2: iv_ruleRepeatStep= ruleRepeatStep EOF
            {
             newCompositeNode(grammarAccess.getRepeatStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRepeatStep=ruleRepeatStep();

            state._fsp--;

             current =iv_ruleRepeatStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRepeatStep"


    // $ANTLR start "ruleRepeatStep"
    // InternalFlowService.g:2418:1: ruleRepeatStep returns [EObject current=null] : (otherlv_0= 'REPEAT' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_repeatProps_3_0= ruleRepeatProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? ) ;
    public final EObject ruleRepeatStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_properties_2_0 = null;

        EObject lv_repeatProps_3_0 = null;

        EObject lv_steps_4_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:2424:2: ( (otherlv_0= 'REPEAT' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_repeatProps_3_0= ruleRepeatProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? ) )
            // InternalFlowService.g:2425:2: (otherlv_0= 'REPEAT' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_repeatProps_3_0= ruleRepeatProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? )
            {
            // InternalFlowService.g:2425:2: (otherlv_0= 'REPEAT' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_repeatProps_3_0= ruleRepeatProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )? )
            // InternalFlowService.g:2426:3: otherlv_0= 'REPEAT' (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_repeatProps_3_0= ruleRepeatProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )?
            {
            otherlv_0=(Token)match(input,48,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getRepeatStepAccess().getREPEATKeyword_0());
            		
            // InternalFlowService.g:2430:3: (otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_repeatProps_3_0= ruleRepeatProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==13) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalFlowService.g:2431:4: otherlv_1= '{' ( (lv_properties_2_0= ruleStepProperty ) )* ( (lv_repeatProps_3_0= ruleRepeatProperty ) )* ( (lv_steps_4_0= ruleStep ) )* otherlv_5= '}'
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_33); 

                    				newLeafNode(otherlv_1, grammarAccess.getRepeatStepAccess().getLeftCurlyBracketKeyword_1_0());
                    			
                    // InternalFlowService.g:2435:4: ( (lv_properties_2_0= ruleStepProperty ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==15||(LA52_0>=17 && LA52_0<=19)) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // InternalFlowService.g:2436:5: (lv_properties_2_0= ruleStepProperty )
                    	    {
                    	    // InternalFlowService.g:2436:5: (lv_properties_2_0= ruleStepProperty )
                    	    // InternalFlowService.g:2437:6: lv_properties_2_0= ruleStepProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getRepeatStepAccess().getPropertiesStepPropertyParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_33);
                    	    lv_properties_2_0=ruleStepProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getRepeatStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"properties",
                    	    							lv_properties_2_0,
                    	    							"com.webmethods.flow.FlowService.StepProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);

                    // InternalFlowService.g:2454:4: ( (lv_repeatProps_3_0= ruleRepeatProperty ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( ((LA53_0>=49 && LA53_0<=51)) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalFlowService.g:2455:5: (lv_repeatProps_3_0= ruleRepeatProperty )
                    	    {
                    	    // InternalFlowService.g:2455:5: (lv_repeatProps_3_0= ruleRepeatProperty )
                    	    // InternalFlowService.g:2456:6: lv_repeatProps_3_0= ruleRepeatProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getRepeatStepAccess().getRepeatPropsRepeatPropertyParserRuleCall_1_2_0());
                    	    					
                    	    pushFollow(FOLLOW_34);
                    	    lv_repeatProps_3_0=ruleRepeatProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getRepeatStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"repeatProps",
                    	    							lv_repeatProps_3_0,
                    	    							"com.webmethods.flow.FlowService.RepeatProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);

                    // InternalFlowService.g:2473:4: ( (lv_steps_4_0= ruleStep ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==21||LA54_0==26||LA54_0==35||LA54_0==38||LA54_0==40||LA54_0==45||LA54_0==48||LA54_0==52) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // InternalFlowService.g:2474:5: (lv_steps_4_0= ruleStep )
                    	    {
                    	    // InternalFlowService.g:2474:5: (lv_steps_4_0= ruleStep )
                    	    // InternalFlowService.g:2475:6: lv_steps_4_0= ruleStep
                    	    {

                    	    						newCompositeNode(grammarAccess.getRepeatStepAccess().getStepsStepParserRuleCall_1_3_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_steps_4_0=ruleStep();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getRepeatStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"steps",
                    	    							lv_steps_4_0,
                    	    							"com.webmethods.flow.FlowService.Step");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getRepeatStepAccess().getRightCurlyBracketKeyword_1_4());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRepeatStep"


    // $ANTLR start "entryRuleRepeatProperty"
    // InternalFlowService.g:2501:1: entryRuleRepeatProperty returns [EObject current=null] : iv_ruleRepeatProperty= ruleRepeatProperty EOF ;
    public final EObject entryRuleRepeatProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRepeatProperty = null;


        try {
            // InternalFlowService.g:2501:55: (iv_ruleRepeatProperty= ruleRepeatProperty EOF )
            // InternalFlowService.g:2502:2: iv_ruleRepeatProperty= ruleRepeatProperty EOF
            {
             newCompositeNode(grammarAccess.getRepeatPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRepeatProperty=ruleRepeatProperty();

            state._fsp--;

             current =iv_ruleRepeatProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRepeatProperty"


    // $ANTLR start "ruleRepeatProperty"
    // InternalFlowService.g:2508:1: ruleRepeatProperty returns [EObject current=null] : ( (otherlv_0= 'count' otherlv_1= ':' ( (lv_count_2_0= RULE_INT ) ) ) | (otherlv_3= 'repeatInterval' otherlv_4= ':' ( (lv_interval_5_0= RULE_INT ) ) ) | (otherlv_6= 'repeatOn' otherlv_7= ':' ( (lv_on_8_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleRepeatProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_count_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_interval_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_on_8_0=null;


        	enterRule();

        try {
            // InternalFlowService.g:2514:2: ( ( (otherlv_0= 'count' otherlv_1= ':' ( (lv_count_2_0= RULE_INT ) ) ) | (otherlv_3= 'repeatInterval' otherlv_4= ':' ( (lv_interval_5_0= RULE_INT ) ) ) | (otherlv_6= 'repeatOn' otherlv_7= ':' ( (lv_on_8_0= RULE_STRING ) ) ) ) )
            // InternalFlowService.g:2515:2: ( (otherlv_0= 'count' otherlv_1= ':' ( (lv_count_2_0= RULE_INT ) ) ) | (otherlv_3= 'repeatInterval' otherlv_4= ':' ( (lv_interval_5_0= RULE_INT ) ) ) | (otherlv_6= 'repeatOn' otherlv_7= ':' ( (lv_on_8_0= RULE_STRING ) ) ) )
            {
            // InternalFlowService.g:2515:2: ( (otherlv_0= 'count' otherlv_1= ':' ( (lv_count_2_0= RULE_INT ) ) ) | (otherlv_3= 'repeatInterval' otherlv_4= ':' ( (lv_interval_5_0= RULE_INT ) ) ) | (otherlv_6= 'repeatOn' otherlv_7= ':' ( (lv_on_8_0= RULE_STRING ) ) ) )
            int alt56=3;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt56=1;
                }
                break;
            case 50:
                {
                alt56=2;
                }
                break;
            case 51:
                {
                alt56=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalFlowService.g:2516:3: (otherlv_0= 'count' otherlv_1= ':' ( (lv_count_2_0= RULE_INT ) ) )
                    {
                    // InternalFlowService.g:2516:3: (otherlv_0= 'count' otherlv_1= ':' ( (lv_count_2_0= RULE_INT ) ) )
                    // InternalFlowService.g:2517:4: otherlv_0= 'count' otherlv_1= ':' ( (lv_count_2_0= RULE_INT ) )
                    {
                    otherlv_0=(Token)match(input,49,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getRepeatPropertyAccess().getCountKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,16,FOLLOW_9); 

                    				newLeafNode(otherlv_1, grammarAccess.getRepeatPropertyAccess().getColonKeyword_0_1());
                    			
                    // InternalFlowService.g:2525:4: ( (lv_count_2_0= RULE_INT ) )
                    // InternalFlowService.g:2526:5: (lv_count_2_0= RULE_INT )
                    {
                    // InternalFlowService.g:2526:5: (lv_count_2_0= RULE_INT )
                    // InternalFlowService.g:2527:6: lv_count_2_0= RULE_INT
                    {
                    lv_count_2_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_count_2_0, grammarAccess.getRepeatPropertyAccess().getCountINTTerminalRuleCall_0_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRepeatPropertyRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"count",
                    							lv_count_2_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFlowService.g:2545:3: (otherlv_3= 'repeatInterval' otherlv_4= ':' ( (lv_interval_5_0= RULE_INT ) ) )
                    {
                    // InternalFlowService.g:2545:3: (otherlv_3= 'repeatInterval' otherlv_4= ':' ( (lv_interval_5_0= RULE_INT ) ) )
                    // InternalFlowService.g:2546:4: otherlv_3= 'repeatInterval' otherlv_4= ':' ( (lv_interval_5_0= RULE_INT ) )
                    {
                    otherlv_3=(Token)match(input,50,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getRepeatPropertyAccess().getRepeatIntervalKeyword_1_0());
                    			
                    otherlv_4=(Token)match(input,16,FOLLOW_9); 

                    				newLeafNode(otherlv_4, grammarAccess.getRepeatPropertyAccess().getColonKeyword_1_1());
                    			
                    // InternalFlowService.g:2554:4: ( (lv_interval_5_0= RULE_INT ) )
                    // InternalFlowService.g:2555:5: (lv_interval_5_0= RULE_INT )
                    {
                    // InternalFlowService.g:2555:5: (lv_interval_5_0= RULE_INT )
                    // InternalFlowService.g:2556:6: lv_interval_5_0= RULE_INT
                    {
                    lv_interval_5_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_interval_5_0, grammarAccess.getRepeatPropertyAccess().getIntervalINTTerminalRuleCall_1_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRepeatPropertyRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"interval",
                    							lv_interval_5_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalFlowService.g:2574:3: (otherlv_6= 'repeatOn' otherlv_7= ':' ( (lv_on_8_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2574:3: (otherlv_6= 'repeatOn' otherlv_7= ':' ( (lv_on_8_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2575:4: otherlv_6= 'repeatOn' otherlv_7= ':' ( (lv_on_8_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,51,FOLLOW_7); 

                    				newLeafNode(otherlv_6, grammarAccess.getRepeatPropertyAccess().getRepeatOnKeyword_2_0());
                    			
                    otherlv_7=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_7, grammarAccess.getRepeatPropertyAccess().getColonKeyword_2_1());
                    			
                    // InternalFlowService.g:2583:4: ( (lv_on_8_0= RULE_STRING ) )
                    // InternalFlowService.g:2584:5: (lv_on_8_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2584:5: (lv_on_8_0= RULE_STRING )
                    // InternalFlowService.g:2585:6: lv_on_8_0= RULE_STRING
                    {
                    lv_on_8_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_on_8_0, grammarAccess.getRepeatPropertyAccess().getOnSTRINGTerminalRuleCall_2_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRepeatPropertyRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"on",
                    							lv_on_8_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRepeatProperty"


    // $ANTLR start "entryRuleExitStep"
    // InternalFlowService.g:2606:1: entryRuleExitStep returns [EObject current=null] : iv_ruleExitStep= ruleExitStep EOF ;
    public final EObject entryRuleExitStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitStep = null;


        try {
            // InternalFlowService.g:2606:49: (iv_ruleExitStep= ruleExitStep EOF )
            // InternalFlowService.g:2607:2: iv_ruleExitStep= ruleExitStep EOF
            {
             newCompositeNode(grammarAccess.getExitStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExitStep=ruleExitStep();

            state._fsp--;

             current =iv_ruleExitStep; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExitStep"


    // $ANTLR start "ruleExitStep"
    // InternalFlowService.g:2613:1: ruleExitStep returns [EObject current=null] : (otherlv_0= 'EXIT' (otherlv_1= '{' ( (lv_exitProps_2_0= ruleExitProperty ) )* otherlv_3= '}' )? otherlv_4= ';' ) ;
    public final EObject ruleExitStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_exitProps_2_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:2619:2: ( (otherlv_0= 'EXIT' (otherlv_1= '{' ( (lv_exitProps_2_0= ruleExitProperty ) )* otherlv_3= '}' )? otherlv_4= ';' ) )
            // InternalFlowService.g:2620:2: (otherlv_0= 'EXIT' (otherlv_1= '{' ( (lv_exitProps_2_0= ruleExitProperty ) )* otherlv_3= '}' )? otherlv_4= ';' )
            {
            // InternalFlowService.g:2620:2: (otherlv_0= 'EXIT' (otherlv_1= '{' ( (lv_exitProps_2_0= ruleExitProperty ) )* otherlv_3= '}' )? otherlv_4= ';' )
            // InternalFlowService.g:2621:3: otherlv_0= 'EXIT' (otherlv_1= '{' ( (lv_exitProps_2_0= ruleExitProperty ) )* otherlv_3= '}' )? otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getExitStepAccess().getEXITKeyword_0());
            		
            // InternalFlowService.g:2625:3: (otherlv_1= '{' ( (lv_exitProps_2_0= ruleExitProperty ) )* otherlv_3= '}' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==13) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalFlowService.g:2626:4: otherlv_1= '{' ( (lv_exitProps_2_0= ruleExitProperty ) )* otherlv_3= '}'
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_35); 

                    				newLeafNode(otherlv_1, grammarAccess.getExitStepAccess().getLeftCurlyBracketKeyword_1_0());
                    			
                    // InternalFlowService.g:2630:4: ( (lv_exitProps_2_0= ruleExitProperty ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==15||LA57_0==19||(LA57_0>=53 && LA57_0<=57)) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // InternalFlowService.g:2631:5: (lv_exitProps_2_0= ruleExitProperty )
                    	    {
                    	    // InternalFlowService.g:2631:5: (lv_exitProps_2_0= ruleExitProperty )
                    	    // InternalFlowService.g:2632:6: lv_exitProps_2_0= ruleExitProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getExitStepAccess().getExitPropsExitPropertyParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_35);
                    	    lv_exitProps_2_0=ruleExitProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getExitStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"exitProps",
                    	    							lv_exitProps_2_0,
                    	    							"com.webmethods.flow.FlowService.ExitProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,14,FOLLOW_13); 

                    				newLeafNode(otherlv_3, grammarAccess.getExitStepAccess().getRightCurlyBracketKeyword_1_2());
                    			

                    }
                    break;

            }

            otherlv_4=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getExitStepAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExitStep"


    // $ANTLR start "entryRuleExitProperty"
    // InternalFlowService.g:2662:1: entryRuleExitProperty returns [EObject current=null] : iv_ruleExitProperty= ruleExitProperty EOF ;
    public final EObject entryRuleExitProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitProperty = null;


        try {
            // InternalFlowService.g:2662:53: (iv_ruleExitProperty= ruleExitProperty EOF )
            // InternalFlowService.g:2663:2: iv_ruleExitProperty= ruleExitProperty EOF
            {
             newCompositeNode(grammarAccess.getExitPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExitProperty=ruleExitProperty();

            state._fsp--;

             current =iv_ruleExitProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExitProperty"


    // $ANTLR start "ruleExitProperty"
    // InternalFlowService.g:2669:1: ruleExitProperty returns [EObject current=null] : ( (otherlv_0= 'comment' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) ) | (otherlv_3= 'label' otherlv_4= ':' ( (lv_label_5_0= RULE_STRING ) ) ) | (otherlv_6= 'signal' otherlv_7= ':' ( (lv_signal_8_0= RULE_STRING ) ) ) | (otherlv_9= 'failureName' otherlv_10= ':' ( (lv_failureName_11_0= RULE_STRING ) ) ) | (otherlv_12= 'failureInstance' otherlv_13= ':' ( (lv_failureInstance_14_0= RULE_STRING ) ) ) | (otherlv_15= 'exitForm' otherlv_16= ':' ( (lv_exitForm_17_0= RULE_STRING ) ) ) | (otherlv_18= 'failureMessage' otherlv_19= ':' ( (lv_failureMessage_20_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleExitProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_comment_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_label_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_signal_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_failureName_11_0=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_failureInstance_14_0=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token lv_exitForm_17_0=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token lv_failureMessage_20_0=null;


        	enterRule();

        try {
            // InternalFlowService.g:2675:2: ( ( (otherlv_0= 'comment' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) ) | (otherlv_3= 'label' otherlv_4= ':' ( (lv_label_5_0= RULE_STRING ) ) ) | (otherlv_6= 'signal' otherlv_7= ':' ( (lv_signal_8_0= RULE_STRING ) ) ) | (otherlv_9= 'failureName' otherlv_10= ':' ( (lv_failureName_11_0= RULE_STRING ) ) ) | (otherlv_12= 'failureInstance' otherlv_13= ':' ( (lv_failureInstance_14_0= RULE_STRING ) ) ) | (otherlv_15= 'exitForm' otherlv_16= ':' ( (lv_exitForm_17_0= RULE_STRING ) ) ) | (otherlv_18= 'failureMessage' otherlv_19= ':' ( (lv_failureMessage_20_0= RULE_STRING ) ) ) ) )
            // InternalFlowService.g:2676:2: ( (otherlv_0= 'comment' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) ) | (otherlv_3= 'label' otherlv_4= ':' ( (lv_label_5_0= RULE_STRING ) ) ) | (otherlv_6= 'signal' otherlv_7= ':' ( (lv_signal_8_0= RULE_STRING ) ) ) | (otherlv_9= 'failureName' otherlv_10= ':' ( (lv_failureName_11_0= RULE_STRING ) ) ) | (otherlv_12= 'failureInstance' otherlv_13= ':' ( (lv_failureInstance_14_0= RULE_STRING ) ) ) | (otherlv_15= 'exitForm' otherlv_16= ':' ( (lv_exitForm_17_0= RULE_STRING ) ) ) | (otherlv_18= 'failureMessage' otherlv_19= ':' ( (lv_failureMessage_20_0= RULE_STRING ) ) ) )
            {
            // InternalFlowService.g:2676:2: ( (otherlv_0= 'comment' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) ) | (otherlv_3= 'label' otherlv_4= ':' ( (lv_label_5_0= RULE_STRING ) ) ) | (otherlv_6= 'signal' otherlv_7= ':' ( (lv_signal_8_0= RULE_STRING ) ) ) | (otherlv_9= 'failureName' otherlv_10= ':' ( (lv_failureName_11_0= RULE_STRING ) ) ) | (otherlv_12= 'failureInstance' otherlv_13= ':' ( (lv_failureInstance_14_0= RULE_STRING ) ) ) | (otherlv_15= 'exitForm' otherlv_16= ':' ( (lv_exitForm_17_0= RULE_STRING ) ) ) | (otherlv_18= 'failureMessage' otherlv_19= ':' ( (lv_failureMessage_20_0= RULE_STRING ) ) ) )
            int alt59=7;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt59=1;
                }
                break;
            case 19:
                {
                alt59=2;
                }
                break;
            case 53:
                {
                alt59=3;
                }
                break;
            case 54:
                {
                alt59=4;
                }
                break;
            case 55:
                {
                alt59=5;
                }
                break;
            case 56:
                {
                alt59=6;
                }
                break;
            case 57:
                {
                alt59=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // InternalFlowService.g:2677:3: (otherlv_0= 'comment' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2677:3: (otherlv_0= 'comment' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2678:4: otherlv_0= 'comment' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) )
                    {
                    otherlv_0=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getExitPropertyAccess().getCommentKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getExitPropertyAccess().getColonKeyword_0_1());
                    			
                    // InternalFlowService.g:2686:4: ( (lv_comment_2_0= RULE_STRING ) )
                    // InternalFlowService.g:2687:5: (lv_comment_2_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2687:5: (lv_comment_2_0= RULE_STRING )
                    // InternalFlowService.g:2688:6: lv_comment_2_0= RULE_STRING
                    {
                    lv_comment_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_comment_2_0, grammarAccess.getExitPropertyAccess().getCommentSTRINGTerminalRuleCall_0_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExitPropertyRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"comment",
                    							lv_comment_2_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFlowService.g:2706:3: (otherlv_3= 'label' otherlv_4= ':' ( (lv_label_5_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2706:3: (otherlv_3= 'label' otherlv_4= ':' ( (lv_label_5_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2707:4: otherlv_3= 'label' otherlv_4= ':' ( (lv_label_5_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getExitPropertyAccess().getLabelKeyword_1_0());
                    			
                    otherlv_4=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_4, grammarAccess.getExitPropertyAccess().getColonKeyword_1_1());
                    			
                    // InternalFlowService.g:2715:4: ( (lv_label_5_0= RULE_STRING ) )
                    // InternalFlowService.g:2716:5: (lv_label_5_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2716:5: (lv_label_5_0= RULE_STRING )
                    // InternalFlowService.g:2717:6: lv_label_5_0= RULE_STRING
                    {
                    lv_label_5_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_label_5_0, grammarAccess.getExitPropertyAccess().getLabelSTRINGTerminalRuleCall_1_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExitPropertyRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"label",
                    							lv_label_5_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalFlowService.g:2735:3: (otherlv_6= 'signal' otherlv_7= ':' ( (lv_signal_8_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2735:3: (otherlv_6= 'signal' otherlv_7= ':' ( (lv_signal_8_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2736:4: otherlv_6= 'signal' otherlv_7= ':' ( (lv_signal_8_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,53,FOLLOW_7); 

                    				newLeafNode(otherlv_6, grammarAccess.getExitPropertyAccess().getSignalKeyword_2_0());
                    			
                    otherlv_7=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_7, grammarAccess.getExitPropertyAccess().getColonKeyword_2_1());
                    			
                    // InternalFlowService.g:2744:4: ( (lv_signal_8_0= RULE_STRING ) )
                    // InternalFlowService.g:2745:5: (lv_signal_8_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2745:5: (lv_signal_8_0= RULE_STRING )
                    // InternalFlowService.g:2746:6: lv_signal_8_0= RULE_STRING
                    {
                    lv_signal_8_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_signal_8_0, grammarAccess.getExitPropertyAccess().getSignalSTRINGTerminalRuleCall_2_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExitPropertyRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"signal",
                    							lv_signal_8_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalFlowService.g:2764:3: (otherlv_9= 'failureName' otherlv_10= ':' ( (lv_failureName_11_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2764:3: (otherlv_9= 'failureName' otherlv_10= ':' ( (lv_failureName_11_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2765:4: otherlv_9= 'failureName' otherlv_10= ':' ( (lv_failureName_11_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,54,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getExitPropertyAccess().getFailureNameKeyword_3_0());
                    			
                    otherlv_10=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_10, grammarAccess.getExitPropertyAccess().getColonKeyword_3_1());
                    			
                    // InternalFlowService.g:2773:4: ( (lv_failureName_11_0= RULE_STRING ) )
                    // InternalFlowService.g:2774:5: (lv_failureName_11_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2774:5: (lv_failureName_11_0= RULE_STRING )
                    // InternalFlowService.g:2775:6: lv_failureName_11_0= RULE_STRING
                    {
                    lv_failureName_11_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_failureName_11_0, grammarAccess.getExitPropertyAccess().getFailureNameSTRINGTerminalRuleCall_3_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExitPropertyRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"failureName",
                    							lv_failureName_11_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalFlowService.g:2793:3: (otherlv_12= 'failureInstance' otherlv_13= ':' ( (lv_failureInstance_14_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2793:3: (otherlv_12= 'failureInstance' otherlv_13= ':' ( (lv_failureInstance_14_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2794:4: otherlv_12= 'failureInstance' otherlv_13= ':' ( (lv_failureInstance_14_0= RULE_STRING ) )
                    {
                    otherlv_12=(Token)match(input,55,FOLLOW_7); 

                    				newLeafNode(otherlv_12, grammarAccess.getExitPropertyAccess().getFailureInstanceKeyword_4_0());
                    			
                    otherlv_13=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_13, grammarAccess.getExitPropertyAccess().getColonKeyword_4_1());
                    			
                    // InternalFlowService.g:2802:4: ( (lv_failureInstance_14_0= RULE_STRING ) )
                    // InternalFlowService.g:2803:5: (lv_failureInstance_14_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2803:5: (lv_failureInstance_14_0= RULE_STRING )
                    // InternalFlowService.g:2804:6: lv_failureInstance_14_0= RULE_STRING
                    {
                    lv_failureInstance_14_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_failureInstance_14_0, grammarAccess.getExitPropertyAccess().getFailureInstanceSTRINGTerminalRuleCall_4_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExitPropertyRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"failureInstance",
                    							lv_failureInstance_14_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalFlowService.g:2822:3: (otherlv_15= 'exitForm' otherlv_16= ':' ( (lv_exitForm_17_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2822:3: (otherlv_15= 'exitForm' otherlv_16= ':' ( (lv_exitForm_17_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2823:4: otherlv_15= 'exitForm' otherlv_16= ':' ( (lv_exitForm_17_0= RULE_STRING ) )
                    {
                    otherlv_15=(Token)match(input,56,FOLLOW_7); 

                    				newLeafNode(otherlv_15, grammarAccess.getExitPropertyAccess().getExitFormKeyword_5_0());
                    			
                    otherlv_16=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_16, grammarAccess.getExitPropertyAccess().getColonKeyword_5_1());
                    			
                    // InternalFlowService.g:2831:4: ( (lv_exitForm_17_0= RULE_STRING ) )
                    // InternalFlowService.g:2832:5: (lv_exitForm_17_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2832:5: (lv_exitForm_17_0= RULE_STRING )
                    // InternalFlowService.g:2833:6: lv_exitForm_17_0= RULE_STRING
                    {
                    lv_exitForm_17_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_exitForm_17_0, grammarAccess.getExitPropertyAccess().getExitFormSTRINGTerminalRuleCall_5_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExitPropertyRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"exitForm",
                    							lv_exitForm_17_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalFlowService.g:2851:3: (otherlv_18= 'failureMessage' otherlv_19= ':' ( (lv_failureMessage_20_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2851:3: (otherlv_18= 'failureMessage' otherlv_19= ':' ( (lv_failureMessage_20_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2852:4: otherlv_18= 'failureMessage' otherlv_19= ':' ( (lv_failureMessage_20_0= RULE_STRING ) )
                    {
                    otherlv_18=(Token)match(input,57,FOLLOW_7); 

                    				newLeafNode(otherlv_18, grammarAccess.getExitPropertyAccess().getFailureMessageKeyword_6_0());
                    			
                    otherlv_19=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_19, grammarAccess.getExitPropertyAccess().getColonKeyword_6_1());
                    			
                    // InternalFlowService.g:2860:4: ( (lv_failureMessage_20_0= RULE_STRING ) )
                    // InternalFlowService.g:2861:5: (lv_failureMessage_20_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2861:5: (lv_failureMessage_20_0= RULE_STRING )
                    // InternalFlowService.g:2862:6: lv_failureMessage_20_0= RULE_STRING
                    {
                    lv_failureMessage_20_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_failureMessage_20_0, grammarAccess.getExitPropertyAccess().getFailureMessageSTRINGTerminalRuleCall_6_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExitPropertyRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"failureMessage",
                    							lv_failureMessage_20_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExitProperty"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0011214804204000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000402000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000A18EC000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000018004000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000006180EC000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000618004000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000000A0004000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000042000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000102000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00112178042EC000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0011217804204000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x001121C8042EC000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x001121C804204000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000120000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00112DC8042EC000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x00112DC804204000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0011E148042EC000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0011E14804204000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x001F2148042EC000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x001F214804204000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x03E000000008C000L});

}