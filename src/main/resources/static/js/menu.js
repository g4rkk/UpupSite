const nav = document.getElementById("nav");
const mask = document.getElementById("mask");

function iconAction() {
    nav.classList.add('active');
}

function menuCloseAction() {
    nav.classList.remove('active');
}

mask.addEventListener('click', () => {
    nav.classList.remove('active');
})