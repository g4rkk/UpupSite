const csrfToken = document.querySelector("meta[name='_csrf']").content;

function chatLikeAction(messageId, likeData) {
    var likeDataParent = likeData.parentElement;
    const isActive = likeDataParent.classList.contains("active");
    
    if (isActive) {
        likeDataParent.classList.remove("active");
        deleteChatLike(messageId);
    } else {
        likeDataParent.classList.add("active");
        addChatLike(messageId);
    }
}

function replyLikeAction(messageId, likeData) {
    var likeDataParent = likeData.parentElement
    var isActive = likeDataParent.classList.contains("active");
    
    if (isActive) {
        likeDataParent.classList.remove("active");
        deleteReplyLike(messageId);
    } else {
        likeDataParent.classList.add("active");
        addReplyLike(messageId);
    }
}
