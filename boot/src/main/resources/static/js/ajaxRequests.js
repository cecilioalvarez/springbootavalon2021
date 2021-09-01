function getBooks() {
    let params = {
        url: "http://localhost:8080/library/webapi/books", 
        dataType: "json",
        method: "GET"
    };
    return $.ajax(params);
}

function deleteBook(pk_isbn) {
    let params = {
        url: `http://localhost:8080/library/webapi/books/${pk_isbn}`, 
        method: "DELETE"
    };
    return $.ajax(params);
}

function insertBook(book) {
    let params = {
        url: "http://localhost:8080/library/webapi/books", 
        method: "POST", 
        data: book
    };
    return $.ajax(params);
}

function getAuthors() {
    let params = {
        url: "http://localhost:8080/library/webapi/authors", 
        dataType: "json",
        method: "GET"
    };
    return $.ajax(params);
}