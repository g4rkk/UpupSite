function sendChatDelete(deleteData) {
    stompClient.send('/app/main/bad/chat/delete', {}, deleteData);
}

function sendReplyDelete(deleteData) {
    stompClient.send('/app/main/bad/reply/delete', {}, deleteData);
}

function deleteConfirm() {
    var result = confirm("メッセージを削除しますか？");
    return result;
}

function chatDeleteAction(element) {
    if (deleteConfirm()) {
        const chatId = getChatId(element);
        var deleteForm = { id: chatId };
        sendChatDelete(JSON.stringify(deleteForm));
    }
}

function replyDeleteAction(element) {
    if (deleteConfirm()) {
        const replyId = getReplyId(element);
        var deleteForm = { id: replyId };
        sendReplyDelete(JSON.stringify(deleteForm));
    }
}


function getChatId(element) {
    var parentDiv = element.closest('.chat-content');
    var parentDivId = parentDiv.getAttribute('id');
    var parentChatId = parentDivId.match(/_(\d+)/);

    return Number(parentChatId[1]);
}

function getReplyId(element) {
    var parentDiv = element.closest('.reply-content');
    var parentDivId = parentDiv.getAttribute('id');
    var parentReplyId = parentDivId.match(/_(\d+)/);
    
    return Number(parentReplyId[1]);
}