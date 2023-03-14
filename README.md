# 0 twiliostudioivr
Twilio studio IVR with Twilio V2 rest api


#1 Read Me First

1. Import project in intellij as maven project

2. Compile project : On command line type and execute:

mvn clean install


3. Run springboot using maven or java

a) mvn spring-boot:run
or
b)java -jar target/twiliostudioivr-0.0.1-SNAPSHOT.jar

The app wil run on http port 15020


4. run ngrok

ngrok http 15020


#2 Twilio Studio Configuration 

#2 A ) Use flowwithhttpcallback.json  in studio to test  user respponse captured by HTTP callback

1. Now go to twilio studio flow configuration  and copy the generated url of ngrok and paste that in REQUEST URL  of http_1 widget .
   Append /ivr/gatherResult to the ngrok url and choose REQUEST METHOD AS post. This will configure callback to REST controller from studio 
  for user response. (Please note that you need to restart ngrok if you make changes and repeat this step.)

2. Now go test folder and right click run the main program
   TwilioV2OutboundVoice.java
   This will intiate outbound call to studio
   
3. Check user response from http callback in console of springboot app . I have put sys pout in REST controller TwilioStudioReceiver.java

#3 b ) Use flowwithouthttpcallback.json in studio to test  user respponse captured by HTTP callback

In this case we do not need to worry about REST controller TwilioStudioReceiver.java
 But the issue is I am not able to get user response. I need help in context api coding

