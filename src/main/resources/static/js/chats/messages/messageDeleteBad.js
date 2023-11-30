const chatRemove = '/app/main/bad/chat/delete';
const replyRemove = '/app/main/bad/reply/delete';

function deleteConfirm() {
    var result = confirm("メッセージを削除しますか？");
    return result;
}

function chatDeleteAction(thisElement) {
    if (deleteConfirm()) {
        var deleteForm = JSON.stringify({
            id: getChatId(thisElement)
        });
        
        stompClient.send(chatRemove, {}, deleteForm);
    }
}

function replyDeleteAction(thisElement) {
    if (deleteConfirm()) {
        var deleteForm = JSON.stringify({
            id: getReplyId(thisElement)
        });
        
        stompClient.send(replyRemove, {}, deleteForm);
    }
}
