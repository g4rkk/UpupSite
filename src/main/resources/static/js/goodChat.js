
const form = document.getElementById('form-block');
const formData = new FormData(form);

// 返信ではない場合は0をバックエンドへ送る（初期値０）
let messageId = 0;

let clickAction = document.querySelector(".click-action");
let clickedName = document.getElementById("clicked-name");

let stompClient = null;

function connect() {
    const socket = new SockJS('/ws-chat');
    stompClient = Stomp.over(socket);
    
    stompClient.connect({}, function (frame) {
        // console.log('接続確認: ' + frame);
        
        stompClient.subscribe('/topic/messages', function (response) {
            console.log('response' + JSON.parse(response.body).content);
            /**
             * ここで分岐かな？
             * showMessage()に対してチャットなのか、返信なのか
             */
            //showMessage(JSON.parse(response.body).content);
        });
    });
}

function closeAction() {
    messageId = 0;
    clickAction.classList.remove("active");
}

function chatContent(id, userName) {
    messageId = id;
    clickedName.innerHTML = userName;
    
    clickAction.classList.add("active");
}



function sendChat(message) {
    stompClient.send('/app/main/good/chat', {}, JSON.stringify({ 'content': message }));
}

function sendReply(message) {
    stompClient.send('/app/main/good/reply', {}, JSON.stringify({ 'content': message, 'messge_id': messageId }));
}



function sendMessage() {
    let message = formData.get('message');
    
    /**
     * 条件分岐をする
     * 新規メッセージか、返信か？
     */
    sendChat(message);
}

document.addEventListener("DOMContentLoaded", function() {
    connect();
});





/**
 * 
 * function sendMessage() {
    const form = document.getElementById('chat-block');
    const formData = new FormData(form);
    
    fetch('/main/good/message', {
            method: 'POST',
            body: formData,
    })
}
 * 
 */

