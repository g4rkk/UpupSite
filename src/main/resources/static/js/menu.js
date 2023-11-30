const nav = document.getElementById("nav");
const mask = document.getElementById("mask");

function iconAction() {
    nav.classList.add('active');
}

function closeAction() {
    nav.classList.remove('active');
}

mask.addEventListener('click', () => {
    nav.classList.remove('active');
})