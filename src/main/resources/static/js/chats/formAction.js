let formStyle = document.getElementById("form-style");
let chatWrap = document.getElementById("chat-wrap");

let currentTextAreaHeight = formStyle.clientHeight;

let messageId = 0;
let clickAction = document.querySelector(".click-action");
let clickedName = document.getElementById("clicked-name");



function chatWrapHeight() {
    var currentHeight = formStyle.clientHeight;
    chatWrap.style.paddingBottom = currentHeight + 'px';
}

function addFormHeight() {
    currentTextAreaHeight = currentTextAreaHeight + 24;
    
    var currentHeight = formStyle.clientHeight;
    formStyle.style.height = currentHeight + 24 + "px";

    chatWrapHeight();
}

function removeFormHeight() {
    currentTextAreaHeight = currentTextAreaHeight - 24;
    
    var currentHeight = formStyle.clientHeight;
    formStyle.style.height = currentHeight - 24 + "px";

    chatWrapHeight();
}




function inputFormHeight(message) {
    formStyle.style.height = currentTextAreaHeight + message + "px";
}

function autoresize() {
    let message = document.getElementById("message");
    message.style.height = 'auto';
    message.style.height = (message.scrollHeight) + 'px';
    
    inputFormHeight(message.scrollHeight - 36);
    chatWrapHeight();
}



function chatAction(id, userName) {
    if (messageId === 0) {
        addFormHeight();
    }
    
    messageId = id;
    clickedName.innerHTML = userName;
    clickAction.classList.add("active");
}


function closeAction() {
    removeFormHeight();
    messageId = 0;
    clickAction.classList.remove("active");
}


document.addEventListener("DOMContentLoaded", function() {
    chatWrapHeight();
});
