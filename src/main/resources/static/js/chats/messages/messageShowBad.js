let stompClient = null;
const showNewMessageMapping = '/topic/bad/messages';
const showDeleteMessageMapping = '/topic/bad/deleteMessage';


function connect() {
    const socket = new SockJS('/ws-chat');
    stompClient = Stomp.over(socket);
    
    stompClient.connect({}, function (frame) {
        
        stompClient.subscribe(showNewMessageMapping, function (response) {
            var responseBody = JSON.parse(response.body);

            if (responseBody.typeMessage == "chat") {
                showChatMessage(responseBody);
            } else if (responseBody.typeMessage == "reply") {
                showReplyMessage(responseBody);
            } else {
                alert("エラーが発生しました");
            }
        });
        
        stompClient.subscribe(showDeleteMessageMapping, function (response) {
            var responseBody = JSON.parse(response.body);

            if (responseBody.typeMessage == "chat") {
                showChatDeleteMessage(responseBody);
            } else if (responseBody.typeMessage == "reply") {
                showReplyDeleteMessage(responseBody);
            } else {
                alert("エラーが発生しました");
            }
        });
    });
}


function showChatMessage(responseBody) {
    var newCreateDiv = document.createElement('div');
    newCreateDiv.classList.add('chat-content', 'mt-3');
    newCreateDiv.setAttribute('id', "chat_" + responseBody.id);
    
    if (!responseBody.image) {
        responseBody.image = "/images/icons/no_icon.png";
    }

    if (responseBody.userId == loginUserId) {

        newCreateDiv.innerHTML = `
            <div class="d-flex align-items-start">
                <div class="me-3">
                    <img src="${responseBody.image}" alt="icon" width="50" height="50" class="rounded-circle">
                </div>
                <div>
                    <div class="name-style">${responseBody.name}</div>
                    <div onclick="chatAction(${responseBody.id}, '${responseBody.name}')" class="cursor-pointer">${responseBody.message}</div>
                    
                    <div class="heart-position heart-action">
                        <div class="heart cursor-pointer" onclick="chatLikeAction(${responseBody.id}, this)"></div>
                        <div class="heart-count">0</div>
                    </div>
                    
                    <div class="d-flex align-items-center mt-2 aligin-delete">
                        <div class="small-font cursor-pointer" onclick="chatAction(${responseBody.id}, '${responseBody.name}')">
                            メッセージを返信する
                        </div>
                        <a href="javascript:void(0)" onclick="chatDeleteAction(this)" class="d-inline-block ms-4 link-danger text-decoration-none fw-bold delete-font">削除</a>
                    </div>
                </div>
            </div>
        `; 
        
        var chatWrap = document.getElementById('chat-wrap');
        chatWrap.appendChild(newCreateDiv);
        
    } else {

        newCreateDiv.innerHTML = `
            <div class="d-flex align-items-start">
                <div class="me-3">
                    <img src="${responseBody.image}" alt="icon" width="50" height="50" class="rounded-circle">
                </div>
                <div>
                    <div class="name-style">${responseBody.name}</div>
                    <div onclick="chatAction(${responseBody.id}, '${responseBody.name}')" class="cursor-pointer">${responseBody.message}</div>
                    
                    <div class="heart-position heart-action">
                        <div class="heart cursor-pointer" onclick="chatLikeAction(${responseBody.id}, this)"></div>
                        <div class="heart-count">0</div>
                    </div>
                    
                    <div class="d-flex align-items-center mt-2 aligin-delete">
                        <div class="small-font cursor-pointer" onclick="chatAction(${responseBody.id}, '${responseBody.name}')">
                            メッセージを返信する
                        </div>
                    </div>
                </div>
            </div>
        `;
        
        var chatWrap = document.getElementById('chat-wrap');
        chatWrap.appendChild(newCreateDiv);
    }
}


function showReplyMessage(responseBody) {
    var newCreateDiv = document.createElement('div');
    newCreateDiv.classList.add('reply-content', 'mt-2', 'ms-5');
    newCreateDiv.setAttribute('id', "reply_" + responseBody.id);
    
    if (!responseBody.image) {
        responseBody.image = "/images/icons/no_icon.png";
    }
    
    if (responseBody.userId == loginUserId) {

        newCreateDiv.innerHTML = `
            <div class="d-flex align-items-start">
                <div class="me-3">
                    <img src="${responseBody.image}" alt="icon" width="50" height="50" class="rounded-circle">
                </div>
                <div>
                    <div class="name-style">${responseBody.name}</div>
                    <div>${responseBody.message}</div>
                    
                    <div class="heart-position heart-action">
                        <div class="heart cursor-pointer"onclick="replyLikeAction(${responseBody.id}, this)"></div>
                        <div class="heart-count">0</div>
                    </div>
                    
                    <div class="d-flex align-items-center mt-2 aligin-delete">
                        <div class="small-font">メッセージを返信する</div>
                        <a href="javascript:void(0)" onclick="replyDeleteAction(this)" class="d-inline-block ms-4 link-danger text-decoration-none fw-bold delete-font">削除</a>
                    </div>
                </div>
            </div>
        `;
        
    } else {
        var newCreateDiv = document.createElement('div');
        newCreateDiv.classList.add('reply-content', 'mt-2', 'ms-5');
        newCreateDiv.setAttribute('id', "reply_" + responseBody.id);
        newCreateDiv.innerHTML = `
            <div class="d-flex align-items-start">
                <div class="me-3">
                    <img src="${responseBody.image}" alt="icon" width="50" height="50" class="rounded-circle">
                </div>
                <div>
                    <div class="name-style">${responseBody.name}</div>
                    <div>${responseBody.message}</div>
                    
                    <div class="heart-position heart-action">
                        <div class="heart cursor-pointer"onclick="replyLikeAction(${responseBody.id}, this)"></div>
                        <div class="heart-count">0</div>
                    </div>
                    
                    <div class="d-flex align-items-center mt-2 aligin-delete">
                        <div class="small-font">メッセージを返信する</div>
                    </div>
                </div>
            </div>
        `;
        
    }
    
    const targetChatId = "chat_" + responseBody.chatId;
    const targetChatElement = document.getElementById(targetChatId);
    targetChatElement.appendChild(newCreateDiv);
    
}

function showChatDeleteMessage(responseBody) {
    var targetChatId = "chat_" + responseBody.id;
    var targetChatElement = document.getElementById(targetChatId);
    targetChatElement.remove();
}

function showReplyDeleteMessage(responseBody) {
    var targetReplyId = "reply_" + responseBody.id;
    var targetReplyElement = document.getElementById(targetReplyId);
    targetReplyElement.remove();
}



document.addEventListener("DOMContentLoaded", function() {
    connect();
});
