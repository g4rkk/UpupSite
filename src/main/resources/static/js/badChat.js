
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
            var responseMessageBody = JSON.parse(response.body);
            if (responseMessageBody.typeMessage == "chat") {
                showChatMessage(responseMessageBody);
            } else if (responseMessageBody.typeMessage == "reply") {
                showReplyMessage(responseMessageBody);
            }
            
        });
        
        stompClient.subscribe('/topic/deleteMessage', function (response) {
            var responseMessageBody = JSON.parse(response.body);
            if (responseMessageBody.typeMessage == "chat") {
                showChatDeleteMessage(responseMessageBody);
            } else if (responseMessageBody.typeMessage == "reply") {
                showReplyDeleteMessage(responseMessageBody);
            }
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
    } else {
        var messageForm = { message: message };
        sendChat(JSON.stringify(messageForm));
    }
    
    textarea.value = "";
}

function showChatMessage(responseMessageBody) {
    if (responseMessageBody.userId == loginUserId) {
        var newChatDiv = document.createElement('div');
        newChatDiv.classList.add('chat-content', 'mt-3');
        newChatDiv.setAttribute('id', "chat_" + responseMessageBody.id);

        newChatDiv.innerHTML = `
            <div class="d-flex align-items-start">
                <div class="me-3">
                    <img src="/images/monster02.png" alt="icon" width="50" height="50" class="rounded-circle">
                </div>
                <div>
                    <div>${responseMessageBody.name}</div>
                    <div onclick="chatAction(${responseMessageBody.id}, '${responseMessageBody.name}')" class="cursor-pointer">${responseMessageBody.message}</div>
                    
                    <div class="heart-position heart-action">
                        <div class="heart cursor-pointer" onclick="chatLikeAction(${responseMessageBody.id}, this)"></div>
                        <div class="heart-count">0</div>
                    </div>
                    
                    <div class="d-flex align-items-center mt-2 aligin-delete">
                        <div class="small-font cursor-pointer" onclick="chatAction(${responseMessageBody.id}, '${responseMessageBody.name}')">
                            メッセージを返信する
                        </div>
                        <a href="javascript:void(0)" th:onclick="|chatDeleteAction(this)|" class="d-inline-block ms-4 link-danger text-decoration-none fw-bold delete-font">削除</a>
                    </div>
                </div>
            </div>
        `; 
        
        var chatWrap = document.getElementById('chat-wrap');
        chatWrap.appendChild(newChatDiv);
        
    } else {
        var newChatDiv = document.createElement('div');
        newChatDiv.classList.add('chat-content', 'mt-3');
        newChatDiv.setAttribute('id', "chat_" + responseMessageBody.id);
        newChatDiv.innerHTML = `
            <div class="d-flex align-items-start">
                <div class="me-3">
                    <img src="/images/monster02.png" alt="icon" width="50" height="50" class="rounded-circle">
                </div>
                <div>
                    <div>${responseMessageBody.name}</div>
                    <div onclick="chatAction(${responseMessageBody.id}, '${responseMessageBody.name}')" class="cursor-pointer">${responseMessageBody.message}</div>
                    
                    <div class="heart-position heart-action">
                        <div class="heart cursor-pointer" onclick="chatLikeAction(${responseMessageBody.id}, this)"></div>
                        <div class="heart-count">0</div>
                    </div>
                    
                    <div class="d-flex align-items-center mt-2 aligin-delete">
                        <div class="small-font cursor-pointer" onclick="chatAction(${responseMessageBody.id}, '${responseMessageBody.name}')">
                            メッセージを返信する
                        </div>
                    </div>
                </div>
            </div>
        `;
        
        var chatWrap = document.getElementById('chat-wrap');
        chatWrap.appendChild(newChatDiv);
    }
}


function showReplyMessage(responseMessageBody) {
    if (responseMessageBody.userId == loginUserId) {
        var newReplyDiv = document.createElement('div');
        newReplyDiv.classList.add('reply-content', 'mt-2', 'ms-5');
        newReplyDiv.setAttribute('id', "reply_" + responseMessageBody.id);
        newReplyDiv.innerHTML = `
            <div class="d-flex align-items-start">
                <div class="me-3">
                    <img src="/images/monster02.png" alt="icon" width="50" height="50" class="rounded-circle">
                </div>
                <div>
                    <div>${responseMessageBody.name}</div>
                    <div>${responseMessageBody.message}</div>
                    
                    <div class="heart-position heart-action">
                        <div class="heart cursor-pointer"onclick="replyLikeAction(${responseMessageBody.id}, this)"></div>
                        <div class="heart-count">0</div>
                    </div>
                    
                    <div class="d-flex align-items-center mt-2 aligin-delete">
                        <div class="small-font">メッセージを返信する</div>
                        <a href="javascript:void(0)" onclick="replyDeleteAction(this)" class="d-inline-block ms-4 link-danger text-decoration-none fw-bold delete-font">削除</a>
                    </div>
                </div>
            </div>
        `;
        
        var targetChatId = "chat_" + responseMessageBody.chatId;
        var targetChatElement = document.getElementById(targetChatId);
        targetChatElement.appendChild(newReplyDiv);
        
    } else {
        var newReplyDiv = document.createElement('div');
        newReplyDiv.classList.add('reply-content', 'mt-2', 'ms-5');
        newReplyDiv.setAttribute('id', "reply_" + responseMessageBody.id);
        newReplyDiv.innerHTML = `
            <div class="d-flex align-items-start">
                <div class="me-3">
                    <img src="/images/monster02.png" alt="icon" width="50" height="50" class="rounded-circle">
                </div>
                <div>
                    <div>${responseMessageBody.name}</div>
                    <div>${responseMessageBody.message}</div>
                    
                    <div class="heart-position heart-action">
                        <div class="heart cursor-pointer"onclick="replyLikeAction(${responseMessageBody.id}, this)"></div>
                        <div class="heart-count">0</div>
                    </div>
                    
                    <div class="d-flex align-items-center mt-2 aligin-delete">
                        <div class="small-font">メッセージを返信する</div>
                    </div>
                </div>
            </div>
        `;
        
        var targetChatId = "chat_" + responseMessageBody.chatId;
        var targetChatElement = document.getElementById(targetChatId);
        targetChatElement.appendChild(newReplyDiv);
        
    }
}

function showChatDeleteMessage(responseMessageBody) {
    var targetChatId = "chat_" + responseMessageBody.id;
    var targetChatElement = document.getElementById(targetChatId);
    targetChatElement.remove();
}

function showReplyDeleteMessage(responseMessageBody) {
    var targetReplyId = "reply_" + responseMessageBody.id;
    var targetReplyElement = document.getElementById(targetReplyId);
    targetReplyElement.remove();
}



document.addEventListener("DOMContentLoaded", function() {
    connect();
});
