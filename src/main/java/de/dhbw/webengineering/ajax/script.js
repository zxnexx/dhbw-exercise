document.addEventListener('DOMContentLoaded', () => {
    const loadSection1Button = document.getElementById('load-section-1');
    const loadSection2Button = document.getElementById('load-section-2');
    const tableBody = document.getElementById('table-body');

    loadSection1Button.addEventListener('click', () => {
        loadSection('section1.json');
    });

    loadSection2Button.addEventListener('click', () => {
        loadSection('section2.json');
    });

    function loadSection(url) {
        fetch(url)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                tableBody.innerHTML = '';
                data.forEach(row => {
                    const tr = document.createElement('tr');
                    const td1 = document.createElement('td');
                    const td2 = document.createElement('td');
                    const td3 = document.createElement('td');
                    td1.textContent = row.col1;
                    td2.textContent = row.col2;
                    td3.textContent = row.col3;
                    tr.appendChild(td1);
                    tr.appendChild(td2);
                    tr.appendChild(td3);
                    tableBody.appendChild(tr);
                });
            })
            .catch(error => {
                console.error('Error loading section:', error);
            });
    }
});
