function getBooks() {
    return axios.get("http://localhost:8080/library/webapi/books");
}

function deleteBook(pk_isbn) {
    return axios.delete(`http://localhost:8080/library/webapi/books/${pk_isbn}`);
}

function insertBook(book) {
    return axios.post("http://localhost:8080/library/webapi/books", book);
}

function updateBook(pk_isbn, book) {
    return axios.put(`http://localhost:8080/library/webapi/books/${pk_isbn}`, book);
}

function getAuthors() {
    return axios.get("http://localhost:8080/library/webapi/authors");
}

function getChapters(pk_isbn) {
    return axios.get(`http://localhost:8080/library/webapi/books/${pk_isbn}/chapters`);
}