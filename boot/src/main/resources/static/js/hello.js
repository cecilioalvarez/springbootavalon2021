$(document).ready(getBookTableContent);

function getBookTableContent() {
    let params = {
        url: "http://localhost:8080/library/webapi/books", 
        method: "GET",
        dataType: "json",
        success: buildBooksTableBody
    };
    $.ajax(params);
}

function buildBooksTableBody(data) {
    $(data).each((index, book) => {
        $("<tr>")
                .appendTo($("main table tbody"))
                .append($("<td>").html(book.pk_isbn))
                .append($("<td>").html(book.title))
                .append($("<td>")
                    .append($("<a>").html(book.fk_author.name).attr("href", "/library/authors/" + book.fk_author.pk_id)))
                .append($("<td>")
                    .append($("<a>").html("Editar").attr("href", "/library/books/" + book.pk_isbn + "/edit"))
                    .append($("<button>").html("Borrar").click(() => deleteBook(book.pk_isbn)))
                    .append($("<a>").html("Ver capítulos").attr("href", "/library/books/" + book.pk_isbn + "/chapters/list")));
    });
    
    function deleteBook(pk_isbn) {
        let params = {
            url: "http://localhost:8080/library/webapi/books/" + pk_isbn, 
            method: "DELETE"
        };
        $.ajax(params);
    }
}