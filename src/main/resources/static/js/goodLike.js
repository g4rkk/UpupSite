let likeMessageId = 0;

function likeAction(messageId, likeData) {    
    const likeDataParent = likeData.parentElement;
    const isActive = likeDataParent.classList.contains("active");
    
    if (isActive) {
        // Like削除処理
        likeDataParent.classList.remove("active");
    } else {
        // Like追加処理
        likeDataParent.classList.add("active");
    }

}
