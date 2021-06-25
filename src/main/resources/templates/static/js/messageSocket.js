var stompClient = null;
var username = null;

function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
}

function connect(name) {
    if (name.trim() != '') {
        username = name;
        console.log('Hello ' + username);
        document.getElementById('nicknameError').innerHTML = '';
        document.getElementById('messageForm').style.display = 'block';
        document.getElementById('chatBlock').style.display = 'block';
        document.getElementById('userName').value = '';
        document.getElementById('userName').style.display = 'none';
        document.getElementById('labelUserName').style.display = 'none';
        var socket = new SockJS('/messages');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {

            setConnected(true);
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/public', function (greeting) {
                showMessage(JSON.parse(greeting.body).messageText, JSON.parse(greeting.body).author);
            });
        });
    } else {
        document.getElementById('nicknameError').innerHTML = 'Write your nickname';
    }
}

function disconnect() {
    document.getElementById('messageForm').style.display = 'none';
    document.getElementById('chatBlock').style.display = 'none';
    document.getElementById('labelUserName').style.display = 'block';
    document.getElementById('userName').style.display = 'block';
    document.getElementById('messageText').value = '';
    stompClient.disconnect();
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    var messageText = document.getElementById('messageText').value;
    if (messageText.trim() != '') {
        document.getElementById('messageText').value = '';
        document.getElementById('messageError').innerHTML = '';
        stompClient.send("/app/messages", {}, JSON.stringify({'messageText': messageText, 'author': username}));
    } else {
        document.getElementById('messageError').innerHTML = 'Write your message';
    }
}

function showMessage(messageText, author) {
    var response = document.getElementById('response');
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
    pAuthor.appendChild(document.createTextNode(author));
    divCol.appendChild(divColDateTime);
    divColDateTime.appendChild(spanDateTime);
    spanDateTime.appendChild(pDateTime);

    let current_datetime = new Date()
    let formatted_date = current_datetime.getFullYear() + "-" + (current_datetime.getMonth() + 1) + "-" + current_datetime.getDate() + " " + current_datetime.getHours() + ":" + current_datetime.getMinutes() + ":" + current_datetime.getSeconds()

    pDateTime.appendChild(document.createTextNode(formatted_date));
    divCol.appendChild(divW100);
    divCol.appendChild(divColMessageText);
    divColMessageText.appendChild(pMessageText);
    pMessageText.appendChild(document.createTextNode(messageText));
    divCol.appendChild(br);
}