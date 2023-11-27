function addChatLike(messageId, likeDataParent) {
    fetch('/main/bad/chat/like/add', {
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
            alert("いいねできませんでした。");
        }
        return response.json();
    })
    .then(data => {
        var responseString = JSON.stringify(data);
        var heartCountElement = likeDataParent.querySelector(".heart-count");
        var updateHeartCount = parseInt(heartCountElement.textContent) + 1;
        heartCountElement.textContent = updateHeartCount;
    })
}

function deleteChatLike(messageId, likeDataParent) {
    fetch('/main/bad/chat/like/delete', {
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
        var responseString = JSON.stringify(data);
        var heartCountElement = likeDataParent.querySelector(".heart-count");
        var updateHeartCount = parseInt(heartCountElement.textContent) - 1;
        heartCountElement.textContent = updateHeartCount;
    })
}

function addReplyLike(messageId, likeDataParent) {
    fetch('/main/bad/reply/like/add', {
        method: "POST",
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        },
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
        var responseString = JSON.stringify(data);
        var heartCountElement = likeDataParent.querySelector(".heart-count");
        var updateHeartCount = parseInt(heartCountElement.textContent) + 1;
        heartCountElement.textContent = updateHeartCount;
    })
}

function deleteReplyLike(messageId, likeDataParent) {
    fetch('/main/bad/reply/like/delete', {
        method: "POST",
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        },
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
        var responseString = JSON.stringify(data);
        var heartCountElement = likeDataParent.querySelector(".heart-count");
        var updateHeartCount = parseInt(heartCountElement.textContent) - 1;
        heartCountElement.textContent = updateHeartCount;
    })
}