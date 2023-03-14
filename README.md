# twiliostudioivr
Twilio studio IVR with Twilio V2 rest api


# Read Me First

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

4. Now go test folder and right click run the main program
   TwilioV2OutboundVoice.java
   This will intiate outbound call to studio

