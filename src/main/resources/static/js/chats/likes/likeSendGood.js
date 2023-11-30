const addChatLike = '/main/good/chat/like/add';
const removeChatLike = '/main/good/chat/like/delete';

const addReplyLike = '/main/good/reply/like/add';
const removeReplyLike = '/main/good/reply/like/delete';

const fetchHeaders = {
    'Content-Type': 'application/json',
    'X-CSRF-TOKEN': csrfToken
};


function addHeartCount(thisElement) {
    var heartCountElement = thisElement.querySelector(".heart-count");
    var updateHeartCount = parseInt(heartCountElement.textContent) + 1;
    heartCountElement.textContent = updateHeartCount;
}

        
function removeHeartCount(thisElement) {
    var heartCountElement = thisElement.querySelector(".heart-count");
    var updateHeartCount = parseInt(heartCountElement.textContent) - 1;
    heartCountElement.textContent = updateHeartCount;
}

function addChatLikeSend(messageId, thisElement) {
    fetch(addChatLike, {
        method: "POST",
        headers: fetchHeaders,
        body: JSON.stringify({
            chatId: messageId,
        })
    })
    .then(response => {
        if (!response.ok) {
            alert("いいねできませんでした。");
        }
        return response.json();
    })
    .then(data => {
        console.log(thisElement);
        addHeartCount(thisElement);
    })
}

function deleteChatLikeSend(messageId, thisElement) {
    fetch(removeChatLike, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        },
        body: JSON.stringify({
            chatId: messageId,
        })
    })
    .then(response => {
        if (!response.ok) {
            alert("いいねを解除できませんでした");
        }
        return response.json();
    })
    .then(data => {
        removeHeartCount(thisElement);
    })
}

function addReplyLikeSend(messageId, thisElement) {
    fetch(addReplyLike, {
        method: "POST",
        headers: fetchHeaders,
        body: JSON.stringify({
            replyId: messageId,
        })
    })
    .then(response => {
        if (!response.ok) {
            alert("いいねできませんでした。");
        }
        return response.json();
    })
    .then(data => {
        addHeartCount(thisElement);
    })
}

function deleteReplyLikeSend(messageId, thisElement) {
    fetch(removeReplyLike, {
        method: "POST",
        headers: fetchHeaders,
        body: JSON.stringify({
            replyId: messageId,
        })
    })
    .then(response => {
        if (!response.ok) {
            alert("いいねを解除できませんでした");
        }
        return response.json();
    })
    .then(data => {
        removeHeartCount(thisElement);
    })
}
