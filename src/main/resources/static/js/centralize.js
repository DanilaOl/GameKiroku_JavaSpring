document.addEventListener("DOMContentLoaded", centralizeForm);

function centralizeForm(event) {
    let form = document.querySelector('form');
    let centerMainY = document.querySelector('main').offsetHeight / 2;
    console.log(centerMainY);
    console.log(form.offsetHeight);
    form.style.top = centerMainY - form.offsetHeight / 2 + "px";
}