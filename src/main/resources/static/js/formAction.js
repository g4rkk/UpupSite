let formStyle = document.getElementById("form-style");
let chatWrap = document.getElementById("chat-wrap");

let currentTextAreaHeight = formStyle.clientHeight;

function addFormHeight() {
    var currentHeight = formStyle.clientHeight;
    formStyle.style.height = currentHeight + 24 + "px";
    currentTextAreaHeight = currentTextAreaHeight + 24;

    chatWrapHeight();
}

function removeFormHeight() {
    var currentHeight = formStyle.clientHeight;
    formStyle.style.height = currentHeight - 24 + "px";
    currentTextAreaHeight = currentTextAreaHeight - 24;

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

function chatWrapHeight() {
    var currentHeight = formStyle.clientHeight;
    chatWrap.style.paddingBottom = currentHeight + 'px';
}


document.addEventListener("DOMContentLoaded", function() {
    chatWrapHeight();
});
