package org.vivek.research.twiliostudioivr.outbound;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.studio.v2.flow.Execution;
import com.twilio.rest.studio.v2.flow.execution.ExecutionContext;
import com.twilio.rest.studio.v2.flow.execution.ExecutionStep;
import java.util.Map;

public class TwilioV2OutboundVoice {



    public static final String ACCOUNT_SID = "<your account sid >";
    public static final String AUTH_TOKEN = "<your token>";

    @SuppressWarnings("UncommentedMain")
    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        String to = "+1<to>>";
        String from = "+<1<twiliophone>>>";
        String flowSid = "FWdcf8b45d648ba0e4a242269d5d5665e3";//your  flow sid
        com.twilio.rest.lookups.v2.PhoneNumber targetLookupPhoneNumber = com.twilio.rest.lookups.v2.PhoneNumber.fetcher(to).fetch();
        com.twilio.type.PhoneNumber toPhoneNumberTwilioType = targetLookupPhoneNumber.getPhoneNumber();
        com.twilio.rest.lookups.v2.PhoneNumber fromLookupPhoneNumber = com.twilio.rest.lookups.v2.PhoneNumber.fetcher(from).fetch();
        com.twilio.type.PhoneNumber fromPhoneNumberTwilioType = fromLookupPhoneNumber.getPhoneNumber();
        Execution execution = Execution.creator(
            flowSid,
            toPhoneNumberTwilioType,
            fromPhoneNumberTwilioType)
            .create();

        String executionSid = execution.getSid();
        System.out.println(" executionSid="+ executionSid);
        // Fetch the execution context for the latest execution
        ExecutionContext executionContext = ExecutionContext.fetcher(flowSid, executionSid).fetch();
        Map<String,Object> mapContext = executionContext.getContext();
        System.out.println("mapContext="+mapContext);

        // Get the execution step for the "gather_input" widget
        ExecutionStep executionStep = null;

        ResourceSet<ExecutionStep> steps = ExecutionStep.reader(
            flowSid,
            executionSid)
            .limit(20).read();
        for (ExecutionStep step : steps) {
            if (step.getTransitionedFrom().equals("call_user_1") && step.getName().equals("gather_input")) {
                executionStep = step;
                break;
            }
        }




        System.out.println("executionStep=" + executionStep);

       /* if (executionStep != null) {
            // Get the user input for the "gather_input" widget
            Map<String, Object> inputValues = executionStep.getInputValues();
            String userInput = (String) inputValues.get("answers");
            System.out.println("User input: " + userInput);
        } else {
            System.out.println("Could not find execution step for widget gather_input");
        }*/

    }
}
