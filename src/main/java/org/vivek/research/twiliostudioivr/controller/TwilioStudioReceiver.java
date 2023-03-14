package org.vivek.research.twiliostudioivr.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ivr")
public class TwilioStudioReceiver {

    @PostMapping(value = "/gatherResult", produces = "application/xml")
    @ResponseBody
    public String handleGatherResult(
        @RequestParam(value = "Digits", required = false) String digits,
        @RequestParam(value = "SpeechResult", required = false) String speechResult) {

        /*if ("1".equals(digits) || StringUtils.equalsAnyIgnoreCase(speechResult, "One", "One.", "one", "one.")) {
            return new VoiceResponse.Builder()
                .say(new Say.Builder(CONFIRMED).build())
                .build().toXml();
        } else if ("2".equals(digits) || StringUtils.equalsAnyIgnoreCase(speechResult, "Two", "Two.", "two", "two.")) {
            return new VoiceResponse.Builder()
                .play(new Play.Builder(CANCELLED).build())
                .build().toXml();
        }*/
        System.out.println("speechResult=" + speechResult);
        System.out.println("Digits=" + digits);

        // if they said or typed something we didn't expect, read the choices again.
        return null;
    }
}
