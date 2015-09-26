#!/bin/sh
echo "on" >> log.txt
#sudo osascript -e "set Volume 10"
#open -a Safari
curl -X POST --header "Content-Type: application/json" -d '{"buttonId": "Foo"}' https://dashboard-button.appspot.com/_ah/api/buttonizer/v0.0.0.1/fire