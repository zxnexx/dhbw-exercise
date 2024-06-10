$(document).ready(function () {
    // Function to switch to edit mode
    function switchToEditMode(row) {
        row.addClass('edit-mode');
        row.find('td').each(function (index) {
            if (index < 3) { // Ignore the last cell with buttons
                var text = $(this).text();
                $(this).html('<input type="text" value="' + text + '">');
            }
        });
        row.find('.deleteBtn').hide();
        row.find('td:last').append('<button class="saveBtn">Save</button>');
    }

    // Function to switch back to read mode
    function switchToReadMode(row) {
        row.removeClass('edit-mode');
        row.find('td').each(function (index) {
            if (index < 3) { // Ignore the last cell with buttons
                var input = $(this).find('input');
                var text = input.val();
                $(this).text(text);
            }
        });
        row.find('.deleteBtn').show();
        row.find('.saveBtn').remove();
    }

    // Event delegation for clicking on a table row
    $('#addressTable').on('click', 'tbody tr', function () {
        var row = $(this);
        if (!row.hasClass('edit-mode')) {
            switchToEditMode(row);
        }
    });

    // Event delegation for save button
    $('#addressTable').on('click', '.saveBtn', function (e) {
        var row = $(this).closest('tr');
        switchToReadMode(row);
        e.stopPropagation(); // Prevent triggering row click event
    });

    // Event delegation for delete button
    $('#addressTable').on('click', '.deleteBtn', function (e) {
        $(this).closest('tr').remove();
        e.stopPropagation(); // Prevent triggering row click event
    });

    // Function to add a new row
    $('#addRowBtn').click(function () {
        var newRow = '<tr>' +
            '<td></td>' +
            '<td></td>' +
            '<td></td>' +
            '<td>' +
            '<button class="deleteBtn">Delete</button>' +
            '</td>' +
            '</tr>';
        $('#addressTable tbody').append(newRow);
    });
});
