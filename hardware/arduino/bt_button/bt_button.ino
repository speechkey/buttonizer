#include <SoftwareSerial.h>

SoftwareSerial vSerial(10, 11); // RX, TX
const int switchPin = 9;
const int ledPin = 13;

bool led = false;
int state = 0;
int oldstate = 0;

void setup()
{
  Serial.begin(9600);
  vSerial.begin(9600);  
  pinMode(switchPin, INPUT);
}

void loop()
{
 while (vSerial.available())  
  {
    char c = vSerial.read();
    if(c=='r'){
      led = !led;
      state = digitalRead(switchPin);
      vSerial.print(" s:");
      vSerial.print(state);
    }
    Serial.write(c);
  }

  while (Serial.available())
  {
    char c = Serial.read();
    vSerial.write(c);
  }
  oldstate = state;
  state = digitalRead(switchPin);
  if(oldstate != state)
    {
      vSerial.print(" c:");
      vSerial.print(state);
    }
  digitalWrite(ledPin,led);
}


void forwardserialandreadcommands()
{
 
}

