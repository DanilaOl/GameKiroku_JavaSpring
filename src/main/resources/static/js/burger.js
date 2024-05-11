document.addEventListener("DOMContentLoaded", ()=> {
    document.querySelector('.menu-dropbutton').addEventListener("click", toggleBurgerMenu);
}) 

function toggleBurgerMenu(event) {
    document.querySelector('.menu-dropcontent').classList.toggle("show-menu");
}