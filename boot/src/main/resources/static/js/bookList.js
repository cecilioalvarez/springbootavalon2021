$(document).ready(() => {
    addListeners();
    loadBooksTable();
    loadAuthorsSelect();
});

function addListeners() {
    $("#saveBook").click(() => createBook);
    configureAddBookListeners();
    
    function configureAddBookListeners() {
        $("#addBook").click(() => {
            $("#createBook").prop("hidden", false);
            $("#addBook").html("Cancelar").off().click(() => {
                $("#addBook").html("Añadir un libro");
                $("#createBook").prop("hidden", true);
                $("#addBook").prop("hidden", false);
                configureAddBookListeners();
            });
        });
    }
}

function loadBooksTable() {
    getBooks().then(buildBooksTableBody);
}

function buildBooksTableBody(data) {
    $("main table tbody").empty();
    $(data).each((index, book) => {
        $("<tr>")
                .appendTo($("main table tbody"))
                .append($("<td>").html(book.pk_isbn))
                .append($("<td>").html(book.title))
                .append($("<td>")
                        .append($("<a>").html(book.fk_author.name).attr("href", `/library/authors/${book.fk_author.pk_id}`)))
                .append($("<td>")
                        .append($("<a>").html("Editar").attr("href", `/library/books/${book.pk_isbn}/edit`))
                        /*.append($("<button>").html("Editar").click(() => $.get(`${book.pk_isbn}/edit`).then(loadEditBookPage)))*/
                        .append($("<button>").html("Borrar").click(() => deleteBook(book.pk_isbn).then(loadBooksTable)))
                        .append($("<a>").html("Ver capítulos").attr("href", `/library/books/${book.pk_isbn}/chapters/list`)));
    });
}

function loadAuthorsSelect() {
    getAuthors().then(buildAuthorsSelectOptions);
}

function buildAuthorsSelectOptions(data) {
    $("#fk_author").empty();
    $(data).each((index, author) => $("<option>").html(author.name).val(author.pk_id).appendTo($("#fk_author")));
}

function createBook() {
    let book = {
        pk_isbn: $("#pk_isbn").val(), 
        title: $("#title").val(), 
        fk_author: {
            pk_id: $("#fk_author").val()
        }
    };
    insertBook(book).then(() => {
        $("#createBook").prop("hidden", true);
        $("#addBook").prop("hidden", false);
        loadBooksTable();
    });
}