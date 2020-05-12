/**
 * @author Maximilian Anderlohr
 * @version 1.0
 * @file Contains the JavaScript for the frontend of the URLshortener
 */

$(document).ready(function () {
    loadAlias();
    loadTable();

    /*$("#inputForm").submit(function() {

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/convert/",
            data: $(this).serialize(),
            success: function() {

            }
        })

    })*/

});

function checkInput() {

}


/**
 * @description Loads a four-digit alias from the server
 * @version 1.1
 */
function loadAlias() {
    $.getJSON("http://localhost:8080/api/alias", function (data) {
        console.log(data);
        $('#aliasInput').val(data.alias);
    });
}

/**
 * @description Posts the URL to the server
 * @version 1.0
 */
/*function convert() {
    let inputString = "http://localhost:8080/api/submit/" + $('#longURLInput').val() + "/" + $('#aliasInput').val();
    let outputString = "http://localhost:8080/api/short/" + $('#aliasInput').val();
    console.log(inputString);
    $.get(inputString);
    $('#shortURLOutput').val(outputString);
    loadAlias();
    $('#longURLInput').val("");
    //Hier Funktion um neuen Eintrag in Table hinzuzufügen
}

function convertPost() {
    // name=Marty+Franco&address=Vine+Lane
    let url = "http://localhost:8080/api/submit/"

    $.post(url, {longURL: $('#longURLInput').val(), alias: $('#aliasInput').val()}, function (result) {
        $('#shortURLOutput').val(result.shortURL);
    }, "json");

    loadAlias();
    $('#longURLInput').val("");
    //Hier Funktion um neuen Eintrag in Table hinzuzufügen
}*/

/**
 * @description Deletes Alias from the memory
 * @version 1.1
 */
function afterConvert() {
    let outputString = "http://localhost:8080/api/short/" + $('#aliasInput').val();
    setTimeout(function () {
            $('#shortURLOutput').val(outputString);
            loadAlias();
            $('#longURLInput').val("");
            refreshTable();
        },
        500
    );
}

/**
 * @description Checks the validity of the Delete-Alias field
 * @version 1.0
 * @returns {boolean} valid
 * @todo Check min and max Value
 */
function checkDelete() {
    var valid;
    var alias = $('#deleteAlias')
    if (alias == "") {
        alert("Name must be filled out");
        valid = false;
    } else valid = true;
}

/**
 * @description Deletes Alias from the memory
 * @version 1.1
 */
function del() {
    let apiString = "http://localhost:8080/api/delete/" + $('#deleteAlias').val();
    console.log(apiString);
    $.ajax({
        type: "DELETE",
        url: apiString,
        contentType: "text/plain",
        success: function () {
            console.log("Deleted successfully")
        },
        error: function () {
            alert("Could not delete")
        },
        complete: function () {
            $('#deleteAlias').val("");
            refreshTable();
        }
    });
}

/**
 * @description Deletes all connections
 * @version 1.0
 */
function delAll() {
    let apiString = "http://localhost:8080/api/delete/all";
    $.ajax({
        type: "DELETE",
        url: apiString,
        success: function () {
            console.log("Deleted all connections successfully")
        },
        error: function () {
            alert("Could not delete all connections")
        },
        complete: function () {
            refreshTable();
        }
    });
}

/**
 * @description Requests the table
 * @version 2.0
 */
function loadTable() {
    let tableString = "http://localhost:8080/api/table";
    $.get(tableString, function (data) {
        $('tbody').append(data);
    })
}

/**
 * @description Empties the table and loads a new one
 * @version 1.0
 */
function refreshTable() {
    $('tbody').empty();
    loadTable();
}

/**
 * @description Copies the Short URL Output
 * @version 1.0
 */
function copyOutput() {
    let copyText = document.getElementById("shortURLOutput");
    copyText.select();
    copyText.setSelectionRange(0, 99999); /*For mobile devices*/
    document.execCommand("copy");
}

/**
 * @description Changes to the Short URL
 * @version 1.0
 */
function goOutput() {
    window.location.href = "" + $('#shortURLOutput').val();
}
