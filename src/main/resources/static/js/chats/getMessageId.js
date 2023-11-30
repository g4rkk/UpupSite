function getChatId(thisElement) {
    var parentDiv = thisElement.closest('.chat-content');
    var parentDivId = parentDiv.getAttribute('id');
    var parentChatId = parentDivId.match(/_(\d+)/);

    return Number(parentChatId[1]);
}

function getReplyId(thisElement) {
    var parentDiv = thisElement.closest('.reply-content');
    var parentDivId = parentDiv.getAttribute('id');
    var parentReplyId = parentDivId.match(/_(\d+)/);
    
    return Number(parentReplyId[1]);
}