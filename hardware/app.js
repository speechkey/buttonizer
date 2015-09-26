var serialport = require('serialport');
var childProcess = require('child_process');
var SerialPort = serialport.SerialPort;




serialport.list(function (err, ports) {
	console.log("Ports:");
	ports.forEach(function(port) {
		console.log(port.comName);
	});
});

portName = process.argv[2] || "/dev/cu.CaseBT01-DevB";
var boxPort = new SerialPort(portName, { baudrate: 9600});


boxPort.on('open', showPortOpen);
boxPort.on('data', sendSerialData);
boxPort.on('close', showPortClose);
boxPort.on('error', showError);

function showPortOpen() {
	console.log('port open. Data rate: ' + boxPort.options.baudRate );
}

function sendSerialData(data) {
	result = data.toString();
	if (result==="c:1" || result === "c:0")
	{
		console.log("change");
		childProcess.exec('./change.sh'); 
		switch(result){
			case 'c:0':
			console.log("on");   
			childProcess.exec('./on.sh'); 	
			break;
			case 'c:1':
			console.log("off");  
			childProcess.exec('./off.sh'); 	 	
			break;
		} 
	}
}

function showPortClose() {
	console.log('port closed.');
}

function showError(error) {
	console.log('Serial port error: ' + error);
}

