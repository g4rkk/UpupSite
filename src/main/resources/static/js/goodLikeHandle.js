function addChatLike(messageId) {
    fetch('/main/good/chat/like/add', {
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
        console.log(responseString);
    })
}

function deleteChatLike(messageId) {
    fetch('/main/good/chat/like/delete', {
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
        console.log(responseString);
    })
}

function addReplyLike(messageId) {
    fetch('/main/good/reply/like/add', {
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
        console.log(responseString);
    })
}

function deleteReplyLike(messageId) {
    fetch('/main/good/reply/like/delete', {
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
        console.log(responseString);
    })
}
