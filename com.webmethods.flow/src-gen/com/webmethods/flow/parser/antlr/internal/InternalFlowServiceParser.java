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
    // InternalFlowService.g:582:1: ruleMapStep returns [EObject current=null] : ( () otherlv_1= 'MAP' (otherlv_2= '{' ( ( (lv_mapElements_3_1= ruleStepProperty | lv_mapElements_3_2= ruleMappingSetEntry | lv_mapElements_3_3= ruleMappingCopyEntry | lv_mapElements_3_4= ruleTransformStep | lv_mapElements_3_5= ruleDropStep ) ) )* otherlv_4= '}' )? otherlv_5= ';' ) ;
    public final EObject ruleMapStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_mapElements_3_1 = null;

        EObject lv_mapElements_3_2 = null;

        EObject lv_mapElements_3_3 = null;

        EObject lv_mapElements_3_4 = null;

        EObject lv_mapElements_3_5 = null;



        	enterRule();

        try {
            // InternalFlowService.g:588:2: ( ( () otherlv_1= 'MAP' (otherlv_2= '{' ( ( (lv_mapElements_3_1= ruleStepProperty | lv_mapElements_3_2= ruleMappingSetEntry | lv_mapElements_3_3= ruleMappingCopyEntry | lv_mapElements_3_4= ruleTransformStep | lv_mapElements_3_5= ruleDropStep ) ) )* otherlv_4= '}' )? otherlv_5= ';' ) )
            // InternalFlowService.g:589:2: ( () otherlv_1= 'MAP' (otherlv_2= '{' ( ( (lv_mapElements_3_1= ruleStepProperty | lv_mapElements_3_2= ruleMappingSetEntry | lv_mapElements_3_3= ruleMappingCopyEntry | lv_mapElements_3_4= ruleTransformStep | lv_mapElements_3_5= ruleDropStep ) ) )* otherlv_4= '}' )? otherlv_5= ';' )
            {
            // InternalFlowService.g:589:2: ( () otherlv_1= 'MAP' (otherlv_2= '{' ( ( (lv_mapElements_3_1= ruleStepProperty | lv_mapElements_3_2= ruleMappingSetEntry | lv_mapElements_3_3= ruleMappingCopyEntry | lv_mapElements_3_4= ruleTransformStep | lv_mapElements_3_5= ruleDropStep ) ) )* otherlv_4= '}' )? otherlv_5= ';' )
            // InternalFlowService.g:590:3: () otherlv_1= 'MAP' (otherlv_2= '{' ( ( (lv_mapElements_3_1= ruleStepProperty | lv_mapElements_3_2= ruleMappingSetEntry | lv_mapElements_3_3= ruleMappingCopyEntry | lv_mapElements_3_4= ruleTransformStep | lv_mapElements_3_5= ruleDropStep ) ) )* otherlv_4= '}' )? otherlv_5= ';'
            {
            // InternalFlowService.g:590:3: ()
            // InternalFlowService.g:591:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMapStepAccess().getMapStepAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getMapStepAccess().getMAPKeyword_1());
            		
            // InternalFlowService.g:601:3: (otherlv_2= '{' ( ( (lv_mapElements_3_1= ruleStepProperty | lv_mapElements_3_2= ruleMappingSetEntry | lv_mapElements_3_3= ruleMappingCopyEntry | lv_mapElements_3_4= ruleTransformStep | lv_mapElements_3_5= ruleDropStep ) ) )* otherlv_4= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==13) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalFlowService.g:602:4: otherlv_2= '{' ( ( (lv_mapElements_3_1= ruleStepProperty | lv_mapElements_3_2= ruleMappingSetEntry | lv_mapElements_3_3= ruleMappingCopyEntry | lv_mapElements_3_4= ruleTransformStep | lv_mapElements_3_5= ruleDropStep ) ) )* otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_12); 

                    				newLeafNode(otherlv_2, grammarAccess.getMapStepAccess().getLeftCurlyBracketKeyword_2_0());
                    			
                    // InternalFlowService.g:606:4: ( ( (lv_mapElements_3_1= ruleStepProperty | lv_mapElements_3_2= ruleMappingSetEntry | lv_mapElements_3_3= ruleMappingCopyEntry | lv_mapElements_3_4= ruleTransformStep | lv_mapElements_3_5= ruleDropStep ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==15||(LA7_0>=17 && LA7_0<=19)||(LA7_0>=23 && LA7_0<=24)||LA7_0==29||LA7_0==31) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalFlowService.g:607:5: ( (lv_mapElements_3_1= ruleStepProperty | lv_mapElements_3_2= ruleMappingSetEntry | lv_mapElements_3_3= ruleMappingCopyEntry | lv_mapElements_3_4= ruleTransformStep | lv_mapElements_3_5= ruleDropStep ) )
                    	    {
                    	    // InternalFlowService.g:607:5: ( (lv_mapElements_3_1= ruleStepProperty | lv_mapElements_3_2= ruleMappingSetEntry | lv_mapElements_3_3= ruleMappingCopyEntry | lv_mapElements_3_4= ruleTransformStep | lv_mapElements_3_5= ruleDropStep ) )
                    	    // InternalFlowService.g:608:6: (lv_mapElements_3_1= ruleStepProperty | lv_mapElements_3_2= ruleMappingSetEntry | lv_mapElements_3_3= ruleMappingCopyEntry | lv_mapElements_3_4= ruleTransformStep | lv_mapElements_3_5= ruleDropStep )
                    	    {
                    	    // InternalFlowService.g:608:6: (lv_mapElements_3_1= ruleStepProperty | lv_mapElements_3_2= ruleMappingSetEntry | lv_mapElements_3_3= ruleMappingCopyEntry | lv_mapElements_3_4= ruleTransformStep | lv_mapElements_3_5= ruleDropStep )
                    	    int alt6=5;
                    	    switch ( input.LA(1) ) {
                    	    case 15:
                    	    case 17:
                    	    case 18:
                    	    case 19:
                    	        {
                    	        alt6=1;
                    	        }
                    	        break;
                    	    case 31:
                    	        {
                    	        alt6=2;
                    	        }
                    	        break;
                    	    case 29:
                    	        {
                    	        alt6=3;
                    	        }
                    	        break;
                    	    case 23:
                    	        {
                    	        alt6=4;
                    	        }
                    	        break;
                    	    case 24:
                    	        {
                    	        alt6=5;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 6, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt6) {
                    	        case 1 :
                    	            // InternalFlowService.g:609:7: lv_mapElements_3_1= ruleStepProperty
                    	            {

                    	            							newCompositeNode(grammarAccess.getMapStepAccess().getMapElementsStepPropertyParserRuleCall_2_1_0_0());
                    	            						
                    	            pushFollow(FOLLOW_12);
                    	            lv_mapElements_3_1=ruleStepProperty();

                    	            state._fsp--;


                    	            							if (current==null) {
                    	            								current = createModelElementForParent(grammarAccess.getMapStepRule());
                    	            							}
                    	            							add(
                    	            								current,
                    	            								"mapElements",
                    	            								lv_mapElements_3_1,
                    	            								"com.webmethods.flow.FlowService.StepProperty");
                    	            							afterParserOrEnumRuleCall();
                    	            						

                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalFlowService.g:625:7: lv_mapElements_3_2= ruleMappingSetEntry
                    	            {

                    	            							newCompositeNode(grammarAccess.getMapStepAccess().getMapElementsMappingSetEntryParserRuleCall_2_1_0_1());
                    	            						
                    	            pushFollow(FOLLOW_12);
                    	            lv_mapElements_3_2=ruleMappingSetEntry();

                    	            state._fsp--;


                    	            							if (current==null) {
                    	            								current = createModelElementForParent(grammarAccess.getMapStepRule());
                    	            							}
                    	            							add(
                    	            								current,
                    	            								"mapElements",
                    	            								lv_mapElements_3_2,
                    	            								"com.webmethods.flow.FlowService.MappingSetEntry");
                    	            							afterParserOrEnumRuleCall();
                    	            						

                    	            }
                    	            break;
                    	        case 3 :
                    	            // InternalFlowService.g:641:7: lv_mapElements_3_3= ruleMappingCopyEntry
                    	            {

                    	            							newCompositeNode(grammarAccess.getMapStepAccess().getMapElementsMappingCopyEntryParserRuleCall_2_1_0_2());
                    	            						
                    	            pushFollow(FOLLOW_12);
                    	            lv_mapElements_3_3=ruleMappingCopyEntry();

                    	            state._fsp--;


                    	            							if (current==null) {
                    	            								current = createModelElementForParent(grammarAccess.getMapStepRule());
                    	            							}
                    	            							add(
                    	            								current,
                    	            								"mapElements",
                    	            								lv_mapElements_3_3,
                    	            								"com.webmethods.flow.FlowService.MappingCopyEntry");
                    	            							afterParserOrEnumRuleCall();
                    	            						

                    	            }
                    	            break;
                    	        case 4 :
                    	            // InternalFlowService.g:657:7: lv_mapElements_3_4= ruleTransformStep
                    	            {

                    	            							newCompositeNode(grammarAccess.getMapStepAccess().getMapElementsTransformStepParserRuleCall_2_1_0_3());
                    	            						
                    	            pushFollow(FOLLOW_12);
                    	            lv_mapElements_3_4=ruleTransformStep();

                    	            state._fsp--;


                    	            							if (current==null) {
                    	            								current = createModelElementForParent(grammarAccess.getMapStepRule());
                    	            							}
                    	            							add(
                    	            								current,
                    	            								"mapElements",
                    	            								lv_mapElements_3_4,
                    	            								"com.webmethods.flow.FlowService.TransformStep");
                    	            							afterParserOrEnumRuleCall();
                    	            						

                    	            }
                    	            break;
                    	        case 5 :
                    	            // InternalFlowService.g:673:7: lv_mapElements_3_5= ruleDropStep
                    	            {

                    	            							newCompositeNode(grammarAccess.getMapStepAccess().getMapElementsDropStepParserRuleCall_2_1_0_4());
                    	            						
                    	            pushFollow(FOLLOW_12);
                    	            lv_mapElements_3_5=ruleDropStep();

                    	            state._fsp--;


                    	            							if (current==null) {
                    	            								current = createModelElementForParent(grammarAccess.getMapStepRule());
                    	            							}
                    	            							add(
                    	            								current,
                    	            								"mapElements",
                    	            								lv_mapElements_3_5,
                    	            								"com.webmethods.flow.FlowService.DropStep");
                    	            							afterParserOrEnumRuleCall();
                    	            						

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,14,FOLLOW_13); 

                    				newLeafNode(otherlv_4, grammarAccess.getMapStepAccess().getRightCurlyBracketKeyword_2_2());
                    			

                    }
                    break;

            }

            otherlv_5=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getMapStepAccess().getSemicolonKeyword_3());
            		

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


    // $ANTLR start "entryRuleTransformStep"
    // InternalFlowService.g:704:1: entryRuleTransformStep returns [EObject current=null] : iv_ruleTransformStep= ruleTransformStep EOF ;
    public final EObject entryRuleTransformStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformStep = null;


        try {
            // InternalFlowService.g:704:54: (iv_ruleTransformStep= ruleTransformStep EOF )
            // InternalFlowService.g:705:2: iv_ruleTransformStep= ruleTransformStep EOF
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
    // InternalFlowService.g:711:1: ruleTransformStep returns [EObject current=null] : (otherlv_0= 'TRANSFORM' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_mappings_3_0= ruleMappingBlock ) )* otherlv_4= '}' )? otherlv_5= ';' ) ;
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
            // InternalFlowService.g:717:2: ( (otherlv_0= 'TRANSFORM' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_mappings_3_0= ruleMappingBlock ) )* otherlv_4= '}' )? otherlv_5= ';' ) )
            // InternalFlowService.g:718:2: (otherlv_0= 'TRANSFORM' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_mappings_3_0= ruleMappingBlock ) )* otherlv_4= '}' )? otherlv_5= ';' )
            {
            // InternalFlowService.g:718:2: (otherlv_0= 'TRANSFORM' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_mappings_3_0= ruleMappingBlock ) )* otherlv_4= '}' )? otherlv_5= ';' )
            // InternalFlowService.g:719:3: otherlv_0= 'TRANSFORM' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_mappings_3_0= ruleMappingBlock ) )* otherlv_4= '}' )? otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTransformStepAccess().getTRANSFORMKeyword_0());
            		
            // InternalFlowService.g:723:3: ( (lv_service_1_0= ruleQualifiedServiceName ) )
            // InternalFlowService.g:724:4: (lv_service_1_0= ruleQualifiedServiceName )
            {
            // InternalFlowService.g:724:4: (lv_service_1_0= ruleQualifiedServiceName )
            // InternalFlowService.g:725:5: lv_service_1_0= ruleQualifiedServiceName
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

            // InternalFlowService.g:742:3: (otherlv_2= '{' ( (lv_mappings_3_0= ruleMappingBlock ) )* otherlv_4= '}' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==13) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalFlowService.g:743:4: otherlv_2= '{' ( (lv_mappings_3_0= ruleMappingBlock ) )* otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_14); 

                    				newLeafNode(otherlv_2, grammarAccess.getTransformStepAccess().getLeftCurlyBracketKeyword_2_0());
                    			
                    // InternalFlowService.g:747:4: ( (lv_mappings_3_0= ruleMappingBlock ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>=27 && LA9_0<=28)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalFlowService.g:748:5: (lv_mappings_3_0= ruleMappingBlock )
                    	    {
                    	    // InternalFlowService.g:748:5: (lv_mappings_3_0= ruleMappingBlock )
                    	    // InternalFlowService.g:749:6: lv_mappings_3_0= ruleMappingBlock
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
    // InternalFlowService.g:779:1: entryRuleDropStep returns [EObject current=null] : iv_ruleDropStep= ruleDropStep EOF ;
    public final EObject entryRuleDropStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDropStep = null;


        try {
            // InternalFlowService.g:779:49: (iv_ruleDropStep= ruleDropStep EOF )
            // InternalFlowService.g:780:2: iv_ruleDropStep= ruleDropStep EOF
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
    // InternalFlowService.g:786:1: ruleDropStep returns [EObject current=null] : (otherlv_0= 'drop' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleDropStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_path_1_0=null;
        Token otherlv_2=null;
        Token lv_path_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalFlowService.g:792:2: ( (otherlv_0= 'drop' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= ';' ) )
            // InternalFlowService.g:793:2: (otherlv_0= 'drop' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= ';' )
            {
            // InternalFlowService.g:793:2: (otherlv_0= 'drop' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= ';' )
            // InternalFlowService.g:794:3: otherlv_0= 'drop' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDropStepAccess().getDropKeyword_0());
            		
            // InternalFlowService.g:798:3: ( (lv_path_1_0= RULE_ID ) )
            // InternalFlowService.g:799:4: (lv_path_1_0= RULE_ID )
            {
            // InternalFlowService.g:799:4: (lv_path_1_0= RULE_ID )
            // InternalFlowService.g:800:5: lv_path_1_0= RULE_ID
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

            // InternalFlowService.g:816:3: (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==25) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalFlowService.g:817:4: otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getDropStepAccess().getSolidusKeyword_2_0());
            	    			
            	    // InternalFlowService.g:821:4: ( (lv_path_3_0= RULE_ID ) )
            	    // InternalFlowService.g:822:5: (lv_path_3_0= RULE_ID )
            	    {
            	    // InternalFlowService.g:822:5: (lv_path_3_0= RULE_ID )
            	    // InternalFlowService.g:823:6: lv_path_3_0= RULE_ID
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
    // InternalFlowService.g:848:1: entryRuleInvokeStep returns [EObject current=null] : iv_ruleInvokeStep= ruleInvokeStep EOF ;
    public final EObject entryRuleInvokeStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvokeStep = null;


        try {
            // InternalFlowService.g:848:51: (iv_ruleInvokeStep= ruleInvokeStep EOF )
            // InternalFlowService.g:849:2: iv_ruleInvokeStep= ruleInvokeStep EOF
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
    // InternalFlowService.g:855:1: ruleInvokeStep returns [EObject current=null] : (otherlv_0= 'INVOKE' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_invokeProps_4_0= ruleInvokeProperty ) )* ( (lv_mappings_5_0= ruleMappingBlock ) )* otherlv_6= '}' )? otherlv_7= ';' ) ;
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
            // InternalFlowService.g:861:2: ( (otherlv_0= 'INVOKE' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_invokeProps_4_0= ruleInvokeProperty ) )* ( (lv_mappings_5_0= ruleMappingBlock ) )* otherlv_6= '}' )? otherlv_7= ';' ) )
            // InternalFlowService.g:862:2: (otherlv_0= 'INVOKE' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_invokeProps_4_0= ruleInvokeProperty ) )* ( (lv_mappings_5_0= ruleMappingBlock ) )* otherlv_6= '}' )? otherlv_7= ';' )
            {
            // InternalFlowService.g:862:2: (otherlv_0= 'INVOKE' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_invokeProps_4_0= ruleInvokeProperty ) )* ( (lv_mappings_5_0= ruleMappingBlock ) )* otherlv_6= '}' )? otherlv_7= ';' )
            // InternalFlowService.g:863:3: otherlv_0= 'INVOKE' ( (lv_service_1_0= ruleQualifiedServiceName ) ) (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_invokeProps_4_0= ruleInvokeProperty ) )* ( (lv_mappings_5_0= ruleMappingBlock ) )* otherlv_6= '}' )? otherlv_7= ';'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getInvokeStepAccess().getINVOKEKeyword_0());
            		
            // InternalFlowService.g:867:3: ( (lv_service_1_0= ruleQualifiedServiceName ) )
            // InternalFlowService.g:868:4: (lv_service_1_0= ruleQualifiedServiceName )
            {
            // InternalFlowService.g:868:4: (lv_service_1_0= ruleQualifiedServiceName )
            // InternalFlowService.g:869:5: lv_service_1_0= ruleQualifiedServiceName
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

            // InternalFlowService.g:886:3: (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_invokeProps_4_0= ruleInvokeProperty ) )* ( (lv_mappings_5_0= ruleMappingBlock ) )* otherlv_6= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==13) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalFlowService.g:887:4: otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_invokeProps_4_0= ruleInvokeProperty ) )* ( (lv_mappings_5_0= ruleMappingBlock ) )* otherlv_6= '}'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_16); 

                    				newLeafNode(otherlv_2, grammarAccess.getInvokeStepAccess().getLeftCurlyBracketKeyword_2_0());
                    			
                    // InternalFlowService.g:891:4: ( (lv_properties_3_0= ruleStepProperty ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==15||(LA12_0>=17 && LA12_0<=19)) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalFlowService.g:892:5: (lv_properties_3_0= ruleStepProperty )
                    	    {
                    	    // InternalFlowService.g:892:5: (lv_properties_3_0= ruleStepProperty )
                    	    // InternalFlowService.g:893:6: lv_properties_3_0= ruleStepProperty
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

                    // InternalFlowService.g:910:4: ( (lv_invokeProps_4_0= ruleInvokeProperty ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>=33 && LA13_0<=34)) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalFlowService.g:911:5: (lv_invokeProps_4_0= ruleInvokeProperty )
                    	    {
                    	    // InternalFlowService.g:911:5: (lv_invokeProps_4_0= ruleInvokeProperty )
                    	    // InternalFlowService.g:912:6: lv_invokeProps_4_0= ruleInvokeProperty
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

                    // InternalFlowService.g:929:4: ( (lv_mappings_5_0= ruleMappingBlock ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>=27 && LA14_0<=28)) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalFlowService.g:930:5: (lv_mappings_5_0= ruleMappingBlock )
                    	    {
                    	    // InternalFlowService.g:930:5: (lv_mappings_5_0= ruleMappingBlock )
                    	    // InternalFlowService.g:931:6: lv_mappings_5_0= ruleMappingBlock
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
    // InternalFlowService.g:961:1: entryRuleMappingBlock returns [EObject current=null] : iv_ruleMappingBlock= ruleMappingBlock EOF ;
    public final EObject entryRuleMappingBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingBlock = null;


        try {
            // InternalFlowService.g:961:53: (iv_ruleMappingBlock= ruleMappingBlock EOF )
            // InternalFlowService.g:962:2: iv_ruleMappingBlock= ruleMappingBlock EOF
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
    // InternalFlowService.g:968:1: ruleMappingBlock returns [EObject current=null] : ( ( ( (lv_direction_0_1= 'input' | lv_direction_0_2= 'output' ) ) ) otherlv_1= '{' ( ( (lv_entries_2_1= ruleMappingCopyEntry | lv_entries_2_2= ruleMappingSetEntry ) ) )* otherlv_3= '}' ) ;
    public final EObject ruleMappingBlock() throws RecognitionException {
        EObject current = null;

        Token lv_direction_0_1=null;
        Token lv_direction_0_2=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_entries_2_1 = null;

        EObject lv_entries_2_2 = null;



        	enterRule();

        try {
            // InternalFlowService.g:974:2: ( ( ( ( (lv_direction_0_1= 'input' | lv_direction_0_2= 'output' ) ) ) otherlv_1= '{' ( ( (lv_entries_2_1= ruleMappingCopyEntry | lv_entries_2_2= ruleMappingSetEntry ) ) )* otherlv_3= '}' ) )
            // InternalFlowService.g:975:2: ( ( ( (lv_direction_0_1= 'input' | lv_direction_0_2= 'output' ) ) ) otherlv_1= '{' ( ( (lv_entries_2_1= ruleMappingCopyEntry | lv_entries_2_2= ruleMappingSetEntry ) ) )* otherlv_3= '}' )
            {
            // InternalFlowService.g:975:2: ( ( ( (lv_direction_0_1= 'input' | lv_direction_0_2= 'output' ) ) ) otherlv_1= '{' ( ( (lv_entries_2_1= ruleMappingCopyEntry | lv_entries_2_2= ruleMappingSetEntry ) ) )* otherlv_3= '}' )
            // InternalFlowService.g:976:3: ( ( (lv_direction_0_1= 'input' | lv_direction_0_2= 'output' ) ) ) otherlv_1= '{' ( ( (lv_entries_2_1= ruleMappingCopyEntry | lv_entries_2_2= ruleMappingSetEntry ) ) )* otherlv_3= '}'
            {
            // InternalFlowService.g:976:3: ( ( (lv_direction_0_1= 'input' | lv_direction_0_2= 'output' ) ) )
            // InternalFlowService.g:977:4: ( (lv_direction_0_1= 'input' | lv_direction_0_2= 'output' ) )
            {
            // InternalFlowService.g:977:4: ( (lv_direction_0_1= 'input' | lv_direction_0_2= 'output' ) )
            // InternalFlowService.g:978:5: (lv_direction_0_1= 'input' | lv_direction_0_2= 'output' )
            {
            // InternalFlowService.g:978:5: (lv_direction_0_1= 'input' | lv_direction_0_2= 'output' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                alt16=1;
            }
            else if ( (LA16_0==28) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalFlowService.g:979:6: lv_direction_0_1= 'input'
                    {
                    lv_direction_0_1=(Token)match(input,27,FOLLOW_5); 

                    						newLeafNode(lv_direction_0_1, grammarAccess.getMappingBlockAccess().getDirectionInputKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMappingBlockRule());
                    						}
                    						setWithLastConsumed(current, "direction", lv_direction_0_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalFlowService.g:990:6: lv_direction_0_2= 'output'
                    {
                    lv_direction_0_2=(Token)match(input,28,FOLLOW_5); 

                    						newLeafNode(lv_direction_0_2, grammarAccess.getMappingBlockAccess().getDirectionOutputKeyword_0_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMappingBlockRule());
                    						}
                    						setWithLastConsumed(current, "direction", lv_direction_0_2, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,13,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getMappingBlockAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalFlowService.g:1007:3: ( ( (lv_entries_2_1= ruleMappingCopyEntry | lv_entries_2_2= ruleMappingSetEntry ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==29||LA18_0==31) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalFlowService.g:1008:4: ( (lv_entries_2_1= ruleMappingCopyEntry | lv_entries_2_2= ruleMappingSetEntry ) )
            	    {
            	    // InternalFlowService.g:1008:4: ( (lv_entries_2_1= ruleMappingCopyEntry | lv_entries_2_2= ruleMappingSetEntry ) )
            	    // InternalFlowService.g:1009:5: (lv_entries_2_1= ruleMappingCopyEntry | lv_entries_2_2= ruleMappingSetEntry )
            	    {
            	    // InternalFlowService.g:1009:5: (lv_entries_2_1= ruleMappingCopyEntry | lv_entries_2_2= ruleMappingSetEntry )
            	    int alt17=2;
            	    int LA17_0 = input.LA(1);

            	    if ( (LA17_0==29) ) {
            	        alt17=1;
            	    }
            	    else if ( (LA17_0==31) ) {
            	        alt17=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 17, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt17) {
            	        case 1 :
            	            // InternalFlowService.g:1010:6: lv_entries_2_1= ruleMappingCopyEntry
            	            {

            	            						newCompositeNode(grammarAccess.getMappingBlockAccess().getEntriesMappingCopyEntryParserRuleCall_2_0_0());
            	            					
            	            pushFollow(FOLLOW_18);
            	            lv_entries_2_1=ruleMappingCopyEntry();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getMappingBlockRule());
            	            						}
            	            						add(
            	            							current,
            	            							"entries",
            	            							lv_entries_2_1,
            	            							"com.webmethods.flow.FlowService.MappingCopyEntry");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // InternalFlowService.g:1026:6: lv_entries_2_2= ruleMappingSetEntry
            	            {

            	            						newCompositeNode(grammarAccess.getMappingBlockAccess().getEntriesMappingSetEntryParserRuleCall_2_0_1());
            	            					
            	            pushFollow(FOLLOW_18);
            	            lv_entries_2_2=ruleMappingSetEntry();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getMappingBlockRule());
            	            						}
            	            						add(
            	            							current,
            	            							"entries",
            	            							lv_entries_2_2,
            	            							"com.webmethods.flow.FlowService.MappingSetEntry");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_3=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getMappingBlockAccess().getRightCurlyBracketKeyword_3());
            		

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


    // $ANTLR start "entryRuleMappingCopyEntry"
    // InternalFlowService.g:1052:1: entryRuleMappingCopyEntry returns [EObject current=null] : iv_ruleMappingCopyEntry= ruleMappingCopyEntry EOF ;
    public final EObject entryRuleMappingCopyEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingCopyEntry = null;


        try {
            // InternalFlowService.g:1052:57: (iv_ruleMappingCopyEntry= ruleMappingCopyEntry EOF )
            // InternalFlowService.g:1053:2: iv_ruleMappingCopyEntry= ruleMappingCopyEntry EOF
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
    // InternalFlowService.g:1059:1: ruleMappingCopyEntry returns [EObject current=null] : (otherlv_0= 'copy' ( (lv_fromPath_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_fromPath_3_0= RULE_ID ) ) )* otherlv_4= '->' ( (lv_toPath_5_0= RULE_ID ) ) (otherlv_6= '/' ( (lv_toPath_7_0= RULE_ID ) ) )* otherlv_8= ';' ) ;
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
            // InternalFlowService.g:1065:2: ( (otherlv_0= 'copy' ( (lv_fromPath_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_fromPath_3_0= RULE_ID ) ) )* otherlv_4= '->' ( (lv_toPath_5_0= RULE_ID ) ) (otherlv_6= '/' ( (lv_toPath_7_0= RULE_ID ) ) )* otherlv_8= ';' ) )
            // InternalFlowService.g:1066:2: (otherlv_0= 'copy' ( (lv_fromPath_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_fromPath_3_0= RULE_ID ) ) )* otherlv_4= '->' ( (lv_toPath_5_0= RULE_ID ) ) (otherlv_6= '/' ( (lv_toPath_7_0= RULE_ID ) ) )* otherlv_8= ';' )
            {
            // InternalFlowService.g:1066:2: (otherlv_0= 'copy' ( (lv_fromPath_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_fromPath_3_0= RULE_ID ) ) )* otherlv_4= '->' ( (lv_toPath_5_0= RULE_ID ) ) (otherlv_6= '/' ( (lv_toPath_7_0= RULE_ID ) ) )* otherlv_8= ';' )
            // InternalFlowService.g:1067:3: otherlv_0= 'copy' ( (lv_fromPath_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_fromPath_3_0= RULE_ID ) ) )* otherlv_4= '->' ( (lv_toPath_5_0= RULE_ID ) ) (otherlv_6= '/' ( (lv_toPath_7_0= RULE_ID ) ) )* otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getMappingCopyEntryAccess().getCopyKeyword_0());
            		
            // InternalFlowService.g:1071:3: ( (lv_fromPath_1_0= RULE_ID ) )
            // InternalFlowService.g:1072:4: (lv_fromPath_1_0= RULE_ID )
            {
            // InternalFlowService.g:1072:4: (lv_fromPath_1_0= RULE_ID )
            // InternalFlowService.g:1073:5: lv_fromPath_1_0= RULE_ID
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

            // InternalFlowService.g:1089:3: (otherlv_2= '/' ( (lv_fromPath_3_0= RULE_ID ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==25) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalFlowService.g:1090:4: otherlv_2= '/' ( (lv_fromPath_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getMappingCopyEntryAccess().getSolidusKeyword_2_0());
            	    			
            	    // InternalFlowService.g:1094:4: ( (lv_fromPath_3_0= RULE_ID ) )
            	    // InternalFlowService.g:1095:5: (lv_fromPath_3_0= RULE_ID )
            	    {
            	    // InternalFlowService.g:1095:5: (lv_fromPath_3_0= RULE_ID )
            	    // InternalFlowService.g:1096:6: lv_fromPath_3_0= RULE_ID
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
            	    break loop19;
                }
            } while (true);

            otherlv_4=(Token)match(input,30,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getMappingCopyEntryAccess().getHyphenMinusGreaterThanSignKeyword_3());
            		
            // InternalFlowService.g:1117:3: ( (lv_toPath_5_0= RULE_ID ) )
            // InternalFlowService.g:1118:4: (lv_toPath_5_0= RULE_ID )
            {
            // InternalFlowService.g:1118:4: (lv_toPath_5_0= RULE_ID )
            // InternalFlowService.g:1119:5: lv_toPath_5_0= RULE_ID
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

            // InternalFlowService.g:1135:3: (otherlv_6= '/' ( (lv_toPath_7_0= RULE_ID ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==25) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalFlowService.g:1136:4: otherlv_6= '/' ( (lv_toPath_7_0= RULE_ID ) )
            	    {
            	    otherlv_6=(Token)match(input,25,FOLLOW_4); 

            	    				newLeafNode(otherlv_6, grammarAccess.getMappingCopyEntryAccess().getSolidusKeyword_5_0());
            	    			
            	    // InternalFlowService.g:1140:4: ( (lv_toPath_7_0= RULE_ID ) )
            	    // InternalFlowService.g:1141:5: (lv_toPath_7_0= RULE_ID )
            	    {
            	    // InternalFlowService.g:1141:5: (lv_toPath_7_0= RULE_ID )
            	    // InternalFlowService.g:1142:6: lv_toPath_7_0= RULE_ID
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
            	    break loop20;
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
    // InternalFlowService.g:1167:1: entryRuleMappingSetEntry returns [EObject current=null] : iv_ruleMappingSetEntry= ruleMappingSetEntry EOF ;
    public final EObject entryRuleMappingSetEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingSetEntry = null;


        try {
            // InternalFlowService.g:1167:56: (iv_ruleMappingSetEntry= ruleMappingSetEntry EOF )
            // InternalFlowService.g:1168:2: iv_ruleMappingSetEntry= ruleMappingSetEntry EOF
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
    // InternalFlowService.g:1174:1: ruleMappingSetEntry returns [EObject current=null] : (otherlv_0= 'set' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= '=' ( (lv_value_5_0= ruleValue ) ) otherlv_6= ';' ) ;
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
            // InternalFlowService.g:1180:2: ( (otherlv_0= 'set' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= '=' ( (lv_value_5_0= ruleValue ) ) otherlv_6= ';' ) )
            // InternalFlowService.g:1181:2: (otherlv_0= 'set' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= '=' ( (lv_value_5_0= ruleValue ) ) otherlv_6= ';' )
            {
            // InternalFlowService.g:1181:2: (otherlv_0= 'set' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= '=' ( (lv_value_5_0= ruleValue ) ) otherlv_6= ';' )
            // InternalFlowService.g:1182:3: otherlv_0= 'set' ( (lv_path_1_0= RULE_ID ) ) (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )* otherlv_4= '=' ( (lv_value_5_0= ruleValue ) ) otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getMappingSetEntryAccess().getSetKeyword_0());
            		
            // InternalFlowService.g:1186:3: ( (lv_path_1_0= RULE_ID ) )
            // InternalFlowService.g:1187:4: (lv_path_1_0= RULE_ID )
            {
            // InternalFlowService.g:1187:4: (lv_path_1_0= RULE_ID )
            // InternalFlowService.g:1188:5: lv_path_1_0= RULE_ID
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

            // InternalFlowService.g:1204:3: (otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==25) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalFlowService.g:1205:4: otherlv_2= '/' ( (lv_path_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getMappingSetEntryAccess().getSolidusKeyword_2_0());
            	    			
            	    // InternalFlowService.g:1209:4: ( (lv_path_3_0= RULE_ID ) )
            	    // InternalFlowService.g:1210:5: (lv_path_3_0= RULE_ID )
            	    {
            	    // InternalFlowService.g:1210:5: (lv_path_3_0= RULE_ID )
            	    // InternalFlowService.g:1211:6: lv_path_3_0= RULE_ID
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
            	    break loop21;
                }
            } while (true);

            otherlv_4=(Token)match(input,32,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getMappingSetEntryAccess().getEqualsSignKeyword_3());
            		
            // InternalFlowService.g:1232:3: ( (lv_value_5_0= ruleValue ) )
            // InternalFlowService.g:1233:4: (lv_value_5_0= ruleValue )
            {
            // InternalFlowService.g:1233:4: (lv_value_5_0= ruleValue )
            // InternalFlowService.g:1234:5: lv_value_5_0= ruleValue
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
    // InternalFlowService.g:1259:1: entryRuleValue returns [String current=null] : iv_ruleValue= ruleValue EOF ;
    public final String entryRuleValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValue = null;


        try {
            // InternalFlowService.g:1259:45: (iv_ruleValue= ruleValue EOF )
            // InternalFlowService.g:1260:2: iv_ruleValue= ruleValue EOF
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
    // InternalFlowService.g:1266:1: ruleValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_STRING_1=null;


        	enterRule();

        try {
            // InternalFlowService.g:1272:2: ( (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING ) )
            // InternalFlowService.g:1273:2: (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING )
            {
            // InternalFlowService.g:1273:2: (this_INT_0= RULE_INT | this_STRING_1= RULE_STRING )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_INT) ) {
                alt22=1;
            }
            else if ( (LA22_0==RULE_STRING) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalFlowService.g:1274:3: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_0);
                    		

                    			newLeafNode(this_INT_0, grammarAccess.getValueAccess().getINTTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalFlowService.g:1282:3: this_STRING_1= RULE_STRING
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
    // InternalFlowService.g:1293:1: entryRuleInvokeProperty returns [EObject current=null] : iv_ruleInvokeProperty= ruleInvokeProperty EOF ;
    public final EObject entryRuleInvokeProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvokeProperty = null;


        try {
            // InternalFlowService.g:1293:55: (iv_ruleInvokeProperty= ruleInvokeProperty EOF )
            // InternalFlowService.g:1294:2: iv_ruleInvokeProperty= ruleInvokeProperty EOF
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
    // InternalFlowService.g:1300:1: ruleInvokeProperty returns [EObject current=null] : (this_ValidateInput_0= ruleValidateInput | this_ValidateOutput_1= ruleValidateOutput ) ;
    public final EObject ruleInvokeProperty() throws RecognitionException {
        EObject current = null;

        EObject this_ValidateInput_0 = null;

        EObject this_ValidateOutput_1 = null;



        	enterRule();

        try {
            // InternalFlowService.g:1306:2: ( (this_ValidateInput_0= ruleValidateInput | this_ValidateOutput_1= ruleValidateOutput ) )
            // InternalFlowService.g:1307:2: (this_ValidateInput_0= ruleValidateInput | this_ValidateOutput_1= ruleValidateOutput )
            {
            // InternalFlowService.g:1307:2: (this_ValidateInput_0= ruleValidateInput | this_ValidateOutput_1= ruleValidateOutput )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==33) ) {
                alt23=1;
            }
            else if ( (LA23_0==34) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalFlowService.g:1308:3: this_ValidateInput_0= ruleValidateInput
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
                    // InternalFlowService.g:1317:3: this_ValidateOutput_1= ruleValidateOutput
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
    // InternalFlowService.g:1329:1: entryRuleValidateInput returns [EObject current=null] : iv_ruleValidateInput= ruleValidateInput EOF ;
    public final EObject entryRuleValidateInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValidateInput = null;


        try {
            // InternalFlowService.g:1329:54: (iv_ruleValidateInput= ruleValidateInput EOF )
            // InternalFlowService.g:1330:2: iv_ruleValidateInput= ruleValidateInput EOF
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
    // InternalFlowService.g:1336:1: ruleValidateInput returns [EObject current=null] : (otherlv_0= 'validateInput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) ) ) ;
    public final EObject ruleValidateInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalFlowService.g:1342:2: ( (otherlv_0= 'validateInput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) ) ) )
            // InternalFlowService.g:1343:2: (otherlv_0= 'validateInput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) ) )
            {
            // InternalFlowService.g:1343:2: (otherlv_0= 'validateInput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) ) )
            // InternalFlowService.g:1344:3: otherlv_0= 'validateInput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getValidateInputAccess().getValidateInputKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getValidateInputAccess().getColonKeyword_1());
            		
            // InternalFlowService.g:1352:3: ( (lv_value_2_0= RULE_BOOL ) )
            // InternalFlowService.g:1353:4: (lv_value_2_0= RULE_BOOL )
            {
            // InternalFlowService.g:1353:4: (lv_value_2_0= RULE_BOOL )
            // InternalFlowService.g:1354:5: lv_value_2_0= RULE_BOOL
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
    // InternalFlowService.g:1374:1: entryRuleValidateOutput returns [EObject current=null] : iv_ruleValidateOutput= ruleValidateOutput EOF ;
    public final EObject entryRuleValidateOutput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValidateOutput = null;


        try {
            // InternalFlowService.g:1374:55: (iv_ruleValidateOutput= ruleValidateOutput EOF )
            // InternalFlowService.g:1375:2: iv_ruleValidateOutput= ruleValidateOutput EOF
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
    // InternalFlowService.g:1381:1: ruleValidateOutput returns [EObject current=null] : (otherlv_0= 'validateOutput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) ) ) ;
    public final EObject ruleValidateOutput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalFlowService.g:1387:2: ( (otherlv_0= 'validateOutput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) ) ) )
            // InternalFlowService.g:1388:2: (otherlv_0= 'validateOutput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) ) )
            {
            // InternalFlowService.g:1388:2: (otherlv_0= 'validateOutput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) ) )
            // InternalFlowService.g:1389:3: otherlv_0= 'validateOutput' otherlv_1= ':' ( (lv_value_2_0= RULE_BOOL ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getValidateOutputAccess().getValidateOutputKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getValidateOutputAccess().getColonKeyword_1());
            		
            // InternalFlowService.g:1397:3: ( (lv_value_2_0= RULE_BOOL ) )
            // InternalFlowService.g:1398:4: (lv_value_2_0= RULE_BOOL )
            {
            // InternalFlowService.g:1398:4: (lv_value_2_0= RULE_BOOL )
            // InternalFlowService.g:1399:5: lv_value_2_0= RULE_BOOL
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
    // InternalFlowService.g:1419:1: entryRuleLoopStep returns [EObject current=null] : iv_ruleLoopStep= ruleLoopStep EOF ;
    public final EObject entryRuleLoopStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopStep = null;


        try {
            // InternalFlowService.g:1419:49: (iv_ruleLoopStep= ruleLoopStep EOF )
            // InternalFlowService.g:1420:2: iv_ruleLoopStep= ruleLoopStep EOF
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
    // InternalFlowService.g:1426:1: ruleLoopStep returns [EObject current=null] : ( () otherlv_1= 'LOOP' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_loopProps_4_0= ruleLoopProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? ) ;
    public final EObject ruleLoopStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_properties_3_0 = null;

        EObject lv_loopProps_4_0 = null;

        EObject lv_steps_5_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:1432:2: ( ( () otherlv_1= 'LOOP' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_loopProps_4_0= ruleLoopProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? ) )
            // InternalFlowService.g:1433:2: ( () otherlv_1= 'LOOP' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_loopProps_4_0= ruleLoopProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? )
            {
            // InternalFlowService.g:1433:2: ( () otherlv_1= 'LOOP' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_loopProps_4_0= ruleLoopProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? )
            // InternalFlowService.g:1434:3: () otherlv_1= 'LOOP' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_loopProps_4_0= ruleLoopProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )?
            {
            // InternalFlowService.g:1434:3: ()
            // InternalFlowService.g:1435:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLoopStepAccess().getLoopStepAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,35,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getLoopStepAccess().getLOOPKeyword_1());
            		
            // InternalFlowService.g:1445:3: (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_loopProps_4_0= ruleLoopProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==13) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalFlowService.g:1446:4: otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_loopProps_4_0= ruleLoopProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_24); 

                    				newLeafNode(otherlv_2, grammarAccess.getLoopStepAccess().getLeftCurlyBracketKeyword_2_0());
                    			
                    // InternalFlowService.g:1450:4: ( (lv_properties_3_0= ruleStepProperty ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==15||(LA24_0>=17 && LA24_0<=19)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalFlowService.g:1451:5: (lv_properties_3_0= ruleStepProperty )
                    	    {
                    	    // InternalFlowService.g:1451:5: (lv_properties_3_0= ruleStepProperty )
                    	    // InternalFlowService.g:1452:6: lv_properties_3_0= ruleStepProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getLoopStepAccess().getPropertiesStepPropertyParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_24);
                    	    lv_properties_3_0=ruleStepProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getLoopStepRule());
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
                    	    break loop24;
                        }
                    } while (true);

                    // InternalFlowService.g:1469:4: ( (lv_loopProps_4_0= ruleLoopProperty ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( ((LA25_0>=36 && LA25_0<=37)) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalFlowService.g:1470:5: (lv_loopProps_4_0= ruleLoopProperty )
                    	    {
                    	    // InternalFlowService.g:1470:5: (lv_loopProps_4_0= ruleLoopProperty )
                    	    // InternalFlowService.g:1471:6: lv_loopProps_4_0= ruleLoopProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getLoopStepAccess().getLoopPropsLoopPropertyParserRuleCall_2_2_0());
                    	    					
                    	    pushFollow(FOLLOW_25);
                    	    lv_loopProps_4_0=ruleLoopProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getLoopStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"loopProps",
                    	    							lv_loopProps_4_0,
                    	    							"com.webmethods.flow.FlowService.LoopProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    // InternalFlowService.g:1488:4: ( (lv_steps_5_0= ruleStep ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==21||LA26_0==26||LA26_0==35||LA26_0==38||LA26_0==40||LA26_0==45||LA26_0==48||LA26_0==52) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalFlowService.g:1489:5: (lv_steps_5_0= ruleStep )
                    	    {
                    	    // InternalFlowService.g:1489:5: (lv_steps_5_0= ruleStep )
                    	    // InternalFlowService.g:1490:6: lv_steps_5_0= ruleStep
                    	    {

                    	    						newCompositeNode(grammarAccess.getLoopStepAccess().getStepsStepParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_steps_5_0=ruleStep();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getLoopStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"steps",
                    	    							lv_steps_5_0,
                    	    							"com.webmethods.flow.FlowService.Step");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getLoopStepAccess().getRightCurlyBracketKeyword_2_4());
                    			

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
    // InternalFlowService.g:1516:1: entryRuleLoopProperty returns [EObject current=null] : iv_ruleLoopProperty= ruleLoopProperty EOF ;
    public final EObject entryRuleLoopProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopProperty = null;


        try {
            // InternalFlowService.g:1516:53: (iv_ruleLoopProperty= ruleLoopProperty EOF )
            // InternalFlowService.g:1517:2: iv_ruleLoopProperty= ruleLoopProperty EOF
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
    // InternalFlowService.g:1523:1: ruleLoopProperty returns [EObject current=null] : ( (otherlv_0= 'inputArray' otherlv_1= ':' ( (lv_input_2_0= RULE_STRING ) ) ) | (otherlv_3= 'outputArray' otherlv_4= ':' ( (lv_output_5_0= RULE_STRING ) ) ) ) ;
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
            // InternalFlowService.g:1529:2: ( ( (otherlv_0= 'inputArray' otherlv_1= ':' ( (lv_input_2_0= RULE_STRING ) ) ) | (otherlv_3= 'outputArray' otherlv_4= ':' ( (lv_output_5_0= RULE_STRING ) ) ) ) )
            // InternalFlowService.g:1530:2: ( (otherlv_0= 'inputArray' otherlv_1= ':' ( (lv_input_2_0= RULE_STRING ) ) ) | (otherlv_3= 'outputArray' otherlv_4= ':' ( (lv_output_5_0= RULE_STRING ) ) ) )
            {
            // InternalFlowService.g:1530:2: ( (otherlv_0= 'inputArray' otherlv_1= ':' ( (lv_input_2_0= RULE_STRING ) ) ) | (otherlv_3= 'outputArray' otherlv_4= ':' ( (lv_output_5_0= RULE_STRING ) ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==36) ) {
                alt28=1;
            }
            else if ( (LA28_0==37) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalFlowService.g:1531:3: (otherlv_0= 'inputArray' otherlv_1= ':' ( (lv_input_2_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:1531:3: (otherlv_0= 'inputArray' otherlv_1= ':' ( (lv_input_2_0= RULE_STRING ) ) )
                    // InternalFlowService.g:1532:4: otherlv_0= 'inputArray' otherlv_1= ':' ( (lv_input_2_0= RULE_STRING ) )
                    {
                    otherlv_0=(Token)match(input,36,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getLoopPropertyAccess().getInputArrayKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getLoopPropertyAccess().getColonKeyword_0_1());
                    			
                    // InternalFlowService.g:1540:4: ( (lv_input_2_0= RULE_STRING ) )
                    // InternalFlowService.g:1541:5: (lv_input_2_0= RULE_STRING )
                    {
                    // InternalFlowService.g:1541:5: (lv_input_2_0= RULE_STRING )
                    // InternalFlowService.g:1542:6: lv_input_2_0= RULE_STRING
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
                    // InternalFlowService.g:1560:3: (otherlv_3= 'outputArray' otherlv_4= ':' ( (lv_output_5_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:1560:3: (otherlv_3= 'outputArray' otherlv_4= ':' ( (lv_output_5_0= RULE_STRING ) ) )
                    // InternalFlowService.g:1561:4: otherlv_3= 'outputArray' otherlv_4= ':' ( (lv_output_5_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,37,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getLoopPropertyAccess().getOutputArrayKeyword_1_0());
                    			
                    otherlv_4=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_4, grammarAccess.getLoopPropertyAccess().getColonKeyword_1_1());
                    			
                    // InternalFlowService.g:1569:4: ( (lv_output_5_0= RULE_STRING ) )
                    // InternalFlowService.g:1570:5: (lv_output_5_0= RULE_STRING )
                    {
                    // InternalFlowService.g:1570:5: (lv_output_5_0= RULE_STRING )
                    // InternalFlowService.g:1571:6: lv_output_5_0= RULE_STRING
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
    // InternalFlowService.g:1592:1: entryRuleSequenceStep returns [EObject current=null] : iv_ruleSequenceStep= ruleSequenceStep EOF ;
    public final EObject entryRuleSequenceStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceStep = null;


        try {
            // InternalFlowService.g:1592:53: (iv_ruleSequenceStep= ruleSequenceStep EOF )
            // InternalFlowService.g:1593:2: iv_ruleSequenceStep= ruleSequenceStep EOF
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
    // InternalFlowService.g:1599:1: ruleSequenceStep returns [EObject current=null] : ( () otherlv_1= 'SEQUENCE' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_seqProps_4_0= ruleSequenceProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? ) ;
    public final EObject ruleSequenceStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_properties_3_0 = null;

        EObject lv_seqProps_4_0 = null;

        EObject lv_steps_5_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:1605:2: ( ( () otherlv_1= 'SEQUENCE' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_seqProps_4_0= ruleSequenceProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? ) )
            // InternalFlowService.g:1606:2: ( () otherlv_1= 'SEQUENCE' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_seqProps_4_0= ruleSequenceProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? )
            {
            // InternalFlowService.g:1606:2: ( () otherlv_1= 'SEQUENCE' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_seqProps_4_0= ruleSequenceProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? )
            // InternalFlowService.g:1607:3: () otherlv_1= 'SEQUENCE' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_seqProps_4_0= ruleSequenceProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )?
            {
            // InternalFlowService.g:1607:3: ()
            // InternalFlowService.g:1608:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSequenceStepAccess().getSequenceStepAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,38,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getSequenceStepAccess().getSEQUENCEKeyword_1());
            		
            // InternalFlowService.g:1618:3: (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_seqProps_4_0= ruleSequenceProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==13) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalFlowService.g:1619:4: otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_seqProps_4_0= ruleSequenceProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_26); 

                    				newLeafNode(otherlv_2, grammarAccess.getSequenceStepAccess().getLeftCurlyBracketKeyword_2_0());
                    			
                    // InternalFlowService.g:1623:4: ( (lv_properties_3_0= ruleStepProperty ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==15||(LA29_0>=17 && LA29_0<=19)) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalFlowService.g:1624:5: (lv_properties_3_0= ruleStepProperty )
                    	    {
                    	    // InternalFlowService.g:1624:5: (lv_properties_3_0= ruleStepProperty )
                    	    // InternalFlowService.g:1625:6: lv_properties_3_0= ruleStepProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getSequenceStepAccess().getPropertiesStepPropertyParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_26);
                    	    lv_properties_3_0=ruleStepProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getSequenceStepRule());
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
                    	    break loop29;
                        }
                    } while (true);

                    // InternalFlowService.g:1642:4: ( (lv_seqProps_4_0= ruleSequenceProperty ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==39) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalFlowService.g:1643:5: (lv_seqProps_4_0= ruleSequenceProperty )
                    	    {
                    	    // InternalFlowService.g:1643:5: (lv_seqProps_4_0= ruleSequenceProperty )
                    	    // InternalFlowService.g:1644:6: lv_seqProps_4_0= ruleSequenceProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getSequenceStepAccess().getSeqPropsSequencePropertyParserRuleCall_2_2_0());
                    	    					
                    	    pushFollow(FOLLOW_27);
                    	    lv_seqProps_4_0=ruleSequenceProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getSequenceStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"seqProps",
                    	    							lv_seqProps_4_0,
                    	    							"com.webmethods.flow.FlowService.SequenceProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    // InternalFlowService.g:1661:4: ( (lv_steps_5_0= ruleStep ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==21||LA31_0==26||LA31_0==35||LA31_0==38||LA31_0==40||LA31_0==45||LA31_0==48||LA31_0==52) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalFlowService.g:1662:5: (lv_steps_5_0= ruleStep )
                    	    {
                    	    // InternalFlowService.g:1662:5: (lv_steps_5_0= ruleStep )
                    	    // InternalFlowService.g:1663:6: lv_steps_5_0= ruleStep
                    	    {

                    	    						newCompositeNode(grammarAccess.getSequenceStepAccess().getStepsStepParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_steps_5_0=ruleStep();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getSequenceStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"steps",
                    	    							lv_steps_5_0,
                    	    							"com.webmethods.flow.FlowService.Step");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getSequenceStepAccess().getRightCurlyBracketKeyword_2_4());
                    			

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
    // InternalFlowService.g:1689:1: entryRuleSequenceProperty returns [EObject current=null] : iv_ruleSequenceProperty= ruleSequenceProperty EOF ;
    public final EObject entryRuleSequenceProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceProperty = null;


        try {
            // InternalFlowService.g:1689:57: (iv_ruleSequenceProperty= ruleSequenceProperty EOF )
            // InternalFlowService.g:1690:2: iv_ruleSequenceProperty= ruleSequenceProperty EOF
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
    // InternalFlowService.g:1696:1: ruleSequenceProperty returns [EObject current=null] : (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleSequenceProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalFlowService.g:1702:2: ( (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // InternalFlowService.g:1703:2: (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // InternalFlowService.g:1703:2: (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            // InternalFlowService.g:1704:3: otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,39,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getSequencePropertyAccess().getExitOnKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getSequencePropertyAccess().getColonKeyword_1());
            		
            // InternalFlowService.g:1712:3: ( (lv_value_2_0= RULE_STRING ) )
            // InternalFlowService.g:1713:4: (lv_value_2_0= RULE_STRING )
            {
            // InternalFlowService.g:1713:4: (lv_value_2_0= RULE_STRING )
            // InternalFlowService.g:1714:5: lv_value_2_0= RULE_STRING
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
    // InternalFlowService.g:1734:1: entryRuleTryStep returns [EObject current=null] : iv_ruleTryStep= ruleTryStep EOF ;
    public final EObject entryRuleTryStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTryStep = null;


        try {
            // InternalFlowService.g:1734:48: (iv_ruleTryStep= ruleTryStep EOF )
            // InternalFlowService.g:1735:2: iv_ruleTryStep= ruleTryStep EOF
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
    // InternalFlowService.g:1741:1: ruleTryStep returns [EObject current=null] : ( () otherlv_1= 'TRY' otherlv_2= '{' ( ( (lv_properties_3_0= ruleStepProperty ) ) | ( (lv_tryProps_4_0= ruleTryProperty ) ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' ( (lv_catches_7_0= ruleCatchStep ) )* ( (lv_finallyBlock_8_0= ruleFinallyStep ) )? ) ;
    public final EObject ruleTryStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_properties_3_0 = null;

        EObject lv_tryProps_4_0 = null;

        EObject lv_steps_5_0 = null;

        EObject lv_catches_7_0 = null;

        EObject lv_finallyBlock_8_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:1747:2: ( ( () otherlv_1= 'TRY' otherlv_2= '{' ( ( (lv_properties_3_0= ruleStepProperty ) ) | ( (lv_tryProps_4_0= ruleTryProperty ) ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' ( (lv_catches_7_0= ruleCatchStep ) )* ( (lv_finallyBlock_8_0= ruleFinallyStep ) )? ) )
            // InternalFlowService.g:1748:2: ( () otherlv_1= 'TRY' otherlv_2= '{' ( ( (lv_properties_3_0= ruleStepProperty ) ) | ( (lv_tryProps_4_0= ruleTryProperty ) ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' ( (lv_catches_7_0= ruleCatchStep ) )* ( (lv_finallyBlock_8_0= ruleFinallyStep ) )? )
            {
            // InternalFlowService.g:1748:2: ( () otherlv_1= 'TRY' otherlv_2= '{' ( ( (lv_properties_3_0= ruleStepProperty ) ) | ( (lv_tryProps_4_0= ruleTryProperty ) ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' ( (lv_catches_7_0= ruleCatchStep ) )* ( (lv_finallyBlock_8_0= ruleFinallyStep ) )? )
            // InternalFlowService.g:1749:3: () otherlv_1= 'TRY' otherlv_2= '{' ( ( (lv_properties_3_0= ruleStepProperty ) ) | ( (lv_tryProps_4_0= ruleTryProperty ) ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' ( (lv_catches_7_0= ruleCatchStep ) )* ( (lv_finallyBlock_8_0= ruleFinallyStep ) )?
            {
            // InternalFlowService.g:1749:3: ()
            // InternalFlowService.g:1750:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTryStepAccess().getTryStepAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,40,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getTryStepAccess().getTRYKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_26); 

            			newLeafNode(otherlv_2, grammarAccess.getTryStepAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalFlowService.g:1764:3: ( ( (lv_properties_3_0= ruleStepProperty ) ) | ( (lv_tryProps_4_0= ruleTryProperty ) ) )*
            loop33:
            do {
                int alt33=3;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==15||(LA33_0>=17 && LA33_0<=19)) ) {
                    alt33=1;
                }
                else if ( (LA33_0==39) ) {
                    alt33=2;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalFlowService.g:1765:4: ( (lv_properties_3_0= ruleStepProperty ) )
            	    {
            	    // InternalFlowService.g:1765:4: ( (lv_properties_3_0= ruleStepProperty ) )
            	    // InternalFlowService.g:1766:5: (lv_properties_3_0= ruleStepProperty )
            	    {
            	    // InternalFlowService.g:1766:5: (lv_properties_3_0= ruleStepProperty )
            	    // InternalFlowService.g:1767:6: lv_properties_3_0= ruleStepProperty
            	    {

            	    						newCompositeNode(grammarAccess.getTryStepAccess().getPropertiesStepPropertyParserRuleCall_3_0_0());
            	    					
            	    pushFollow(FOLLOW_26);
            	    lv_properties_3_0=ruleStepProperty();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTryStepRule());
            	    						}
            	    						add(
            	    							current,
            	    							"properties",
            	    							lv_properties_3_0,
            	    							"com.webmethods.flow.FlowService.StepProperty");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalFlowService.g:1785:4: ( (lv_tryProps_4_0= ruleTryProperty ) )
            	    {
            	    // InternalFlowService.g:1785:4: ( (lv_tryProps_4_0= ruleTryProperty ) )
            	    // InternalFlowService.g:1786:5: (lv_tryProps_4_0= ruleTryProperty )
            	    {
            	    // InternalFlowService.g:1786:5: (lv_tryProps_4_0= ruleTryProperty )
            	    // InternalFlowService.g:1787:6: lv_tryProps_4_0= ruleTryProperty
            	    {

            	    						newCompositeNode(grammarAccess.getTryStepAccess().getTryPropsTryPropertyParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_26);
            	    lv_tryProps_4_0=ruleTryProperty();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTryStepRule());
            	    						}
            	    						add(
            	    							current,
            	    							"tryProps",
            	    							lv_tryProps_4_0,
            	    							"com.webmethods.flow.FlowService.TryProperty");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            // InternalFlowService.g:1805:3: ( (lv_steps_5_0= ruleStep ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==21||LA34_0==26||LA34_0==35||LA34_0==38||LA34_0==40||LA34_0==45||LA34_0==48||LA34_0==52) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalFlowService.g:1806:4: (lv_steps_5_0= ruleStep )
            	    {
            	    // InternalFlowService.g:1806:4: (lv_steps_5_0= ruleStep )
            	    // InternalFlowService.g:1807:5: lv_steps_5_0= ruleStep
            	    {

            	    					newCompositeNode(grammarAccess.getTryStepAccess().getStepsStepParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_steps_5_0=ruleStep();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTryStepRule());
            	    					}
            	    					add(
            	    						current,
            	    						"steps",
            	    						lv_steps_5_0,
            	    						"com.webmethods.flow.FlowService.Step");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FOLLOW_28); 

            			newLeafNode(otherlv_6, grammarAccess.getTryStepAccess().getRightCurlyBracketKeyword_5());
            		
            // InternalFlowService.g:1828:3: ( (lv_catches_7_0= ruleCatchStep ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==41) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalFlowService.g:1829:4: (lv_catches_7_0= ruleCatchStep )
            	    {
            	    // InternalFlowService.g:1829:4: (lv_catches_7_0= ruleCatchStep )
            	    // InternalFlowService.g:1830:5: lv_catches_7_0= ruleCatchStep
            	    {

            	    					newCompositeNode(grammarAccess.getTryStepAccess().getCatchesCatchStepParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_28);
            	    lv_catches_7_0=ruleCatchStep();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTryStepRule());
            	    					}
            	    					add(
            	    						current,
            	    						"catches",
            	    						lv_catches_7_0,
            	    						"com.webmethods.flow.FlowService.CatchStep");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            // InternalFlowService.g:1847:3: ( (lv_finallyBlock_8_0= ruleFinallyStep ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==44) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalFlowService.g:1848:4: (lv_finallyBlock_8_0= ruleFinallyStep )
                    {
                    // InternalFlowService.g:1848:4: (lv_finallyBlock_8_0= ruleFinallyStep )
                    // InternalFlowService.g:1849:5: lv_finallyBlock_8_0= ruleFinallyStep
                    {

                    					newCompositeNode(grammarAccess.getTryStepAccess().getFinallyBlockFinallyStepParserRuleCall_7_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_finallyBlock_8_0=ruleFinallyStep();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTryStepRule());
                    					}
                    					set(
                    						current,
                    						"finallyBlock",
                    						lv_finallyBlock_8_0,
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
    // InternalFlowService.g:1922:1: ruleCatchStep returns [EObject current=null] : ( () otherlv_1= 'CATCH' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_catchProps_4_0= ruleCatchProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? ) ;
    public final EObject ruleCatchStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_properties_3_0 = null;

        EObject lv_catchProps_4_0 = null;

        EObject lv_steps_5_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:1928:2: ( ( () otherlv_1= 'CATCH' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_catchProps_4_0= ruleCatchProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? ) )
            // InternalFlowService.g:1929:2: ( () otherlv_1= 'CATCH' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_catchProps_4_0= ruleCatchProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? )
            {
            // InternalFlowService.g:1929:2: ( () otherlv_1= 'CATCH' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_catchProps_4_0= ruleCatchProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? )
            // InternalFlowService.g:1930:3: () otherlv_1= 'CATCH' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_catchProps_4_0= ruleCatchProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )?
            {
            // InternalFlowService.g:1930:3: ()
            // InternalFlowService.g:1931:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCatchStepAccess().getCatchStepAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,41,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getCatchStepAccess().getCATCHKeyword_1());
            		
            // InternalFlowService.g:1941:3: (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_catchProps_4_0= ruleCatchProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==13) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalFlowService.g:1942:4: otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_catchProps_4_0= ruleCatchProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_29); 

                    				newLeafNode(otherlv_2, grammarAccess.getCatchStepAccess().getLeftCurlyBracketKeyword_2_0());
                    			
                    // InternalFlowService.g:1946:4: ( (lv_properties_3_0= ruleStepProperty ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==15||(LA37_0>=17 && LA37_0<=19)) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // InternalFlowService.g:1947:5: (lv_properties_3_0= ruleStepProperty )
                    	    {
                    	    // InternalFlowService.g:1947:5: (lv_properties_3_0= ruleStepProperty )
                    	    // InternalFlowService.g:1948:6: lv_properties_3_0= ruleStepProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getCatchStepAccess().getPropertiesStepPropertyParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_29);
                    	    lv_properties_3_0=ruleStepProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getCatchStepRule());
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
                    	    break loop37;
                        }
                    } while (true);

                    // InternalFlowService.g:1965:4: ( (lv_catchProps_4_0= ruleCatchProperty ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==39||(LA38_0>=42 && LA38_0<=43)) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalFlowService.g:1966:5: (lv_catchProps_4_0= ruleCatchProperty )
                    	    {
                    	    // InternalFlowService.g:1966:5: (lv_catchProps_4_0= ruleCatchProperty )
                    	    // InternalFlowService.g:1967:6: lv_catchProps_4_0= ruleCatchProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getCatchStepAccess().getCatchPropsCatchPropertyParserRuleCall_2_2_0());
                    	    					
                    	    pushFollow(FOLLOW_30);
                    	    lv_catchProps_4_0=ruleCatchProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getCatchStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"catchProps",
                    	    							lv_catchProps_4_0,
                    	    							"com.webmethods.flow.FlowService.CatchProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);

                    // InternalFlowService.g:1984:4: ( (lv_steps_5_0= ruleStep ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==21||LA39_0==26||LA39_0==35||LA39_0==38||LA39_0==40||LA39_0==45||LA39_0==48||LA39_0==52) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalFlowService.g:1985:5: (lv_steps_5_0= ruleStep )
                    	    {
                    	    // InternalFlowService.g:1985:5: (lv_steps_5_0= ruleStep )
                    	    // InternalFlowService.g:1986:6: lv_steps_5_0= ruleStep
                    	    {

                    	    						newCompositeNode(grammarAccess.getCatchStepAccess().getStepsStepParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_steps_5_0=ruleStep();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getCatchStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"steps",
                    	    							lv_steps_5_0,
                    	    							"com.webmethods.flow.FlowService.Step");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getCatchStepAccess().getRightCurlyBracketKeyword_2_4());
                    			

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
    // InternalFlowService.g:2012:1: entryRuleCatchProperty returns [EObject current=null] : iv_ruleCatchProperty= ruleCatchProperty EOF ;
    public final EObject entryRuleCatchProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCatchProperty = null;


        try {
            // InternalFlowService.g:2012:54: (iv_ruleCatchProperty= ruleCatchProperty EOF )
            // InternalFlowService.g:2013:2: iv_ruleCatchProperty= ruleCatchProperty EOF
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
    // InternalFlowService.g:2019:1: ruleCatchProperty returns [EObject current=null] : ( (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_exit_2_0= RULE_STRING ) ) ) | (otherlv_3= 'failures' otherlv_4= ':' ( (lv_failures_5_0= RULE_STRING ) ) ) | (otherlv_6= 'selection' otherlv_7= ':' ( (lv_selection_8_0= RULE_STRING ) ) ) ) ;
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
            // InternalFlowService.g:2025:2: ( ( (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_exit_2_0= RULE_STRING ) ) ) | (otherlv_3= 'failures' otherlv_4= ':' ( (lv_failures_5_0= RULE_STRING ) ) ) | (otherlv_6= 'selection' otherlv_7= ':' ( (lv_selection_8_0= RULE_STRING ) ) ) ) )
            // InternalFlowService.g:2026:2: ( (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_exit_2_0= RULE_STRING ) ) ) | (otherlv_3= 'failures' otherlv_4= ':' ( (lv_failures_5_0= RULE_STRING ) ) ) | (otherlv_6= 'selection' otherlv_7= ':' ( (lv_selection_8_0= RULE_STRING ) ) ) )
            {
            // InternalFlowService.g:2026:2: ( (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_exit_2_0= RULE_STRING ) ) ) | (otherlv_3= 'failures' otherlv_4= ':' ( (lv_failures_5_0= RULE_STRING ) ) ) | (otherlv_6= 'selection' otherlv_7= ':' ( (lv_selection_8_0= RULE_STRING ) ) ) )
            int alt41=3;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt41=1;
                }
                break;
            case 42:
                {
                alt41=2;
                }
                break;
            case 43:
                {
                alt41=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalFlowService.g:2027:3: (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_exit_2_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2027:3: (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_exit_2_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2028:4: otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_exit_2_0= RULE_STRING ) )
                    {
                    otherlv_0=(Token)match(input,39,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getCatchPropertyAccess().getExitOnKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getCatchPropertyAccess().getColonKeyword_0_1());
                    			
                    // InternalFlowService.g:2036:4: ( (lv_exit_2_0= RULE_STRING ) )
                    // InternalFlowService.g:2037:5: (lv_exit_2_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2037:5: (lv_exit_2_0= RULE_STRING )
                    // InternalFlowService.g:2038:6: lv_exit_2_0= RULE_STRING
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
                    // InternalFlowService.g:2056:3: (otherlv_3= 'failures' otherlv_4= ':' ( (lv_failures_5_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2056:3: (otherlv_3= 'failures' otherlv_4= ':' ( (lv_failures_5_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2057:4: otherlv_3= 'failures' otherlv_4= ':' ( (lv_failures_5_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,42,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getCatchPropertyAccess().getFailuresKeyword_1_0());
                    			
                    otherlv_4=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_4, grammarAccess.getCatchPropertyAccess().getColonKeyword_1_1());
                    			
                    // InternalFlowService.g:2065:4: ( (lv_failures_5_0= RULE_STRING ) )
                    // InternalFlowService.g:2066:5: (lv_failures_5_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2066:5: (lv_failures_5_0= RULE_STRING )
                    // InternalFlowService.g:2067:6: lv_failures_5_0= RULE_STRING
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
                    // InternalFlowService.g:2085:3: (otherlv_6= 'selection' otherlv_7= ':' ( (lv_selection_8_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2085:3: (otherlv_6= 'selection' otherlv_7= ':' ( (lv_selection_8_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2086:4: otherlv_6= 'selection' otherlv_7= ':' ( (lv_selection_8_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,43,FOLLOW_7); 

                    				newLeafNode(otherlv_6, grammarAccess.getCatchPropertyAccess().getSelectionKeyword_2_0());
                    			
                    otherlv_7=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_7, grammarAccess.getCatchPropertyAccess().getColonKeyword_2_1());
                    			
                    // InternalFlowService.g:2094:4: ( (lv_selection_8_0= RULE_STRING ) )
                    // InternalFlowService.g:2095:5: (lv_selection_8_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2095:5: (lv_selection_8_0= RULE_STRING )
                    // InternalFlowService.g:2096:6: lv_selection_8_0= RULE_STRING
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
    // InternalFlowService.g:2117:1: entryRuleFinallyStep returns [EObject current=null] : iv_ruleFinallyStep= ruleFinallyStep EOF ;
    public final EObject entryRuleFinallyStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFinallyStep = null;


        try {
            // InternalFlowService.g:2117:52: (iv_ruleFinallyStep= ruleFinallyStep EOF )
            // InternalFlowService.g:2118:2: iv_ruleFinallyStep= ruleFinallyStep EOF
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
    // InternalFlowService.g:2124:1: ruleFinallyStep returns [EObject current=null] : ( () otherlv_1= 'FINALLY' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_finalProps_4_0= ruleFinallyProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? ) ;
    public final EObject ruleFinallyStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_properties_3_0 = null;

        EObject lv_finalProps_4_0 = null;

        EObject lv_steps_5_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:2130:2: ( ( () otherlv_1= 'FINALLY' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_finalProps_4_0= ruleFinallyProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? ) )
            // InternalFlowService.g:2131:2: ( () otherlv_1= 'FINALLY' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_finalProps_4_0= ruleFinallyProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? )
            {
            // InternalFlowService.g:2131:2: ( () otherlv_1= 'FINALLY' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_finalProps_4_0= ruleFinallyProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? )
            // InternalFlowService.g:2132:3: () otherlv_1= 'FINALLY' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_finalProps_4_0= ruleFinallyProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )?
            {
            // InternalFlowService.g:2132:3: ()
            // InternalFlowService.g:2133:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFinallyStepAccess().getFinallyStepAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,44,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getFinallyStepAccess().getFINALLYKeyword_1());
            		
            // InternalFlowService.g:2143:3: (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_finalProps_4_0= ruleFinallyProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==13) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalFlowService.g:2144:4: otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_finalProps_4_0= ruleFinallyProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_26); 

                    				newLeafNode(otherlv_2, grammarAccess.getFinallyStepAccess().getLeftCurlyBracketKeyword_2_0());
                    			
                    // InternalFlowService.g:2148:4: ( (lv_properties_3_0= ruleStepProperty ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==15||(LA42_0>=17 && LA42_0<=19)) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // InternalFlowService.g:2149:5: (lv_properties_3_0= ruleStepProperty )
                    	    {
                    	    // InternalFlowService.g:2149:5: (lv_properties_3_0= ruleStepProperty )
                    	    // InternalFlowService.g:2150:6: lv_properties_3_0= ruleStepProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getFinallyStepAccess().getPropertiesStepPropertyParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_26);
                    	    lv_properties_3_0=ruleStepProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getFinallyStepRule());
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
                    	    break loop42;
                        }
                    } while (true);

                    // InternalFlowService.g:2167:4: ( (lv_finalProps_4_0= ruleFinallyProperty ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==39) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // InternalFlowService.g:2168:5: (lv_finalProps_4_0= ruleFinallyProperty )
                    	    {
                    	    // InternalFlowService.g:2168:5: (lv_finalProps_4_0= ruleFinallyProperty )
                    	    // InternalFlowService.g:2169:6: lv_finalProps_4_0= ruleFinallyProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getFinallyStepAccess().getFinalPropsFinallyPropertyParserRuleCall_2_2_0());
                    	    					
                    	    pushFollow(FOLLOW_27);
                    	    lv_finalProps_4_0=ruleFinallyProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getFinallyStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"finalProps",
                    	    							lv_finalProps_4_0,
                    	    							"com.webmethods.flow.FlowService.FinallyProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);

                    // InternalFlowService.g:2186:4: ( (lv_steps_5_0= ruleStep ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==21||LA44_0==26||LA44_0==35||LA44_0==38||LA44_0==40||LA44_0==45||LA44_0==48||LA44_0==52) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // InternalFlowService.g:2187:5: (lv_steps_5_0= ruleStep )
                    	    {
                    	    // InternalFlowService.g:2187:5: (lv_steps_5_0= ruleStep )
                    	    // InternalFlowService.g:2188:6: lv_steps_5_0= ruleStep
                    	    {

                    	    						newCompositeNode(grammarAccess.getFinallyStepAccess().getStepsStepParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_steps_5_0=ruleStep();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getFinallyStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"steps",
                    	    							lv_steps_5_0,
                    	    							"com.webmethods.flow.FlowService.Step");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getFinallyStepAccess().getRightCurlyBracketKeyword_2_4());
                    			

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
    // InternalFlowService.g:2214:1: entryRuleFinallyProperty returns [EObject current=null] : iv_ruleFinallyProperty= ruleFinallyProperty EOF ;
    public final EObject entryRuleFinallyProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFinallyProperty = null;


        try {
            // InternalFlowService.g:2214:56: (iv_ruleFinallyProperty= ruleFinallyProperty EOF )
            // InternalFlowService.g:2215:2: iv_ruleFinallyProperty= ruleFinallyProperty EOF
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
    // InternalFlowService.g:2221:1: ruleFinallyProperty returns [EObject current=null] : (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleFinallyProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalFlowService.g:2227:2: ( (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // InternalFlowService.g:2228:2: (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // InternalFlowService.g:2228:2: (otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            // InternalFlowService.g:2229:3: otherlv_0= 'exitOn' otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,39,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getFinallyPropertyAccess().getExitOnKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getFinallyPropertyAccess().getColonKeyword_1());
            		
            // InternalFlowService.g:2237:3: ( (lv_value_2_0= RULE_STRING ) )
            // InternalFlowService.g:2238:4: (lv_value_2_0= RULE_STRING )
            {
            // InternalFlowService.g:2238:4: (lv_value_2_0= RULE_STRING )
            // InternalFlowService.g:2239:5: lv_value_2_0= RULE_STRING
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
    // InternalFlowService.g:2259:1: entryRuleBranchStep returns [EObject current=null] : iv_ruleBranchStep= ruleBranchStep EOF ;
    public final EObject entryRuleBranchStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBranchStep = null;


        try {
            // InternalFlowService.g:2259:51: (iv_ruleBranchStep= ruleBranchStep EOF )
            // InternalFlowService.g:2260:2: iv_ruleBranchStep= ruleBranchStep EOF
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
    // InternalFlowService.g:2266:1: ruleBranchStep returns [EObject current=null] : ( () otherlv_1= 'BRANCH' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_branchProps_4_0= ruleBranchProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? ) ;
    public final EObject ruleBranchStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_properties_3_0 = null;

        EObject lv_branchProps_4_0 = null;

        EObject lv_steps_5_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:2272:2: ( ( () otherlv_1= 'BRANCH' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_branchProps_4_0= ruleBranchProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? ) )
            // InternalFlowService.g:2273:2: ( () otherlv_1= 'BRANCH' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_branchProps_4_0= ruleBranchProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? )
            {
            // InternalFlowService.g:2273:2: ( () otherlv_1= 'BRANCH' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_branchProps_4_0= ruleBranchProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? )
            // InternalFlowService.g:2274:3: () otherlv_1= 'BRANCH' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_branchProps_4_0= ruleBranchProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )?
            {
            // InternalFlowService.g:2274:3: ()
            // InternalFlowService.g:2275:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBranchStepAccess().getBranchStepAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,45,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getBranchStepAccess().getBRANCHKeyword_1());
            		
            // InternalFlowService.g:2285:3: (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_branchProps_4_0= ruleBranchProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==13) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalFlowService.g:2286:4: otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_branchProps_4_0= ruleBranchProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_31); 

                    				newLeafNode(otherlv_2, grammarAccess.getBranchStepAccess().getLeftCurlyBracketKeyword_2_0());
                    			
                    // InternalFlowService.g:2290:4: ( (lv_properties_3_0= ruleStepProperty ) )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==15||(LA46_0>=17 && LA46_0<=19)) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // InternalFlowService.g:2291:5: (lv_properties_3_0= ruleStepProperty )
                    	    {
                    	    // InternalFlowService.g:2291:5: (lv_properties_3_0= ruleStepProperty )
                    	    // InternalFlowService.g:2292:6: lv_properties_3_0= ruleStepProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getBranchStepAccess().getPropertiesStepPropertyParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_31);
                    	    lv_properties_3_0=ruleStepProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getBranchStepRule());
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
                    	    break loop46;
                        }
                    } while (true);

                    // InternalFlowService.g:2309:4: ( (lv_branchProps_4_0= ruleBranchProperty ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( ((LA47_0>=46 && LA47_0<=47)) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalFlowService.g:2310:5: (lv_branchProps_4_0= ruleBranchProperty )
                    	    {
                    	    // InternalFlowService.g:2310:5: (lv_branchProps_4_0= ruleBranchProperty )
                    	    // InternalFlowService.g:2311:6: lv_branchProps_4_0= ruleBranchProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getBranchStepAccess().getBranchPropsBranchPropertyParserRuleCall_2_2_0());
                    	    					
                    	    pushFollow(FOLLOW_32);
                    	    lv_branchProps_4_0=ruleBranchProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getBranchStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"branchProps",
                    	    							lv_branchProps_4_0,
                    	    							"com.webmethods.flow.FlowService.BranchProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);

                    // InternalFlowService.g:2328:4: ( (lv_steps_5_0= ruleStep ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==21||LA48_0==26||LA48_0==35||LA48_0==38||LA48_0==40||LA48_0==45||LA48_0==48||LA48_0==52) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // InternalFlowService.g:2329:5: (lv_steps_5_0= ruleStep )
                    	    {
                    	    // InternalFlowService.g:2329:5: (lv_steps_5_0= ruleStep )
                    	    // InternalFlowService.g:2330:6: lv_steps_5_0= ruleStep
                    	    {

                    	    						newCompositeNode(grammarAccess.getBranchStepAccess().getStepsStepParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_steps_5_0=ruleStep();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getBranchStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"steps",
                    	    							lv_steps_5_0,
                    	    							"com.webmethods.flow.FlowService.Step");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getBranchStepAccess().getRightCurlyBracketKeyword_2_4());
                    			

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
    // InternalFlowService.g:2356:1: entryRuleBranchProperty returns [EObject current=null] : iv_ruleBranchProperty= ruleBranchProperty EOF ;
    public final EObject entryRuleBranchProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBranchProperty = null;


        try {
            // InternalFlowService.g:2356:55: (iv_ruleBranchProperty= ruleBranchProperty EOF )
            // InternalFlowService.g:2357:2: iv_ruleBranchProperty= ruleBranchProperty EOF
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
    // InternalFlowService.g:2363:1: ruleBranchProperty returns [EObject current=null] : ( (otherlv_0= 'switch' otherlv_1= ':' ( (lv_switch_2_0= RULE_STRING ) ) ) | (otherlv_3= 'evaluateLabels' otherlv_4= ':' ( (lv_eval_5_0= RULE_BOOL ) ) ) ) ;
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
            // InternalFlowService.g:2369:2: ( ( (otherlv_0= 'switch' otherlv_1= ':' ( (lv_switch_2_0= RULE_STRING ) ) ) | (otherlv_3= 'evaluateLabels' otherlv_4= ':' ( (lv_eval_5_0= RULE_BOOL ) ) ) ) )
            // InternalFlowService.g:2370:2: ( (otherlv_0= 'switch' otherlv_1= ':' ( (lv_switch_2_0= RULE_STRING ) ) ) | (otherlv_3= 'evaluateLabels' otherlv_4= ':' ( (lv_eval_5_0= RULE_BOOL ) ) ) )
            {
            // InternalFlowService.g:2370:2: ( (otherlv_0= 'switch' otherlv_1= ':' ( (lv_switch_2_0= RULE_STRING ) ) ) | (otherlv_3= 'evaluateLabels' otherlv_4= ':' ( (lv_eval_5_0= RULE_BOOL ) ) ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==46) ) {
                alt50=1;
            }
            else if ( (LA50_0==47) ) {
                alt50=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalFlowService.g:2371:3: (otherlv_0= 'switch' otherlv_1= ':' ( (lv_switch_2_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2371:3: (otherlv_0= 'switch' otherlv_1= ':' ( (lv_switch_2_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2372:4: otherlv_0= 'switch' otherlv_1= ':' ( (lv_switch_2_0= RULE_STRING ) )
                    {
                    otherlv_0=(Token)match(input,46,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getBranchPropertyAccess().getSwitchKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getBranchPropertyAccess().getColonKeyword_0_1());
                    			
                    // InternalFlowService.g:2380:4: ( (lv_switch_2_0= RULE_STRING ) )
                    // InternalFlowService.g:2381:5: (lv_switch_2_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2381:5: (lv_switch_2_0= RULE_STRING )
                    // InternalFlowService.g:2382:6: lv_switch_2_0= RULE_STRING
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
                    // InternalFlowService.g:2400:3: (otherlv_3= 'evaluateLabels' otherlv_4= ':' ( (lv_eval_5_0= RULE_BOOL ) ) )
                    {
                    // InternalFlowService.g:2400:3: (otherlv_3= 'evaluateLabels' otherlv_4= ':' ( (lv_eval_5_0= RULE_BOOL ) ) )
                    // InternalFlowService.g:2401:4: otherlv_3= 'evaluateLabels' otherlv_4= ':' ( (lv_eval_5_0= RULE_BOOL ) )
                    {
                    otherlv_3=(Token)match(input,47,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getBranchPropertyAccess().getEvaluateLabelsKeyword_1_0());
                    			
                    otherlv_4=(Token)match(input,16,FOLLOW_22); 

                    				newLeafNode(otherlv_4, grammarAccess.getBranchPropertyAccess().getColonKeyword_1_1());
                    			
                    // InternalFlowService.g:2409:4: ( (lv_eval_5_0= RULE_BOOL ) )
                    // InternalFlowService.g:2410:5: (lv_eval_5_0= RULE_BOOL )
                    {
                    // InternalFlowService.g:2410:5: (lv_eval_5_0= RULE_BOOL )
                    // InternalFlowService.g:2411:6: lv_eval_5_0= RULE_BOOL
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
    // InternalFlowService.g:2432:1: entryRuleRepeatStep returns [EObject current=null] : iv_ruleRepeatStep= ruleRepeatStep EOF ;
    public final EObject entryRuleRepeatStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRepeatStep = null;


        try {
            // InternalFlowService.g:2432:51: (iv_ruleRepeatStep= ruleRepeatStep EOF )
            // InternalFlowService.g:2433:2: iv_ruleRepeatStep= ruleRepeatStep EOF
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
    // InternalFlowService.g:2439:1: ruleRepeatStep returns [EObject current=null] : ( () otherlv_1= 'REPEAT' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_repeatProps_4_0= ruleRepeatProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? ) ;
    public final EObject ruleRepeatStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_properties_3_0 = null;

        EObject lv_repeatProps_4_0 = null;

        EObject lv_steps_5_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:2445:2: ( ( () otherlv_1= 'REPEAT' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_repeatProps_4_0= ruleRepeatProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? ) )
            // InternalFlowService.g:2446:2: ( () otherlv_1= 'REPEAT' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_repeatProps_4_0= ruleRepeatProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? )
            {
            // InternalFlowService.g:2446:2: ( () otherlv_1= 'REPEAT' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_repeatProps_4_0= ruleRepeatProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )? )
            // InternalFlowService.g:2447:3: () otherlv_1= 'REPEAT' (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_repeatProps_4_0= ruleRepeatProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )?
            {
            // InternalFlowService.g:2447:3: ()
            // InternalFlowService.g:2448:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRepeatStepAccess().getRepeatStepAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,48,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getRepeatStepAccess().getREPEATKeyword_1());
            		
            // InternalFlowService.g:2458:3: (otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_repeatProps_4_0= ruleRepeatProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==13) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalFlowService.g:2459:4: otherlv_2= '{' ( (lv_properties_3_0= ruleStepProperty ) )* ( (lv_repeatProps_4_0= ruleRepeatProperty ) )* ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_33); 

                    				newLeafNode(otherlv_2, grammarAccess.getRepeatStepAccess().getLeftCurlyBracketKeyword_2_0());
                    			
                    // InternalFlowService.g:2463:4: ( (lv_properties_3_0= ruleStepProperty ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==15||(LA51_0>=17 && LA51_0<=19)) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalFlowService.g:2464:5: (lv_properties_3_0= ruleStepProperty )
                    	    {
                    	    // InternalFlowService.g:2464:5: (lv_properties_3_0= ruleStepProperty )
                    	    // InternalFlowService.g:2465:6: lv_properties_3_0= ruleStepProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getRepeatStepAccess().getPropertiesStepPropertyParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_33);
                    	    lv_properties_3_0=ruleStepProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getRepeatStepRule());
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
                    	    break loop51;
                        }
                    } while (true);

                    // InternalFlowService.g:2482:4: ( (lv_repeatProps_4_0= ruleRepeatProperty ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( ((LA52_0>=49 && LA52_0<=51)) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // InternalFlowService.g:2483:5: (lv_repeatProps_4_0= ruleRepeatProperty )
                    	    {
                    	    // InternalFlowService.g:2483:5: (lv_repeatProps_4_0= ruleRepeatProperty )
                    	    // InternalFlowService.g:2484:6: lv_repeatProps_4_0= ruleRepeatProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getRepeatStepAccess().getRepeatPropsRepeatPropertyParserRuleCall_2_2_0());
                    	    					
                    	    pushFollow(FOLLOW_34);
                    	    lv_repeatProps_4_0=ruleRepeatProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getRepeatStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"repeatProps",
                    	    							lv_repeatProps_4_0,
                    	    							"com.webmethods.flow.FlowService.RepeatProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);

                    // InternalFlowService.g:2501:4: ( (lv_steps_5_0= ruleStep ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==21||LA53_0==26||LA53_0==35||LA53_0==38||LA53_0==40||LA53_0==45||LA53_0==48||LA53_0==52) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalFlowService.g:2502:5: (lv_steps_5_0= ruleStep )
                    	    {
                    	    // InternalFlowService.g:2502:5: (lv_steps_5_0= ruleStep )
                    	    // InternalFlowService.g:2503:6: lv_steps_5_0= ruleStep
                    	    {

                    	    						newCompositeNode(grammarAccess.getRepeatStepAccess().getStepsStepParserRuleCall_2_3_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_steps_5_0=ruleStep();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getRepeatStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"steps",
                    	    							lv_steps_5_0,
                    	    							"com.webmethods.flow.FlowService.Step");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,14,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getRepeatStepAccess().getRightCurlyBracketKeyword_2_4());
                    			

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
    // InternalFlowService.g:2529:1: entryRuleRepeatProperty returns [EObject current=null] : iv_ruleRepeatProperty= ruleRepeatProperty EOF ;
    public final EObject entryRuleRepeatProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRepeatProperty = null;


        try {
            // InternalFlowService.g:2529:55: (iv_ruleRepeatProperty= ruleRepeatProperty EOF )
            // InternalFlowService.g:2530:2: iv_ruleRepeatProperty= ruleRepeatProperty EOF
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
    // InternalFlowService.g:2536:1: ruleRepeatProperty returns [EObject current=null] : ( (otherlv_0= 'count' otherlv_1= ':' ( (lv_count_2_0= RULE_INT ) ) ) | (otherlv_3= 'repeatInterval' otherlv_4= ':' ( (lv_interval_5_0= RULE_INT ) ) ) | (otherlv_6= 'repeatOn' otherlv_7= ':' ( (lv_on_8_0= RULE_STRING ) ) ) ) ;
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
            // InternalFlowService.g:2542:2: ( ( (otherlv_0= 'count' otherlv_1= ':' ( (lv_count_2_0= RULE_INT ) ) ) | (otherlv_3= 'repeatInterval' otherlv_4= ':' ( (lv_interval_5_0= RULE_INT ) ) ) | (otherlv_6= 'repeatOn' otherlv_7= ':' ( (lv_on_8_0= RULE_STRING ) ) ) ) )
            // InternalFlowService.g:2543:2: ( (otherlv_0= 'count' otherlv_1= ':' ( (lv_count_2_0= RULE_INT ) ) ) | (otherlv_3= 'repeatInterval' otherlv_4= ':' ( (lv_interval_5_0= RULE_INT ) ) ) | (otherlv_6= 'repeatOn' otherlv_7= ':' ( (lv_on_8_0= RULE_STRING ) ) ) )
            {
            // InternalFlowService.g:2543:2: ( (otherlv_0= 'count' otherlv_1= ':' ( (lv_count_2_0= RULE_INT ) ) ) | (otherlv_3= 'repeatInterval' otherlv_4= ':' ( (lv_interval_5_0= RULE_INT ) ) ) | (otherlv_6= 'repeatOn' otherlv_7= ':' ( (lv_on_8_0= RULE_STRING ) ) ) )
            int alt55=3;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt55=1;
                }
                break;
            case 50:
                {
                alt55=2;
                }
                break;
            case 51:
                {
                alt55=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalFlowService.g:2544:3: (otherlv_0= 'count' otherlv_1= ':' ( (lv_count_2_0= RULE_INT ) ) )
                    {
                    // InternalFlowService.g:2544:3: (otherlv_0= 'count' otherlv_1= ':' ( (lv_count_2_0= RULE_INT ) ) )
                    // InternalFlowService.g:2545:4: otherlv_0= 'count' otherlv_1= ':' ( (lv_count_2_0= RULE_INT ) )
                    {
                    otherlv_0=(Token)match(input,49,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getRepeatPropertyAccess().getCountKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,16,FOLLOW_9); 

                    				newLeafNode(otherlv_1, grammarAccess.getRepeatPropertyAccess().getColonKeyword_0_1());
                    			
                    // InternalFlowService.g:2553:4: ( (lv_count_2_0= RULE_INT ) )
                    // InternalFlowService.g:2554:5: (lv_count_2_0= RULE_INT )
                    {
                    // InternalFlowService.g:2554:5: (lv_count_2_0= RULE_INT )
                    // InternalFlowService.g:2555:6: lv_count_2_0= RULE_INT
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
                    // InternalFlowService.g:2573:3: (otherlv_3= 'repeatInterval' otherlv_4= ':' ( (lv_interval_5_0= RULE_INT ) ) )
                    {
                    // InternalFlowService.g:2573:3: (otherlv_3= 'repeatInterval' otherlv_4= ':' ( (lv_interval_5_0= RULE_INT ) ) )
                    // InternalFlowService.g:2574:4: otherlv_3= 'repeatInterval' otherlv_4= ':' ( (lv_interval_5_0= RULE_INT ) )
                    {
                    otherlv_3=(Token)match(input,50,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getRepeatPropertyAccess().getRepeatIntervalKeyword_1_0());
                    			
                    otherlv_4=(Token)match(input,16,FOLLOW_9); 

                    				newLeafNode(otherlv_4, grammarAccess.getRepeatPropertyAccess().getColonKeyword_1_1());
                    			
                    // InternalFlowService.g:2582:4: ( (lv_interval_5_0= RULE_INT ) )
                    // InternalFlowService.g:2583:5: (lv_interval_5_0= RULE_INT )
                    {
                    // InternalFlowService.g:2583:5: (lv_interval_5_0= RULE_INT )
                    // InternalFlowService.g:2584:6: lv_interval_5_0= RULE_INT
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
                    // InternalFlowService.g:2602:3: (otherlv_6= 'repeatOn' otherlv_7= ':' ( (lv_on_8_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2602:3: (otherlv_6= 'repeatOn' otherlv_7= ':' ( (lv_on_8_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2603:4: otherlv_6= 'repeatOn' otherlv_7= ':' ( (lv_on_8_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,51,FOLLOW_7); 

                    				newLeafNode(otherlv_6, grammarAccess.getRepeatPropertyAccess().getRepeatOnKeyword_2_0());
                    			
                    otherlv_7=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_7, grammarAccess.getRepeatPropertyAccess().getColonKeyword_2_1());
                    			
                    // InternalFlowService.g:2611:4: ( (lv_on_8_0= RULE_STRING ) )
                    // InternalFlowService.g:2612:5: (lv_on_8_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2612:5: (lv_on_8_0= RULE_STRING )
                    // InternalFlowService.g:2613:6: lv_on_8_0= RULE_STRING
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
    // InternalFlowService.g:2634:1: entryRuleExitStep returns [EObject current=null] : iv_ruleExitStep= ruleExitStep EOF ;
    public final EObject entryRuleExitStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitStep = null;


        try {
            // InternalFlowService.g:2634:49: (iv_ruleExitStep= ruleExitStep EOF )
            // InternalFlowService.g:2635:2: iv_ruleExitStep= ruleExitStep EOF
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
    // InternalFlowService.g:2641:1: ruleExitStep returns [EObject current=null] : ( () otherlv_1= 'EXIT' (otherlv_2= '{' ( (lv_exitProps_3_0= ruleExitProperty ) )* otherlv_4= '}' )? otherlv_5= ';' ) ;
    public final EObject ruleExitStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_exitProps_3_0 = null;



        	enterRule();

        try {
            // InternalFlowService.g:2647:2: ( ( () otherlv_1= 'EXIT' (otherlv_2= '{' ( (lv_exitProps_3_0= ruleExitProperty ) )* otherlv_4= '}' )? otherlv_5= ';' ) )
            // InternalFlowService.g:2648:2: ( () otherlv_1= 'EXIT' (otherlv_2= '{' ( (lv_exitProps_3_0= ruleExitProperty ) )* otherlv_4= '}' )? otherlv_5= ';' )
            {
            // InternalFlowService.g:2648:2: ( () otherlv_1= 'EXIT' (otherlv_2= '{' ( (lv_exitProps_3_0= ruleExitProperty ) )* otherlv_4= '}' )? otherlv_5= ';' )
            // InternalFlowService.g:2649:3: () otherlv_1= 'EXIT' (otherlv_2= '{' ( (lv_exitProps_3_0= ruleExitProperty ) )* otherlv_4= '}' )? otherlv_5= ';'
            {
            // InternalFlowService.g:2649:3: ()
            // InternalFlowService.g:2650:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExitStepAccess().getExitStepAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,52,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getExitStepAccess().getEXITKeyword_1());
            		
            // InternalFlowService.g:2660:3: (otherlv_2= '{' ( (lv_exitProps_3_0= ruleExitProperty ) )* otherlv_4= '}' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==13) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalFlowService.g:2661:4: otherlv_2= '{' ( (lv_exitProps_3_0= ruleExitProperty ) )* otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_35); 

                    				newLeafNode(otherlv_2, grammarAccess.getExitStepAccess().getLeftCurlyBracketKeyword_2_0());
                    			
                    // InternalFlowService.g:2665:4: ( (lv_exitProps_3_0= ruleExitProperty ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==15||LA56_0==19||(LA56_0>=53 && LA56_0<=57)) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // InternalFlowService.g:2666:5: (lv_exitProps_3_0= ruleExitProperty )
                    	    {
                    	    // InternalFlowService.g:2666:5: (lv_exitProps_3_0= ruleExitProperty )
                    	    // InternalFlowService.g:2667:6: lv_exitProps_3_0= ruleExitProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getExitStepAccess().getExitPropsExitPropertyParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_35);
                    	    lv_exitProps_3_0=ruleExitProperty();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getExitStepRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"exitProps",
                    	    							lv_exitProps_3_0,
                    	    							"com.webmethods.flow.FlowService.ExitProperty");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop56;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,14,FOLLOW_13); 

                    				newLeafNode(otherlv_4, grammarAccess.getExitStepAccess().getRightCurlyBracketKeyword_2_2());
                    			

                    }
                    break;

            }

            otherlv_5=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getExitStepAccess().getSemicolonKeyword_3());
            		

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
    // InternalFlowService.g:2697:1: entryRuleExitProperty returns [EObject current=null] : iv_ruleExitProperty= ruleExitProperty EOF ;
    public final EObject entryRuleExitProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitProperty = null;


        try {
            // InternalFlowService.g:2697:53: (iv_ruleExitProperty= ruleExitProperty EOF )
            // InternalFlowService.g:2698:2: iv_ruleExitProperty= ruleExitProperty EOF
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
    // InternalFlowService.g:2704:1: ruleExitProperty returns [EObject current=null] : ( (otherlv_0= 'comment' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) ) | (otherlv_3= 'label' otherlv_4= ':' ( (lv_label_5_0= RULE_STRING ) ) ) | (otherlv_6= 'signal' otherlv_7= ':' ( (lv_signal_8_0= RULE_STRING ) ) ) | (otherlv_9= 'failureName' otherlv_10= ':' ( (lv_failureName_11_0= RULE_STRING ) ) ) | (otherlv_12= 'failureInstance' otherlv_13= ':' ( (lv_failureInstance_14_0= RULE_STRING ) ) ) | (otherlv_15= 'exitForm' otherlv_16= ':' ( (lv_exitForm_17_0= RULE_STRING ) ) ) | (otherlv_18= 'failureMessage' otherlv_19= ':' ( (lv_failureMessage_20_0= RULE_STRING ) ) ) ) ;
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
            // InternalFlowService.g:2710:2: ( ( (otherlv_0= 'comment' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) ) | (otherlv_3= 'label' otherlv_4= ':' ( (lv_label_5_0= RULE_STRING ) ) ) | (otherlv_6= 'signal' otherlv_7= ':' ( (lv_signal_8_0= RULE_STRING ) ) ) | (otherlv_9= 'failureName' otherlv_10= ':' ( (lv_failureName_11_0= RULE_STRING ) ) ) | (otherlv_12= 'failureInstance' otherlv_13= ':' ( (lv_failureInstance_14_0= RULE_STRING ) ) ) | (otherlv_15= 'exitForm' otherlv_16= ':' ( (lv_exitForm_17_0= RULE_STRING ) ) ) | (otherlv_18= 'failureMessage' otherlv_19= ':' ( (lv_failureMessage_20_0= RULE_STRING ) ) ) ) )
            // InternalFlowService.g:2711:2: ( (otherlv_0= 'comment' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) ) | (otherlv_3= 'label' otherlv_4= ':' ( (lv_label_5_0= RULE_STRING ) ) ) | (otherlv_6= 'signal' otherlv_7= ':' ( (lv_signal_8_0= RULE_STRING ) ) ) | (otherlv_9= 'failureName' otherlv_10= ':' ( (lv_failureName_11_0= RULE_STRING ) ) ) | (otherlv_12= 'failureInstance' otherlv_13= ':' ( (lv_failureInstance_14_0= RULE_STRING ) ) ) | (otherlv_15= 'exitForm' otherlv_16= ':' ( (lv_exitForm_17_0= RULE_STRING ) ) ) | (otherlv_18= 'failureMessage' otherlv_19= ':' ( (lv_failureMessage_20_0= RULE_STRING ) ) ) )
            {
            // InternalFlowService.g:2711:2: ( (otherlv_0= 'comment' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) ) | (otherlv_3= 'label' otherlv_4= ':' ( (lv_label_5_0= RULE_STRING ) ) ) | (otherlv_6= 'signal' otherlv_7= ':' ( (lv_signal_8_0= RULE_STRING ) ) ) | (otherlv_9= 'failureName' otherlv_10= ':' ( (lv_failureName_11_0= RULE_STRING ) ) ) | (otherlv_12= 'failureInstance' otherlv_13= ':' ( (lv_failureInstance_14_0= RULE_STRING ) ) ) | (otherlv_15= 'exitForm' otherlv_16= ':' ( (lv_exitForm_17_0= RULE_STRING ) ) ) | (otherlv_18= 'failureMessage' otherlv_19= ':' ( (lv_failureMessage_20_0= RULE_STRING ) ) ) )
            int alt58=7;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt58=1;
                }
                break;
            case 19:
                {
                alt58=2;
                }
                break;
            case 53:
                {
                alt58=3;
                }
                break;
            case 54:
                {
                alt58=4;
                }
                break;
            case 55:
                {
                alt58=5;
                }
                break;
            case 56:
                {
                alt58=6;
                }
                break;
            case 57:
                {
                alt58=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalFlowService.g:2712:3: (otherlv_0= 'comment' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2712:3: (otherlv_0= 'comment' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2713:4: otherlv_0= 'comment' otherlv_1= ':' ( (lv_comment_2_0= RULE_STRING ) )
                    {
                    otherlv_0=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getExitPropertyAccess().getCommentKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getExitPropertyAccess().getColonKeyword_0_1());
                    			
                    // InternalFlowService.g:2721:4: ( (lv_comment_2_0= RULE_STRING ) )
                    // InternalFlowService.g:2722:5: (lv_comment_2_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2722:5: (lv_comment_2_0= RULE_STRING )
                    // InternalFlowService.g:2723:6: lv_comment_2_0= RULE_STRING
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
                    // InternalFlowService.g:2741:3: (otherlv_3= 'label' otherlv_4= ':' ( (lv_label_5_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2741:3: (otherlv_3= 'label' otherlv_4= ':' ( (lv_label_5_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2742:4: otherlv_3= 'label' otherlv_4= ':' ( (lv_label_5_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getExitPropertyAccess().getLabelKeyword_1_0());
                    			
                    otherlv_4=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_4, grammarAccess.getExitPropertyAccess().getColonKeyword_1_1());
                    			
                    // InternalFlowService.g:2750:4: ( (lv_label_5_0= RULE_STRING ) )
                    // InternalFlowService.g:2751:5: (lv_label_5_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2751:5: (lv_label_5_0= RULE_STRING )
                    // InternalFlowService.g:2752:6: lv_label_5_0= RULE_STRING
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
                    // InternalFlowService.g:2770:3: (otherlv_6= 'signal' otherlv_7= ':' ( (lv_signal_8_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2770:3: (otherlv_6= 'signal' otherlv_7= ':' ( (lv_signal_8_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2771:4: otherlv_6= 'signal' otherlv_7= ':' ( (lv_signal_8_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,53,FOLLOW_7); 

                    				newLeafNode(otherlv_6, grammarAccess.getExitPropertyAccess().getSignalKeyword_2_0());
                    			
                    otherlv_7=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_7, grammarAccess.getExitPropertyAccess().getColonKeyword_2_1());
                    			
                    // InternalFlowService.g:2779:4: ( (lv_signal_8_0= RULE_STRING ) )
                    // InternalFlowService.g:2780:5: (lv_signal_8_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2780:5: (lv_signal_8_0= RULE_STRING )
                    // InternalFlowService.g:2781:6: lv_signal_8_0= RULE_STRING
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
                    // InternalFlowService.g:2799:3: (otherlv_9= 'failureName' otherlv_10= ':' ( (lv_failureName_11_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2799:3: (otherlv_9= 'failureName' otherlv_10= ':' ( (lv_failureName_11_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2800:4: otherlv_9= 'failureName' otherlv_10= ':' ( (lv_failureName_11_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,54,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getExitPropertyAccess().getFailureNameKeyword_3_0());
                    			
                    otherlv_10=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_10, grammarAccess.getExitPropertyAccess().getColonKeyword_3_1());
                    			
                    // InternalFlowService.g:2808:4: ( (lv_failureName_11_0= RULE_STRING ) )
                    // InternalFlowService.g:2809:5: (lv_failureName_11_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2809:5: (lv_failureName_11_0= RULE_STRING )
                    // InternalFlowService.g:2810:6: lv_failureName_11_0= RULE_STRING
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
                    // InternalFlowService.g:2828:3: (otherlv_12= 'failureInstance' otherlv_13= ':' ( (lv_failureInstance_14_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2828:3: (otherlv_12= 'failureInstance' otherlv_13= ':' ( (lv_failureInstance_14_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2829:4: otherlv_12= 'failureInstance' otherlv_13= ':' ( (lv_failureInstance_14_0= RULE_STRING ) )
                    {
                    otherlv_12=(Token)match(input,55,FOLLOW_7); 

                    				newLeafNode(otherlv_12, grammarAccess.getExitPropertyAccess().getFailureInstanceKeyword_4_0());
                    			
                    otherlv_13=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_13, grammarAccess.getExitPropertyAccess().getColonKeyword_4_1());
                    			
                    // InternalFlowService.g:2837:4: ( (lv_failureInstance_14_0= RULE_STRING ) )
                    // InternalFlowService.g:2838:5: (lv_failureInstance_14_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2838:5: (lv_failureInstance_14_0= RULE_STRING )
                    // InternalFlowService.g:2839:6: lv_failureInstance_14_0= RULE_STRING
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
                    // InternalFlowService.g:2857:3: (otherlv_15= 'exitForm' otherlv_16= ':' ( (lv_exitForm_17_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2857:3: (otherlv_15= 'exitForm' otherlv_16= ':' ( (lv_exitForm_17_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2858:4: otherlv_15= 'exitForm' otherlv_16= ':' ( (lv_exitForm_17_0= RULE_STRING ) )
                    {
                    otherlv_15=(Token)match(input,56,FOLLOW_7); 

                    				newLeafNode(otherlv_15, grammarAccess.getExitPropertyAccess().getExitFormKeyword_5_0());
                    			
                    otherlv_16=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_16, grammarAccess.getExitPropertyAccess().getColonKeyword_5_1());
                    			
                    // InternalFlowService.g:2866:4: ( (lv_exitForm_17_0= RULE_STRING ) )
                    // InternalFlowService.g:2867:5: (lv_exitForm_17_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2867:5: (lv_exitForm_17_0= RULE_STRING )
                    // InternalFlowService.g:2868:6: lv_exitForm_17_0= RULE_STRING
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
                    // InternalFlowService.g:2886:3: (otherlv_18= 'failureMessage' otherlv_19= ':' ( (lv_failureMessage_20_0= RULE_STRING ) ) )
                    {
                    // InternalFlowService.g:2886:3: (otherlv_18= 'failureMessage' otherlv_19= ':' ( (lv_failureMessage_20_0= RULE_STRING ) ) )
                    // InternalFlowService.g:2887:4: otherlv_18= 'failureMessage' otherlv_19= ':' ( (lv_failureMessage_20_0= RULE_STRING ) )
                    {
                    otherlv_18=(Token)match(input,57,FOLLOW_7); 

                    				newLeafNode(otherlv_18, grammarAccess.getExitPropertyAccess().getFailureMessageKeyword_6_0());
                    			
                    otherlv_19=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_19, grammarAccess.getExitPropertyAccess().getColonKeyword_6_1());
                    			
                    // InternalFlowService.g:2895:4: ( (lv_failureMessage_20_0= RULE_STRING ) )
                    // InternalFlowService.g:2896:5: (lv_failureMessage_20_0= RULE_STRING )
                    {
                    // InternalFlowService.g:2896:5: (lv_failureMessage_20_0= RULE_STRING )
                    // InternalFlowService.g:2897:6: lv_failureMessage_20_0= RULE_STRING
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