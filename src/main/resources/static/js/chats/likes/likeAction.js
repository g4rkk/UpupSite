function chatLikeAction(messageId, likeData) {
    var likeDataParent = likeData.parentElement;
    const isActive = likeDataParent.classList.contains("active");
    
    if (isActive) {
        likeDataParent.classList.remove("active");
        deleteChatLikeSend(messageId, likeDataParent);
    } else {
        likeDataParent.classList.add("active");
        addChatLikeSend(messageId, likeDataParent);
    }
}

function replyLikeAction(messageId, likeData) {
    var likeDataParent = likeData.parentElement
    var isActive = likeDataParent.classList.contains("active");
    
    if (isActive) {
        likeDataParent.classList.remove("active");
        deleteReplyLikeSend(messageId, likeDataParent);
    } else {
        likeDataParent.classList.add("active");
        addReplyLikeSend(messageId, likeDataParent);
    }
}