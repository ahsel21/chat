var stompClient = null;

var roomId = null;

var auth = null;

function connect() {
    var socket = new SockJS('/messages');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {

        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/public' , function (greeting) {
            showMessage(JSON.parse(greeting.body).messageText, JSON.parse(greeting.body).author);
        });
    });
}


function disconnect() {
    document.getElementById('messageText').value = '';
    stompClient.disconnect();
    console.log("Disconnected");
}

connect();

function getRoom() {
    roomId = document.getElementsByClassName('active')[0].id.replace('r', '');
    return roomId;
}

function sendMessage() {
    var messageText = document.getElementById('messageText').value;
    if (messageText.trim() !== '') {
        var messageChatArray = messageText.split(' ');
        if (messageChatArray[0].split('')[0] + messageChatArray[0].split('')[1] !== '//') {
            document.getElementById('messageText').value = '';
            document.getElementById('messageError').innerHTML = '';
            stompClient.send("/app/messages", {}, JSON.stringify({
                'messageText': messageText,
                'room': {
                    'id': getRoom()
                }
            }));
        } else {
            messageChatArray[0] = messageChatArray[0].replace('/', '').replace('/', '');
            // команды для комнаты
            if (messageChatArray[0] === 'room') {
                roomCommands(messageChatArray);
            } else if (messageChatArray[0] === 'user') {
                userCommand(messageChatArray);
            }
        }

    } else {
        document.getElementById('messageError').innerHTML = 'Write your message';
    }
}

function showMessage(messageText, author) {

    auth = author;

    var response = document.getElementById('response' + roomId);
    var row = document.createElement("div");
    row.className = 'row';
    var divCol = document.createElement("div");
    divCol.className = 'col';
    var divW100 = document.createElement("div");
    divW100.className = 'w-100';
    var divColAuthor = document.createElement("div");
    divColAuthor.className = 'col';
    var pAuthor = document.createElement("p");
    var divColDateTime = document.createElement("div");
    divColDateTime.className = 'col';
    var spanDateTime = document.createElement("span");
    var pDateTime = document.createElement("p");
    pDateTime.style = 'text-align:left';
    var divColMessageText = document.createElement("div");
    divColMessageText.className = 'col';
    var pMessageText = document.createElement("p");
    var br = document.createElement("br");

    response.appendChild(row);
    row.appendChild(divCol);
    divCol.appendChild(divW100);
    divCol.appendChild(divColAuthor);
    divColAuthor.appendChild(pAuthor);
    pAuthor.appendChild(document.createTextNode(author.username));
    divCol.appendChild(divColDateTime);
    divColDateTime.appendChild(spanDateTime);
    spanDateTime.appendChild(pDateTime);

    pDateTime.appendChild(document.createTextNode(getNowDateTime()));
    divCol.appendChild(divW100);
    divCol.appendChild(divColMessageText);
    divColMessageText.appendChild(pMessageText);
    pMessageText.appendChild(document.createTextNode(messageText));
    divCol.appendChild(br);
}

function getNowDateTime() {

    var newDate = new Date();
    var fullYear = newDate.getFullYear();
    var date = newDate.getDate();
    var month = (newDate.getMonth() + 1);

    if (date < 10)
        date = "0" + date;

    if (month < 10)
        month = "0" + month;

    var cur_day = fullYear + "-" + month + "-" + date;

    var hours = newDate.getHours()
    var minutes = newDate.getMinutes()
    var seconds = newDate.getSeconds();

    if (hours < 10)
        hours = "0" + hours;

    if (minutes < 10)
        minutes = "0" + minutes;

    if (seconds < 10)
        seconds = "0" + seconds;

    return cur_day + " " + hours + ":" + minutes + ":" + seconds;


}
