
// 返信ではない場合は0をバックエンドへ送る（初期値０）
let messageId = 0;

let clickAction = document.querySelector(".click-action");
let clickedName = document.getElementById("clicked-name");

let stompClient = null;

function connect() {
    const socket = new SockJS('/ws-chat');
    stompClient = Stomp.over(socket);
    
    stompClient.connect({}, function (frame) {
        //console.log('接続確認: ' + frame);
        
        stompClient.subscribe('/topic/messages', function (response) {
            /**
             * ここで分岐かな？
             * showMessage()に対してチャットなのか、返信なのか
             */
            console.log(response);
            showChatMessage(JSON.parse(response.body));
        });
    });
}

function closeAction() {
    removeFormHeight();
    messageId = 0;
    clickAction.classList.remove("active");
}

function chatAction(id, userName) {
    if (messageId === 0) {
        addFormHeight();
    }
    messageId = id;
    clickedName.innerHTML = userName;
    
    clickAction.classList.add("active");
}

function sendChat(messageForm) {
    stompClient.send('/app/main/good/chat', {}, messageForm);
}

function sendReply(messageForm) {
    stompClient.send('/app/main/good/reply', {}, messageForm);
}


function sendMessage() {
    const form = document.getElementById('form-block');
    const message = document.getElementById('message').value;    

    if (messageId > 0) {
        var messageForm = { message: message, chatId: messageId };
        sendReply(JSON.stringify(messageForm));
    } else {
        var messageForm = { message: message };
        sendChat(JSON.stringify(messageForm));
    }
}

function showChatMessage(messageData) {
    /**
     * 
     htmlを挿入する
     
     送信者の場合は、削除のリンクを貼り付ける。
     送信者でない場合は追加しない。
     条件分岐かな？
     
     サーバーサイドの処理としては
     ・ログインユーザーIDを取得
     ・登録したデータのユーザーIDを取得
     ・一致した場合は1を返却
     ・一致しなかった場合は0を返却
     
     */
    
    console.log('レスポンス値 ' + messageData.message);
    
    if (messageData.loggedUserFlag == 0) {
        console.log("削除なし");
        /**
         * 削除なしのHTML
         */
    } else if (messageData.loggedUserFlag == 1) {
         /**
         * 削除ありのHTML
         */
        console.log("削除あり");
    }
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

