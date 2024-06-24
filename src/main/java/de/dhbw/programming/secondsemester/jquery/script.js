$(document).ready(function () {
    // Datepicker german date format init
    $.datepicker.setDefaults($.datepicker.regional['de']);

    function switchToEditMode(row) {
        row.addClass('edit-mode');
        row.find('td').each(function (index) {
            if (index < 4) { // Ignore the last cell with buttons
                var text = $(this).text();
                if (index === 3) { // Date picker for birthday
                    $(this).html('<input type="text" class="datepicker" value="' + text + '">');
                    $('.datepicker').datepicker({dateFormat: 'dd.mm.yy'});
                } else {
                    $(this).html('<input type="text" value="' + text + '">');
                }
            }
        });
        row.find('.deleteBtn').hide();
        row.find('td:last').append('<button class="saveBtn">Save</button>');
    }

    function switchToReadMode(row) {
        row.removeClass('edit-mode');
        row.find('td').each(function (index) {
            if (index < 4) { // Ignore the last cell with buttons
                var input = $(this).find('input');
                var text = input.val();
                $(this).text(text);
            }
        });
        row.find('.deleteBtn').show();
        row.find('.saveBtn').remove();
    }

    // click on table row
    $('#addressTable').on('click', 'tbody tr', function () {
        var row = $(this);
        if (!row.hasClass('edit-mode')) {
            switchToEditMode(row);
        }
    });

    // click save button
    $('#addressTable').on('click', '.saveBtn', function (e) {
        var row = $(this).closest('tr');
        switchToReadMode(row);
        e.stopPropagation(); // Stackoverflow dingens
    });

    // click delete button
    $('#addressTable').on('click', '.deleteBtn', function (e) {
        var row = $(this).closest('tr');
        $("#dialog-confirm").dialog({
            resizable: false,
            height: "auto",
            width: 400,
            modal: true,
            buttons: {
                "Delete": function () {
                    row.remove();
                    $(this).dialog("close");
                },
                Cancel: function () {
                    $(this).dialog("close");
                }
            }
        });
        e.stopPropagation(); // irgendwas aus stackoverflow ka
    });

    // func to add new row
    $('#addRowBtn').click(function () {
        var newRow = '<tr>' +
            '<td></td>' +
            '<td></td>' +
            '<td></td>' +
            '<td></td>' +
            '<td>' +
            '<button class="deleteBtn">Delete</button>' +
            '</td>' +
            '</tr>';
        $('#addressTable tbody').append(newRow);
    });

    // Drag racing zeugs
    $('#addressTable tbody').sortable({
        helper: fixHelper,
        stop: function (event, ui) {
            ui.item.children('td').each(function () {
                $(this).width($(this).width());
            });
        }
    }).disableSelection();

    // Drag racing helper
    var fixHelper = function (e, ui) {
        ui.children().each(function () {
            $(this).width($(this).width());
        });
        return ui;
    };
});
