var deleteButton = document.getElementById('deleteButton');
var closeButton = document.getElementById('deleteCloseButton');
var deleteDialog = document.getElementById('deleteDialog');
var outputBox = document.querySelector('output');

deleteButton.addEventListener('click', () => {
    deleteDialog.setAttribute('open', '');
});

deleteDialog.addEventListener('click', () => {
    closeButton.removeAttribute('open');
});