function sendChat(messageForm) {
    stompClient.send('/app/main/bad/chat', {}, messageForm);
}

function sendReply(messageForm) {
    stompClient.send('/app/main/bad/reply', {}, messageForm);
}


function sendMessage() {
    const form = document.getElementById('form-block');
    const textarea = form.querySelector('textarea');
    const message = textarea.value;

    if (messageId > 0) {
        var messageForm = { message: message, chatId: messageId };
        sendReply(JSON.stringify(messageForm));
        closeAction();
    } else {
        var messageForm = { message: message };
        sendChat(JSON.stringify(messageForm));
    }
    
    textarea.value = "";
}
