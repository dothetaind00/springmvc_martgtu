let bar = document.querySelector('.header_bar');
let close = document.querySelector('.header_close');
let nav = document.querySelector('.header_nav');
let drop = document.querySelector('.header_drop');
let overlay = document.querySelector('.overlay');

bar.addEventListener('click', function() {
    nav.classList.add('show_menu');
    overlay.style.right = '0';
    close.style.left = '93%';
    close.style.color = '#000';
});

close.addEventListener('click', function() {
    nav.classList.remove('show_menu');
    overlay.style.right = '150%';
    close.style.color = '#fff';
    close.style.left = '150%';
});

drop.addEventListener('click', function() {
    document.querySelector('.drop-down').classList.toggle('d-block');
});

overlay.addEventListener('click', function() {
    nav.classList.remove('show_menu');
    overlay.style.right = '150%';
    close.style.color = '#fff';
    close.style.left = '150%';
});