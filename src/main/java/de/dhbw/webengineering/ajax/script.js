document.addEventListener('DOMContentLoaded', () => {
    const loadSection1Button = document.getElementById('load-section-1');
    const loadSection2Button = document.getElementById('load-section-2');
    const tableBody = document.getElementById('table-body');

    loadSection1Button.addEventListener('click', () => {
        loadSection('section1.html');
    });

    loadSection2Button.addEventListener('click', () => {
        loadSection('section2.html');
    });

    function loadSection(url) {
        fetch(url)
            .then(response => response.text())
            .then(data => {
                tableBody.innerHTML = data;
            })
            .catch(error => {
                console.error('Error loading section:', error);
            });
    }
});
