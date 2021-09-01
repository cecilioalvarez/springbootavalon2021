$(document).ready(() => {
    addListeners();
    loadBooksTable();
    loadAuthorsSelect();
});

function addListeners() {
    configureAddBookListener();
    $("#hideChapters").click(() => $("#chaptersDetail").hide());
}

function configureAddBookListener() {
    $("#saveBook").html("Añadir").off("click").click(createBook);
    $("#bookForm legend").html("Datos del nuevo libro");
    $("#addBook").off().click(() => {
        $("#bookForm").show();
        $("#pk_isbn").prop("readonly", false);
        $("#addBook").html("Cancelar").off().click(() => {
            $("#pk_isbn").val("");
            $("#title").val("");
            $("#fk_author option:first").prop("selected", true);
            $("#addBook").html("Añadir un libro");
            $("#bookForm").hide();
            $("#addBook").show();
            configureAddBookListener();
        });
    });
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
        $("#bookForm").hide();
        $("#addBook").html("Añadir un libro").show();
        $("#pk_isbn").val("");
        $("#title").val("");
        $("#fk_author option:first").prop("selected", true);
        loadBooksTable();
        configureAddBookListener();
    });
}

function loadBooksTable() {
    getBooks().then(buildBooksTableBody);
}

function buildBooksTableBody(response) {
    $("#booksTable tbody").empty();
    $(response.data).each((index, book) => {
        $("<tr>")
                .appendTo($("#booksTable tbody"))
                .append($("<td>").html(book.pk_isbn))
                .append($("<td>").html(book.title))
                .append($("<td>")
                        .append($("<a>").html(book.fk_author.name).attr("href", `/library/authors/${book.fk_author.pk_id}`))
                        )
                .append($("<td>")
                        .append($("<button>").html("Editar").click(() => configureEditBookListener(book)))
                        .append($("<button>").html("Borrar").click(() => deleteBook(book.pk_isbn).then(loadBooksTable)))
                        .append($("<button>").html("Ver capítulos").click(() => loadChaptersTable(book)))
                        );
    });
    
    function configureEditBookListener(book) {
        $("#bookForm").show();
        $("#bookForm legend").html("Edición del libro");
        $("#saveBook").html("Guardar cambios").off("click").click(() => editBook(book.pk_isbn));
        $("#pk_isbn").prop("readonly", true).val(book.pk_isbn);
        $("#title").val(book.title);
        $("#fk_author option[value='" + book.fk_author.pk_id + "']").prop("selected", true);
        $("#addBook").html("Cancelar").off("click").click(() => {
            $("#pk_isbn").prop("readonly", false).val("");
            $("#title").val("");
            $("#fk_author option:first").prop("selected", true);
            $("#addBook").html("Añadir un libro").show();
            $("#bookForm").hide();
            configureAddBookListener();
        });
    }
    
    function editBook(pk_isbn) {
        let book = {
            pk_isbn: $("#pk_isbn").val(), 
            title: $("#title").val(), 
            fk_author: {
                pk_id: $("#fk_author").val()
            }
        };
        updateBook(pk_isbn, book).then(() => {
            $("#bookForm").hide();
            $("#addBook").html("Añadir un libro").show();
            $("#pk_isbn").val("");
            $("#title").val("");
            $("#fk_author option:first").prop("selected", true);
            $("#saveBook").off().click(() => createBook);
            loadBooksTable();
            configureAddBookListener();
        });
    }
}

function loadChaptersTable(book) {
    $("#chaptersTable caption").html(`Capítulos de «${book.title}»`);
    getChapters(book.pk_isbn).then(buildChaptersTableBody);
    $("#chaptersDetail").show();
}

function buildChaptersTableBody(response) {
    $("#chaptersTable tbody").empty();
    $(response.data).each((index, chapter) => {
        $("<tr>")
                .appendTo($("#chaptersTable tbody"))
                .append($("<td>").html(chapter.pk_title))
                .append($("<td>").html(chapter.pages))
                .append($("<td>")
                        .append($("<button>").html("Editar"))
                        .append($("<button>").html("Borrar"))
                        );
    });
}

function loadAuthorsSelect() {
    getAuthors().then(buildAuthorsSelectOptions);
}

function buildAuthorsSelectOptions(response) {
    $("#fk_author").empty();
    $(response.data).each((index, author) => $("<option>").html(author.name).val(author.pk_id).appendTo($("#fk_author")));
}